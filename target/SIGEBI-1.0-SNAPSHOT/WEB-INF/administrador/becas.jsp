<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="sidebar">
    <div class="logo-details">
        <a class='icon' href="ServletDivisionAcademica"> <img class="favicoin" src="${pageContext.request.contextPath}/img/favicoin12px.png" alt=""></a>
        <div class="logo_name">SIGEBI</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
        <li>
            <a href="ServletConvocatoria">
                <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/convocatorias.png" alt=""></i>
                <span class="links_name">Convocatorias</span>
            </a>
        </li>
        <li>
            <a href="ServletBeca">
                <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/becas.png" alt=""></i>
                <span class="links_name">Becas</span>
            </a>
        </li>
        <li>
            <a href="ServletAlumnos">
                <i class="fas fa-user-graduate"></i>
                <span class="links_name">Alumnos</span>
            </a>
        </li>
        <li>
            <a href="ServletCuentaComite">
                <i class="fas fa-user-tie"></i>
                <span class="links_name">Comité de Becas</span>
            </a>
        </li>
        <li>
            <a href="ServletDivisionAcademica">
                <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/divisiones.png" alt=""></i>
                <span class="links_name">Divisiones y Carreras</span>
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
    <div class="row-12 text-center p-2 cabecera">Becas</div>

    <div class="container mt-4">
        <div class="row">
            <div class="col-md-12 col-sm-12 mb-3 float-right">
                <form action="ServletBecaRU" class="form-inline my-2 my-lg-0 justify-content-end float-right" method="post">
                    <input type="hidden" name="opc" value="S">
                    <input name="buscador" class="form-control mr-sm-2" type="search" placeholder="Buscar por Nombre o Id" aria-labelledby="Buscar por Nombre o Id">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
                </form>
            </div>
            <div class="col-12">
                <div class="card">
                    <div style="background-color: #00AB84" class=" text-white card-header justify-content-center text-center">
                        Becas Institucionales
                    </div>

                    <table class="table table-striped tableBecas">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Tipo Beca</th>
                            <th SCOPE="col">Estado</th>
                            <th scope="col">Acciones</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${listaBecas}" var="beca" varStatus="status">
                            <tr>
                                <td>${beca.idBeca}</td>
                                <td>${beca.tipoBeca}</td>
                                <td>${beca.estado}</td>
                                <td>
                                    <form action="ServletBecaRU" method="post">
                                        <input type="hidden" name="idBeca" value="${beca.idBeca}">
                                        <input type="hidden" name="opc" value="R">
                                        <button class="btn btn-info"><i class="fas fa-edit"></i> Modificar</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>






<!-- Optional JavaScript; choose one of the two! -->
<script src="${pageContext.request.contextPath}/js/sideBar.js"></script>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

</body>
</html>