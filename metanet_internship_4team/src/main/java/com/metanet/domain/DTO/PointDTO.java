package com.metanet.domain.DTO;

import com.metanet.domain.Buy;
import com.metanet.domain.Charge;
import com.metanet.domain.Refund;

import lombok.Data;


@Data
public class PointDTO {

	int number;

	int userNumber; 

	String kind = "사용";

	int point;
	
	java.sql.Date date; 
	
	public void transferFrom(Charge charge) {
		
		number = charge.getChargeNumber();
		userNumber = charge.getUsersNumber();
		kind = charge.getChargeKind();
		point = charge.getChargePoint();
		date = charge.getChargeDate();
		
	}
	
	
	public void transferFrom(Buy buy) {
		
		number = buy.getBuyNumber();
	    userNumber = buy.getUsersNumber();
	    kind = buy.getBuyKind();
	    point = buy.getBuyPoint();
	    date = buy.getBuyDate();
	    
	}
	

	public void transferFrom(Refund refund) {
		
		number = refund.getRefundNumber();
	    userNumber = refund.getUsersNumber();
	    point = refund.getRefundPoint();
	    date = refund.getRefundDate();				
	}
	



	
}
