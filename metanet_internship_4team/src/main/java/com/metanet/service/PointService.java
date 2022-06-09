package com.metanet.service;

import java.util.List;

import com.metanet.domain.Buy;
import com.metanet.domain.Charge;
import com.metanet.domain.Refund;
import com.metanet.domain.dto.BuyDto;
import com.metanet.domain.dto.ChargeDto;
import com.metanet.domain.dto.RefundDto;

public interface PointService {

	
	public void addCharge(ChargeDto.ChargeRequest chargeRequest, int userNumber); 
	
	public void addBuy(BuyDto.BuyRequest buyRequest, int userNumber); 
	
	public void addRefund(RefundDto.RefundRequest refundRequest, int userNumber); 
	
	public int addPoint( String userId, int point );
	
	public int subtractPoint(String userId , int point ); 
	
	
	public List<Charge> getChargeList( int userNumber);
	
	public List<Buy> getBuyList( int userNumber);
	
	public List<Refund> getRefundList( int userNumber);
	
	
	
	
	
}
