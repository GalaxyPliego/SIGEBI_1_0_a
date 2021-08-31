<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.login == null}">
    <c:redirect url="/index.jsp"/>
</c:if>
<!doctype html>
<html lang="es">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

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


<body>
<div id="lineaverde">Linea verde</div>
<div class="sidebar">
    <div class="logo-details">

        <a class='icon' href=""> <img class="favicoin" src="${pageContext.request.contextPath}/img/favicoin12px.png" alt=""></a>
        <div class="logo_name">SIGEBI</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
        <li>
            <a href="${pageContext.request.contextPath}/ServletGo?to=administrador/convocatorias.jsp">
                <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/convocatorias.png" alt=""></i>
                <span class="links_name">Convocatorias</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/ServletGo?to=administrador/becas.jsp">
                <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/becas.png" alt=""></i>
                <span class="links_name">Becas</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/ServletGo?to=administrador/alumnos.jsp">
                <i class="fas fa-user-graduate"></i>
                <span class="links_name">Alumnos</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/ServletGo?to=administrador/comiteBecas.jsp">
                <i class="fas fa-user-tie"></i>
                <span class="links_name">Comité de Becas</span>
            </a>
        </li>
        </li>
        <a href="${pageContext.request.contextPath}/ServletGo?to=administrador/carrerasDivisiones.jsp">

            <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/divisiones.png" alt=""></i>
            <span class="links_name">Carreras Divisiones</span>
        </a>
        </li>
        <li class="profile">
            <div class="profile-details">
                <i class="fas fa-user"></i>
            </div>
            <i class='bx bx-log-out' id="log_out" ></i>
        </li>
    </ul>
</div>
<div class="container">
    <div class="row">

        <div class="col-12">
            <div class="card card-default mt-3">
                <div class="card-header text-center">
                    <h5 class="card-title">Informacion personal</h5>
                </div>
                <div class="card-body">
                    <div class="row">
                        <form action="ServletCuentaComite" method="post">
                            ${mensaje}
                            <div class="form-row justify-content-center p-4">
                                <div class="col-md-4 col-sm-12  form-group ">
                                    <label for="correo">Correo Elecronico</label>
                                    <input class="form-control" type="text" name="correo" id="correo" placeholder="correo@utez.edu.mx">
                                </div>
                                <div class="col-md-4 col-sm-12 form-group ">
                                    <label for="nombre">Nombre(s)</label>
                                    <input class="form-control" type="text" name="nombre" id="nombre" placeholder="Nombre">
                                </div>
                                <div class="col-md-4 col-sm-12  form-group ">
                                    <label for="primerApellido">Primer Apellido</label>
                                    <input class="form-control" type="text" name="primerApellido" id="primerApellido" placeholder="Apellido">
                                </div>
                                <div class="col-md-4 col-sm-12  form-group ">
                                    <label for="segundoApellido">Segundo Apellido</label>
                                    <input class="form-control" type="text" name="segundoApellido" id="segundoApellido" placeholder="Apellido">
                                </div>

                                <div class="col-md-4 col-sm-12  form-group ">
                                    <label for="contrasenia">Contraseña</label>
                                    <input class="form-control" type="text" name="contrasenia" id="contrasenia" placeholder="correo@utez.edu.mx">
                                </div>

                                <div class="col-md-4 col-sm-12  form-group ">
                                    <label for="estado">Estado</label>
                                    <select class="form-control" id="estado" name="estado">
                                        <option value=Activo>Activo </option>
                                        <option value=Inactivo>Inactivo</option>
                                    </select>
                                </div>
                                <div class="col-md-4 col-sm-12  form-group ">
                                    <label for="id_division">División Academica</label>
                                    <select class="form-control" id="id_division" name="id_division">
                                        <option>- </option>
                                        <option value="1">División Académica Económica-Administrativa </option>
                                        <option value="2"> División Académica de Mecánica Industrial</option>
                                        <option value="3">División Académica de Tecnologías de la Información y Comunicación</option>
                                        <option value="4">División Académica de Terapia Física </option>
                                    </select>
                                </div>
                                <br>
                                <input type="hidden" name="rol" id="rol" value="2">

                            </div>
                            <div class="offset-5">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success">Agregar nuevo miembro</button>

                                </div>
                            </div>
                            <br>
                        </form>
                    </div>
                </div>
            </div>


        </div>

    </div>
</div>




<!-- Optional JavaScript; choose one of the two! -->
<script src="${pageContext.request.contextPath}/js/sideBar.js"></script>

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