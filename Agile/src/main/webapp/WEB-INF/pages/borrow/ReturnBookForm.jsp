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
	</head>
	<body>
		<form:form method="POST" id="insertBorrow" commandName="borrow" class="form-horizontal">
			<label>Membre* :</label>
			<form:input path="member" class="form-control" type="text" name="membreBorrow" id="membreBorrow" placeholder="Nom_Prénom_Date de naissance"/>
			<div class="message-erreur"></div><br/>
			<input type="text" name="idMember" id="idMember" style="display:none;"/>
		</form:form>
	
		<form:form>
			<table>
				<thead>
					<tr>
						<td>Titre</td>
						<td>ISBN</td>
						<td>Date d'emprunt</td>
						<td>Retour</td>
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
					if(value == availableMembers[int].label){
						$("#membreBorrow").next(".message-erreur").hide();
						memberValid = true;
						$("#idMember").val(availableMembers[int].value);
						getBorrowTable(availableMembers[int].value);
						return false;
					}else{
						$("#membreBorrow").next(".message-erreur").show().text("Veuillez renseigner un membre valide");
						$("#submit").hide();
					}
				}
			}
			
			function getBorrowTable(idMember){
				$.getJSON( "return/"+idMember)
				.done(function(data){
						console.log(data);
						for(i=0;i<data.length;i++)
						{
							$("#borrowed").append("<tr><td>"+data[i].book.titleBook+"</td><td>"+data[i].book.isbn+"</td><td>A ajouter</td><td></td></tr>");
						}
				});
			}
				
		</script>
		<div id="booksListe" style="display: none;">${books}</div>
	</body>
</html>