

<%@page
	import="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost"%>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setBundle basename="messages.messages" />


<jsp:useBean id="restoranRezervacija"
	type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran"
	scope="request" />




<html>
<head>
<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function pr() {
		var x = document.URL;
		if (x === "http://localhost:8080/Vezbe09/restorani.jsp?Nijeuspelo") {
			alert("Upis nije ispavan,verovatno je zauzet sto tad!");
		}
	}
</script>
<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
	<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<c:if
	test="${sessionScope.admin==null && sessionScope.gost==null && sessionScope.menadzer==null}">
	<c:redirect url="./start.jsp" />
</c:if>

<body>
	<jsp:include page="./navbar.jsp" />


	<c:if test="${sessionScope.admin!=null}">

	</c:if>










	<c:if test="${sessionScope.gost!=null}">


		<jsp:useBean id="prijatelji"
			type="java.util.HashSet<rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost>"
			scope="request"></jsp:useBean>



		<form class="form-horizontal" action="./RezervacijaController"
			method="post">
			<fieldset>

				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Restoran</label>
					<div class="col-md-4">
						<input type="text" value="${restoranRezervacija.naziv}"
							readonly="readonly"> <input type="hidden" name="restoran"
							value="${restoranRezervacija.id}"> 
					</div>
				</div>

		
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Datum</label>
					<div class="col-md-4">
					
					<input type="date" name="datum">
					</div>
					</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Vreme</label>
					<div class="col-md-4">
					
					<input type="time" name="vreme">
				</div>
				</div>
				 

				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Trajanje</label>
					<div class="col-md-4">
						<input type="number" name="trajanje">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="selectmultiple">Sto:</label>
					<div class="col-md-4">
						<select name="rezsto">
							<c:forEach items="${rezervacijasto}" var="p">
								<option value="${p.id}">${p.pozicija}</option>

							</c:forEach>
						</select>
					</div>
				</div>

				
				


				<div class="form-group">
					<label class="col-md-4 control-label" for="selectmultiple">Pozovi
						prijatelje:</label>
					<div class="col-md-4">
						<select name="prija" multiple>
							<c:forEach items="${prijatelji}" var="p">
								<option value="${p.id}">${p.firstName}${p.lastName}</option>

							</c:forEach>
						</select>
					</div>
				</div>
				<!-- <tr>
					<td colspan="2"><button type="submit">Kreiraj
							Rezervaciju</button></td>
				</tr> -->
				<!-- Button -->
				<div class="form-group">
					
					<div class="col-md-4">
						<button  type="submit"id="singlebutton" name="singlebutton"
							class="btn btn-primary">Kreiraj</button>
					</div>
				</div>

			</fieldset>

		</form>
		
	</c:if>











	<c:if test="${sessionScope.menadzer!=null}">

	</c:if>

	</div>

<script src="./jquery.min.js"></script>
	<script src="./bootstrap.min.js"></script>
</body>
</html>