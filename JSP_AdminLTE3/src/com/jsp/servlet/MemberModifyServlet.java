package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.request.MemberRegistRequest;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

/**
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/member/modify")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String url = "/member/modify";
		
		MemberVO member = null;
		try {
			member = MemberServiceImpl.getInstance().getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
			url="error/500_error";
		}
		request.setAttribute("member", member);
		
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String url = "/member/modify_success";
		
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String picture=request.getParameter("picture");
		String name = request.getParameter("name");
		String authority = request.getParameter("authority");
		String[] phone = request.getParameterValues("phone");
		
		MemberRegistRequest memberReq = 
				new MemberRegistRequest(id,pwd,authority,email,phone,picture,name);
	
		MemberVO member = memberReq.toMemberVO();
		HttpSession session = request.getSession();
		
		if(session.getId() == null) {
			return;
		}
		
		try {
			MemberServiceImpl.getInstance().modify(member);
//			url=""
		} catch (SQLException e) {
			e.printStackTrace();
			url="error/500_error";
		}
		request.setAttribute("member", member);
	
		ViewResolver.view(request, response, url);
	}

}
