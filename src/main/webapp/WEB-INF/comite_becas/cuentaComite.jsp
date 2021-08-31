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
  <div class="row-12 text-center p-2 cabecera">Información personal</div>
  <div class="container">
    <div class="row " style="margin-top: 2%">
      <div class="col-sm-3" style="text-align: center">
        <img class="img-thumbnail bg-light" src="https://image.flaticon.com/icons/png/512/1077/1077063.png" width="245"
             height="100" alt="UserIcon" id="UserIcon">
        <br>
        <h5> ${sessionScope.nombre} ${sessionScope.primerApellido} ${sessionScope.segundoApellido}</h5>
        <img class="imagen" src="${pageContext.request.contextPath}/img/identificador_sigebi_gris.png"
             style="height: 50px; width: 168px">
      </div>
      <div class="col-sm-9">
        <form action="ServletcuentaComiteU" method="post">
          <input type="hidden" name="opc" value="U">
          <input type="hidden" name="idUser" value="${idUsuario}">
          <div class="form-row  justify p-4">
            <div class="col-md-4 col-sm-12 form-group ">
              <label for="nombre">Nombre(s)</label>
              <input class="form-control" type="text" name="nombre" id="nombre" placeholder="Nombre"
                     value="${nombre}">
            </div>
            <div class="col-md-4 col-sm-12  form-group ">
              <label for="primerApellido">Primer Apellido</label>
              <input class="form-control" type="text" name="primerApellido" id="primerApellido"
                     placeholder="Primer apellido" value="${primerApellido}">
            </div>
            <div class="col-md-4 col-sm-12  form-group ">
              <label for="segundoApellido">Segundo Apellido</label>
              <input class="form-control" type="text" name="segundoApellido" id="segundoApellido"
                     placeholder="Segundo apellido" value="${segundoApellido}">
            </div>
            <div class="col-md-4 col-sm-12 form-group ">
              <label for="correo">Correo electrónico</label>
              <input class="form-control" type="text" name="correo" id="correo"
                     placeholder="Correo electrónico" value="${correo}">
            </div>
            <div class="col-md-4 col-sm-12 form-group ">
              <label for="clave">Contraseña</label>
              <input class="form-control" type="text" name="clave" id="clave" placeholder="Contraseña"
                     value="${clave}">
            </div>
            <div class="col-md-4 col-sm-12 form-group ">
              <label for="divisionAcademica">División Académica</label>
              <select class="form-control" id="divisionAcademica" name="divisionAcademica">
                <c:forEach items="${listaDivisiones}" var="divisiones" varStatus="status">
                  <option <c:if test="${sessionScope.divisionAcademica==divisiones.idDivisionAcademica}">selected</c:if>
                          value="${divisiones.idDivisionAcademica}">${divisiones.nombreDivisionAcademica}</option>
                </c:forEach>
              </select>
            </div>
            <div class="col-sm-3 col-sm-9 form-group ">
              <button type="submit" class="btn btn-primary" data-toggle="button" aria-pressed="false">
                Actualizar información
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
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
</body>

</html>
