package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

@WebServlet("/join")
public class MemberJoin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService member = MemberServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/memberJoin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("${param.id}");
		String pwd = request.getParameter("${param.pwd}");
		String pwdcheck = request.getParameter("${param.pwdcheck}");
		String phone = request.getParameter("${param.phone}");
		String address = request.getParameter("${param.address}");
		String email = request.getParameter("${param.email}");
		String picture = request.getParameter("${param.picture}");
		String name = request.getParameter("${param.name}");
		
		if(pwd != pwdcheck) {
			String msg = "입력한 두 비밀번호가 다릅니다.";
			request.setAttribute("msg", msg);
			return;
		}
		
		MemberVO paramVO = new MemberVO();
		paramVO.setAddress(address);
		paramVO.setEmail(email);
		paramVO.setEnabled(1);
		paramVO.setId(id);
		paramVO.setName(name);
		paramVO.setPhone(phone);
		paramVO.setPicture(picture);
		paramVO.setPwd(pwd);
		
		doGet(request, response);
	}

}
