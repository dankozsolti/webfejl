package hu.dpara.webfejl.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@ToString
@Builder
@Getter
@EqualsAndHashCode
public class Employee {

	private int empNo;
	private Date birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	private Date hireDate;
	
}
