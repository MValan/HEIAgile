<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="http://oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css">
<script
	src="http://oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script>
	$(document)
			.ready(
					function() {
						$("#input-isbn")
								.keyup(
										function() {
											if ($("#isbn-form").attr("class") == "form-group has-feedback has-success") {
												$("#isbn-valid").val(
														$("#input-isbn").val());
												$("#submit-form").show();
											}
											if ($("#isbn-form").attr("class") == "form-group has-feedback has-error") {
												$("#isbn-valid").val("");
												$("#submit-form").hide();
											}
										});
						$(".numericOnly").keyup(function() {
							this.value = this.value.replace(/[^0-9\.]/g, '');
						});
					});
</script>
</head>

<body>
	<div class="container">
		<h3>${confirmationAddBook}</h3>
		<h1>Ajouter un Ouvrage</h1>
		<form id="isbnForm" class="form-horizontal">
			<div id="isbn-form" class="form-group">
				<div class="row">
					<label class="col-sm-3 control-label">ISBN * (<i>9971502100</i>)
					</label>
					<div class="col-sm-5">
						<input type="text" id="input-isbn" class="form-control"
							name="isbn" />
					</div>
				</div>
			</div>
		</form>
		<script>
			$('#isbnForm').bootstrapValidator({
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					isbn : {
						validators : {
							isbn : {
								message : 'Veuillez saisir un code ISBN valide'
							}
						}
					}
				}
			});
		</script>

		<form:form method="POST" commandName="book" class="form-horizontal">
			<div class="form-group">
				<form:input path="isbn" id="isbn-valid" style="display: none;" />


				<div class="row">
					<label class="col-sm-3 control-label" for="titleBook">Titre
						*</label>
					<div class="col-sm-5">
						<form:input path="titleBook" placeholder="Titre de l'ouvrage"
							required="required" />
					</div>
				</div>

				<div class="row">
					<label class="col-sm-3 control-label" for="priceBook">Prix
						d'achat</label>
					<div class="col-sm-5">
						<form:input path="priceBook" class="numericOnly"
							placeholder="Prix d'achat en euro" required="required" />
					</div>
				</div>

				<div class="row">
					<div class="col-sm-3 control-label">
						<button type="submit" id="submit-form" style="display: none;">Ajouter</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>