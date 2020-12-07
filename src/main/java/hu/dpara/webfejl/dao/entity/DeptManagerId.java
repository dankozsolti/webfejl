package hu.dpara.webfejl.dao.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class DeptManagerId implements Serializable {

    @ManyToOne
    @JoinColumn(name="emp_no")
    private EmployeeEntity id;


    @ManyToOne
    @JoinColumn(name="dept_no")
    private DepartmentEntity dept_no;
}
