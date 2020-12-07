package hu.dpara.webfejl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Builder
@Getter
@EqualsAndHashCode
public class Title {

	private int empNo;
	private String title;
	private String fromDate;
	private String toDate;
	
}
