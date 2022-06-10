package com.metanet.domain.dto;

import com.metanet.domain.Charge;
import com.metanet.domain.Refund;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class RefundDto {

	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class  RefundRequest{
		
		private int refundPoint;
	
		public Refund transferTo( Refund refund ) {
			refund.setRefundPoint(refundPoint);
			return refund;
		}
	}

	




}
