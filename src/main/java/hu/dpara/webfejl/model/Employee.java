package hu.dpara.webfejl.model;

import hu.dpara.webfejl.enums.Gender;
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
public class Employee {

	private int empNo;
	private String birthDate;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String hireDate;
	
}
