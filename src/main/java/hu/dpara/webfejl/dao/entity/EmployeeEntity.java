package hu.dpara.webfejl.dao.entity;

import hu.dpara.webfejl.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employees", schema = "employees")

public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="emp_no")
    private long id;

    @Column
    private Date birthDate;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Gender gender;

    @Column
    private Date hireDate;


}
