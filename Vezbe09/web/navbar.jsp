
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

<div>
	<link href="./bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
	<link href="./bootstrap.min.css" rel="stylesheet" type="text/css" />

	<nav class="navbar navbar-dark bg-inverse">

		<c:if test="${sessionScope.admin!=null}">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="./InitRestoranController">
						<div>
							<fmt:message key="restorani" />
						</div>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./InitKorisniciController">
						<div>
							<fmt:message key="korisnici" />
						</div>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./InitMenadzerController">
						<div>
							<fmt:message key="menadzeri" />
						</div>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./InitJelovniciController">
						<div>
							<fmt:message key="jelovnici" />
						</div>
				</a></li>

				<li class="nav-item"><a class="nav-link"
					href="InitJelaController">
						<div>
							<fmt:message key="jela" />
						</div>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="home.jsp">
						<div>
							<c:out value="${admin.firstName}"></c:out>
							&nbsp;&nbsp;
							<c:out value="${admin.lastName}"></c:out>
						</div>
				</a></li>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="./LogoutController">
						<div>
							<fmt:message key="odjava" />
						</div>
				</a></li>
			</ul>



		</c:if>















		<c:if test="${sessionScope.gost!=null}">
			<ul class="nav navbar-nav">

				<li class="nav-item"><a class="nav-link"
					href="./InitRestoranController">
						<div>
							<fmt:message key="restorani" />
						</div>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./PrijateljiController">
						<div>
							<fmt:message key="prijatelji" />
						</div>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="./InitPoseteController"></i>
						<div>
							<fmt:message key="mojeposete" />
						</div></a></li>
				<li class="nav-item"><a class="nav-link"
					href="./InitRezervacijeController"></i>
						<div>
							<fmt:message key="mojerezervacije" />
						</div></a></li>

				<li class="nav-item"><a class="nav-link" href="home.jsp">
						<div>
							<c:out value="${gost.firstName}"></c:out>
							&nbsp;&nbsp;
							<c:out value="${gost.lastName}"></c:out>
						</div>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./LogoutController">
						<div>
							<fmt:message key="odjava" />
						</div>
				</a></li>
			</ul>



		</c:if>


		<c:if test="${sessionScope.menadzer!=null}">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="./InitRestoranController">
						<div>
							<fmt:message key="restorani" />
						</div>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./InitJelovniciController">
						<div>
							<fmt:message key="jelovnici" />
						</div>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="home.jsp">
						<div>
							<c:out value="${menadzer.firstName}"></c:out>
							&nbsp;&nbsp;
							<c:out value="${menadzer.lastName}"></c:out>
						</div>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="./LogoutController">
						<div>
							<fmt:message key="odjava" />
						</div>
				</a></li>
			</ul>




		</c:if>
	</nav>
	<script src="./jquery.min.js"></script>
	<script src="./bootstrap.min.js"></script>
</div>