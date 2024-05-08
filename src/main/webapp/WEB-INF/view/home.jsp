<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<style>
table,th,td {
  border:1px solid black;
}
body{
background-color:#F6F5F2;
}
th{
text-align:center;
}
a{
text-decoration:none;
color:black;
}
.one{
text-align:center;
}
</style>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active text-white" href="/index">Home <span class="sr-only"></span></a>
      <a class="nav-item nav-link text-white logout" href="/logout">Logout</a>
    </div>
  </div>
</nav>

<h1 class="display-1 one">Project Manager</h1>
<div class="container mt-4">
	<table style="width:100%">
	<thead>
	<tr class="bg-dark text-white">
	<th>project Id</th>
	<th>project Title</th>
	<th>created Date</th>
	</tr>
	</thead>
	<c:forEach var="data" items="${project}">
	<tbody>
	<tr class="bg-white">
	<td>${data.projectId}</td>
	<td><a href="/todo/${data.projectId}">${data.projectTitle}</a></td>
	<td>${data.createdDate}</td>
	</tr>
	</tbody>
	</c:forEach>
	</table>
	<a href="/createproject" class="btn btn-success text-white mt-4">Create Project</a>
</div>
</body>
</html>