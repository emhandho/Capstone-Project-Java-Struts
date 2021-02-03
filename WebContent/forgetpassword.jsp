<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<style>
	.button-register {background-color: green; color: white; margin-left: 40%; margin-top: 30px;}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	
	<div align="center">
	<h1>Change Your Password</h1>

	<s:form action="changepassword" method="post">
		<s:textfield label="Email" required="true" name="email"/>
		<s:password label="New Password" required="true" name="unewpass"/>
		<s:submit class="button-register" value="Confirm"/>
	</s:form>
	
	<s:if test="ctr>0">
			<span style="color: green;"><s:property value="msg" /></span>
		</s:if>
		<s:else>
			<span style="color: red;"><s:property value="msg" /></span>
		</s:else>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>