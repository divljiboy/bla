
<%
	response.setHeader("Cache-Control",
	"no-cache, no-store, must-revalidate");
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

<script type="text/javascript">
	function pr() {
		var x = document.URL;
		if (x === "http://localhost:8080/Vezbe09/restorani.jsp?Nijeuspelo") {
			alert("Upis nije ispavan!");
		}
	}
</script>



<script src="sorttable.js"></script>
</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>

<body onload="pr()">
	<jsp:include page="./navbar.jsp" />



		<c:if test="${sessionScope.admin!=null}">
			<jsp:useBean id="restorani2" type="java.util.List<Restoran>"
				scope="session" />

			

			<form>
				<table class="sortable">
					<thead>
						<tr>
							<th>Ime restorana</th>
							<th>Opis</th>
							<th><a href="dodajRestoran.jsp">Dodaj restoran</a></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${restorani2}" var="restoran">
							<tr>
								<td>${restoran.naziv}</td>
								<td>${restoran.opis}</td>
								<td><a href="./RestoranAdminController?id=${restoran.id}">Obrisi</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</c:if>













		<c:if test="${sessionScope.gost!=null}">
			<jsp:useBean id="restorani" type="java.util.List<Restoran>"
				scope="session" />
			
			<form action="./InitRestoranController" method="post">
				<table class="sortable">
					<thead>
						<tr>
							<th>Ime restorana</th>
							<th>Opis</th>
							<th>Rejting</th>
							<th>Prijatelji</th>
							<th><input type="text" name="ImeIliVrsta"
								placeholder="Unesite ime ili opis restorana"></th>
							<th><button type="submit">Pretrazi</button></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${restorani}" var="restoran">
							<tr>
								<td>${restoran.naziv}</td>
								<td>${restoran.opis}</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td colspan="2"><a href="./RezervacijaController?id=${restoran.id}">Rezervisi</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</c:if>







		<c:if test="${sessionScope.menadzer!=null}">
			<jsp:useBean id="restoran"
				type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran"
				scope="session" />

			

			<form>
				<table class="sortable">
					<thead>
						<tr>
							<th>Ime restorana</th>
							<th>Opis</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${restoran.naziv}</td>
							<td>${restoran.opis}</td>
							<td><a href="./IzmenaRestoranaMenadzer">Izmeni</a></td>
						</tr>
					</tbody>
				</table>
			</form>

		</c:if>

	</div>


</body>
</html>