<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet" media="screen" type="text/css" title="Design" href="../css/global.css" />
</head>

<fmt:formatDate value="${member.birthDateMember}" var="dateString" pattern="yyyy/MM/dd" />

<body>
<div class="container">
<jsp:include page="../navbar.jsp">
	<jsp:param name="activeTab" value="member" />
</jsp:include>
<div>
    <h1>Ajouter un client</h1>
    <br>
    <br>

    <c:if test="${not empty message}">
        <div class="alert alert-success" role="alert"><strong>Bravo!</strong> ${message}</div>
    </c:if>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger" role="alert"><strong>Mince !</strong>
            <c:forEach var="err" items="${errors}">
                ${err}
            </c:forEach>
        </div>
    </c:if>

    <br>
    <form:form method="POST" commandName="member" class="form-horizontal">
        <div class="row">
            <label class="col-sm-3 control-label" for="lastNameMember">Nom * : </label>

            <div class="col-sm-5">
                <form:input path="lastNameMember" class="form-control" placeholder="Nom"
                            pattern="[A-Za-z '-�������]{2,50}" required="true"/>
            </div>
        </div>
        <br>

        <div class="row">

            <label class="col-sm-3 control-label" for="firstNameMember">Prénom * : </label>

            <div class="col-sm-5">
                <form:input path="firstNameMember" class="form-control" placeholder="Prénom"
                            pattern="[A-Za-z '-�������]{2,50}" required="true"/>
            </div>
        </div>
        <br>

        <div class="row">

            <label class="col-sm-3 control-label" for="genderMember1">Sexe * : </label>

            <div class="col-sm-5">
                <label class="radio-inline">
                    <form:radiobutton path="genderMember" value="M" required="true"/> Masculin</label>
                <label class="radio-inline">
                    <form:radiobutton path="genderMember" value="F" required="true"/> Féminin</label>
            </div>
        </div>
        <br>

        <div class="row">
            <label class="col-sm-3 control-label" for="birthDateMember">Date de naissance * :</label>

            <div class="col-sm-5">
                <form:input placeholder="AAAA/MM/JJ" path="birthDateMember" class="form-control"
                            required="true" value="${dateString}" pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}"/>
            </div>
        </div>
        <br>

        <div class="row">
            <div class="col-md-3 col-md-offset-3">
                <button type="submit" class="btn btn-success" id="submit">Ajouter</button>
            </div>
        </div>
    </form:form>
</div>
</div>
</body>
</html>