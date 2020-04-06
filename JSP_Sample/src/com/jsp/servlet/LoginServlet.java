package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private MemberService service = MemberServiceImpl.getInstance();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/common/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/WEB-INF/views/common/login_success.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//로그인 처리부
		
		MemberVO paramVO = new MemberVO();
		paramVO.setId(id);
		paramVO.setPwd(pwd);
		MemberVO mv = service.loginCheck(paramVO);

		if(mv == null){
			//로그인 실패
			request.setAttribute("id", id);
			url = "/WEB-INF/views/common/loginForm.jsp";			
		} else {
			//로그인 성공
			MemberVO user = new MemberVO();
			user.setId(id);
			user.setPwd(pwd);
			user.setName(mv.getName());
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
