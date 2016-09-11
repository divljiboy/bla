
<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran"%>
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
		<jsp:useBean id="svaJela"
			type="java.util.List<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo>"
			scope="session" />


		<form>
			<table>
				<thead>
					<tr>
						<th>Naziv</th>
						<th>Opis</th>
						<th>Cena</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${svaJela}" var="jelo">
						<tr>
							<td>${jelo.naziv}</td>
							<td>${jelo.opis}</td>
							<td>${jelo.cena}</td>

						</tr>

					</c:forEach>
				</tbody>
			</table>
		</form>
	</c:if>



	<c:if test="${sessionScope.gost!=null}">


		<table>
			<tr>
				<th>Ime</th>
				<th>Prezime</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>

			<c:forEach items="${gosti}" var="prijatelj">
				<tr>
					<td>${prijatelj.firstName}</td>
					<td>${prijatelj.lastName}</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>


	</c:if>




	<c:if test="${sessionScope.menadzer!=null}">

	</c:if>

	


</body>
</html>