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
    <div class="row-12 text-center p-2 cabecera">Historial</div>

    <div class="accordion" id="accordionExample">
    <div class="card-responsive" style="width:100%">
        <div class="card-header" id="headingOne">
            <h2 class="mb" action= "-0" >
                <form action="ServletEnviarinfo" method="post">

                    <button style=" background-color:rgb(0, 46, 93)" class="btn btn-link btn-block text-center text-white" type="submit" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Académicas
                    </button>
                </form>

            </h2>
        </div>

        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
            <div class="card-body">

                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Matricula</th>
                            <th scope="col">Nombre</th>
                            <th scope="col"> Veredicto</th>
                            <th scope="col">Porcentaje</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaSolicitudesAcademica}" var="solicitud">
                            <tr>
                                <td>${solicitud.matriculaSolicitud}</td>
                                <td>${solicitud.nombre}</td>
                                <td>${solicitud.verdicto}</td>
                                <td>${solicitud.porcentaje}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>


            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingTwo">
            <h2 class="mb-0">
                <form action="ServletEnviarinfo" method="post">

                    <button style="background-color:rgb(0, 46, 93)" class="btn btn-link btn-block text-center text-white" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Actividades extracurriculares
                    </button>
                </form>
            </h2>
        </div>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Matricula</th>
                            <th scope="col">Nombre</th>
                            <th scope="col"> Veredicto</th>
                            <th scope="col">Porcentaje</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaSolicitudesActividades}" var="solicitud">
                            <tr>
                                <td>${solicitud.matriculaSolicitud}</td>
                                <td>${solicitud.nombre}</td>
                                <td>${solicitud.verdicto}</td>
                                <td>${solicitud.porcentaje}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingThree">
            <h2 class="mb-0">
                <form action="ServletHistorial" method="post">

                    <button  style=" background-color:rgb(0, 46, 93)" class="btn btn-link btn-block text-center text-white " type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Madres solteras
                    </button>
                </form>
            </h2>
        </div>
        <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
            <div class="card-body">
                <div class="table-responsive">
                    <table class=" table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Matricula</th>
                            <th scope="col">Nombre</th>
                            <th scope="col"> Veredicto</th>
                            <th scope="col">Porcentaje</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaSolicitudesMadres}" var="solicitud">
                            <tr>
                                <td>${solicitud.matriculaSolicitud}</td>
                                <td>${solicitud.nombre}</td>
                                <td>${solicitud.verdicto}</td>
                                <td>${solicitud.porcentaje}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingFour">
            <h2 class="mb-0">
                <form action="ServletHistorial" method="post">

                    <button  style=" background-color:rgb(0, 46, 93)" class="btn btn-link btn-block text-center text-white " type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        Personal Administrativo
                    </button>
                </form>
            </h2>
        </div>
        <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
            <div class="card-body">
                <div class="table-responsive">
                    <table class=" table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Matricula</th>
                            <th scope="col">Nombre</th>
                            <th scope="col"> Veredicto</th>
                            <th scope="col">Porcentaje</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaSolicitudesAdmin}" var="solicitud">
                            <tr>
                                <td>${solicitud.matriculaSolicitud}</td>
                                <td>${solicitud.nombre}</td>
                                <td>${solicitud.verdicto}</td>
                                <td>${solicitud.porcentaje}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingFive">
            <h2 class="mb-0">
                <form action="ServletHistorial" method="post">

                    <button  style=" background-color:rgb(0, 46, 93)" class="btn btn-link btn-block text-center text-white " type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                        Discapacidades y Comunidades Indígenas
                    </button>
                </form>
            </h2>
        </div>
        <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionExample">
            <div class="card-body">
                <div class="table-responsive">
                    <table class=" table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">Matricula</th>
                            <th scope="col">Nombre</th>
                            <th scope="col"> Veredicto</th>
                            <th scope="col">Porcentaje</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaSolicitudesDiscapacidades}" var="solicitud">
                            <tr>
                                <td>${solicitud.matriculaSolicitud}</td>
                                <td>${solicitud.nombre}</td>
                                <td>${solicitud.verdicto}</td>
                                <td>${solicitud.porcentaje}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
        <form method="post">
            <a href="ServletPdf">Generar pdf</a>
        </form>
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