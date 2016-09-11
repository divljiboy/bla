
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
<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />


<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



</head>

<body>
	
	
		<jsp:useBean id="potvrdarez"
			type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rezervacija"
			scope="request" />

		<jsp:useBean id="potvrdagost"
			type="rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gost"
			scope="request" />

		<form class="form-horizontal" action="./PotvrdaRezervacije"
			method="post">
			<fieldset>

				<!-- Form Name -->


				<input type="hidden" name="idrez"
					value="${potvrdarez.rezervacija_id }"> 
			    <input type="hidden" name="idgost" 
			        value="${potvrdagost.id }">

				<!-- Button (Double) -->
				<div class="form-group">

					<div class="col-md-8">
						<button id="button1id" name="button" value="OK"
							class="btn btn-success">Prihvatam</button>
						<button id="button2id" name="button" value="CANCEL"
							class="btn btn-danger">Otkazujem</button>
					</div>
				</div>

			</fieldset>
		</form>


	


	<script src="./jquery.min.js"></script>
	<script src="./bootstrap.min.js"></script>





</body>
</html>




