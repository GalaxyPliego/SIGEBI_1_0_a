<%--
  Created by IntelliJ IDEA.
  User: guidodm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/StylesAlumno.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sideBar.css">
  <!-- favicoin link -->
  <link rel="shortcut icon" href="img/favicoin.png" type="image/x-icon">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

  <!-- CDNS -->
  <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>SIGEBI | Convocatorias</title>
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

<!-- Sección de convocatorias -->
<section class="home-section">
  <div class="container convocatorias">

    <div class="row"><!-- FILA 1 -->
      <c:forEach items="${Lista_Convocatorias}" var="convocatoria" varStatus="status">
        <div class="col-md-6 col-sm-12 mb-3"><!-- Convocatoria ACADEMICA -->
          <div class="card mb-3" style="max-width: 500px;">
            <div class="card-header">
                ${convocatoria.fechaInicio} - ${convocatoria.fechaFin}
            </div>
            <div class="row no-gutters">
              <div class="col-md-6">
                <div class="card-body">
                  <h5 class="card-title">${convocatoria.tipoBeca}</h5>
                  <p class="card-text">Monto total: $9,000</p>
                  <a href="" data-toggle="modal" data-target="#modal_restricciones" class="especificaciones"><p class="card-text"><small class="text-muted">Restricciones...</small></p></a>
                  <a href=""><p class="card-text"><small class="text-muted">Detalles del programa...</small></p></a>
                  <form action="ServletEleccionBeca" method="post">
                    <input type="hidden" name="opc" value="${convocatoria.idBeca}">
                    <input type="hidden" name="idAlumno" value="${idAlumno}">
                    <input type="hidden" name="id_convocatoria" value="${convocatoria.idConvocatoria}">
                    <button type="submit" class="btn btn-azul mt-2" >Solicitar Beca</button>
                  </form>


                </div>
              </div>

              <div class="col-md-6">
                <img src="img/Logo-utez.png" alt="" class="img-card">
              </div>
            </div>
          </div>
        </div><!-- FIN Convocatoria ACADEMICA -->
      </c:forEach>
    </div><!-- Final FILA 3 -->

  </div><!-- Final Div Container -->
</section>

<!-- Modal -->
<div class="modal fade" id="modal_restricciones" tabindex="-1" aria-labelledby="ModalAcademica" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="ModalAcademica">Restricciones. <small class="text-muted"></small></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>
          A) Solo podrán participar estudiantes regulares (No reincorporaciones), inscrito(a)s y sin
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
      </div>
      <div class="modal-footer">

      </div>
    </div>
  </div>
</div><!-- FINAL MODAL -->




<!-- Optional JavaScript; choose one of the two! -->
<script src="${pageContext.request.contextPath}/js/sideBar.js"></script>
<script src="${pageContext.request.contextPath}/js/fechaSolicitud.js.js"></script>

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

