
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setBundle basename="messages.messages" />

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>

<body>


	<jsp:include page="./navbar.jsp" />


	<c:if test="${sessionScope.admin!=null}">


		<div>
			<form class="form" action="./EditAccountController" id="podaci">

				<p class="name">
					<label for="name"><h3>Ime:</h3></label> <input readonly="readonly"
						type="text" name="name" id="name"
						value="<c:out value="${admin.firstName}"></c:out>" />
				</p>

				<p class="email">
					<label for="email"><h3>Prezime:</h3></label><input type="text"
						name="email" id="email"
						value="<c:out value="${admin.lastName}"></c:out>" />
				</p>

				<p class="submit">
					<input type="submit" value="Izmeni" /> <input type="hidden"
						name="id" value="${admin.id}">
				</p>
			</form>
		</div>

	</c:if>

	<c:if test="${sessionScope.gost!=null}">
		<div>
			<form class="form" action="./EditAccountController" id="podaci">

				<p class="name">
					<label for="name"><h3>Ime:</h3></label> <input readonly="readonly"
						type="text" name="name" id="name"
						value="<c:out value="${gost.firstName}"></c:out>" />
				</p>

				<p class="email">
					<label for="email"><h3>Prezime:</h3></label><input type="text"
						name="email" id="email"
						value="<c:out value="${gost.lastName}"></c:out>" />
				</p>

				<p class="submit">
					<input type="submit" value="Izmeni" /> <input type="hidden"
						name="id" value="${gost.id}">
				</p>
			</form>

		</div>

	</c:if>




		<c:if test="${sessionScope.menadzer!=null}">
		

			<form class="form" action="./EditAccountController" id="podaci">

				<p class="name">
					<label for="name"><h3>Ime:</h3></label> <input readonly="readonly"
						type="text" name="name" id="name"
						value="<c:out value="${menadzer.firstName}"></c:out>" />
				</p>

				<p class="email">
					<label for="email"><h3>Prezime:</h3></label><input type="text"
						name="email" id="email"
						value="<c:out value="${menadzer.lastName}"></c:out>" />
				</p>

				<p class="submit">
					<input type="submit" value="Izmeni" /> <input type="hidden"
						name="id" value="${menadzer.id}">
				</p>
			</form>


		</c:if>






</body>
</html>