package com.metanet.domain.dto;

import javax.persistence.Column;

import com.metanet.domain.Charge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ChargeDto {

	
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class ChargeRequest{
		
		@Column(name = "CHARGE_KIND", columnDefinition = "char")
		private String chargeKind;
		
		@Column(name = "CHARGE_POINT")
		private int chargePoint;			
	
		
		public Charge transferTo( Charge charge ) {

			charge.setChargeKind( chargeKind);
			charge.setChargePoint(chargePoint);

			return charge;
		}
		
		
		
	}
	
	

	
}
