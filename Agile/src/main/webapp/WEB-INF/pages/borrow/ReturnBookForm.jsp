<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
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
		<script type="text/javascript">
			//Remplacer le "1" par une variable idmembre --> Autocomplete
			$.getJSON( "return/1")
			.done(function(data){
					console.log(data);
					for(i=0;i<data.length;i++)
					{
						$("#borrowed").append("<tr><td>"+data[i].book.titleBook+"</td><td>"+data[i].book.isbn+"</td><td>A ajouter</td><td><form:checkbox path='' value='true'/></td></tr>");
					}
				});
				
		</script>
	</body>
</html>