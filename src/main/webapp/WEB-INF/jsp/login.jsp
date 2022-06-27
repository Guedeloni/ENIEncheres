<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion / Inscription</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<!-- Logo -->
			<a class="navbar-brand" href="<c:url value="/" />">Eni-Ench�res</a>
		</div>
	</nav>

	<div class="container-md">
		<form>
			<div class="form-group w-25">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email">
			</div>

			<div class="form-group w-25 mt-3">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword1"
					placeholder="Password">
			</div>

			<div class="d-flex justify-content-around w-25 mt-3">
				<div>
					<button type="submit" class="btn btn-primary">Connexion</button>
				</div>

				<div class="form-check d-grid">

					<div>
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Se
							souvenir de moi</label>
					</div>

					<a href="<c:url value="/mdp-oublie" />"> <small id="mdp-oublie"
						class="form-text text-muted">Mot de passe oubli�</small>
					</a>
				</div>
			</div>

			<div>

				<a class="btn btn-primary mt-3" href="<c:url value="/inscription" />">
					Cr�er un compte </a>
			</div>
		</form>
	</div>



</body>
</html>