<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.login == null}">
    <c:redirect url="/index.jsp"/>
</c:if>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <!-- CSS Link -->
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
<div>
    <div id="lineaverde">Linea verde</div>
    <nav class="sidebar">
        <ul class="nav-list">
            <li>
                <a href="ServletCuentaComite"><i class="fas fa-backward"></i>
                    <span class="links_name"> Regresar</span>
                </a>
            </li>
        </ul>
    </nav>
    <div class="row-12 text-center p-2 cabecera">Información personal</div>
    <div class="container">
        <div class="row " style="margin-top: 2%">
            <div class="col-sm-3" style="text-align: center">
                <img class="imagen" src="${pageContext.request.contextPath}/img/user.png"
                     style="height: 190px; align-content: center;">
                <p></p>
                <img class="imagen" src="${pageContext.request.contextPath}/img/identificador_sigebi_gris.png"
                     style="height: 50px; width: 168px; ">
            </div>
            <div class="col-sm-9">
                <form action="ServletCuentaComiteCRUD" method="post">
                    <input type="hidden" name="opc" value="U">
                    <input type="hidden" name="idUser" value="${usuarios.idUsuario}">
                    <div class="form-row  justify p-4">
                        <div class="col-md-4 col-sm-12 form-group ">
                            <label for="nombre">Nombre(s)</label>
                            <input class="form-control" type="text" name="nombre" id="nombre" placeholder="Nombre"
                                   value="${usuarios.nombre}">
                        </div>
                        <div class="col-md-4 col-sm-12  form-group ">
                            <label for="primerApellido">Primer Apellido</label>
                            <input class="form-control" type="text" name="primerApellido" id="primerApellido"
                                   placeholder="Primer apellido" value="${usuarios.primerApellido}">
                        </div>
                        <div class="col-md-4 col-sm-12  form-group ">
                            <label for="segundoApellido">Segundo Apellido</label>
                            <input class="form-control" type="text" name="segundoApellido" id="segundoApellido"
                                   placeholder="Segundo apellido" value="${usuarios.segundoApellido}">
                        </div>
                        <div class="col-md-4 col-sm-12 form-group ">
                            <label for="correo">Correo electrónico</label>
                            <input class="form-control" type="text" name="correo" id="correo"
                                   placeholder="Correo electrónico" value="${usuarios.correo}">
                        </div>
                        <div class="col-md-4 col-sm-12 form-group ">
                            <label for="clave">Contraseña</label>
                            <input class="form-control" type="text" name="clave" id="clave" placeholder="Contraseña"
                                   value="${usuarios.clave}">
                        </div>
                        <div class="col-md-4 col-sm-12 form-group ">
                            <label for="estado">Estado</label>
                            <select class="form-control" id="estado" name="estado">
                                <option selected value="${usuarios.estado}">${usuarios.estado}</option>
                                <option value="Activo">Activo</option>
                                <option value="Inactivo">Inactivo</option>
                            </select>
                        </div>
                        <div class="col-md-4 col-sm-12 form-group ">
                            <label for="divisionAcademica">División Academica</label>
                            <select class="form-control" id="divisionAcademica" name="divisionAcademica">
                                <option value="${usuarios.idDivisionAcademica}">${usuarios.idDivisionAcademica}</option>
                                <c:forEach items="${listaDivisiones}" var="divisiones" varStatus="">
                                    <option value="${divisiones.idDivisionAcademica}">${divisiones.idDivisionAcademica} -> ${divisiones.nombreDivisionAcademica}</option>
                                </c:forEach>

                            </select>
                        </div>
                        <div class="col-sm-3 col-sm-9 form-group ">
                            <button type="submit" class="btn btn-primary" data-toggle="button" aria-pressed="false">Actualizar información</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Optional JavaScript; choose one of the two! -->
<!-- javaSrcipt-->
<script src="${pageContext.request.contextPath}/js/sideBar.js"></script>
<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
-->
</body>

</html>
