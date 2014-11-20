<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="utf-8">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	</head>
	
	<body>
		<div>
			<h1>Ajouter un emprunt</h1>
			
			<div id="booksListe" style="display: none;">${books}</div>
			<form:form method="POST" commandName="borrow" class="form-horizontal">
				<label>Titre de l'ouvrage* :</label>
				<form:input path="book" class="form-control" type="text" name="titleBook" id="titleBook" placeholder="Titre"/><br/>
				<input type="text" name="idBook" id="idBook" style="display:none;"/>
				
				<label>Membre* :</label>
				<form:input path="member" class="form-control" type="text" name="membreBorrow" id="membreBorrow" placeholder="Nom_Prénom_Date de naissance"/><br/>
				<input type="text" name="idMember" id="idMember" style="display:none;"/>
				
				<label>Date maximale de restitution :</label>
				<input type="date" name="dateBorrow" id="dateBorrow" value="${dateRest}" disabled/><br/>
				
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</form:form>
		</div>	
	</body>
</html>