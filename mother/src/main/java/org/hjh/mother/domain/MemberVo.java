package org.hjh.mother.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVo {
	private int mno;
	private String id;
	private String password;
	private String name;
	private String gender;
	private Date join_date;
}
