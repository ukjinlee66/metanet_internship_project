package com.metanet.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Buy;
import com.metanet.domain.Charge;
import com.metanet.domain.Refund;
import com.metanet.domain.Users;
import com.metanet.domain.DTO.BuyDTO;
import com.metanet.domain.DTO.ChargeDTO;
import com.metanet.domain.DTO.RefundDTO;
import com.metanet.service.AccountService;
import com.metanet.service.PointService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Point")
public class PointController {

	@Autowired
	private AccountService accountService;
		
	@Autowired
	private PointService pointService;
	
	
	
	@PostMapping("/charge")
	@CrossOrigin
	@ApiOperation(value="포인트 충전",notes="성공시 1 반환, 실패시 -1 반환")
	public int charge( HttpServletRequest request,  ChargeDTO.ChargeRequest chargeRequest  )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
					
			// 포인트 충전 로직 
			// 포인트 기록 
			Users users =  (Users)session.getAttribute("info");
			
			if( 1== pointService.addPoint(users.getUserId(), chargeRequest.getChargePoint()) ) {
				pointService.addCharge( chargeRequest , users.getUserNumber());
				return 1; 
			}else 	return -1;
		
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}
		
	}
	
	
	
	@GetMapping("/getChargeList")
	@CrossOrigin
	@ApiOperation(value="회원 충전 정보 조회",notes="성공시 List<Charge> 반환, 실패시 1(=null) 반환 ")
	public List<Charge> getChargeList(HttpServletRequest request) {
		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
			// 포인트 충전 로직 
			Users users =  (Users)session.getAttribute("info");
			List<Charge> chargeList =  pointService.getChargeList(users.getUserNumber());
			return chargeList;
			
		} else {
			System.out.println("You need to login first login first");
			return null;
		}
	}
	
	
	
	
	
	@PostMapping("/buy")
	@CrossOrigin
	@ApiOperation(value="정기원 구매",notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")
	public int  buy( HttpServletRequest request,  BuyDTO.BuyRequest buyRequest )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
			// 포인트 충전 로직 
			Users users =  (Users)session.getAttribute("info");
			
			if( 1 == pointService.subtractPoint(users.getUserId(), buyRequest.getBuyPoint())) {
				pointService.addBuy( buyRequest , users.getUserNumber()); 
				return 1; 
			}else 	return -1;
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}
		
	}
	
	
	
	@GetMapping("/getBuyList")
	@CrossOrigin
	@ApiOperation(value="회원 구매 정보 조회", notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")
	public List<Buy> getBuyList(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
			// 포인트 충전 로직 
			Users users =  (Users)session.getAttribute("info");
			List<Buy> buyList =  pointService.getBuyList(users.getUserNumber());
			return buyList;
			
		} else {
			System.out.println("You need to login first login first");
			return null;
		}
	}
	
	
	
	@PostMapping("/refund")
	@CrossOrigin
	@ApiOperation(value="포인트 봔불 ",notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")
	public int  refundPoint( HttpServletRequest request, RefundDTO.RefundRequest refundRequest )
	{
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
					
	
			Users users =  (Users)session.getAttribute("info");
			
			if( 1==pointService.subtractPoint(users.getUserId(), refundRequest.getRefundPoint())) {
				pointService.addRefund( refundRequest , users.getUserNumber()); 
				return 1; 
			}else return -1 ;
			
		} else {
			System.out.println("You need to login first login first");
			return -1;
		}
		
	}
	

	
	
	@GetMapping("/getRefundList")
	@CrossOrigin
	@ApiOperation(value="회원 구매 정보 조회", notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")
	public List<Refund> getRefundList(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			session = request.getSession(true);
			session.setAttribute("state", "NOT_LOG_IN");
		}
		
		if (session.getAttribute("state").equals("LOG_IN")) {
			// 포인트 충전 로직 
			Users users =  (Users)session.getAttribute("info");
			List<Refund> refundList =  pointService.getRefundList(users.getUserNumber());
			return refundList;
			
		} else {
			System.out.println("You need to login first login first");
			return null;
		}
	}
	
	
	
	
}
















