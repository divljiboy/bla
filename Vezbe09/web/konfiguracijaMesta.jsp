
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
<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
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
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><a href="dodajRestoran.jsp">Dodaj restoran</a></td>
						</tr>
					</tbody>
				</table>
			</form>
		</c:if>

		<c:if test="${sessionScope.gost!=null}">
			<jsp:useBean id="restorani" type="java.util.List<Restoran>"
				scope="session" />
			
			<form>
				<table>
					<thead>
						<tr>
							<th>Ime restorana</th>
							<th>Rejting</th>
							<th>Prijatelji</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${restorani}" var="restoran">
							<tr>
								<td>${restoran.naziv}</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td><a href="./RezervacijaController?id=${restoran.id}">Rezervisi</a></td>
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

			
			<form  action="./KonfiguracijaMesta1" method="post">
				<table class="table table-inverse">
					<thead>
						<tr>
							<th colspan="4">Konfiguracija mesta za restoran:</th>
							<th colspan="4">${restoran.naziv}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="0" /></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="1" /></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="2" /></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="3" /></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="4" /></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="5" /></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="6" /></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="7" /></td>
						</tr>
						<tr>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="8"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="9"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="10"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="11"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="12"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="13"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="14"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="15"/></td>
						</tr>
						<tr>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="16"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="17"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="18"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="19"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="20"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="21"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="22"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="23"/></td>
						</tr>
						<tr>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="23"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="24"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="25"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="26"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="27"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="28"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="29"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="30"/></td>
						</tr>
						<tr>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="31"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="32"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="33"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="34"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="35"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="36"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="37"/></td>
							<td bgcolor="#FF0000"><input type="checkbox" name="sto" value="38"/></td>
						</tr>

					</tbody>
				</table>
				
				<button type="submit"  class="btn btn-success">Success</button>
				
			</form>
		</c:if>

	
<script src="./jquery.min.js"></script>
	<script src="./bootstrap.min.js"></script>

</body>
</html>