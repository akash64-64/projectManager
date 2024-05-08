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
</style>
</head>
<body>
<form>
<div class="container mt-5">
<label class="form-label"><strong>Description</strong></label>
<input class="form-control w-75" type="text" name="desc"/>
<div class="form-check form-check-inline">
<input class="form-check-input" type="radio" name="status" value="Pending"/>
<label class="form-check-label">Pending</label></div>
<div class="form-check form-check-inline mt-3">
<input class="form-check-input" type="radio" name="status" value="Completed"/>
<label class="form-check-label">Completed</label></div> <br/>
<input class="btn btn-success mt-3" type="submit" value="Add"/>
</div>
</form>
</body>
</html>