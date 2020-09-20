<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Task Manager</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/mainPage.css">
</head>
<body>
	<center>
		
	<form>
		<div>
		    <h1 style="color:#0040ff73">Task Manager</h1>
	    <div>
	
		<table border="1">
			
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Priority</th>
			</tr>
				<tr>
					
					<td><p>${task.taskId} </p></td>
					<td><p>${task.taskName} </p></td>
					<td><p>${task.taskDescribe} </p></td>
					
					
					<c:choose>
					   <c:when test="${task.priority==1}"><td><img src="${pageContext.request.contextPath}/resources/veryhigh.png"></td></c:when>
					   <c:when test="${task.priority==2}"><td><img src="${pageContext.request.contextPath}/resources/high.png"></td></c:when>
					   <c:when test="${task.priority==3}"><td><img src="${pageContext.request.contextPath}/resources/mid.png"></td></c:when>
					   <c:when test="${task.priority==4}"><td><img src="${pageContext.request.contextPath}/resources/low.png"></td></c:when> 
					   <c:when test="${task.priority==5}"><td><img src="${pageContext.request.contextPath}/resources/verylow.png"></td></c:when>
					</c:choose>
					
					
					
				</tr>
				
		</table>
		</div>
		<div>
		<br></br>
		<button type="submit" formaction="main">OK</button>
		</div>
		
		</form>
		</center>
</body>
</html>