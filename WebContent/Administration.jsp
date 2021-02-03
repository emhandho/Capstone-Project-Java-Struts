<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Report</title>
<style>
table, td, th {border: 1px solid black;}
table {border-collapse: collapse;width: 60%;}
th {height: 30px;}
.button-update {background-color: #008CBA;color: white;}
.button-delete {background-color: red;color: white;}
</style>
</head>
<body>
	<jsp:include page="headeradminlogin.jsp"/>
	<div style="margin-top: 40px;" align="center">
	   <h2>Report User of this Website!</h2>
		<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Sr.No.</th>
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
				<s:iterator value="userList">
					<tr>
						<td><s:property value="srNo" /></td>
						<td><s:property value="firstname" /></td>
						<td><s:property value="lastname" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="companyname" /></td>
						<td><s:property value="city" /></td>
						<td><s:property value="country" /></td>
						<td><s:property value="password" /></td>
						<td>
							<a href="adminupdateuser.action?submitType=updatedata&email=<s:property value="email"/>">
								<button class="button-update">Update</button>
							</a>
							<a href="deleteuser.action?email=<s:property value="email"/>&firstname=<s:property value="firstname"/>&lastname=<s:property value="lastname"/>">
								<button class="button-delete">Delete</button>
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found.</div>
		</s:else>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>