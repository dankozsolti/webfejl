package hu.dpara.webfejl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Builder
@Getter
@EqualsAndHashCode
public class DeptManager {

	private String deptNo;
	private int empNo;
	private String fromDate;
	private String toDate;
	
}
