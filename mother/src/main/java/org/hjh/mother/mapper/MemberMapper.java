package org.hjh.mother.mapper;

import org.apache.ibatis.annotations.Param;
import org.hjh.mother.domain.MemberVo;

public interface MemberMapper {
	public int join(MemberVo member);
	public MemberVo loginId(MemberVo member);
	public MemberVo loginPw(MemberVo member);
	public MemberVo idCheck(@Param("id") String id);
}
