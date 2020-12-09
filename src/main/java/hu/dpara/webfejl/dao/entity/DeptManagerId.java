package hu.dpara.webfejl.dao.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DeptManagerId implements Serializable {

    private int empNo;

    private String deptNo;

}
