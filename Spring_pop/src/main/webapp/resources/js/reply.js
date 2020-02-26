/**
 * 
 */
var bno=1;
var str="";
$.getJSON("../replies/all/"+bno,function(data){
	console.log(data.length);
	
	$(data).each(function(){
		str+="<li data-rno='"+this.rno+"' class='replyLi'>"
		+this.rno+":"+this.replytext
		+"<button>수정</button></li>";
		//+"<input type="button" value="수정"></li>";
	});
	$("#replies").html(str);
});
	
$(document).ready(function() {
	// 댓글 쓰기 버튼 클릭 start
	$("#replyAddBtn").on("click",function(){
		var bno = $("#newBno").val();
		var replyer = $("#newReplyWriter").val();
		var replytext = $("#newReplyText").val();
		
		$.ajax({
			type:"post",
			url:"../replies",
			contentType:"application/json",
			data:JSON.stringify({bno:bno,replytext:replytext,replyer:replyer}),
			dataType:"text",
			success : function(data){
				alert("정상 처리 되었습니다.");
			},
			error : function(err) {
				alert("정상 처리 되지 못했습니다.");
			}
		});
	}); // 댓글쓰기 버튼 클릭 end
	
	// 댓글 수정 버튼 클릭 start
	$("#replies").on("click",".replyLi button",function(){
	// $("#replies").on("click",".replyLi $(:button)",function(){
		var reply=$(this).parent();
		var rno=reply.attr("data-rno");
		var replytext = reply.text();
		$(".model-title").html(rno);
		$("#replytext").val(replytext);
		$("modDiv").show("slow");
	});// 댓글 수정 버튼 클릭 end
	
	$("#replyModBtn").on("click",function(){
		var rno=$(".model-title").html();
		var replytext=$("#replytext").val();
		
		$.ajax({
			type:"put",
			url:"../replies/"+rno,
			contentType:"application/json",
			dataType:"text",
			data:JSON.stringify({replytext:replytext}),
			success : function(data){
				if(data=="SUCCESS"){
					alert("수정 되었습니다.");
					$("#modDiv").hide("slow");
				}
			},
			error : function(err) {
				alert("정상 처리 되지 못했습니다.");
			}
		});
	});
	
	// 삭제
	$("#replyDelBtn").on("click",function(){
		var rno=$(".model-title").html();

		$.ajax({
			type:"delete",
			url:"../replies/"+rno,
			contentType:"application/json",
			dataType:"text",
			data:JSON.stringify({replytext:replytext}),
			success : function(data){
				if(data=="SUCCESS"){
					alert("삭제 되었습니다.");
					$("#modDiv").hide("slow");
				}
			},
			error : function(err) {
				alert("정상 처리 되지 못했습니다.");
			}
		});
	});
	
	
	
	
	
	
});























