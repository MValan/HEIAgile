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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	
	<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="../js/jquery-ui-1.11.1.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.multidatespicker.js"></script>
<title>Gestion des jours d'ouverture de la bibliothèque</title>
<script>

</script>
<link rel="stylesheet" media="screen" type="text/css" title="Design" href="../css/global.css" />
</head>

<body>
<div class="container">
<jsp:include page="../navbar.jsp">
	<jsp:param name="activeTab" value="opendays" />
</jsp:include>
	<div>
		<h1>Gestion des jours d'ouverture</h1>
		<br> <br> <br>
		<form id="daysForm" class="form-horizontal">
			<div class="form-group">
				<div>
					<label class="col-sm-3 control-label" for="input-days">Jour	d'ouverture :</label> <select name="input-days" id="input-days">
						<option value="lundi" selected>Lundi</option>
						<option value="mardi">Mardi</option>
						<option value="mercredi">Mercredi</option>
						<option value="jeudi">Jeudi</option>
						<option value="vendredi">Vendredi</option>
						<option value="samedi">Samedi</option>
						<option value="dimanche">Dimanche</option>
					</select> 
					<label for="openHour"> De </label> <input type="time" name="openHour" id="openHour" value="00:00">
					<label for="closeHour">à </label> <input type="time" name="closeHour" id="closeHour" value="00:00"> 
					<input type="submit" id="submitNewDay" value="Ajouter" class="btn btn-success">
				</div>
			</div>
		</form>
		<div id="table_ins">
			${allDays}
		</div>
		
		<form id="closedDaysForm" class="form-horizontal">
			<div class="form-group">
				<div>
					<label class="col-sm-3 control-label" for="input-closedDays">Jours exceptionnels de fermeture :</label> 
					<div class="box"  id="from--input">
							<input type="text" id="from-input" name="closedDate">
					</div>
					<script>
						$('#from-input').multiDatesPicker({
							altField: "#datepicker",
							firstDay: 1,
							closeText: 'Fermer',
							prevText: 'Précédent',
							nextText: 'Suivant',
							currentText: 'Aujourd\'hui',
							monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
							monthNamesShort: ['Janv.', 'Févr.', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil.', 'Août', 'Sept.', 'Oct.', 'Nov.', 'Déc.'],
							dayNames: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
							dayNamesShort: ['Dim.', 'Lun.', 'Mar.', 'Mer.', 'Jeu.', 'Ven.', 'Sam.'],
							dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
							weekHeader: 'Sem.'
						});
					</script>
				</div>
			</div>
			<input type="submit" id="submitClosedDays" value="Ajouter" class="btn btn-success">
		</form>
		<div id="forHtml">${closedDates}</div>
		<div id="table_ins_closed">
			${allClosedDays}
		</div>
	</div>
	<script>
	$(document.body).on("click", "#submitNewDay", function(event){	
			$.post('addNewOpenDay', $("#daysForm").serialize(), function(data){
				console.log(data);
				if(data.length > 0){
					var toappend="<table class='table'><thead><tr><th>Jour</th><th>De</th><th>A</th></tr></thead><tbody id='insideHtmlTable'>";
					for(i=0;i<data.length;i++)
					{
						toappend+="<tr><td>"+ data[i].day +"</td><td>"+ data[i].fromHour +"</td><td>"+ data[i].toHour +"</td></tr>";
					}
					toappend+="</tbody></table>";
					$('#table_ins').html(toappend);
				}
				$('#openHour').val("00:00");
				$('#closeHour').val("00:00");
			}, 'json');
		event.preventDefault();
	});
	
	$(document.body).on("click", "#submitClosedDays", function(event){	
		$.post('addNewClosedDay', $("#closedDaysForm").serialize(), function(data){
			$('#table_ins_closed').html(data);
		}, 'json');
	event.preventDefault();
});
	</script>
</div>
</body>
</html>