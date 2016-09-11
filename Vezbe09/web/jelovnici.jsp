<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik"%>
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
<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript">
	function pr() {
		var x = document.URL;
		if (x === "http://localhost:8080/Vezbe09/jelovnici.jsp?Nijeuspelo") {
			alert("Upis nije ispavan!");
		}
	}
</script>



</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>

<body onLoad=pr()>
	<jsp:include page="./navbar.jsp" />



	<c:if test="${sessionScope.admin!=null}">
		<jsp:useBean id="sviJelovnici"
			type="java.util.List<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik>"
			scope="session" />

		<form>
			<table>
				<thead>
					<tr>
						<th>Naziv jelovnika</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sviJelovnici}" var="jelovnik">
						<tr>
							<td align="center"><a
								href="./AdminJelovniciController?id=${jelovnik.id}">${jelovnik.naziv}</a></td>
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
			prijatelji
		</table>


	</c:if>




	<c:if test="${sessionScope.menadzer!=null}">
		<jsp:useBean id="restoran"
			type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran"
			scope="session" />
		<jsp:useBean id="jelovnici"
			type="java.util.HashSet<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik>"
			scope="session" />
		

		<form action="./IzmenaRestoranaMenadzer" method="post">
			<table>
				<thead>
					<th align="center" colspan="2">Jelovnici</th>
				</thead>
				<tbody>
					<c:forEach items="${jelovnici}" var="jelovnik">
						<tr>
							<td><a href="./IzmenaMenijaMenadzer?id=${jelovnik.id}">${jelovnik.naziv}</a>
							</td>
							<td><a href="./ObrisiJelovnik?id=${jelovnik.id}">Obrisi</a>
							</td>
						</tr>
					</c:forEach>


					<tr>
						<td>&nbsp;</td>
						<td><a href="./DodajJelovnik">Kreiraj Jelovnik</a></td>
					</tr>
				</tbody>
			</table>

		</form>




	</c:if>

	


</body>
</html>