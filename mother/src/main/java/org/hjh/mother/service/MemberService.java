package org.hjh.mother.service;

import org.hjh.mother.domain.MemberVo;

public interface MemberService {
	public int idCheck(String id);
	public boolean join(MemberVo member);
	public int login(MemberVo member);
}
