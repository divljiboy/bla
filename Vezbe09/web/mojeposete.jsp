
<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<jsp:useBean id="mojeposete"
			type="java.util.HashSet<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija>"
			scope="session" />
			
<jsp:useBean id="mojiutisci"
			type="java.util.HashSet<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Utisak>"
			scope="session" />

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
	if(${mojerezervacije}=="nemateposete"){
		alert("Za sad nemate ni jednu posetu");
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







	<c:if test="${sessionScope.gost!=null}">
		

		<table class="table table-inverse">
			<tr>
				<th>Ime restorana</th>
				<th>Od</th>
				<th>Do</th>
				<th>Sto</th>
				<th>Akcija</th>
			</tr>

			<c:forEach items="${mojeposete}" var="r">
				<tr>
					<td>${r.restoran.naziv}</td>
					<td>${r.od}</td>
					<td>${r.doo}</td>

					<td>${r.sto.pozicija}</td>
					
					<td><a href="./OstaviUtisak?id=${r.rezervacija_id}">Ostavi utisak</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<table class="table table-inverse">
			<tr>
				<th>Ime restorana</th>
				<th>Ocena</th>
				<th>Opis</th>
				
			</tr>

			<c:forEach items="${mojiutisci}" var="r">
				<tr>
					<td>${r.id}</td>
					<td>${r.ocena}</td>
					<td>${r.opis}</td>

					
				</tr>
			</c:forEach>
		</table>





	</c:if>




	<c:if test="${sessionScope.menadzer!=null}">

	</c:if>



	<script src="./jquery.min.js"></script>
	<script src="./bootstrap.min.js"></script>
</body>
</html>