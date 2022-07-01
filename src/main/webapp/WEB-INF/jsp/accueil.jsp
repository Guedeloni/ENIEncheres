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

			<%-- Si l' utilisateur n'est pas connecté  --%>
			<c:if test="${empty utilisateur.pseudo }">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">

						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="<c:url value="/inscription" />">S'inscrire</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/login" />">Se connecter</a></li>
					</ul>
				</div>
			</c:if>

			<%-- Si l' utilisateur est connecté  --%>
			<c:if test="${! empty utilisateur.pseudo }">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">

						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="<c:url value="/liste-encheres" />">Enchères</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/vente-article" />">Vendre un article</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="<c:url value="/profil" />">Mon
								profil</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/login" />">Déconnexion</a></li>

					</ul>
				</div>
			</c:if>
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
			<select class="form-select" id="catégories">
				<c:if test="${ ! empty listeCategorie }">
				<option selected>Toutes</option>
					<c:forEach var="categorie" items="${ listeCategorie }">
						<option value="${categorie.no_categorie }">${categorie.libelle }</option>
					</c:forEach>
				</c:if>
			</select>

		</div>


		<!-- TODO faire une fonction Javascript qui permettra de mettre en disabled les inputs selon
qu'on clique  sur Achats ou Mes Ventes car avec le Java ça rechargera à chaque fois la page  -->

		<c:if test="${! empty utilisateur.pseudo }">

			<%--  si l'utilisateur est connecté on affiche les champs Achats et Ventes --%>

			<div class="d-flex justify-content-around w-50 pb-4">

				<div>
					<div>
						<input type="radio" id="achats" name="achats" value="achats"
							checked> <label for="achats">Achats</label>
					</div>

					<div class="ms-5">
						<div class="form-check">
							<input class="form-check-input" type="checkbox"
								value="encheres_ouvertes" id="encheres_ouvertes" checked>
							<label class="form-check-label" for="encheres_ouvertes">
								enchères ouvertes </label>
						</div>

						<div class="form-check">
							<input class="form-check-input" type="checkbox"
								value="encheres_en_cours" id="encheres_en_cours"> <label
								class="form-check-label" for="encheres_en_cours"> Mes
								enchères en cours </label>
						</div>

						<div class="form-check">
							<input class="form-check-input" type="checkbox"
								value="encheres_remporte" id="encheres_remporte"> <label
								class="form-check-label" for="encheres_remporte"> Mes
								enchères remportées </label>
						</div>
					</div>
				</div>


				<div>
					<div>
						<input type="radio" id="ventes" name="ventes" value="ventes">
						<label for="ventess">Mes Ventes</label>
					</div>

					<c:choose>
						<c:when test="${! empty utilisateur.pseudo}">
							<div class="ms-5">
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="ventes_en_cours" id="ventes_en_cours" disabled>
									<label class="form-check-label" for="ventes_en_cours">
										mes ventes en cours </label>
								</div>

								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="ventes_non_debute" id="ventes_non_debute" disabled>
									<label class="form-check-label" for="ventes_non_debute">
										ventes non débutées </label>
								</div>

								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										value="ventes_termine" id="ventes_termine" disabled> <label
										class="form-check-label" for="ventes_termine"> ventes
										terminées </label>
								</div>
							</div>
						</c:when>
					</c:choose>
				</div>
			</div>


		</c:if>



		<div class="d-flex justify-content-around">
			<c:if test="${ ! empty listeArticle }">
				<c:forEach var="article" items="${ listeArticle }">

					<div class="card" style="width: 18rem;">
						<div class="card-body ">
							<img class="card-img-top"
								src="http://tsr-industrie.fr/wp-content/uploads/2016/04/ef3-placeholder-image.jpg"
								alt="Card image cap">
							<h5 class="card-title mt-2">${article.nom_article }</h5>
							<div>Prix : ${article.prix_initial } points</div>
							<p class="card-text">Fin de l'enchère :
								${article.date_fin_encheres }</p>

							<!-- TODO => créer un article avec un utilisateur pour puvoir récupérer le pseudo sinon null -->
							 	<p class="card-text">Vendeur : ${article.utilisateur.pseudo }</p> 

						</div>
					</div>
				</c:forEach>
			</c:if>

		</div>

	</div>


</body>
</html>