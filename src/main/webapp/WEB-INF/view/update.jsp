<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
body{
background-color:#F6F5F2;
}
.one{
position:absolute;
top:30%;
left:40%;
}
</style>
</head>
<body>
<form action="/updated/${id}/${todo.todoId}">
<div class="container">
<div class="one">
<h1>Update</h1>
<label class="form-label">Description</label>
<input class="form-control" type="text" name="desc" value = "${todo.description}"/>
<div class="form-check form-check-inline">
<input class="form-check-input" type="radio" name="status" value="Pending"/>
<label class="form-check-label">Pending</label></div>
<div class="form-check form-check-inline mt-3">
<input class="form-check-input" type="radio" name="status" value="Completed"/>
<label class="form-check-label">Completed</label></div> <br/>
<input class="btn btn-primary mt-3" type="submit" value="update"/>
<a class="btn btn-danger ms-3 mt-3" href="/todo/${id}">Cancel</a>
</div>
</div>
</form>
</body>
</html>