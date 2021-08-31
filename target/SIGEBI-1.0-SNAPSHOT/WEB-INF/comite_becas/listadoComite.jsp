<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.login == null}">
    <c:redirect url="/index.jsp"/>
</c:if>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <!-- CSS Link -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sideBar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleComite.css">

    <!-- favicoin link -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicoin.png" type="image/x-icon">
    <!--Font awesome -->
    <script src="https://kit.fontawesome.com/16c39358e7.js" crossorigin="anonymous"></script>
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SIGEBI | Convocatorias</title>

</head>

<body>

<div id="lineaverde">Linea verde</div>
<div class="sidebar">
    <div class="logo-details">
        <a class='icon' href="ServletDivisionAcademica"> <img class="favicoin" src="${pageContext.request.contextPath}/img/favicoin12px.png" alt=""></a>
        <div class="logo_name">SIGEBI</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
        <li>
            <a href="ServletConvocatoriasComite">
                <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/convocatorias.png" alt=""></i>
                <span class="links_name">Convocatorias</span>
            </a>
        </li>
        <li>
            <a href="ServletEnviarinfo">
                <i class="fas fa-history"></i>
                <span class="links_name">Historial</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/ServletGo?to=comite_becas/cuentaComite.jsp">
                <i class="fas fa-user-tie"></i>
                <span class="links_name">Perfil</span>
            </a>
        </li>
        <li class="profile">
            <div class="profile-details">
            </div>
            <a href="${pageContext.request.contextPath}/ServletLogout">
                <i class='bx bx-log-out' id="log_out" ></i>
            </a>
        </li>
    </ul>
</div>

<section class="home-section">
    <div class="row-12 text-center p-2 cabecera">Listado de solicitudes</div>

    <c:forEach items="${listadodeSolicitudes}" var="listaS" varStatus="status">
        <div class="card" style="width:100%;">
            <div class="card-body">
                <div class="table-responsive">
                    <table id="tabla1" class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Matricula</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Fecha de solicitud</th>
                            <th scope="col">Estatus</th>
                            <th scope="col">Comentario</th>
                            <th scope="col">Veredicto</th>
                            <th scope="col">Porcentaje</th>
                            <th scope="col"> Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${status.count}</td>
                            <td>${listaS.matriculaSolicitud}</td>
                            <td>${listaS.nombre}</td>
                            <td>${listaS.fechaSolicitud}</td>
                            <td style=" background-color:rgb(5, 185, 164)"> ${listaS.estado}</td>
                            <form action="ServletEnviarinfo" method="post">
                                <td>
                                    <textarea name="comentario" id="comentario" class="form-control">${listaS.comentario}</textarea>
                                </td>
                                <td>
                                    <div class="btn-group" role="group">
                                        <select class="form-control" id="veredicto" name="veredicto">
                                            <option value="Aprobado"> Aprobado</option>
                                            <option value="No aprobado">No aprobado</option>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <input type="number" step="5" min="0" name="porcentaje" id="porcentaje" value="${listaS.porcentaje}">
                                </td>
                                <td>
                                    <input type="hidden" name="id_solicitud" value="${listaS.id_solicitud}">
                                    <button type="submit" class="btn" style="background-color:#00AB84" >Enviar</button>

                            </form>

                            <form action="ServletMostrarFormulario" method="post">
                                <input type="hidden" name="id_solicitud1" value="${listaS.id_solicitud}">
                                <input type="hidden" name="tipoBeca" value="${tipoBeca}">
                                <button type="submit" class="btn" style="background-color:#00AB84"> ver Información</button>
                            </form>

                            </td>

                        </tr>
                        </tbody>
                    </table>
                </div>



            </div>
        </div>



    </c:forEach>



    </div>
</section>
<!-- Optional JavaScript; choose one of the two! -->
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