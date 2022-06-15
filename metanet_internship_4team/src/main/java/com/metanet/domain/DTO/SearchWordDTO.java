package com.metanet.domain.DTO;

import com.metanet.domain.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SearchWordDTO {

		
	@NoArgsConstructor
	@Data
	public static class SearchWordResponse {

		public String value;
		
		public SearchWordResponse(String value) {
			this.value =  value;
		}
	
	}
	
	
	
}
