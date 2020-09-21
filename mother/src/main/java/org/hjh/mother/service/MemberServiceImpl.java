package org.hjh.mother.service;

import org.hjh.mother.domain.MemberVo;
import org.hjh.mother.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	@Override
	public int idCheck(String id) {
		if(memberMapper.idCheck(id) == null) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public boolean join(MemberVo member) {
		int n = memberMapper.join(member);
		if(n==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int login(MemberVo member) {
		if(memberMapper.loginId(member) != null) {
			if(memberMapper.loginPw(member) != null) {
				return 1;
			}else {
				return 2;
			}
		}else {
			return 0;	//id¿¡·¯
		}
	}

}
