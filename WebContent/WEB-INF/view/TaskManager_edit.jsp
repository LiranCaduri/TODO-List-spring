<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<link rel="stylesheet" href="resources/designADD.css">

<head>
</head>

<body>
<form action="afterEditTask" method="GET">
<div>
	
	<h1>Edit Task</h1>
	 <div class="inset">
			  <p>
			    <label for="email">Edit ID</label>
			    <input type="text" name="id" value="${taskId}" id="id">
			  </p>
			  <p>
			    <label for="password">Edit Name</label>
			    <input type="text" name="name" value="${taskName}" id="name">
			  </p>
			  
			   <p>
			    <label for="email">Edit Description</label>
			    <input type="text" name="description"  value="${taskDescription}" id="description">
			  </p>
			    <label for="email">Edit Priority</label>
	<select name="priority">
				<option selected>${priority}</option>
			    <option value="Very High">Very High</option>
			    <option value="High">High</option>
			    <option value="Medium">Medium</option>
			    <option value="Low">Low</option>
			    <option value="Very Low">Very Low</option>
  </select>
  </div>
	
</div>
	<input type="submit" value="Edit"/>
	<input type="submit" value="Cancel"/>

</form>
</body>
