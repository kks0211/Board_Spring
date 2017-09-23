<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Read</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var formObj=$("form[role='form']");
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/board/modify");
		formObj.attr("method", "get");
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/board/remove");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		self.location= "/board/listAll";
	});
	
});

</script>
<body>
<form role="form" method="post">
<input type="hidden" name="bno" value="${boardVO.bno }">
</form>
<div class="box-body">
<div class="form-group">
<label for="exampleInputTitle">Title</label>
<input type="text" name="title" class="form-control" value="${boardVO.title }" readonly="readonly">
</div>
<div class="form-group">
<label for="exampleInputContent">Content</label>
<textarea rows="3" class="form-control" name="content" readonly="readonly">${boardVO.content }</textarea>
</div>
<div class="form-group">
<label for="exampleInputWriter">Writer</label>
<input type="text" name="writer" class="form-control" value="${boardVO.writer }" readonly="readonly">
</div>
</div>
<div class="box-footer">
<button type="submit" class="btn btn-warning">Modify</button>
<button type="submit" class="btn btn-danger">Remove</button>
<button type="submit" class="btn btn-primary">List All</button>
</div>
</body>
</html>