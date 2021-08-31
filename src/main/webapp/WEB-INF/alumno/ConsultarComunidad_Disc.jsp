<%--
  Created by IntelliJ IDEA.
  User: guidodm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
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

<div class="container mt-4"><!-- Inicio DIV CONTAINER -->

    <div class="alert alert-danger mt-2" role="alert">
        <p>   A) Solo podrán participar estudiantes regulares (No reincorporaciones), inscrito(a)s y sin
            adeudos con la Universidad. <br>
            B) No haber incurrido en alguna de las faltas de conducta y disciplina en materia
            administrativa, académica y/o extracadémica. <br>
            C) Si cuentan con Beca Federal o Estatal, solo se podrá beneficiar hasta con un porcentaje
            máximo del 50% en la exención parcial del pago de la           inscripción al cuatrimestre que
            corresponda la convocatoria. <br>
            D) El Comité de Becas en función a la disponibilidad presupuestal y de la demanda de
            solicitudes, otorgará los porcentajes de descuento. <br>
            E) EL PAGO DE CUATRIMESTRE SOLICITADO DEBERÁ DE REALIZARSE INMEDIATAMENTE DESPUÉS
            DE LA EMISIÓN DE RESULTADOS DE BECAS.
        </p>
    </div><!-- FIN RESTRICCIONES -->

    <div class="container card"> <!-- INICIO div del formulario -->
        <h3>Requisitos</h3>
        <form action=ServletGuardarSolicitud" method="post" class="mt-3">
            <div class="row">
                <div class="col-md-6 col-sm-12">
                    <div class="form-group ml-5">
                        <label for="cuatrimestreAnterior">Cuatrimestre anterior</label>
                        <select class="form-control w-75" id="cuatrimestreAnterior">
                            <option value="${requisitos.cuatrimestreAnterior}">${requisitos.cuatrimestreAnterior}</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-6 col-sm-12">
                    <div class="form-group ml-5">
                        <label for="cuatrimestreActual">Cuatrimestre actual</label>
                        <select class="form-control w-75" id="cuatrimestreActual">
                            <option value="${requisitos.cuatrimestreActual}">${requisitos.cuatrimestreActual}</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6 col-sm-12">
                    <div class="form-group ml-5">
                        <label for="promedio">Promedio</label>
                        <input id="promedio" value="${requisitos.promedio}" readonly>
                    </div>
                </div>
                <div class="col-md-6 col-sm-12">
                    <div class="form-group ml-5">
                        <label>Boleta Cuatrimestre anterior</label>
                        <img style="width: 450px;height: 500px;" src="${pageContext.request.contextPath}/ServletObtenerBoleta?id=${id_solicitud}" >
                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6 col-sm-12">
                    <div class="form-group ml-5">
                        <label for="motivos">Motivos</label>
                        <textarea class="form-control w-75" id="motivos" rows="3" name="motivos" required="">${requisitos.motivos}</textarea>
                    </div>
                </div>
                <div class="col-md-6 col-sm-12">
                    <div class="form-group ml-5">
                        <label>Constancia</label>
                        <img style="width: 450px;height: 500px;" src="${pageContext.request.contextPath}/ServletObtenerConstancia?id=${id_solicitud}" >
                    </div>
                </div>
            </div>


        </form>
    </div><!-- FIN div del formulario -->

</div><!-- Final DIV CONTAINER -->






<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

</body>
</html>
