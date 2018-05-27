<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>PubHub</title>
<link rel="shortcut icon" href="../resources/imgs/favicon.png"
	type="image/x-icon">

<!-- CSS - Custom fonts -->
<link href="/resources/libraries/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"> -->

<!-- CSS - jQuery DataTables -->
<link
	href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />

<!-- CSS - Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/resources/libraries/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/libraries/css/freelancer.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/libraries/css/half-slider.css" />

<!-- CSS - Custom -->
<link rel="stylesheet" type="text/css"
	href="/resources/styles/custom.css" />

</head>
<body>
	id="page-top" class="index">
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath }">PubHub</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">PubHub<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/pubHub/home">Home (Level 100)</a></li>
						<li class="divider"></li>
						<li><a href="${request.contextPath}/publishBook.jsp">Publish
								Book</a></li>
						<li><a href="/logout">Logout</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Marketplace<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/pubHub/home">Home (Level 200)</a></li>
						<li class="divider"></li>
						<li><a href="/order/cart">Cart</a></li>
						<li><a href="/order/list">Orders</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Social<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/social/home">Home (Level 300)</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>