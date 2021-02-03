<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title></title>
</head>
<body>
	<jsp:include page="headeradminlogin.jsp"/>
	<div style="margin-top: 40px;" align="center">
	<h2>You have deleting a data!</h2>
	<span style="color: green;"><s:property value="msg" /></span><br><br>
	<a href="report">
		<button type="button">See All User</button>
	</a>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>