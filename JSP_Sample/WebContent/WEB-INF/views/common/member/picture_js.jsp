<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	function cancel(){
		var check = confirm("회원가입을 취소하시겠습니까?");
		if(check == true){
			alert("회원가입을 취소합니다.")
			history.go(-1);			
		}
	}
	
// 	function 
</script>