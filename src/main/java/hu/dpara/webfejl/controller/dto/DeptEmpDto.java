package hu.dpara.webfejl.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DeptEmpDto {
	
	private int empNo;
	private String deptNo;
	private String fromDate;
	private String toDate;

}
