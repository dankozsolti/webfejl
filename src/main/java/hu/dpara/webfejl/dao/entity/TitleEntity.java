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
@Table(name = "titles", schema = "employees")


public class TitleEntity {

   @EmbeddedId
   private TitleId id;

    @Column
    private Date toDate;
}
