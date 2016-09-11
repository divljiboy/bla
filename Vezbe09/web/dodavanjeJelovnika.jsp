
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
<script src="./menuvertical.js" type="text/javascript"></script>
<title></title>
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
			<jsp:useBean id="restoran"
				type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran"
				scope="session" />
			
			<form action="./DodajJelovnik" method="post">
				<table>
					<tbody>
					<tr><td>Naziv: </td>
						<td><input type="text" name="jelovnikIme"> </td></tr>
						<tr>
						<td><a href="./InitJelovniciController"> Vrati se korak u nazad</a> </td>
						<td><button type="submit">Sacuvaj </button></td> </tr>
					</tbody>
				</table>
				<input type="hidden" name="id" value="${restoran.id}">
			</form>
		</c:if>

	


</body>
</html>