$(function() {

	$("#titleBook").keyup(
			function() {
				if (!$("#titleBook").val().match(/^[a-z]+$/i)) {
					$("#titleBook").next(".message-erreur").show().text(
							"Veuillez saisir un titre d'ouvrage valide");

				} else {
					$("#titleBook").next(".message-erreur").hide().text("");
				}
			});

	$("#membreBorrow").keyup(
			function() {
				if (valid == false && $("#membreBorrow").val() == "") {
					$("#membreBorrow").next(".message-erreur").show().text(
							"Veuillez renseigner un membre");

				} else {
					$("#membreBorrow").next(".message-erreur").hide().text("");
				}
			});

	$("#submit").click(
			function() {
				valid = true;
				if ($("#titleBook").val() == "") {
					$("#titleBook").next(".message-erreur").fadeIn().text(
							"Veuillez saisir un titre d'ouvrage");
					valid = false;

				} else if (!$("#titleBook").val().match(/^[a-z]+$/i)) {
					valid = false;
				}

				if ($("#membreBorrow").val() == "") {
					$("#membreBorrow").next(".message-erreur").show().text(
							"Veuillez renseigner un membre");
					valid = false;
				} else {
					$("#membreBorrow").next(".message-erreur").fadeOut();
				}

				if (!valid) {
					alert("faux");
				}

				return valid;

			});
});
