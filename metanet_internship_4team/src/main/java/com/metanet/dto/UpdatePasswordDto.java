package com.metanet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdatePasswordDto {

	
	private String userId;
	
	private String userPassword;
	
	private String userNewPassword;
}
