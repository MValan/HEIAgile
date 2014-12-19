<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="http://oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css">
<script
	src="http://oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>Gestion des jours d'ouverture de la bibliothèque</title>
</head>

<body>
	<div class="container">
		<h1>Gestion des jours d'ouverture</h1>
		<br> <br> <br>
		<form id="daysForm" class="form-horizontal">
			<div id="daysForm" class="form-group">
				<div>
					<label class="col-sm-3 control-label" for="input-days">Jour
						d'ouverture :</label> <select name="input-days" id="input-days">
						<option value="lundi">Lundi</option>
						<option value="mardi">Mardi</option>
						<option value="mercredi">Mercredi</option>
						<option value="jeudi">Jeudi</option>
						<option value="vendredi">Vendredi</option>
						<option value="samedi">Samedi</option>
						<option value="dimanche">Dimanche</option>
						<option value="aucun" selected>Aucun</option>
					</select> <label for="input-hours"> De </label> <input type="time" for="openHour">
					<label>à </label> <input type="time" for="closeHour"> <input type="submit"
						value="Ajouter">
				</div>
			</div>
		</form>
	</div>
</body>
</html>