package com.jsp.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jsp.dto.MemberVO;
import com.jsp.util.SqlMapClientFactory;

public class MemberDaoImpl implements MemberDao {

	private SqlMapClient smc;
	
	private static MemberDaoImpl dao;
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		MemberVO res = null;
		try {
			res = (MemberVO) smc.queryForObject("member.loginCheck", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int joinMember(MemberVO paramVO) {
		int check = 0;
		try {
			check = (int) smc.insert(arg0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

}
