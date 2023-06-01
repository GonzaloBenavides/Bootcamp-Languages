<%@page import="org.springframework.ui.Model"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/boostrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<title>Languages API</title>
</head>
<body>
	
	<div class="container p-2">
	<a href="/languages">Dashboard</a>
		<div class="row form-group">
			<label for="langName">Nombre</label> <input class="form-control"
				placeholder="Nombre del lenguaje" id="langName"
				value="${newLang.nombre}" disabled />
		</div>
		<div class="row form-group">
			<label for="langCreator">Creador</label> <input class="form-control"
				placeholder="Nombre del creador" id="langCreator"
				value="${newLang.creador}" disabled />
		</div>
		<div class="row form-group">
			<label for="langVersion">Version</label> <input class="form-control"
				placeholder="Última versión" id="langVersion"
				value="${newLang.version}" disabled />
		</div>
		<br>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>