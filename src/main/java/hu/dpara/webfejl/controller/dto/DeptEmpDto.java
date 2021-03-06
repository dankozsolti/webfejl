package hu.dpara.webfejl.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DeptEmpDto {
	
	private int empNo;
	private String deptNo;
	private Date fromDate;
	private Date toDate;

}
