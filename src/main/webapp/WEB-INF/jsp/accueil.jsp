<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
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
			<a class="navbar-brand" href="<c:url value="/encheres" />">Eni-Enchères</a>

			<!-- burger menu -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- liens connexion -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<c:url value="/inscription" />">S'inscrire</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/login" />">Se connecter</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-md">
		<div class="d-flex justify-content-center">
			<h1 class="mt-3">Liste des Enchères</h1>
		</div>

		<div class="w-50">
			<h4>Filtres:</h4>
		</div>
		<div class="input-group w-50 p-3">
			<input type="search" class="form-control rounded"
				placeholder="le nom de l'article ..." aria-label="Search"
				aria-describedby="search-addon" />
			<button type="button" class="btn btn-outline-primary">Rechercher</button>
		</div>

		<div class="input-group mb-3 w-50 p-3">
			<label class="input-group-text" for="inputGroupSelect01">Catégories</label>
			<select class="form-select" id="inputGroupSelect01">
				<option selected>Toutes</option>
				<option value="1">Ameublement</option>
				<option value="2">Vêtements</option>
				<option value="3">Sport & Loisirs</option>
			</select>
		</div>


		<div class="d-flex justify-content-around">
			<div class="card" style="width: 18rem;">
				<div class="card-body ">
					<img class="card-img-top"
						src="http://tsr-industrie.fr/wp-content/uploads/2016/04/ef3-placeholder-image.jpg"
						alt="Card image cap">
					<h5 class="card-title mt-2">Pc Gamer pour travailler</h5>
					<div>Prix : 210 points</div>
					<p class="card-text">Fin de l'enchère : 10/08/2018</p>
					<p class="card-text">Vendeur : jojo44</p>

				</div>
			</div>

			<div class="card" style="width: 18rem;">
				<div class="card-body">
					<img class="card-img-top"
						src="http://tsr-industrie.fr/wp-content/uploads/2016/04/ef3-placeholder-image.jpg"
						alt="Card image cap">
					<h5 class="card-title mt-2">Rocket stove pour riz et pâtes</h5>
					<div>Prix : 185 points</div>
					<p class="card-text">Fin de l'enchère : 09/10/2018</p>
					<p class="card-text">Vendeur : NineJea</p>

				</div>
			</div>
		</div>

	</div>


</body>
</html>