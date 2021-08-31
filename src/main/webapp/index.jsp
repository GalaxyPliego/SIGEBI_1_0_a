<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.login != null}">
    <c:redirect url="/ServletGo"/>
</c:if>
<!doctype html>
<html lang="es">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <!-- CSS Link -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/StylesInicioSesion.css">

    <!-- favicoin link -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicoin.png" type="image/x-icon">

    <title>SIGEBI | Inicio Sesión</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navegador">
    <div class="navbar-header">

        <a href="index.jsp"><img src="${pageContext.request.contextPath}vistas/img/acronimo_sigebi_blanco.png" alt="" class="acronimoNav"></a>
    </div>
</nav>
<div class="container">
    <div class="row justify-content-center contenido">

        <!--Formulario-->
        <div class="col-md-6 bg-white p-5 border">

            <!--Fila del identificador-->
            <div class="row justify-content-center">
                <img title="Sistema de Gestión de Becas Internas" class="identificador" src="${pageContext.request.contextPath}/img/identificador_sigebi_gris.png" alt="Sistema de Gestión de Becas Internas">
            </div>
            <br>
            <hr>


            ${message}

            <!--Fila del formulario-->
            <form class="" action="${pageContext.request.contextPath}/ServletLogin" method="POST" name="formLogin" id="formLogin" onsubmit="return validacion(this)">

                <!--Email-->
                <fieldset>
                    <div class="form-group">
                        <label for="correoInstitucional">Correo Institucional</label>
                        <input required class="form-control" type="email" name="correoInstitucional" id="correoInstitucional" placeholder="Correo Institucional" required>
                    </div>
                    <!--Contraseña-->
                    <div class="form-group">
                        <label for="contrasenia">Contraseña</label>
                        <input required class="form-control" type="password" name="contrasenia" id="contrasenia" placeholder="Contraseña">
                    </div>

                    <div class="text-center mb-2">
                        <label>
                            <a class="" href="${pageContext.request.contextPath}/ServletIndex?to=recuperar_contrasenia/recuperarContrasenia.jsp">¿Olvidaste tu contraseña?</a>
                        </label>
                    </div>

                    <input type="submit" class="btn btn-success btn-block btn-lg" value="Iniciar Sesión">
                    <br>
                    <div class="row justify-content-center">
                        <p>¿Aún no te has registrado? </p>
                        <a class="ml-3" href="ServletRegistro"> Registrate</a>
                    </div>
                    </fieldset>
            </form>
        </div>
    </div>
</div>




<!-- Optional JavaScript; choose one of the two! -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
-->
</body>
</html>