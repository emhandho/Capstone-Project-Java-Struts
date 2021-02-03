<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ABCJobs Welcome page!</title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div align="center">
			<h2>Welcome to ABCJobs</h2>
			<p>Here <span><a href="registration">join</a></span> with the Big Comunity of Software Developer.<br>
			You already have an account? <span><a href="login">Log in here</a></span></p>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>