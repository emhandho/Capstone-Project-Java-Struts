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
				<h2>Find user!</h2>
			</div>
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Sr.No.</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="srNo" /></td>
						<td><s:property value="firstname" /></td>
						<td><s:property value="lastname" /></td>
						<td><s:property value="email" /></td>
						<td>
							<a href="viewprofile.action?email=<s:property value="email"/>">
								<button class="button-update">View Profile</button>
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No User Found.</div>
		</s:else>
		
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>