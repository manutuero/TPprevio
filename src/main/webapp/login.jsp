<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TP previo - Login</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel = "stylesheet" href = "http://localhost:8080/TPPREVIO/css/styles.css" content = "text/css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>

<body>
  <div class="login">
	<h1>Login</h1>
    <form action="login" method="post">
    	<input type="text" name="username" placeholder="Usuario" required="required" />
        <input type="password" name="password" placeholder="Contraseña" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Ingresar</button>
    </form>
    <br>
    <br>
    <% String mensajeError = (String)request.getAttribute("error");
    	if(mensajeError != null) {
    		out.println("<span style='color:white'>" + mensajeError + "</span>");
    	} %>
  </div>
  
    <script src="js/index.js"></script>

</body>
</html>