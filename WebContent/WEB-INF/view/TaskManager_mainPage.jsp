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
				<h1 style="color: #0040ff73">Task Manager</h1>
				<div>

					<form method="post" name="form">
						<button type="submit" formaction="show">
							<span>Show</span>
						</button>
						<button type="submit" formaction="add">
							<span>Add</span>
						</button>
						<button type="submit" formaction="delete">
							<span>Delete</span>
						</button>
						<button type="submit" formaction="edit">
							<span>Edit</span>
						</button>
					</form>
					<table border="1">

						<tr>
							<th></th>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Priority</th>
						</tr>
						<c:forEach items="${tasks}" var="task">
							<tr>

								<td>
									<div class="radio">
										<input type="radio" name="button" value="${task.taskName}"
											id="${task.taskName}">
									</div>
								</td>
								<td><p>${task.taskId}</p></td>
								<td><p>${task.taskName}</p></td>
								<td><p>${task.taskDescribe}</p></td>


								<c:choose>
									<c:when test="${task.priority==1}">
										<td><img src="${pageContext.request.contextPath}/resources/veryhigh.png"></td>
									</c:when>
									<c:when test="${task.priority==2}">
										<td><img src="${pageContext.request.contextPath}/resources/high.png"></td>
									</c:when>
									<c:when test="${task.priority==3}">
										<td><img src="${pageContext.request.contextPath}/resources/mid.png"></td>
									</c:when>
									<c:when test="${task.priority==4}">
										<td><img src="${pageContext.request.contextPath}/resources/low.png"></td>
									</c:when>
									<c:when test="${task.priority==5}">
										<td><img src="${pageContext.request.contextPath}/resources/verylow.png"></td>
									</c:when>
								</c:choose>



							</tr>

						</c:forEach>
					</table>
				</div>
		</form>
	</center>
</body>
</html>