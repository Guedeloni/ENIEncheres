<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
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

	<div class="container-md w-75 text-center">
		<%-- 	<c:if test="${ request.getSession(false) != null }"> --%>

		<h2 class="mt-3 mb-3">Mon profil</h2>
			
		<div class="mb-3"><span class="text-secondary">Pseudo :</span>  ${utilisateur.pseudo }</div>
		<div class="mb-3"><span class="text-secondary">Nom :</span> ${utilisateur.nom }</div>
		<div class="mb-3"><span class="text-secondary">Prénom :</span> ${utilisateur. prenom }</div>
		<div class="mb-3"><span class="text-secondary">Email :</span> ${utilisateur.email }</div>
		<div class="mb-3"><span class="text-secondary">Telèphone :</span> ${utilisateur.telephone }</div>
		<div class="mb-3"><span class="text-secondary">Rue :</span> ${utilisateur.rue }</div>
		<div class="mb-3"><span class="text-secondary">Code postal :</span> ${utilisateur.code_postal }</div>
		<div class="mb-3"><span class="text-secondary">Ville :</span> ${utilisateur. ville}</div>


		<div class="contenu">
			<a href="<c:url value="/modif_profil" />"> <input type="submit"
				value="Modifier" class="btn btn-primary" />
			</a>
		</div>

	</div>
	<%-- </c:if> --%>

	<%-- 	<c:if test="${ request.getSession(false) = null }">
		<h1>Pas de session en cours</h1>	
		<div class="contenu">
			<a href="<c:url value="/encheres" />">
				<input type="submit" value="Retour à l'accueil" />
			</a>
		</div>
	</c:if> --%>

</body>
</html>