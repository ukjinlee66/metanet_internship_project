package com.metanet.controller;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.metanet.domain.Buy;
import com.metanet.domain.Charge;
import com.metanet.domain.Refund;
import com.metanet.domain.Users;
import com.metanet.domain.DTO.BuyDTO;
import com.metanet.domain.DTO.ChargeDTO;
import com.metanet.domain.DTO.PointDTO;
import com.metanet.domain.DTO.RefundDTO;
import com.metanet.repository.UsersRepository;
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
	
	@Autowired
	private UsersRepository UsersRepo;
	
	
	@PostMapping("/charge")
	@CrossOrigin
	@ApiOperation(value="포인트 충전",notes="성공시 1 반환, 실패시 -1 반환")

	public int charge(  ChargeDTO.ChargeRequest chargeRequest, @RequestParam(value = "userId", required=false, defaultValue="none") String userId   )
	{
		
		if(userId.equals("none")) return -1;
		else {
		
			Users findUser =  accountService.getAccount(userId).get();
			
			
			if( 1== pointService.addPoint(findUser.getUserId(), chargeRequest.getChargePoint()) ) {
				pointService.addCharge( chargeRequest , findUser.getUserNumber());
				return 1; 
				
			}else 	return -1;
		
		}
		
	
		
	}
	
	
	
	@GetMapping("/getChargeList")
	@CrossOrigin
	@ApiOperation(value="회원 충전 정보 조회",notes="성공시 List<Charge> 반환, 실패시 1(=null) 반환 ")
	public List<PointDTO> getChargeList(@RequestParam(value = "userId", required=false, defaultValue="none") String userId ) {
		
		if(userId.equals("none")) return null;
		else {
			
			Users findUser =  accountService.getAccount(userId).get();
			List<Charge> chargeList =  pointService.getChargeList(findUser.getUserNumber());
			
			
			
			List<PointDTO> pointList = new ArrayList<>();
			
			for( Charge  charge : chargeList) {
				
				PointDTO temp = new PointDTO();
				temp.transferFrom(charge);
				pointList.add(temp);
			}
				
			return pointList;	

		}
		
	}
	
	
	
	
	
	@PostMapping("/buy")
	@CrossOrigin
	@ApiOperation(value="정기원 구매",notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")

	public int  buy(  BuyDTO.BuyRequest buyRequest,      @RequestParam(value = "userId", required=false, defaultValue="none") String userId  )
	{
		if(userId.equals("none")) return -1;
		else {

			
			Users findUser =  accountService.getAccount(userId).get();
						
			if( 1 == pointService.subtractPoint(findUser.getUserId(), buyRequest.getBuyPoint())) {
				pointService.addBuy( buyRequest , findUser.getUserNumber()); 
				pointService.addUserEndsubscribe(buyRequest, findUser.getUserNumber());
				return 1; 
			}else 	return -1;
				
			
		}   
	}
	
	
	@GetMapping("/getBuyList")
	@CrossOrigin
	@ApiOperation(value="회원 구매 정보 조회", notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")
	public List<PointDTO> getBuyList( @RequestParam(value = "userId", required=false, defaultValue="none") String userId  ) {
		
		if(userId.equals("none")) return null;
		else {
			
			Users findUser =  accountService.getAccount(userId).get();
			List<Buy> buyList =  pointService.getBuyList(findUser.getUserNumber());	

			List<PointDTO> pointList = new ArrayList<>();
			
			for( Buy  buy : buyList) {
				
				PointDTO temp = new PointDTO();
				temp.transferFrom(buy);
				pointList.add(temp);
			}
				
			return pointList;	
	
		}	
	}
	
	
	
	@PostMapping("/refund")
	@CrossOrigin
	@ApiOperation(value="포인트 봔불 ",notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")
	public int  refundPoint( RefundDTO.RefundRequest refundRequest,     @RequestParam(value = "userId", required=false, defaultValue="none") String userId  )
	{

		if(userId.equals("none")) return -1; 
		else {
			
			Users findUser =  accountService.getAccount(userId).get();
						
			if( 1==pointService.subtractPoint(findUser.getUserId(), refundRequest.getRefundPoint())) {
				pointService.addRefund( refundRequest , findUser.getUserNumber()); 
				return 1;  
			}else 	return -1;	
		}
		
	}
	

	
	
	@GetMapping("/getRefundList")
	@CrossOrigin
	@ApiOperation(value="회원 구매 정보 조회", notes="성공시 회원정보 반환, 실패시 1 (=null) 반환 ")
	public List<PointDTO> getRefundList( @RequestParam(value = "userId", required=false, defaultValue="none") String userId ) {
		
		if(userId.equals("none")) return null;
		else {
			
			Users findUser =  accountService.getAccount(userId).get();
			List<Refund> refundList =  pointService.getRefundList(findUser.getUserNumber());
			
			
			List<PointDTO> pointList = new ArrayList<>();
			
			for( Refund refund : refundList) {
				
				PointDTO temp = new PointDTO();
				temp.transferFrom(refund);
				pointList.add(temp);
			}
			
			
			return pointList;	
		}
	}
	
	
	
	
}
















