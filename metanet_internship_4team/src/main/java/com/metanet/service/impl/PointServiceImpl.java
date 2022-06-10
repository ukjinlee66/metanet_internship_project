package com.metanet.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Buy;
import com.metanet.domain.Charge;
import com.metanet.domain.Refund;
import com.metanet.domain.Users;
import com.metanet.domain.dto.BuyDto;
import com.metanet.domain.dto.ChargeDto;
import com.metanet.domain.dto.RefundDto;
import com.metanet.repository.BuyRepository;
import com.metanet.repository.ChargeRepository;
import com.metanet.repository.RefundRepository;
import com.metanet.repository.UsersRepository;
import com.metanet.service.PointService;


@Service
public class PointServiceImpl implements PointService {

	@Autowired
	BuyRepository buyRepository;
	
	@Autowired
	ChargeRepository chargeRepository;
	
	@Autowired
	RefundRepository refundRepository ;
	
	@Autowired
	UsersRepository usersRepository;
	
	
	public void addCharge(ChargeDto.ChargeRequest chargeRequest , int userNumber) {
		
		
		Charge charge = new Charge();
		
		charge = chargeRequest.transferTo(charge);
		charge.setUsersNumber(userNumber);
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    charge.setChargeDate(date);
	    
	    chargeRepository.save(charge);
		
	}; 
	
	
	public void addBuy(BuyDto.BuyRequest buyRequest, int userNumber) {
		Buy buy = new Buy();
		
		buy = buyRequest.transferTo(buy);
		
		
		buy.setUsersNumber(userNumber);
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    
	    buy.setBuyDate(date);

	    buyRepository.save(buy);
		
	}; 
	
	public void addRefund(RefundDto.RefundRequest refundRequest, int userNumber) {
		
		Refund refund = new Refund();
		
		refund = refundRequest.transferTo(refund);
		refund.setUsersNumber(userNumber);
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    refund.setRefundDate(date);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	 

	    refundRepository.save(refund);
		
		
	}; 
		

	
	public int addPoint(String userId, int point ) {
		
		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		
		if(findUsers.isPresent()) {
			
			int newPoint = findUsers.get().getUserPoint() +point ;
			findUsers.get().setUserPoint(newPoint);
			usersRepository.save(findUsers.get());
			return 1;
		}else return -1;
		
		
	}
	
	public int subtractPoint(String userId, int point ) {
	
		Optional<Users> findUsers = usersRepository.findByUserId(userId);
		
		if(findUsers.isPresent()) {
			
			int newPoint = findUsers.get().getUserPoint() - point ;
			
			if(newPoint<0) return -1; 
			
			findUsers.get().setUserPoint(newPoint);
			return 1;
			
		}else return -1 ;
			
	}
	
	
	
	public List<Charge> getChargeList( int userNumber){
		
		List<Charge> chargeList  = chargeRepository.findByUsersNumber(userNumber);
		
		// 시간순 정졀 
		
		return chargeList;
		
	};
	
	public List<Buy> getBuyList( int userNumber){
		
		List<Buy> buyList  =  buyRepository.findByUsersNumber(userNumber);
		
		
		// 시간 순 정렬 
		
		return buyList;
		
		
	};
	
	
	
	public List<Refund> getRefundList( int userNumber){
		
		List<Refund> refundList  = refundRepository.findByUsersNumber(userNumber);
		
		
		// 시간 순 정렬 
		
		return refundList;
		
		
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
