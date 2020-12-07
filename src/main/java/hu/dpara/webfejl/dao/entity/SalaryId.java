package hu.dpara.webfejl.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;

@Data
@Embeddable
public class SalaryId implements Serializable {

    @ManyToOne
    @JoinColumn(name="emp_no")
    private EmployeeEntity id;

    @Column
    private Date fromDate;
}