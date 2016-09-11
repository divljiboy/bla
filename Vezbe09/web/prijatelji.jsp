<%@page import="com.sun.crypto.provider.RSACipher"%>

<%@page import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost"%>
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
	
	<script src="sorttable.js"></script>
</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>

<body>
	<jsp:include page="./navbar.jsp" />



		<c:if test="${sessionScope.admin!=null}">
		<jsp:useBean id="korisniciSistema" type="java.util.List<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost>" scope="session" />
			

			<form>
				<table class="sortable">
					<thead>
						<tr>
							<th>Ime</th>
							<th>Prezime</th>
							<th>Korisnicko ime</th>
							<th>Lozinka</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${korisniciSistema}" var="korisnik">
							<tr>
								<td>${korisnik.firstName}</td>
								<td>${korisnik.lastName}</td>
								<td>${korisnik.username}</td>
								<td>${korisnik.password}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</form>
		</c:if>



		<c:if test="${sessionScope.gost!=null}">
			<jsp:useBean id="prijatelji" type="java.util.HashSet<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost>"
				scope="session" />
				<jsp:useBean id="nisuprijatelji" type="java.util.HashSet<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost>"
				scope="session" />
			

			<form>
			<table class="sortable">
			<thead>
				<tr>
					<th>Ime</th>
					<th>Prezime</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${prijatelji}" var="pr">
					<tr>
						<td>${pr.firstName}</td>
						<td>${pr.lastName}</td>
						<td><a href="./ObrisiPrijatelja?id=${pr.id}">Obrisi prijatelja</a></td>
					</tr>
				</c:forEach>

			</tbody>	
			</table>
		</form>	
		
		<form action="./AddPrijatelja" method="post">
				<table>
					<thead>
						<tr>
							<th colspan="2"><input type="text" name="imePrezime"
								placeholder="Unesite ime ili prezime"></th>
							<th colspan="2"><input type="submit" value="Pretrazi"></th>
						</tr>

						<tr>
							<th>Ime</th>
							<th>Prezime</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${nisuprijatelji}" var="pri">
							<tr>
								<td>${pri.firstName}</td>
								<td>${pri.lastName}</td>
								<td><a href="./DodajPrijatelja?id=${pri.id}">Dodaj</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</tbody>
				</table>
			</form>

		</c:if>




		<c:if test="${sessionScope.menadzer!=null}">
			
		</c:if>


</body>
</html>