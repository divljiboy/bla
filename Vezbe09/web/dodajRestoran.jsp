
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

		<form action="./DodajRestoranController" method="post">
			<table>
				<thead>
					<tr>
						<th>Novi Restoran</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Ime restorana:</td>
						<td><input type="text" name="ime_restorana" required></td>
					</tr>
					<tr>
						<td>Opis:</td>
						<td><input type="text" name="opis_restorana" required></td>
					</tr>
					<tr>
						<td><a href="restorani.jsp">Odustani</a></td>
						<td>
							<button type="submit">Sacuvaj podatke</button>
						</td>
					</tr>

				</tbody>
			</table>
		</form>
	</c:if>















































	</div>


</body>
</html>