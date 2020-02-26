function checkImageType(fileName) {
	alert("aaa");
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}

function getImageLink(fileName) {
	if(!checkImageType(fileName)) {
		return;
	}
	var front=fileName.substr(0,12);
	var end=fileName.substr(14);
	
	alert("front : "+front);	// /2020/01/07/
	alert("end : "+end);		// s_0b07edde-adf0-423b-9bc8-8936cd4c7554_kmj.jpg
	
	return front+end;
}
function getOriginalName(fileName) {
	alert("filename="+fileName);
	return fileName;
}

$(".fileDrop").on("dragenter dragover", function(event){
	event.preventDefault();
})
$(".fileDrop").on("drop", function(event){
	event.preventDefault();
	var files=event.originalEvent.dataTransfer.files;
	var file=files[0];
	// console.log(file);
	
	var formData = new FormData();
	
	formData.append("file", file);
	
	$.ajax({
		url:"uploadAjax",
		data:formData,
		dataType:"text",
		processData:false,
		contentType:false,
		type:"post",
		success:function(data) {
			// console.log(data);
			// alert(data);
			alert(checkImageType);
			
			var str="";
			if(checkImageType(data)){
				alert("bbb");
				str="<div>"
					+"<img src='displayFile?fileName="+getImageLink(data)+"'/>"
					+"<small data-src=\'"+data+"\'>X</small>"+"</div>";
			} else {
				alert("ccc");
				str="<div><a href='displayFile?fileName="+data+"'>"
					+getOriginalName(data)+"</a></div>";
			}
			$(".uploadedList").append(str);
		}
	});
});	// drop

// small 태그를 click했을 때.
$(".uploadedList").on("click","small",function(event){
	alert("delete?");
	var that = $(this);
	$.ajax({
		url:"deleteFile",
		type:"post",
		data:{fileName:$(this).attr("data-src")},
		dataType:"text",
		success:function(result){
			if(result=="deleted"){
				// alert("delete");
				that.parent("div").remove();
			}
		}
	});
});












