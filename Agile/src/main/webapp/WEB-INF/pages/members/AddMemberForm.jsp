<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	
	<body>
		<div>
			<h1>Nouveau client</h1>
	
			<form:form method="POST" commandName="member" class="form-horizontal">
			  <div>
			    <label for="lastNameMember">Nom</label>
			    <div>
			    	<form:input path="lastNameMember" placeholder="Nom"/>
			    </div>
			  </div>
			  
			  <div>
			    <label for="firstNameMember">Prénom</label>
			    <div>
			      <form:input path="firstNameMember" placeholder="Prénom"/>
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
			      <form:input path="birthDateMember" placeholder="AAAA/MM/JJ"/>
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