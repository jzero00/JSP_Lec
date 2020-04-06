<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body>
<div class="wrapper">
  <div class="row">
	  <div class="col-sm-3">
	  </div>
	  <div class="col-sm-6">
	  <!-- card card-primary start -->
	  <div class="card card-primary">
		 <div class="card-header">
		   <h3 class="card-title">회원가입</h3>
		 </div>
		 <!-- /.card-header -->
		 <!-- form start -->
		 <form class="form-horizontal">
           <div class="card-body">
             <div class="form-group row">
               <label for="inputid" class="col-sm-3 col-form-label">이름</label>
               <div class="col-sm-6">
                 <input type="text" class="form-control" id="name" value="${param.name}" placeholder="이름">
               </div>
             </div>
             <div class="form-group row">
               <label for="inputid" class="col-sm-3 col-form-label">ID</label>
               <div class="col-sm-6">
                 <input type="text" class="form-control" id="id" value="${param.id}" placeholder="ID">
               </div>
               <div class="col-sm-3">
                 <button type="submit" class="btn btn-info">중복체크</button>
               </div>
             </div>
             <div class="form-group row">
               <label for="pwd" class="col-sm-3 col-form-label">비밀번호</label>
               <div class="col-sm-6">
                 <input type="password" class="form-control" id="pwd" value="${param.pwd}" placeholder="PASSWORD">
               </div>
             </div>
             <div class="form-group row">
               <label for="pwd" class="col-sm-3 col-form-label">비밀번호확인</label>
               <div class="col-sm-6">
                 <input type="password" class="form-control" id="pwd" value="${param.pwdcheck}" placeholder="비밀번호확인">
               </div>
             </div>
             <div class="form-group row">
               <label for="phone" class="col-sm-3 col-form-label">전화번호</label>
               <div class="col-sm-6">
                 <input type="text" class="form-control" id="phone" value="${param.phone}" placeholder="전화번호">
               </div>
             </div>
             <div class="form-group row">
               <label for="address" class="col-sm-3 col-form-label">주소</label>
               <div class="col-sm-9">
                 <input type="text" class="form-control" id="address" value="${param.address}" placeholder="주소">
               </div>
             </div>
             <div class="form-group row">
               <label for="address" class="col-sm-3 col-form-label">이메일</label>
               <div class="col-sm-9">
                 <input type="text" class="form-control" id="email" value="${param.email}" placeholder="이메일">
               </div>
             </div>
             <div class="form-group row">
               <label for="address" class="col-sm-3 col-form-label">프로필이미지</label>
               <div class="col-sm-9">
                 <div class="form-group">
                    <div class="custom-file">
                      <input type="file" class="custom-file-input" id="picture" value="${param.picture}">
                      <label class="custom-file-label" for="customFile">파일 선택</label>
                    </div>
                  </div>
               </div>
             </div>
             
           </div>
           <!-- /.card-body -->
           <div class="card-footer">
             <button type="submit" class="btn btn-info">회원가입</button>
             <button type="button" onclick=cancel() class="btn btn-default float-right">취소</button>
           </div>
           <!-- /.card-footer -->
         </form>
		</div>
		<!-- card card-primary end -->
	  </div>
  </div>
</div>
<!-- ./wrapper -->
</body>
<script>
	function cancel(){
		var check = confirm("회원가입을 취소하시겠습니까?");
		if(check == true){
			alert("회원가입을 취소합니다.")
			history.go(-1);			
		}
	}
</script>
</html>