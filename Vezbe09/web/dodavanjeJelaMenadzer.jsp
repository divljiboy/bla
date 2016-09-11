
<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo"%>
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

<script type="text/javascript">
	function pr() {
		var x = document.URL;
		if (x === "http://localhost:8080/Vezbe09/restorani.jsp?Nijeuspelo") {
			alert("Upis nije ispavan!");
		}
	}
</script>

<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />


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
				<table>
					<thead>
						<tr>
							<th>Ime restorana</th>
							<th>Opis</th>
							<th>&nbsp;</th>
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
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><a href="dodajRestoran.jsp">Dodaj restoran</a></td>
					</tbody>
				</table>
			</form>
		</c:if>









		<c:if test="${sessionScope.menadzer!=null}">
			<jsp:useBean id="jela"
				type="java.util.HashSet<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelo>"
				scope="session" />
			<jsp:useBean id="jeloNaJelovniku"
				type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Jelovnik"
				scope="session" />

			

			<form action="./PretragaJela" method="post">
				<table>
					<thead>
						<tr>
							<th><input type="text" name="Pretraga" 	placeholder="Unesite ime ili opis jela"></th>
							<th><button>Pretrazi</button></th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>

						</tr>
						<tr>
							<th>Naziv jela:</th>
							<th>Opis jela:</th>
							<th>Cena jela:</th>
							<th>&nbsp;</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jela}" var="jelo">
							<tr>
								<td>${jelo.naziv}</td>
								<td>${jelo.opis}</td>
								<td>${jelo.cena}</td>
								<td><a
									href="./DodavanjeJelaUMeni?id=${jelo.jelo_id}&jelovnik=${jeloNaJelovniku.id}">Dodaj
										Jelo</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="4"><a
								href="./IzmenaMenijaMenadzer?id=${jeloNaJelovniku.id}">
									Vrati se korak u nazad</a></td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" name="id" value="${jeloNaJelovniku.id}">
			</form>
		</c:if>

	


</body>
</html>