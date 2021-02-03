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
	
	<div align="center">
		<h2>User Profile of this Website!</h2>
		<h3>Hello, <s:property value="#session['user'].email"/> here your profile view:</h3>
	</div>
	
	<div style="margin-top: 40px;" align="center">
		<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Company Name</th>
						<th>City</th>
						<th>Country</th>
						<th>Password</th>
						<th>Action</th>
					</tr>
				</thead>
					<tr>
						<td><s:property value="firstname" /></td>
						<td><s:property value="lastname" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="companyname" /></td>
						<td><s:property value="city" /></td>
						<td><s:property value="country" /></td>
						<td><s:property value="password" /></td>
						<td>
							<a href="updateuser.action?submitType=updatedata&email=<s:property value="email"/>">
								<button class="button-update">Update</button>
							</a>
						</td>
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