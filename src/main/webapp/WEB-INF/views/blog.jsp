<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	padding: 0;
	margin: 0;
}

body {
	font-family: sans-serif;
	background-image: url(< c :url value = "/resources/images/background.jpg"/ >);
}

a {
	text-decoration: none;
	color: #00A5CC;
}

li {
	list-style-type: none;
}

nav {
	width: 100%;
	text-align: center;
}

nav a {
	display: block;
	padding: 15px 0;
	border-bottom: 1px solid #C3AA6E;
}

nav a:hover {
	background: #E5DAC0;
	color: #FFF;
}

nav li:last-child a {
	border-bottom: none;
}

.menu {
	width: 240px;
	height: 100%;
	position: absolute;
	background: #D9C9A3;
}


</style>
</head>
<body>
	<br><br><br><br><br>
	<center><a href="newblog">Add New Blog </a>
	<a href="search" >Search For Blogs</a>
	</center>
	<nav class="menu">
		<ul>
			<li><a href="chat">Chat</a></li>
			<li><a href="forum">Forum</a></li>
			<li><a href="login">Logout </a></li>
			<li><a href="home">Back </a></li>
		</ul>
	</nav>
<%@ include file="footer.jsp" %>	
</body>
</html>

