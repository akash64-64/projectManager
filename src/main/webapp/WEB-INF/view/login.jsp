<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<form action="/login" method="post">
<div class="container mt-4 bg-white border border-dark">
<label class="form-label">UserName:</label>
<input class="form-control" type="text" name="name" required/>
<label class="form-label">Password</label>
<input class="form-control" type="password" name="pass" required/>
<input class="btn btn-success text-white mt-3" type="submit" value="Log In"/>
</div>
</form>
</body>
</html>