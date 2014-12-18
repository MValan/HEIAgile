<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="css/borrow/borrowBookForm.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- <script type="text/javascript" src="js/borrow/borrowBookForm.js"></script> -->
</head>

<body>
<div class="container">
    <h1>Ajouter un Emprunt</h1>

    <br>
    <br>
    <c:if test="${not empty message}">
        <div class="alert alert-success" role="alert"><strong>Bravo!</strong> ${message}</div>
    </c:if>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger" role="alert"><strong>Zut!</strong>
            <c:forEach var="err" items="${errors}">
                ${err}
            </c:forEach>
        </div>
    </c:if>

    <div id="emptyBooks" class="alert alert-warning" style="display: none;">
        Il n'y a aucun livre enregistré (ou disponible) en Base de Données.<strong> Veuillez
        d'abord en ajouter un <a href='../books/books'>ici.</a> </strong>
    </div>

    <div id="emptyMembers" class="alert alert-warning" style="display: none;">
        Il n'y a aucun membre enregistré en Base de Données.<strong> Veuillez
        d'abord en ajouter un <a href='../members/members'>ici.</a></strong>
    </div>

    <br>
    <form:form method="POST" id="insertBorrow" commandName="borrow" class="form-horizontal">

        <div class="row">
            <label class="col-sm-3 control-label" for="titleBook">Titre de l'ouvrage * :</label>

            <div class="col-sm-5">
                <form:input path="book" class="form-control" type="text" name="titleBook" id="titleBook"
                            placeholder="Titre"
                            onPropertyChange="checkTitle(this.val())" required="true" />
            </div>
        </div>

        <br>

        <div class="row">
            <label class="col-sm-3 control-label" for="titleBook">Membre* :</label>

            <div class="col-sm-5">
                <form:input path="member" class="form-control" type="text"
                            name="membreBorrow" id="membreBorrow"
                            placeholder="Nom_Prénom_Date de naissance" required="true" />
            </div>
            <div class="message-erreur"></div>
        </div>

        <br>


        <div class="row">
            <label class="col-sm-3 control-label" for="dateBorrow">Date maximale de restitution :</label>

            <div class="col-sm-5">
                <form:input path="dateBorrowEnd"  class="form-control" type="date" name="dateBorrow"
                            id="dateBorrow" value="${dateRest}" readonly="true"/>
            </div>
            <div class="message-erreur"></div>
        </div>

        <br>

        <input type="text" name="idBook" id="idBook" style="display: none;"/>
        <input type="text" name="idMember" id="idMember"
               style="display: none;"/>

        <div class="row">
                <div class="col-md-3 col-md-offset-3">
                    <button type="submit" class="btn btn-primary" id="submit" style="display: none;">Ajouter</button>
                </div>
        </div>
    </form:form>
</div>


<div id="booksListe" style="display: none;">${books}</div>
<script>
    var everythingValid = false;
    var titleValid = false;
    var memberValid = false;
    $(document).ready(function () {
        if (availableBooks.length === 0) {
            $("#insertBorrow").hide();
            $("#emptyBooks").show();
        }
        if (availableMembers.length === 0) {
            $("#insertBorrow").hide();
            $("#emptyMembers").show();
        }
        $("#titleBook").bind("change paste keyup", function () {
            checkTitle($(this).val());
        });
        $("#membreBorrow").bind("change paste keyup", function () {
            checkMember($(this).val());
        });

        $("input").keypress(function (e) {
            if (e.keyCode == 13) {
                e.preventDefault();
                return false;
            }
        });

    });

    function checkTitle(value) {
        for (var int = 0; int < availableBooks.length; int++) {
            if (value == availableBooks[int].label) {
                $("#titleBook").next(".message-erreur").hide();
                titleValid = true;
                $("#idBook").val(availableBooks[int].value);
                if (memberValid) {
                    $("#submit").show();
                }
                return false;
            } else {
                $("#titleBook").next(".message-erreur").show().text(
                        "Veuillez saisir un titre d'ouvrage valide");
                $("#submit").hide();
            }
        }
    }
    function checkMember(value) {
        for (var int = 0; int < availableMembers.length; int++) {
            if (value == availableMembers[int].label) {
                $("#membreBorrow").next(".message-erreur").hide();
                memberValid = true;
                $("#idMember").val(availableMembers[int].value);
                if (titleValid) {
                    $("#submit").show();
                }
                return false;
            } else {
                $("#membreBorrow").next(".message-erreur").show().text(
                        "Veuillez renseigner un membre valide");
                $("#submit").hide();
            }
        }
    }
</script>
</body>
</html>