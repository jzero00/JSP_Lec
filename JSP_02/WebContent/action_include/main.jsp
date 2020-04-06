<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	
	<%String msg="Hello World"; %>
	
	<%--@ include file="header.jsp" --%>
		<jsp:include page="header.jsp">
			<jsp:param value="<%=msg %>" name="msg"/>
		</jsp:include>
	
	<h1>main.jsp : <%=msg %></h1>
	
	<%--@ include file="footer.jsp" --%>
		<jsp:include page="footer.jsp">
			<jsp:param value="<%=msg %>" name="msg"/>
		</jsp:include>
	
</body>
</html>