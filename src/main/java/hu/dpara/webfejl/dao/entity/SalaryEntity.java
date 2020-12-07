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
@Table(name = "salaries", schema = "employees")

public class SalaryEntity {


    @EmbeddedId
    private SalaryId id;

    @Column
    private int salary;

    @Column
    private Date toDate;
}
