package hu.dpara.webfejl.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TitleDto {
	
	private int empNo;
	private String title;
	private String fromDate;
	private String toDate;
	
}
