
<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setBundle basename="messages.messages" />
<html>
<head>
<title><fmt:message key="registracija" /></title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
<link href="./registracija.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function pr() {
		var x = document.URL;
		if (x === "http://localhost:8080/Vezbe09/registracija.jsp?Nijeuspelo") {
			alert("Upis nije ispavan!");
		}
	}
</script>
<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body onload="pr()">
	<form action="./RegisterGostController" id="login" method="post"
		accept-charset="UTF-8">
		<h1>
			<fmt:message key="registracija" />
		</h1>
		<fieldset id="inputs">
			<input id="username" type="text" name="korisnickoIme"
				placeholder="<fmt:message key="korisnickoIme"/>"
				autofocus="autofocus" required="required"> <input
				id="password" type="password" name="lozinka"
				placeholder="<fmt:message key="lozinka"/>" required="required">
			<input id="password" type="password" name="lozinka2"
				placeholder="<fmt:message key="ponovitelozinku"/>"
				required="required">
		</fieldset>
		<fieldset id="actions">
			<input type="submit" id="submit"
				value="<fmt:message key="registracija"/>"> </a><a
				href="loginKorisnik.jsp">Odustanak</a>
		</fieldset>
	</form>
</body>
</html>