package org.hjh.mother.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVo {
	private int rno;
	private int dno;
	private String reply;
	private String replyer;
	private Date reg_date;
	private Date up_date;
}
