<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Here your Profile</title>
	<style>
		table, td, th {border: 1px solid black;}
		table {border-collapse: collapse;width: 60%;}
		th {height: 30px;}
		.button-update {background-color: #008CBA;color: white;}
		.button-delete {background-color: red;color: white;}
		.button-logout {background-color: blue; color: white;}
	</style>
</head>
<body>
	<jsp:include page="headerlogin.jsp"/>
	
	<div style="margin-top: 40px;" align="center">
		<s:if test="noData==true">
		    <div align="center">
				<h2>User Profile Preview</h2>
				<h3>You are viewing <s:property value="firstname"/> <s:property value="lastname"/> profile:</h3>
	        </div>
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Company Name</th>
						<th>City</th>
						<th>Country</th>
					</tr>
				</thead>
					<tr>
						<td><s:property value="firstname" /></td>
						<td><s:property value="lastname" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="comname" /></td>
						<td><s:property value="city" /></td>
						<td><s:property value="country" /></td>
					</tr>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found.</div>
		</s:else>
		
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>