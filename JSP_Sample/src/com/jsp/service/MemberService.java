package com.jsp.service;

import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberService {

	public MemberVO loginCheck(MemberVO paramVO);
	
	public int joinMember(MemberVO paramVO);

	public List<MemberVO> getMemberList();
	
}
