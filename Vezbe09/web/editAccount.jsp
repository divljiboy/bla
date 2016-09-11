
<%
	response.setHeader("Cache-Control",
			"no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setBundle basename="messages.messages" />
<jsp:useBean id="editAccount"
	type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.User"
	scope="request" />




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
			
			<form action="./EditAccountController" method="post">
				<table>
					<tr>
						<td>Ime :</td>
						<td><input type="text" value="${editAccount.firstName}"
							name="firstName" required></td>
					</tr>
					<tr>
						<td>Prezime:</td>
						<td><input type="text" value="${editAccount.lastName}"
							name="lastName" required></td>
					</tr>

					<tr>
						<td>Lozinka:</td>
						<td><input type="text" value="${editAccount.password}"
							name="password" required></td>
					</tr>

					<tr>
						<td>Slika:</td>
						<td><input type="file" value="Ucitaj"></td>
					</tr>

					<tr>
						<td><a href="home.jsp"
							class="action-button shadow animate yellow">Odustani</a></td>
						<td>
							<button type="submit">Sacuvaj podatke</button>
						</td>
					</tr>

				</table>
				<input type="hidden" name="id" value="${admin.id}">

			</form>

		</c:if>



		<c:if test="${sessionScope.gost!=null}">
			
			<form action="./EditAccountController" method="post">
				<table>
					<tr>
						<td>Ime :</td>
						<td><input type="text" value="${editAccount.firstName}"
							name="firstName" required></td>
					</tr>
					<tr>
						<td>Prezime:</td>
						<td><input type="text" value="${editAccount.lastName}"
							name="lastName" required></td>
					</tr>

					<tr>
						<td>Lozinka:</td>
						<td><input type="text" value="${editAccount.password}"
							name="password" required></td>
					</tr>

					<tr>
						<td>Slika:</td>
						<td><input type="file" value="Ucitaj"></td>
					</tr>

					<tr>
						<td><a href="home.jsp"
							class="action-button shadow animate yellow">Odustani</a></td>
						<td>
							<button type="submit">Sacuvaj podatke</button>
						</td>
					</tr>

				</table>
				<input type="hidden" name="id" value="${editAccount.id}">

			</form>

		</c:if>











		<c:if test="${sessionScope.menadzer!=null}">
			


			<form action="./EditAccountController" method="post">
				<table>
					<tr>
						<td>Ime :</td>
						<td><input type="text" value="${editAccount.firstName}"
							name="firstName" required></td>
					</tr>
					<tr>
						<td>Prezime:</td>
						<td><input type="text" value="${editAccount.lastName}"
							name="lastName" required></td>
					</tr>

					<tr>
						<td>Lozinka:</td>
						<td><input type="text" value="${editAccount.password}"
							name="password" required></td>
					</tr>

					<tr>
						<td>Slika:</td>
						<td><input type="file" value="Ucitaj"></td>
					</tr>

					<tr>
						<td><a href="home.jsp"
							class="action-button shadow animate yellow">Odustani</a></td>
						<td>
							<button type="submit">Sacuvaj podatke</button>
						</td>
					</tr>

				</table>
				<input type="hidden" name="id" value="${editAccount.id}">

			</form>

		</c:if>

	</div>


</body>
</html>