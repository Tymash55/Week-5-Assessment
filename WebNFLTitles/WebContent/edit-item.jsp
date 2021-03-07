<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
</head>
<body>
	<form action="editItemServlet" method="post">
	Store: <input type="text" name="team" value="${itemToEdit.team }">
	Item: <input type="text" name="titles" value="${itemToEdit.titles }">
	<input type="hidden" name="id" value="${itemtoEdit.id }">
	<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>