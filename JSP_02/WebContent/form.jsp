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
	<form action="form_recieve.jsp" method="post">
		이름 : <input type="text" name="name" /><br/>
		나이 : <input type="text" name="age" /><br/>
		생일 : <input type="date" name="birth" /><br/>
		취미 : 
			<label for="00">영화</label>
			<input type="checkbox" name="hobby" value="영화" id="00"/>
			<label for="01">만화</label>        
			<input type="checkbox" name="hobby" value="만화" id="01"/>
			<label for="02">등산</label>        
			<input type="checkbox" name="hobby" value="등산" id="02"/>
			<label for="03">낚시</label>        
			<input type="checkbox" name="hobby" value="낚시" id="03"/>
			<label for="04">게임</label>        
			<input type="checkbox" name="hobby" value="게임" id="04"/>
			<label for="05">유튜브</label>      
			<input type="checkbox" name="hobby" value="유튜브" id="05"/><br/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>