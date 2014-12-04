<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
		<title>Insert title here</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container">
			<h1>Restitution d'Ouvrage</h1>
			<form:form method="POST" id="insertBorrow" commandName="borrow" class="form-horizontal">
				<div class="form-group">
					<div class="row">
						<label class="col-sm-3 control-label">Membre* :</label>
						<div class="col-sm-5">
							<form:input path="member" class="form-control" type="text" name="membreBorrow" id="membreBorrow" placeholder="Nom_Prénom_Date de naissance"/>
						</div>
						<input type="text" name="idMember" id="idMember" style="display:none;"/>
					</div>
					<div class="row error">
						<div class="message-erreur col-sm-5 col-sm-offset-3 "></div><br/>
					</div>
				</div>
			</form:form>
		
			<form:form>
				<table class="table">
					<thead>
						<tr>
							<th>Titre</th>
							<th>ISBN</th>
							<th>Date d'emprunt</th>
							<th>Retour</th>
						</tr>
					</thead>
					<tbody id="borrowed">					
					</tbody>
					
				</table>
			</form:form>
			<script>
			var everythingValid = false;
			var titleValid = false;
			var memberValid = false;
				$(document).ready(function(){
					if(availableMembers.length === 0){
						$("#insertBorrow").hide();
						$("#emptyMembers").show();
					}
					$("#titleBook").bind("change paste keyup", function(){
						checkTitle($(this).val());				
					});
					$("#membreBorrow").bind("change paste keyup", function(){
						checkMember($(this).val());				
					});
				});
				
				function checkMember(value){
					for (var int = 0; int < availableMembers.length; int++) {
						if(value == availableMembers[int].label || value == ""){
							$("#membreBorrow").parent().parent().parent().children(".error").children(".message-erreur").hide();
							memberValid = true;
							$("#idMember").val(availableMembers[int].value);
							getBorrowTable(availableMembers[int].value);
							return false;
						}else{
							$("#membreBorrow").parent().parent().parent().children(".error").children(".message-erreur").show().html("<div class='alert alert-danger'><span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span><span class='sr-only'>Error:</span>Veuillez renseigner un membre valide</div>");
							$("#submit").hide();
						}
					}
				}
				
				function getBorrowTable(idMember){
					$.getJSON(idMember)
					.done(function(data){
							console.log(data);
							$("#borrowed").empty();
							for(i=0;i<data.length;i++)
							{
								$("#borrowed").append("<tr><td>"+data[i].book.titleBook+"</td><td>"+data[i].book.isbn+"</td><td>A ajouter</td><td></td></tr>");
							}
					});
				}
					
			</script>
			<div id="booksListe" style="display: none;">${books}</div>
		</div>
	</body>
</html>