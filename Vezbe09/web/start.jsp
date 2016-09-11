
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setBundle basename="messages.messages" />
<html>
<head>
<title><fmt:message key="prijava" /></title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
<!-- <link href="./registracija.css" rel="stylesheet" type="text/css" /> -->
<link href="./bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<form id="login" action="" method="post" accept-charset="UTF-8">
		<h1>Registracija</h1>
	
		<fieldset id="inputs">
			


			<nav class="navbar navbar-light bg-faded">
				<a class="navbar-brand" href="loginKorisnik.jsp">Korisnik</a>
			</nav>
			<nav class="navbar navbar-light bg-faded">
				<a class="navbar-brand" href="loginMenadzer.jsp">Menadzer</a>
			</nav>
			<nav class="navbar navbar-light bg-faded">
				<a class="navbar-brand" href="login.jsp">Admin</a>
			</nav>

		</fieldset>
	</form>
	<script src="./jquery.min.js"></script>
	  <script src="./bootstrap.min.js"></script>

</body>
</html>