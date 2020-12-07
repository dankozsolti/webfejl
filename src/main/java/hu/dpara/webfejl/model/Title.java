package hu.dpara.webfejl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@ToString
@Builder
@Getter
@EqualsAndHashCode
public class Title {

	private int empNo;
	private String title;
	private Date fromDate;
	private Date toDate;
	
}
