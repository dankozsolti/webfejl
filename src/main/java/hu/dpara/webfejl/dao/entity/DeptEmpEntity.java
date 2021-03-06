package hu.dpara.webfejl.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="dept_emp", schema="employees")
@IdClass(DeptEmpId.class)
public class DeptEmpEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name ="emp_no")
    private EmployeeEntity empNo;

    @Id
    @ManyToOne
    @JoinColumn(name ="dept_no")
    private DepartmentEntity deptNo;

    @Column(name ="from_date")
    private Date fromDate;

    @Column(name ="to_date")
    private Date toDate;


}