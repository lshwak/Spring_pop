$(document).ready(function(){
	
	// 수정버튼(id가 modity인 것)을 클릭했을 때
	$("#modity").click(function(){
		("#form1").attr("action","modify")
	})
	// 삭제 버튼은 클릭했을 때
	$("#delete").click(function(){
		("#form1").attr("action","delete")
	})
	
})











