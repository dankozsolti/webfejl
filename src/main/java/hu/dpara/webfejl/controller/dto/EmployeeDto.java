package hu.dpara.webfejl.controller.dto;

import hu.dpara.webfejl.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private int empNo;
	private String birthDate;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String hireDate;
	
}
