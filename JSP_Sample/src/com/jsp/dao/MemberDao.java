package com.jsp.dao;

import com.jsp.dto.MemberVO;

public interface MemberDao {

	public MemberVO loginCheck(MemberVO vo);
	
	public int joinMember(MemberVO paramVO);
	
}
