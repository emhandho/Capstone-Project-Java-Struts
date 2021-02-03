<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Update</title>
	<style type="text/css">
		form {display: block; margin-top: 10px;}
		.button-update {background-color: green; color: white; margin-left: 70%}
		.button-logout {background-color: blue; color: white;}
		
		input {
		  width: 60%;
		  padding: 12px 20px;
		  margin: 8px 0;
		  display: inline-block;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
		}

		input[type=submit] {
		  width: 30%;
		  background-color: #4CAF50;
		  color: white;
		  padding: 14px 20px;
		  margin: 8px 0;
		  border: none;
		  border-radius: 4px;
		  cursor: pointer;
		}

		input[type=submit]:hover {
		  background-color: #45a049;
		}
		
		.form {
		  border-radius: 5px;
		  background-color: #f2f2f2;
		  padding: 20px;
		}
	</style>
</head>
<body>
	<jsp:include page="headerlogin.jsp"/>
	
	<div align="center" class="form">
		<h2>Update your data!</h2>
		<form action="updateuser" method="post">
			<label for="firstname">First Name :</label>
			<input type="text" name="firstname" value='<s:property value="firstname"/>'><br><br>
			
			<label for="lastname">Last Name :</label>
			<input type="text" name="lastname" value='<s:property value="lastname"/>'><br><br>
					
			<label for="email">Email :</label>
			<input type="email"  name="email" value='<s:property value="email"/>'>
			<input type="hidden" name="emailhidden" value='<s:property value="email"/>'><br><br>
			
			<label for="companyname">Company Name :</label>
			<input type="text" name="companyname" value='<s:property value="companyname"/>'><br><br>
			
			<label for="city">City :</label>		 
			<input type="text" name="city" value='<s:property value="city"/>'><br><br>
			
			<label for="country">Country :</label>	 
			<input type="text" name="country" value='<s:property value="country"/>'><br><br>
					
			<label for="password">Password :</label>
			<input type="password" name="password" value='<s:property value="password"/>'><br><br>
		
			<input name="submitType" value="update" type="submit"/>
		</form>
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