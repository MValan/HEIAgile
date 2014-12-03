<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
	
		<table>
		<thead>
			<tr>
				<td>Titre</td>
				<td>ISBN</td>
				<td>Date d'emprunt</td>
			</tr>
		</thead>
		<tbody id="borrowed">
		
		</tbody>
		</table>
		<script type="text/javascript">
			//Remplacer le "1" par une variable idmembre
			$.get( "return/1", function(data) {
				  console.log(data);
				});
				
		</script>
	</body>
</html>