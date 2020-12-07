package hu.dpara.webfejl.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "departments", schema = "employees")

public class DepartmentEntity {

    @Id
    /*@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")*/
    @Column
    private String deptNo;


    @Column
    private String deptName;


}
