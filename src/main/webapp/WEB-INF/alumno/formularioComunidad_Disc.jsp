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
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

  <!-- CSS Link -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/StylesFormulario.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sideBar.css">
  <!-- favicoin link -->
  <link rel="shortcut icon" href="img/favicoin.png" type="image/x-icon">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

  <!-- CDNS -->
  <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SIGEBI | Formulario</title>
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
      <a href="${pageContext.request.contextPath}/ServletAlumnoU?opc=R">
        <i class="fas fa-user-graduate"></i>
        <span class="links_name" >Cuenta</span>
      </a>

    </li>

    <li>
      <a href="ServletConvocatoriasAlumnos">
        <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/convocatorias.png" alt=""></i>
        <span class="links_name">Convocatorias</span>

      </a>
    </li>

    <li>
      <a href="${pageContext.request.contextPath}/ServletAlumnoU?opc=H&matricula=${alumno.matricula}">
        <i><img class="iconosNav" src="${pageContext.request.contextPath}/img/becas.png" alt=""></i>
        <span class="links_name">Historial de Becas</span>
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

  <div class="container mt-4"><!-- Inicio DIV CONTAINER -->

    <div class="alert alert-danger mt-2" role="alert">
      <p> 1. Subir al formulario Constancia de discapacidad expedida por servicios de salud pública
        municipal o estatal o Constancia de ser originario de una comunidad indígena expedida
        por autoridades de la comunidad indígena. <br>
        <br>
        NOTA: LA BECA DE DISCAPACIDAD Y COMUNIDADES INDÍGENAS SE OTORGA COMO UNA
        MODALIDAD DE LA BECA DE FALTA DE SOLVENCIA ECONÓMICA
      </p>
    </div><!-- FIN RESTRICCIONES -->

    <div class="container card"> <!-- INICIO div del formulario -->
      <h3>Requisitos</h3>
      <form action="ServletGuardarSolicitud" class="mt-3" method="post" enctype="multipart/form-data">
        <div class="row">
          <div class="col-md-6 col-sm-12">
            <div class="form-group ml-5">
              <label for="cuatrimestreAnterior">Cuatrimestre anterior</label>
              <select class="form-control w-75" id="cuatrimestreAnterior" name="cuatrimestreAnterior" required="">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
              </select>
            </div>
          </div>
          <div class="col-md-6 col-sm-12">
            <div class="form-group ml-5">
              <label for="cuatrimestreActual">Cuatrimestre actual</label>
              <select class="form-control w-75" id="cuatrimestreActual" name="cuatrimestreActual" required="">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
              </select>
            </div>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-md-6 col-sm-12">
            <div class="form-group ml-5">
              <label for="promedio">Promedio</label>
              <input type="text" class="form-control w-75" id="promedio" name="promedio" required="">
              <small id="promedioS" class="form-text text-muted">Ingresa el promedio del cuatrimestre anterior</small>
            </div>
          </div>
          <div class="col-md-6 col-sm-12">
            <div class="form-group ml-5">
              <label for="boleta">Boleta Cuatrimestre anterior</label>
              <input type="file" class="form-control-file mt-2" id="boleta" name="boleta" required="">
            </div>
          </div>
        </div>
        <div class="row mt-3">
          <div class="col-md-6 col-sm-12">
            <div class="form-group ml-5">
              <label for="motivos">Motivos</label>
              <textarea class="form-control w-75" id="motivos" rows="3" name="motivos" required=""></textarea>
            </div>
          </div>
          <div class="col-md-6 col-sm-12">
            <div class="form-group ml-5">
              <label for="constancia">Constancia</label>
              <input type="file" class="form-control-file mt-2" id="constancia" name="constancia" required="">
              <small id="constanciaS" class="form-text text-muted">Ingresa constancia de discapacidad o de tu comunidad</small>
            </div>
          </div>
        </div>
        <div class="form-group mx-auto mt-3" style="width: 100px;">
          <input type="hidden" value="${infoAlumno.matricula}" name="matricula" id="matricula">
          <input type="hidden" value="${idConvocatoria}" name="idConvocatoria" id="idConvocatoria">
          <input type="hidden" value="${tipoBeca}" name="tipoBeca" id="tipoBeca">
          <button class="btn navegador "  type="submit">Enviar</button>
        </div>

      </form>
    </div><!-- FIN div del formulario -->

  </div><!-- Final DIV CONTAINER -->


</section>

<script src="${pageContext.request.contextPath}/js/sideBar.js"></script>

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

</body>
</html>