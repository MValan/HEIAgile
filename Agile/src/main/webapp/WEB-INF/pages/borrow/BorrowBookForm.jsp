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
			<form>
				<label>Titre de l'ouvrage* :</label>
				<input type="text" name="titleBook" id="titleBook" placeholder="Titre"/><br/>
				
				<label>Membre* :</label>
				<input type="text" name="membreBorrow" id="membreBorrow" placeholder="Nom_Prénom_Date de naissance"/><br/>
				
				<label>Date maximale de restitution :</label>
				<input type="date" name="dateBorrow" id="dateBorrow" value="${dateRest}" disabled/><br/>
				
				<input type="submit" value="Ajouter"/>
			</form>
			
		</div>	
	</body>
</html>