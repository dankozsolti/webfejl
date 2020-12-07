package hu.dpara.webfejl.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "dept_emp", schema = "employees")

public class DeptEmpEntity {

    @EmbeddedId
    private DeptEmpId id;

    @Column
    private Date fromDate;

    @Column
    private Date toDate;
}
