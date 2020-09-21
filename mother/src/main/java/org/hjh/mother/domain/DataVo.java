package org.hjh.mother.domain;

import java.util.Date;

import lombok.Data;

@Data
public class DataVo {
	private int dno;
	private String title;
	private String content;
	private String writer;
	private String type;
	private String img_name;
	private Date reg_date;
	private Date up_date;
	private String read_count;
	private String reply_count;
}
