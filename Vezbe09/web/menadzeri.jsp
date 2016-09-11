<%@page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager"%>
<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires",0);
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
		if(x==="http://localhost:8080/Vezbe09/menadzeri.jsp?Nijeuspelo")
		{
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
		<jsp:useBean id="menadzeriSistema" type="java.util.List<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager>" scope="session" />
			

			<form>
				<table>
					<thead>
						<tr>
							<th>Ime</th>
							<th>Prezime</th>
							<th>Korisnicko ime</th>
							<th>Lozinka</th>
							<td>&nbsp; </td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${menadzeriSistema}" var="menadzer">
							<tr>
								<td>${menadzer.firstName}</td>
								<td>${menadzer.lastName}</td>
								<td>${menadzer.username}</td>
								<td>${menadzer.password}</td>
								<td><a href="./DodajMenadzeraController?id=${menadzer.id}">Obrisi</a></td>
							</tr>

						</c:forEach>
						<tr>
						<td>&nbsp; </td>
						<td>&nbsp; </td>
						<td>&nbsp; </td>
						<td><td><a href="dodajMenadzera.jsp">Dodaj Menadzera</a> </td></td>
						</tr>
					</tbody>
				</table>
			</form>
		</c:if>













		<c:if test="${sessionScope.gost!=null}">
			

		</c:if>







		<c:if test="${sessionScope.menadzer!=null}">
			
		</c:if>

	</div>


</body>
</html>