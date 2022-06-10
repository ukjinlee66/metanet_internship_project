package com.metanet.service;

import java.util.List;

import com.metanet.domain.Buy;
import com.metanet.domain.Charge;
import com.metanet.domain.Refund;
import com.metanet.domain.DTO.BuyDTO;
import com.metanet.domain.DTO.ChargeDTO;
import com.metanet.domain.DTO.RefundDTO;

public interface PointService {

	
	public void addCharge(ChargeDTO.ChargeRequest chargeRequest, int userNumber); 
	
	public void addBuy(BuyDTO.BuyRequest buyRequest, int userNumber); 
	
	public void addRefund(RefundDTO.RefundRequest refundRequest, int userNumber); 
	
	public int addPoint( String userId, int point );
	
	public int subtractPoint(String userId , int point ); 
	
	
	public List<Charge> getChargeList( int userNumber);
	
	public List<Buy> getBuyList( int userNumber);
	
	public List<Refund> getRefundList( int userNumber);
	
	
	
	
	
}
