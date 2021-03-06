package com.metanet.service.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.domain.Buy;
import com.metanet.domain.Charge;
import com.metanet.domain.Refund;
import com.metanet.domain.Users;
import com.metanet.domain.DTO.BuyDTO;
import com.metanet.domain.DTO.BuyDTO.BuyRequest;
import com.metanet.domain.DTO.ChargeDTO;
import com.metanet.domain.DTO.RefundDTO;
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
	
	
	
	public void addCharge(ChargeDTO.ChargeRequest chargeRequest , int userNumber) {
		
		
		Charge charge = new Charge();
		
		charge = chargeRequest.transferTo(charge);
		charge.setUsersNumber(userNumber);
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    charge.setChargeDate(date);
	    
	    chargeRepository.save(charge);
		
	    
	    
	}; 
	
	
	public void addBuy(BuyDTO.BuyRequest buyRequest, int userNumber) {
		Buy buy = new Buy();
		
		buy = buyRequest.transferTo(buy);
		buy.setUsersNumber(userNumber);
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    buy.setBuyDate(date);

	    buyRepository.save(buy);
		
		
	}; 
	
	public void addRefund(RefundDTO.RefundRequest refundRequest, int userNumber) {
		
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
		
		// ????????? ?????? 
		
		return chargeList;
		
	};
	
	public List<Buy> getBuyList( int userNumber){
		
		List<Buy> buyList  =  buyRepository.findByUsersNumber(userNumber);
		
		
		// ?????? ??? ?????? 
		
		return buyList;
		
		
	};
	
	
	
	public List<Refund> getRefundList( int userNumber){
		
		List<Refund> refundList  = refundRepository.findByUsersNumber(userNumber);
		
		
		// ?????? ??? ?????? 
		
		return refundList;
		
		
	};
	public void addUserEndsubscribe(BuyRequest buyRequest, int userNumber) {

		
	 	long millis = System.currentTimeMillis();  
	 	Date now = new java.sql.Date(millis);
		
	    Users user = usersRepository.findByuserNumber(userNumber);
	    Date userSubDate = user.getUserEndsubscribe();
	    
	    int compare = now.compareTo(userSubDate);
	    int buyPoint = buyRequest.getBuyPoint();
	    
	    Calendar cal1 = Calendar.getInstance();
	    Calendar cal2 = Calendar.getInstance();
	    cal1.setTime(now);
	    cal2.setTime(userSubDate);
  
	    if(compare >= 0)
	    {
		    if(buyPoint == 30000)
		    	cal1.add(Calendar.DATE,30);
		    if(buyPoint == 100000)
		    	cal1.add(Calendar.DATE,90);
		    if(buyPoint == 250000)
		    	cal1.add(Calendar.DATE,365);
		    

		    java.util.Date date1 = cal1.getTime();		    

		    java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

		 
		    
		    user.setUserEndsubscribe(sqlDate);
		    usersRepository.save(user);
		    System.out.println(user);
		    
	    }
	    else //????????? ??????
	    {
		    if(buyPoint == 30000)
		    	cal2.add(Calendar.DATE,30);
		    if(buyPoint == 100000)
		    	cal2.add(Calendar.DATE,90);
		    if(buyPoint == 250000)
		    	cal2.add(Calendar.DATE,365);
	    
		    java.util.Date date2 = cal2.getTime();
		    java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
		    user.setUserEndsubscribe(sqlDate);
		    usersRepository.save(user);
		    System.out.println(user);
	    }
	    
        
	    
	};
	
	/* buyKind ?????? ?????? ??????, 30??? ??????, 90???,365??? ????????? ?????? ??? ???????????? ??????,?????? ?????? ??????...*/
//	public void addUserEndsubscribe(BuyRequest buyRequest, int userNumber) {
//		
//		//?????? ????????? now??? ?????? 
//	 	Date now = new java.sql.Date(System.currentTimeMillis());
//		
//	 	//?????? ???????????? userSubEndDate??? ?????? 
//	    Users user = usersRepository.findByuserNumber(userNumber);
//	    Date userSubEndDate = user.getUserEndsubscribe();
//	    
//	    //??????????????? ??????????????? ?????? / ???????????? < ??????????????? :-1 / ???????????? > ??????????????? :1
//	    int compare = now.compareTo(userSubEndDate);
//	    
//	    //????????? ?????? ?????? (buy ???????????? Buykind = 30, 90, 365), ?????????????????? ???????????? ??? ???   
//	    String buyKind = buyRequest.getBuyKind(); 
//	    
//	    //????????? ????????? ?????? calendar??????, cal1 = ?????? ??????, cal2 = ?????????????????? 
//	    Calendar cal1 = Calendar.getInstance();
//	    Calendar cal2 = Calendar.getInstance();
//	    cal1.setTime(now);
//	    cal2.setTime(userSubEndDate);
//	   
////	    1. ?????????????????? ??????, ???????????? + ????????? 
////	    2. ???????????? ??????, ??????????????? + ????????? 
//	    
//	    if(compare >= 0) //???????????? -> ????????? ??????, ???????????? + ?????????
//	    {
//		    if(buyKind == "30")
//		    	cal1.add(Calendar.DATE,30);
//		    if(buyKind == "90")
//		    	cal1.add(Calendar.DATE,90);
//		    if(buyKind == "365")
//		    	cal1.add(Calendar.DATE,365);
//		    
//		    java.util.Date date1 = cal1.getTime();		    
//		    java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
//		    user.setUserEndsubscribe(sqlDate);
//		    usersRepository.save(user);
//	    }
//	    else //????????? -> ??????????????? + ????????? 
//	    {
//		    if(buyKind == "30")
//		    	cal2.add(Calendar.DATE,30);
//		    if(buyKind == "90")
//		    	cal2.add(Calendar.DATE,90);
//		    if(buyKind == "365")
//		    	cal2.add(Calendar.DATE,365);
//	    
//		    java.util.Date date2 = cal2.getTime();
//		    java.sql.Date sqlDate = new java.sql.Date(date2.getTime());
//		    user.setUserEndsubscribe(sqlDate);
//		    usersRepository.save(user);
//	    }
//	};

}
