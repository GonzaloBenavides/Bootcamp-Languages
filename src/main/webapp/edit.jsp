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
	<a class="btn btn-link" href="/languages">Dashboard</a>
	<form style="display: inline;" action="/languages/${newLang.id}"
		method="post">
		<input type="hidden" name="_method" value="delete" />
		<button type="submit" class="btn btn-link">borrar</button>
	</form>
	<div class="container p-2">
		<form:form method="PUT" action="/languages/${newLang.id}"
			modelAttribute="newLang">
			<div class="row">
				<form:errors class="text-danger" path="nombre" />
				<form:errors class="text-danger" path="creador" />
				<form:errors class="text-danger" path="version" />
			</div>
			<div class="row form-group">
				<form:label path="nombre" for="langName">Nombre</form:label>
				<form:input class="form-control" placeholder="Nombre del lenguaje"
					path="nombre" id="langName" />
			</div>
			<div class="row form-group">
				<form:label path="creador" for="langCreator">Creador</form:label>
				<form:input class="form-control" placeholder="Nombre del creador"
					path="creador" id="langCreator" />
			</div>
			<div class="row form-group">
				<form:label path="version" for="langVersion">Version</form:label>
				<form:input class="form-control" placeholder="Última versión"
					path="version" id="langVersion" />
			</div>
			<br>
			<form:hidden path="id" value="${newLang.id}" />
			<input type="hidden" name="_method" value="PUT" />
			<div class="form-group">
				<form:button class="btn btn-secondary">Editar</form:button>
			</div>
		</form:form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>