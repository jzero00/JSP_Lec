<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	var formObj = $("form[role='form']");
	
	$('#modifyBtn').on('click', function(){
		alert('수정버튼 클릭')
		formObj.attr("action", "modifyForm.do");
		location.href='modifyForm.do?pno=${pds.pno}';
		formObj.submit();
	});
	
	$('#removeBtn').on('click', function(){
		formObj.attr("action", "remove.do");
		formObj.attr("method", "get");
		
		
	})
</script>