<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="utf-8">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="css/borrow/borrowBookForm.css">
	    <!-- <script type="text/javascript" src="js/borrow/borrowBookForm.js"></script> -->
	</head>
	
	<body>
		<div>
			<h1>Ajouter un emprunt</h1>
			
			
			<form:form method="POST" commandName="borrow" class="form-horizontal">

				<c:choose>
					<c:when test="${not empty  errors}">
						<div class="error">
							<c:forEach items="${errors}" var="err">
								${err}
								<br/>
							</c:forEach>
						</div>
					</c:when>
				</c:choose>


				<label>Titre de l'ouvrage* :</label>
				<form:input path="book" class="form-control" type="text" name="titleBook" id="titleBook" placeholder="Titre" onPropertyChange="checkTitle(this.val())"/>
				<div class="message-erreur"></div><br/>
				<input type="text" name="idBook" id="idBook" style="display:none;"/>
				
				
				
				<label>Membre* :</label>
				<form:input path="member" class="form-control" type="text" name="membreBorrow" id="membreBorrow" placeholder="Nom_Pr�nom_Date de naissance"/>
				<div class="message-erreur"></div><br/>
				<input type="text" name="idMember" id="idMember" style="display:none;"/>
				
				
				
				<label>Date maximale de restitution :</label>
				<input type="date" name="dateBorrow" id="dateBorrow" value="${dateRest}" disabled/><br/>
				
				
				<button type="submit" class="btn btn-primary" id="submit" style="display: none;">Ajouter</button>
			</form:form>
		</div>
			
		<script>
		var everythingValid = false;
		var titleValid = false;
		var memberValid = false;
			$(document).ready(function(){	
				$("#titleBook").bind("change paste keyup", function(){
					checkTitle($(this).val());				
				});
				$("#membreBorrow").bind("change paste keyup", function(){
					checkMember($(this).val());				
				});
			});
			
			function checkTitle(value){
				for (var int = 0; int < availableBooks.length; int++) {
					if(value == availableBooks[int].label){
						$("#titleBook").next(".message-erreur").hide();
						titleValid = true;
						$("#idBook").val(availableBooks[int].value);
						if(memberValid){
							$("#submit").show();
						}
						return false;
					}else{
						$("#titleBook").next(".message-erreur").show().text("Veuillez saisir un titre d'ouvrage valide");
						$("#submit").hide();
					}
				}
			}
			function checkMember(value){
				for (var int = 0; int < availableMembers.length; int++) {
					if(value == availableMembers[int].label){
						$("#membreBorrow").next(".message-erreur").hide();
						memberValid = true;
						$("#idMember").val(availableMembers[int].value);
						if(titleValid){
							$("#submit").show();
						}
						return false;
					}else{
						$("#membreBorrow").next(".message-erreur").show().text("Veuillez renseigner un membre valide");
						$("#submit").hide();
					}
				}
			}
				
		</script>
		<div id="booksListe" style="display: none;">${books}</div>
	</body>
</html>