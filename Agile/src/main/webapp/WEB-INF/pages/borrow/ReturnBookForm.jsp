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
		<jsp:include page="../navbar.jsp">
			<jsp:param name="activeTab" value="return" />
		</jsp:include>
		<div class="container">
			<h1>Restitution d'Ouvrage</h1>
			<br>
			<br>
			<form:form method="POST" id="insertBorrow" commandName="borrow" class="form-horizontal">
				<div class="form-group">
					<div class="row">
						<label class="col-sm-3 control-label" for="membreBorrow">Membre * :</label>
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

			<div id="returnMessage" style="margin-top: 10px;"></div>

			<div id="tofillwithborrowlist">
			</div>
			<script>
			var everythingValid = false;
			var titleValid = false;
			var memberValid = false;
				$(document).ready(function(){
					if(availableMembers.length === 0){
						$("#insertBorrow").hide();
						$("#emptyMembers").show();
					}
					$("#membreBorrow").bind("change paste keyup", function(){
						if($(this).val() != ""){
							checkMember($(this).val());		
						}else{
							$("#idMember").val(0);
							$('#tofillwithborrowlist').empty();
							$("#returnMessage").html('');
						}
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
				$.getJSON( "return/"+idMember)
				.done(function(data){
						console.log(data);
						console.log("Membre: "+idMember);
						generateHtmlTable(data);
				});
			}
			
			$(document.body).on("click", "#submit", function(event){
				var idMember = $("#idMember").val();
					$.post('returnBook/'+idMember, $("#returnchecklist").serialize(), function(data){
						generateHtmlTable(data);
					}, 'json').done(function(){
						$("#returnMessage").html('<div class="alert alert-success" role="alert"><strong>Bravo!</strong> La modification a bien été prise en compte.</div>');
					}).fail(function(){
						$("#returnMessage").html('<div class="alert alert-danger" role="alert"><strong>Attention!</strong> Une erreur s\'est produite.</div>');
					});
				event.preventDefault();
			});
			
			function generateHtmlTable(data){
				$('#tofillwithborrowlist').empty();
				$("#returnMessage").empty();
				if(data.length > 0){
					var toappend="";
					toappend+='<form:form method="POST" id="returnchecklist" commandName="borrowreturned">';
					toappend+='<table class="table">';
					toappend+='<thead>';
					toappend+='<tr>';
					toappend+='<th>Titre</th>';
					toappend+='<th>ISBN</th>';
					toappend+="<th>Date de restitution</th>";
					toappend+='<th>Retour</th>';
					toappend+='<th>Prolongement</th>';
					toappend+='</tr>';
					toappend+='</thead>';
					toappend+='<tbody id="borrowed">';					
					
					for(i=0;i<data.length;i++)
					{
						toappend+="<tr><td>"+data[i].book.titleBook+"</td>";
						toappend+="<td>"+data[i].book.isbn+"</td>";
						toappend+="<td>"+data[i].dateBorrowEnd+"</td>";
						toappend+='<td><input type="checkbox" name="returned" value="'+data[i].idBorrow+'" /></td>';
						
						if(!data[i].extended) {
							toappend+='<td><input type="checkbox" name="extended" value="'+data[i].idBorrow+'" /></td>';
						} else {
							toappend+='<td><input type="checkbox" name="extended" value="'+data[i].idBorrow+'" disabled /></td>';
						}
						toappend+="</tr>";
												
					}
					toappend+='</tbody>	';	
					toappend+='</table>';
					toappend+= '<button type="submit" class="btn btn-primary" id="submit">Valider</button>';
					toappend+='</form:form>';
					$('#tofillwithborrowlist').append(toappend);
				}else{
					$("#returnMessage").html('<div class="alert alert-warning" role="alert"><strong>Attention!</strong> Cet utilisateur n\'a aucun emprunt en cours.</div>');
				}
				
			}
					
			</script>
			<div id="booksListe" style="display: none;">${books}</div>
		</div>
	</body>
</html>
