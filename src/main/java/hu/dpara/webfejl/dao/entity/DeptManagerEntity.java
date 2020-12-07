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
@Table(name = "dept_manager", schema = "employees")

public class DeptManagerEntity {

    @EmbeddedId
    private DeptManagerId id;

    @Column
    private Date fromDate;

    @Column
    private Date toDate;
}
