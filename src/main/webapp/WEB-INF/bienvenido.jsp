<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP Previo - Bienvenido</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>
	<div class="container">
		<%--Comienzo de Encabezado--%>
		<div class="row">
			<div class="col-xs-2">
				<!-- (columna vacia por estetica) -->
			</div>
			
			<div class="col-xs-8 jumbotron">
				<h1> Bienvenido! </h1>
				<div class="col-xs-4">
					<p> ¿Que desea hacer? </p>
					<button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#myModal">
						Cambiar contraseña
					</button>
					<br>
					<button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modalProvincias">
					 Administrar provincias
					</button>
				</div>
	
				<div class="col-xs-6 ">
				</div>

					<!--Inicio modal cambiar contraseña -->
					<form action = "cambiar-contraseña" name = "form-cambio-password" method="post">
					<div id="myModal" class="modal fade" role="dialog" >
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Cambiar contraseña</h4>
								</div>
								<div class="modal-body">
									<p>Complete los campos para realizar el cambio de contraseña. (Hasta 8 digitos)</p>
									<input id="input-pass-1" class="form-control" type="password" name="password" placeholder="Nueva Contraseña" required="required" maxlength="8"/>
									<input id="input-pass-2" class="form-control" type="password" name="new-password" placeholder="Ingresar Nuevamente" required="required" maxlength="8"/>
								</div>
								<div class="modal-footer">
									<button type="submit" id ="boton-aceptar-cambio-password" class="btn btn-success">Aceptar</button>
									<button type="button" id ="boton-cerrar-cambio-password" class="btn btn-default"data-dismiss="modal">Cerrar</button>
								</div>
							</div>
						</div>
					</div>
					</form>
					<br>
					<!-- Fin modal cambiar contraseña -->
					
					<!-- Inicio modal administrar provincias -->
					<div id="modalProvincias" class="modal fade" role="dialog" >
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Seleccionador de Provincias</h4>
								</div>
								<br>
								<div class="modal-body">
									<p>Seleccionar un pais y una provincia para agregar a la base de datos.</p>
										<select id="country" name="country" class="modal-content" size="1" >
     									   	<option>Seleccionar un pais</option> 		   	
										  <c:forEach var="country" items="${countries}">
     									   	<option value="${country}">${country}</option>
     									  </c:forEach>
  									    </select>
									<br>
									<br>
										<select id="state" name="state" class="modal-content" >
											<option>Seleccionar una provincia</option>
										  <c:forEach var="state" items="${states}">
     									 	<option value="${state}">${state}</option>
     									  </c:forEach>
  										</select>
									<br>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-success" data-dismiss="modal">Aceptar</button>
									<button type="button" class="btn btn-default"data-dismiss="modal">Cerrar</button>
								</div>
							</div>
						</div>
					</div>	
					<!-- Fin modal administrar provincias -->
				</div>
			</div>
			<div class="col-xs-2">
				<!-- (columna vacia por estetica) -->
			</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/app/eventos.js" type="text/javascript"></script>
</body>
</html>