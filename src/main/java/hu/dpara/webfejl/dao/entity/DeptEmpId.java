package hu.dpara.webfejl.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DeptEmpId implements Serializable {

    private int empNo;

    private String deptNo;

}
