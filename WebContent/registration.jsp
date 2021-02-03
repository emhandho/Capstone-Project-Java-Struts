<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title>Register</title>
		<style type="text/css"> 
			.button-register {background-color: green; color: white; margin-left: 70%}
			.button-report {background-color: #000000; color: white; margin-left: 30%}
			s:form s:textfield {color: black;}
		</style>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		
		<div align="center">
			<h2>Create your ABCJobs account</h2>
			<s:form action="registeruser" method="post">
				<s:textfield label="First Name" required="true" name="ufirstname"/>
				<s:textfield label="Last Name" required="true" name="ulastname"/>
				<s:textfield label="Email" required="true" name="uemail"/>
				<s:textfield label="Company Name" name="ucomname"/>
				<s:textfield label="City" name="ucity"/>
				<s:textfield label="Country" name="ucountry"/>
				<s:password label="Password" required="true" name="upass"/>
				<s:submit class="button-register" value="Register"/>
			</s:form>
			<s:if test="ctr>0">
				<span style="color: green"><s:property value="msg" /></span>
			</s:if>
			<s:else>
				<span style="color: red"><s:property value="msg" /></span>
			</s:else>
			
			<br><br><span class="other-letter"><a href="login">You already have an account?</a> </span>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>