package com.metanet.domain.DTO;

import javax.persistence.Column;

import com.metanet.domain.Buy;
import com.metanet.domain.Charge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BuyDTO {

	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class  BuyRequest{
	
	@Column(name = "BUY_KIND")
	private String buyKind;

	@Column(name = "BUY_POINT")
	private int buyPoint;
		
	public Buy transferTo( Buy buy ) {

		buy.setBuyKind(buyKind);
		buy.setBuyPoint(buyPoint);
		
		return buy;
	}
	
	
	
	
	}
	
	
	
	
}
