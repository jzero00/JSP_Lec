package com.jsp.dao;

import java.util.List;

import com.jsp.dto.MemberVO;

public interface MemberDao {

	public MemberVO loginCheck(MemberVO vo);
	
	public int joinMember(MemberVO paramVO);

	public List<MemberVO> getMemberList();
	
}
