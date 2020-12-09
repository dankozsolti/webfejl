package hu.dpara.webfejl.controller.dto;

import hu.dpara.webfejl.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import java.sql.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto extends EmployeeDto{

    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;

}
