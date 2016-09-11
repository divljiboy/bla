
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setBundle basename="messages.messages" />

<html>
<head>
<title><fmt:message key="prijava" /></title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
<link href="./login.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />

</head>
<body>
<!-- 
	<form id="login" action="./LoginAdminController" method="post"
		accept-charset="UTF-8">
		<h1>
			<fmt:message key="prijava" />
		</h1>
		<fieldset id="inputs">
			<input id="username" type="text" name="korisnickoIme"
				placeholder="<fmt:message key="korisnickoIme"/>"
				autofocus="autofocus" required="required"> <input
				id="password" type="password" name="lozinka"
				placeholder="<fmt:message key="lozinka"/>" required="required">
		</fieldset>
		<fieldset id="actions">
			<input type="submit" id="submit"
				value="<fmt:message key="prijaviSe"/>"> </a>
		</fieldset>
	</form>
 -->

	<form class="form-horizontal" id="login"
		action="./LoginAdminController" method="post" accept-charset="UTF-8">
		<fieldset>

			<!-- Form Name -->
			<legend></legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="korisnickoIme"><fmt:message
						key="korisnickoIme" /></label>
				<div class="col-md-4">
					<input id="korisnickoime" name="korisnickoIme" type="text"
						placeholder="" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="lozinka"><fmt:message
						key="lozinka" /></label>
				<div class="col-md-4">
					<input id="lozinka" name="lozinka" type="password" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button  type="submit" id="singlebutton" name="singlebutton"
						class="btn btn-primary">Prijavi se</button>
				</div>
			</div>
			<div class="form-group">
			<a href="start.jsp">Vrati
				se nazad</a>
</div>
		</fieldset>
	</form>



	<script src="./jquery.min.js"></script>
	<script src="./bootstrap.min.js"></script>


</body>
</html>

