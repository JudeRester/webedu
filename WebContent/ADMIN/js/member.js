$(function(){
//   $("#memJoin").click(function(){
   $("input[value='관리자등록']").click(function(){
      if($("#id").val()==""){
         alert("아이디를 입력하세요!");
         $("#id").focus();
         return false;
      }
      
      if($("#id").val().length < 4){
         alert("아이디를 입력하세요!");
         $("#id").focus();
         return false;
      }
      
      if($("#passwd").val()==""){
         alert("비밀번호를 입력하세요!");
         $("#passwd").focus();
         return false;
      }
      
      if($("#passwd").val() != $("#passwd_chk").val()){
         alert("비밀번호가 일치하지 않습니다!");
         $("#passwd_chk").focus();
         return false;
      }
    document.join_frm.submit();
   });
});

$(function(){
   $("modify").click(function(){
      if($("#passwd").val()==""){
         alert("비밀번호를 입력하세요!");
         $("#passwd").focus();
         return false;
      }
      
      if($("#passwd").val() != $("#passwd_chk").val()){
         alert("비밀번호가 일치하지 않습니다!");
         $("#passwd_chk").focus();
         return false;
      }
      
      document.modify_frm.submit();
   })
})








/*
function mem_check(){
		if(document.join_frm.id.value.length ==0){
			window.alert("아이디를 입력해 주세요");
			join_frm.id.focus();
			return;
		}
		if(document.join_frm.id.value.length < 4){
			window.alert("아이디는 최소 10자 이상이어야 합니다.");
			join_frm.id.focus();
			return;
		}
		if(document.join_frm.passwd.value.length ==0){
			window.alert("패스워드를 입력해 주세요");
			join_frm.passwd.focus();
			return;
		}
		if(document.join_frm.passwd.value != document.join_frm.passwd_chk.value){
			window.alert("패스워드를 확인해 주세요");
			join_frm.passwd_chk.focus();
			return;
		}
		document.join_frm.submit();
	}
	
	function updateInfo(){
		if(document.modify_frm.passwd.value.length ==0){
			window.alert("패스워드를 입력해 주세요");
			join_frm.passwd.focus();
			return;
		}
		if(document.modify_frm.passwd.value != document.modify_frm.passwd_chk.value){
			window.alert("패스워드가 일치하지 않습니다.");
			document.modify_frm.passwd.focus();
			return;
		}
		document.modify_frm.submit();
	}

	*/
