<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

</head>

<body>
<div class="container">
    <h1>Interface de gestion de la bibliothèque</h1>
    <br>
    <ul>
    	<li><a href='members/members'>Ajout membres</a></li>
    	<li><a href='books/books'>Ajout livres</a></li>
    	<li><a href='borrow/borrow'>Ajout emprunts</a></li>
    	<li><a href='borrow/return'>Restitution / Gestion emprunts</a></li>
    </ul>
</div>
</body>
</html>