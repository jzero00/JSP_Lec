package com.jsp.service;

import com.jsp.dao.MemberDaoImpl;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDaoImpl dao;
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		super();
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	@Override
	public MemberVO loginCheck(MemberVO paramVO) {
		MemberVO member = null;
		member = dao.loginCheck(paramVO);
		return member;
	}

	@Override
	public int joinMember(MemberVO paramVO) {
		
		return dao.joinMember(paramVO);
	}

}
