<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="utf-8">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="css/borrow/borrowBookForm.css">
	    <script type="text/javascript" src="js/borrow/borrowBookForm.js"></script>
	
	</head>
	
	<body>
		<div>
			<h1>Ajouter un emprunt</h1>
			
			<div id="booksListe" style="display: none;">${books}</div>
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
				<form:input path="book" class="form-control" type="text" name="titleBook" id="titleBook" placeholder="Titre"/>
				<div class="message-erreur"></div><br/>
				<input type="text" name="idBook" id="idBook" style="display:none;"/>
				
				
				
				<label>Membre* :</label>
				<form:input path="member" class="form-control" type="text" name="membreBorrow" id="membreBorrow" placeholder="Nom_Pr�nom_Date de naissance"/>
				<div class="message-erreur"></div><br/>
				<input type="text" name="idMember" id="idMember" style="display:none;"/>
				
				
				
				<label>Date maximale de restitution :</label>
				<input type="date" name="dateBorrow" id="dateBorrow" value="${dateRest}" disabled/><br/>
				
				
				<button type="submit" class="btn btn-primary" id="submit">Ajouter</button>
			</form:form>
		</div>	
	</body>
</html>