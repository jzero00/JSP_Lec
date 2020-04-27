//팝업창들 띄우기
//새로운 Window창을 Open할 경우 사용되는 함수 ( arg : 주소 , 창타이틀 , 넓이 , 길이 )
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth +", " 
							+"height="+ WinHeight +", top="+ wintop +", left=" 
							+ winleft +", resizable=yes, status=yes"  );
  win.focus() ; 
}

//팝업창 닫기
function CloseWindow(){
	window.opener.location.reload(true);
	window.close();
}

//-----------------------------------------------

// form submit
function SubmitMemberRegist(formRole){
	var uploadCheck = $('input[name="checkUpload"]').val();
	if(!(uploadCheck>0)){
		alert("사진 업로드는 필수입니다.");	
		//$('input[name="pictureFile"]').click();
		return;
	}
	/* 유효성 검사 부분 함수로 만들기
	 * var id = $('input[name=name]').val();
	 * alert(id);
	 */
//	var flag = false;
//	form_valid(flag);
	var check = function form_valid(){
		idCheck();
	}
	if(check == false){
		return;
	}
	
	var form = $('form[role="'+formRole+'"]');
	form.submit();
}




function idCheck(){
	
	var id = $('input[name=id]').val().trim();
	var idlen = id.length;
	alert(id);
	alert(idlen);
	if(idlen == 0){
		alert("ID를 입력하세요.");
		return false;
	}
	if(idlen < 8 || idlen > 12 ) {
		alert("ID는 8~12자리 사이로 입력하세요.");
		return false;
	}
	
	idreg = /^[0-9a-zA-Z]{8,12}$/;
	if(!(idreg.test(id))){
		alert("ID 형식 오류..");
		return false;
	}
	return true;
}