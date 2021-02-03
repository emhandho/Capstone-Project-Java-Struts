<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.nav-content {
	margin: 15px;
}

.topnav a, .logo {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.logo {
  font-size: 40px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

.search-container, .nav-right {
	float: right;
}

.btn {
  border-radius: 12px;
  color: white;
  padding: 5px 28px;
  font-size: 12px;
  cursor: pointer;
}
.danger {background-color: #f44336;} /* Red */ 
.danger:hover {background: #da190b;}

.logout {
	margin: 10px;
}
</style>
</head>
<body>

<div class="topnav" id="myTopnav">
  <span class="logo">
  	ABCJobs
  </span>
  <div class="nav-content">
	  <a href="loginadmin">Home</a>
	  <a href="#about">About</a>
	  <a href="report">All User</a>
	  <div class="search-container">
	    <form action="adminsearchuser">
	      <input type="text" placeholder="Search.." name="search">
	      <button type="submit"><i class="fa fa-search"></i></button>
	    </form>
	  </div>
	  <div class="nav-right logout">
		  <form action="logoutuser">
			<button type="submit" class="btn danger">Logout</button>
		  </form>
	  </div>
	  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
	    <i class="fa fa-bars"></i>
	  </a>
  </div>
</div>

<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>

</body>
</html>
