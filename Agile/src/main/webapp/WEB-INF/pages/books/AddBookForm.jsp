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
			<h1>Ajouter un livre</h1>
			
			<div id="addBook" ><!-- style="display: none;" -->${books}</div>
			<form>
				<label>Numéro ISBN* :</label>
				<input type="text" name="isbnBook" id="isbnBook" placeholder="ISBN" required="required"/><br/>
				
				<label>Titre de l'ouvrage* :</label>
				<input type="text" name="titleBook" id="titleBook" placeholder="Titre" required="required"/><br/>
				
				<label>Prix d'achat :</label>
				<input type="number" name="priceBook" id="priceBook" placeholder="Prix en €"/><br/>
								
				<input type="submit" value="Ajouter"/>
			</form>
			
		</div>	
	</body>
</html>