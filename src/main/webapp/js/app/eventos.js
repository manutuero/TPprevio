function comprobarPassword() {
	$('#boton-aceptar-cambio-password').click(function() {
		// obtengo las password de los input del formulario
		var pass1 = $('#input-pass-1').val();
		var pass2 = $('#input-pass-2').val();
		
		if(pass1 === pass2) {
			document.forms["form-cambio-password"].submit(); // javascript nativo :o
		}else {
			alert("Las contraseñas ingresadas no coinciden.");
			document.forms["form-cambio-password"].reset(); // javascript nativo :o
		}
	});
}

$(document).ready(function() {
	comprobarPassword();
});
