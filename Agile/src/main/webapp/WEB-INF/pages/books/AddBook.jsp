<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="utf-8">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
		<link rel="stylesheet" href="css/book/addBook.css">
	</head>
	
	<body>
		<div>
			<h1>Nouvel Ouvrage</h1>
	
			<form:form method="POST" commandName="book" class="form-horizontal">
			  <div>
			    <label for="isbn">ISBN *</label>
			    <div>
			    	<form:input path="isbn" placeholder="ISBN"/>
			    </div>
			  </div>
			  
			  <div>
			    <label for="titleBook">Titre *</label>
			    <div>
			      <form:input path="titleBook" placeholder="Titre de l'ouvrage"/>
			    </div>
			  </div>
			  
			  <div>
			    <label for="priceBook">Prix d'achat</label>
			    <div>
			      <form:input path="priceBook" placeholder="Prix d'achat en euro"/>
			    </div>
			  </div>
			  
			  <div>
			    <div>
			      <button type="submit">Ajouter</button>
			    </div>
			  </div>
			</form:form>	
		</div>	
	</body>
</html>