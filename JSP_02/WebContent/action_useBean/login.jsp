<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- 
	LoginRequest loginReq = new LoginRequest();
	loginReq.setId(requset.getParameter("id"));
	loginReq.setPwd(requset.getParameter("pwd"));
--%>

<jsp:useBean id="loginReq" class="com.spring.request.LoginRequest">
</jsp:useBean>
<jsp:setProperty property="*" name="loginReq"/>

<%-- <jsp:setProperty name="loginReq" property="id" value='<%=request.getParameter("id") %>'/> --%>
<%-- <jsp:setProperty name="loginReq" property="pwd" value='<%=request.getParameter("pwd") %>'/> --%>

<%
	MemberVO member = loginReq.toMemberVO();
	member.setName("홍길동");
	member.setPhone("010-1234-5678");
	member.setAddress("대전혁신도시 중구 대흥동");
	
	session.setAttribute("loginUser", member);
	session.setMaxInactiveInterval(10);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	아이디 : <%=loginReq.getId() %><br/>
	패스워드 : <%=loginReq.getPwd() %><br/>
	
	<button type="button" onclick="location.href='main.jsp';">메인가기</button>
</body>
</html>