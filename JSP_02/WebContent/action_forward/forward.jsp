<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<jsp:forward page="/action_forward/target.jsp?">
	<jsp:param value='<%=URLEncoder.encode("평경장", "utf-8") %>' name="name"/>
	<jsp:param value="60" name="age"/>
</jsp:forward>