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
.todo{
text-align:center;
}
.b1{
outline:none;
border:none;
height:70px;
margin-top:20px;
}
.export{
position:absolute;
right:120px;
}
</style>
</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<div class="container mt-4">
<h1 class="todo display-2">TODOs</h1>
<div id="popup" style="display:none">
<form action="/addtodos/${id}">
<div class="container mt-5">
<label class="form-label"><strong>Description</strong></label>
<input class="form-control w-75" type="text" name="desc"/>
<div class="form-check form-check-inline">
<input class="form-check-input" type="radio" name="status" value="Pending"/>
<label class="form-check-label">Pending</label></div>
<div class="form-check form-check-inline mt-3">
<input class="form-check-input" type="radio" name="status" value="Completed"/>
<label class="form-check-label">Completed</label></div> <br/>
<input class="btn btn-success mt-3" type="submit" value="Add" onclick="closePopup()"/>
<input class="btn btn-danger ms-3 mt-3" style="width:40px" value="X" type="button" onclick="closePopup()"/>
</div>
</form>
</div>

<div id="titlechange" style="display:none">
<form action="/change/${project.projectId}">
<label class="form-label">New Project Title</label>
<input class="form-control w-25" type="text" name="title" value="${project.projectTitle}"/>
<input class="btn btn-success mt-3" type="submit" value="change" onclick="Close()"/>
<input class="btn btn-danger ms-3 mt-3" style="width:40px" value="X" type="button" onclick="Close()"/>
</form>
</div>

<h2 class="display-3">Project Title: <span class="text-success">${project.projectTitle}</span> <button class="b1"><i class="fa-solid fa-pen-to-square text-primary" style="font-size:40px" onclick="change()"></i></button></h2>
<table style="width:100%">
<thead>
<tr class="bg-dark text-white">
<th>TodoId</th>
<th>Description</th>
<th>status</th>
<th>creation Date</th>
<th>Updated Date</th>
<th>Update</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach var="data" items="${todo}">
<tr class="bg-white">
<td>${data.todoId}</td>
<td>${data.description}</td>
<td>${data.status}</td>
<td>${data.creationDate}</td>
<td>${data.updatedDate}</td>
<td><a href="/update/${project.projectId}/${data.todoId}" class="btn btn-primary text-white">Update</a></td>
<td><a href="/delete/${project.projectId}/${data.todoId}" class="btn btn-danger text-white">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<!--  <a href="/addtodos" class="btn btn-success text-white mt-4">Add Todo</a>-->
<button class="btn btn-success text-white mt-4" onclick="openPopup()">Add Todo</button><br/>
<a class="btn btn-info mt-4" href="/home">Go Back</a>
<a href="/export-summary/${project.projectId}" class="btn btn-warning export">Export <i class="fa-solid fa-download"></i></a>
</div>

<!--<div id="updatetodo" class="container" style="display:none">
<form>
<label class="form-label">Description</label>
<input class="form-control w-50" type="text" name="description" value="${data.description}" />
<div class="form-check form-check-inline">
<input class="form-check-input" type="radio" name="status" value="Pending"/>
<label class="form-check-label">Pending</label></div>
<div class="form-check form-check-inline mt-3">
<input class="form-check-input" type="radio" name="status" value="Completed"/>
<label class="form-check-label">Completed</label></div> <br/>
<input class="btn btn-success mt-3" type="submit" value="Done" onclick="updateclose()"/>
<input class="btn btn-danger mt-3" type="button" value="X" onclick="updateclose()"/>
</form>
</div>-->


 <script>
        function openPopup() {
            document.getElementById("popup").style.display = "block";
        }
        
        function closePopup(){
        	document.getElementById("popup").style.display="none";
        }
        
        function change(){
        	document.getElementById("titlechange").style.display="block";
        	
        }
        function Close(){
        	document.getElementById("titlechange").style.display="none";
        }
        function update(){
        	document.getElementById("updatetodo").style.display="block";
        }
        
        function updateclose(){
        	document.getElementById("updatetodo").style.display="none";
        }
</script>
<script
      src="https://kit.fontawesome.com/1c3794f55c.js"
      crossorigin="anonymous"
    ></script>
</body>
</html>