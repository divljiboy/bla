
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

		<form class="form-horizontal" action="./OstaviUtisak" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Form Name</legend>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="selectmultiple">Rezervacija:</label>
					<div class="col-md-4">
						<select name="rezsto">
							<c:forEach items="${trenutnarezervacija}" var="p">
								<option value="${p.rezervacija_id}">${p.restoran.naziv}  ${p.od}</option>

							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="utisak">Utisak</label>
					<div class="col-md-4">
						<textarea class="form-control" id="utisak" name="utisak"></textarea>
					</div>
				</div>

				<!-- Multiple Radios (inline) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="radios">Inline
						Radios</label>
					<div class="col-md-4">
						<label class="radio-inline" for="radios-0"> <input
							type="radio" name="radios" id="radios-0" value="1"
							checked="checked"> 1
						</label> <label class="radio-inline" for="radios-1"> <input
							type="radio" name="radios" id="radios-1" value="2"> 2
						</label> <label class="radio-inline" for="radios-2"> <input
							type="radio" name="radios" id="radios-2" value="3"> 3
						</label> <label class="radio-inline" for="radios-3"> <input
							type="radio" name="radios" id="radios-3" value="4"> 4
						</label> <label class="radio-inline" for="radios-4"> <input
							type="radio" name="radios" id="radios-4" value="5"> 5
						</label>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="button1id"></label>
					<div class="col-md-8">
						<button id="button1id" type="submit" name="button1id" class="btn btn-success">OK</button>
						<button id="button2id" name="button2id" class="btn btn-danger">Cancel</button>
					</div>
				</div>

			</fieldset>
		</form>


	</c:if>




	<c:if test="${sessionScope.menadzer!=null}">

	</c:if>



	<script src="./jquery.min.js"></script>
	<script src="./bootstrap.min.js"></script>
</body>
</html>