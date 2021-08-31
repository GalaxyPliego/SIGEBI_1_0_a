<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.login == null}">
    <c:redirect url="/index.jsp"/>
</c:if>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <!--CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sideBar.css">

    <!-- favicoin link -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicoin.png" type="image/x-icon">

    <!--Font awesome -->
    <script src="https://kit.fontawesome.com/16c39358e7.js" crossorigin="anonymous"></script>
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIGEBI | Administrador</title>
</head>

<body>
<div id="lineaverde">Linea verde</div>
<nav class="sidebar">
    <ul class="nav-list">
        <li>
            <a href="ServletConvocatoria"><i class="fas fa-backward"></i>
                <span class="links_name"> Regresar</span>
            </a>
        </li>
    </ul>
</nav>
<section class="home-section">

    <div class="container mt-5">
        <div class="row">

            <div class="col-12">
                <form action="ServletConvocatoriasRUD" method="post">
                    <input type="hidden" name="opc" value="U">
                    <input type="hidden" name="idConvocatoria" value="${Convocatorias.idConvocatoria}">

                    <div class="form-group">
                        <label for="fechaInicio">Fecha de Inicio</label>
                        <input type="text" class="form-control" name="fechaInicio" id="fechaInicio" value="${Convocatorias.fechaInicio}">
                    </div>

                    <div class="form-group">
                        <label for="fechaFin">Fecha de Fin </label>
                        <input type="text" class="form-control" name="fechaFin" id="fechaFin" value="${Convocatorias.fechaFin}">
                    </div>

                    <div class="form-group">
                        <label for="estado">Estado</label>
                        <select name="estado" class="form-control" id="estado" required>
                            <option value="${Convocatorias.estado} selected">${Convocatorias.estado}</option>
                            <option value="Activo">Activo</option>
                            <option value="Inactivo">Inactivo</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-success btn-block">Modificar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <br>
    <hr>

</section>





<!-- Optional JavaScript; choose one of the two! -->
<script src="${pageContext.request.contextPath}/js/sideBar.js"></script>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

</body>
</html>
