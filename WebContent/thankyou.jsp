<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Thank You</title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
			<div align="center">
			<h2>Thank you for joining with us!</h2>
			<span style="color: green;"><s:property value="msg"/></span><br><br>
			
			<a href="login">Log in here...</a>
			</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>