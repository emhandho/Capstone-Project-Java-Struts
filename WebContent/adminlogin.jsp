<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Log in to ABCJobs as Admin</title>
		<style type="text/css">
			.button-login{background-color: blue; color: white; margin-left: 75%}
			.error-msg{colo:red}
			.other-letter{color: blue}
		</style>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
	
		<div align="center">
			<h2>Log in to ABCJobs as Administrator</h2>
			<s:fielderror name="invalid" class="error-msg"/>
			<s:form action="loginadmin" validate="true" method="post">
				<s:textfield label="Username" required="true" name="uemail"/>
				<s:password label="Password" required="true" name="upass"/>
				<s:submit class="button-login" value="Login"/>
			</s:form>
		</div>
		
		<jsp:include page="footer.jsp"/>
	</body>
</html>