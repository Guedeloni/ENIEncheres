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


<%-- 	<c:if test="${ request.getSession(false) != null }"> --%>

		<h2>Mon profil </h2>
		
		<div>Pseudo : ${utilisateur.pseudo }</div>
		<div>Nom  : ${utilisateur.nom }</div>
		<div>Prénom : ${utilisateur. prenom }</div>
		<div>Email : ${utilisateur.email }</div>
		<div>Telèphone : ${utilisateur.telephone }</div>
		<div>Rue : ${utilisateur.rue }</div>
		<div>Code postal : ${utilisateur.code_postal }</div>
		<div>Ville : ${utilisateur. ville}</div>
		
		
		<div class="contenu">
			<a href="<c:url value="/modif_profil" />">
				<input type="submit" value="Modifier" />
			</a>
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