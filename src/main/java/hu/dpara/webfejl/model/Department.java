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
public class Department {

	private String deptNo;
	private String deptName;
	
}
