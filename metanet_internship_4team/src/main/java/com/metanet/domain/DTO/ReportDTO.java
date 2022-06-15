package com.metanet.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReportDTO {

	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class saveReport{
		private String reportNumber;
		private String usersNumber;
		private String reportTableNumber;
	}
}
