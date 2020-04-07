package com.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;

public class MemberServiceImpl implements MemberService {

	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberServiceImpl() {}
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	
	private MemberDAO memberDAO = MemberDAOImpl.getInstance();
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIdException, InvalidPasswordException {
		MemberVO member = memberDAO.selectMemberById(id);
		if(member == null) throw new NotFoundIdException();
		if(!pwd.equals(member.getPwd())) throw new InvalidPasswordException();
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {

		return null;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {

		return null;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		
	}

	@Override
	public void remove(String id) throws SQLException {
		
	}

}
