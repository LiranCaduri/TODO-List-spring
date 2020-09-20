<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <title>Task Manager</title>
        <meta charset="UTF-8">
        <link type="text/css" href="resources/mainPage.css" rel="stylesheet" />
    </head>
    <center>
    <body>
    <form action="Error" method="GET">
        <h1>ERORR</h1>
        <div>
        	${exeption}
        </div>
		<input type="submit" formaction="main" value="OK"/>
        </form>
    </body>
    </center>
</html>
