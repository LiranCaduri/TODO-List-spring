
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Task Manager</title>
<meta charset="UTF-8">
<link type="text/css" href="resources/designADD.css" rel="stylesheet" />
</head>
<body>
	
	<form action="addSubmit" method="GET">
	<div>
				<h1>Add Task</h1>
	 <div class="inset">
			  <p>
			    <label for="email">Enter ID</label>
			    <input type="text" name="id" id="id" readonly="readonly">
			  </p>
			  <p>
			    <label for="password">Enter Name</label>
			    <input type="text" name="name" id="name">
			  </p>
			  
			   <p>
			    <label for="email">Enter Description</label>
			    <input type="text" name="description" id="description">
			  </p>
			  
			   <label for="email">Enter Priority</label>
			  <select name="priority">
				 <option value="Very High">Very High</option>
				 <option value="High">High</option>
				  <option value="Medium">Medium</option>
				   <option value="Low">Low</option>
				    <option value="Very Low">Very Low</option>
				  </select>			
			  
			  </div>

			
				
	</div>
		<input type="submit" value="Save"/>
		<input type="submit" formaction = "cancel" value="Cancel"/>
	</form>
	
	
</body>
</html>