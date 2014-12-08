<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	
	<body>
		<div>
			<h3>${message}</h3>
			<h1>Nouveau client</h1>
	
			<form:form method="POST" commandName="member" class="form-horizontal">
			  <div>
			    <label for="lastNameMember">Nom</label>
			    <div>
			    	<form:input path="lastNameMember" placeholder="Nom" pattern="[A-Za-z '-éèïàçëê]{2,50}"/>
			    </div>
			  </div>
			  
			  <div>
			    <label for="firstNameMember">Prénom</label>
			    <div>
			      <form:input path="firstNameMember" placeholder="Prénom" pattern="[A-Za-z '-éèïàçëê]{2,50}"/>
			    </div>
			  </div>
			  
			  <div>
			    <label for="genderMember">Sexe</label>
			    <div>
			      <form:radiobutton path="genderMember" value="M"/>Masculin
			      <form:radiobutton path="genderMember" value="F"/>Féminin
			    </div>
			  </div>
			  
			  <div>
			    <label for="birthDateMember">Date de naissance</label>
			    <div class="col-lg-4">
			      <form:input path="birthDateMember" placeholder="AAAA/MM/JJ" pattern="(19|20)\d\d[/](0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])"/>
			    </div>
			  </div>
			  
			  <div>
			    <div>
			      <button type="submit">Enregistrer</button>
			    </div>
			  </div>
			</form:form>	
		</div>	
	</body>
</html>