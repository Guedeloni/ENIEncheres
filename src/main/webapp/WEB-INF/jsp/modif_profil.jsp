<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification Profil</title>
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
			<a class="navbar-brand" href="<c:url value="/encheres" />">
				Eni-Enchères</a>
		</div>
	</nav>

	<div class="container-md">

		<h2>Mon Profil</h2>

		<form method="post"
			action="${pageContext.request.contextPath}/ModifierProfil">

			<div
				class="d-flex justify-content-around align-items-center w-50 p-3">
				<div>
					<div class="form-group">
						<label for="Pseudo">Pseudo</label> <input type="text"
							class="form-control" id="pseudo" aria-describedby="pseudo"
							placeholder="votre pseudo" name="pseudo"
							value="${utilisateur.pseudo}">
					</div>

					<div class="form-group mt-3">
						<label for="nom">Nom</label> <input type="text"
							class="form-control" id="nom" placeholder="Doe" name="nom"
							value="${utilisateur.nom }">
					</div>

					<div class="form-group mt-3">
						<label for="prénom">Prénom</label> <input type="text"
							class="form-control" id="prenom" placeholder="John" name="prenom"
							value="${utilisateur.prenom}">
					</div>

					<div class="form-group mt-3">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" aria-describedby="email"
							placeholder="john-doe@gmail.com" name="email"
							value="${utilisateur.email}">
					</div>

					<div class="form-group mt-3">
						<label for="telephone">Téléphone</label> <input type="text"
							class="form-control" id="telephone" aria-describedby="telephone"
							placeholder="06 12 39 84 52" name="telephone"
							value="${utilisateur.telephone}">
					</div>

					<div class="form-group mt-3">
						<label for="rue">Rue</label> <input type="text"
							class="form-control" id="rue" placeholder="12 rue de l'Eni"
							name="rue" value="${utilisateur.rue}">
					</div>

				</div>

				<div class="mt-3">
					<div class="form-group mt-3">
						<label for="code_postal">Code postal</label> <input type="text"
							class="form-control" id="code_postal" placeholder="44000"
							name="code_postal" value="${utilisateur.code_postal}">
					</div>

					<div class="form-group mt-3">
						<label for="ville">Ville</label> <input type="text"
							class="form-control" id="ville" placeholder="Nantes" name="ville"
							value="${utilisateur.ville}">
					</div>

					<div class="form-group mt-3">
						<label for="Mot de passe actuel">Mot de passe actuel</label> <input
							type="password" class="form-control" id="mot_de_passe"
							name="mot_de_passe" value="${utilisateur.mot_de_passe}">
					</div>


					<div class="form-group mt-3">
						<label for="nouveau mot de passe">Nouveau mot de passe</label> <input
							type="password" class="form-control" id="mot_de_passe"
							name="nouveau_mdp" value="${utilisateur.mot_de_passe}">
					</div>

					<div class="form-group mt-3">
						<label for="confirmation mot de passe">Confirmation</label> <input
							type="password" class="form-control" id="mot_de_passe"
							name="confirmation_mdp" value="${utilisateur.mot_de_passe}">
					</div>
				</div>

			</div>

			<div>
				Crédit <span class="font-weight-bold">${utilisateur.credit}</span>
			</div>

			<div class="d-flex justify-content-around w-25 mt-3">

				<div>
					<button type="submit" class="btn btn-primary">Enregistrer</button>
				</div>

				<div>
					<button type="submit" class="btn btn-primary">Supprimer
						mon compte</button>
				</div>
			</div>

		</form>

		<div>
			<c:if test="${ requestScope.message != '' }">
				<p>${ requestScope.message }</p>
			</c:if>
		</div>
		
	</div>

</body>
</html>