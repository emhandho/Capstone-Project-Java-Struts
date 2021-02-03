<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ABCJobs</title>
		<style>
		.button-logout {background-color: blue; color: white;}
		.button-report {background-color: #000000; color: white;}
		</style>	
	</head>
	<body>
		<jsp:include page="headerlogin.jsp"/>
		
		<div align="center">
			<h3>Hello, <s:property value="#session['user'].email"/></h3>
			<h2>Welcome to landing page of this Website!</h2>
			<a href="profileuser"><button class="button-report" type="button">View your Profile</button></a>
		</div>
		
		<jsp:include page="footer.jsp"/>
	</body>
</html>