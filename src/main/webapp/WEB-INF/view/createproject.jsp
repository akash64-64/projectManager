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
</style>
</head>
<body>
<form action="/send">
<div class="container">
	<label class="form-label">Project Title</label>
	<input class="form-control" type="text" name="title"/>
	<input class="btn btn-success mt-4" type="submit" value="Create"/>
</div>
</form>
</body>
</html>