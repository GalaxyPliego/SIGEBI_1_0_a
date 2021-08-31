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
    <div class="row-12 text-center p-2 cabecera">Divisiones Académicas y Carreras</div>

    <div class="container mt-4">
      <div class="row">
        <div class="col-md-6 col-sm-6 float-left">
          <button type="button" class="btn btn-info" data-toggle="modal" data-target="#contenedor-modal" data-backdrop="false">Crear División</button>
          <!-- Modal Agregar nueva division -->
          <div class="modal fade" tabindex="-1" role="dialog" id="contenedor-modal" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">

                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Crear División Académica</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>

                <div class="modal-body">
                  <form action="ServletDivisionAcademica" method="post" id="forumularioDivisiones">
                    <div class="form-group">
                      <label for="nombreDivisionAcademica">División Académica</label>
                      <input class="form-control" type="text" name="nombreDivisionAcademica" id="nombreDivisionAcademica" required>
                    </div>
                    <div class="form-group">
                      <label for="estadoDivision">Estado </label>
                      <select name="estadoDivision" class="form-control" id="estadoDivision" required>
                        <option value="Activo">Activo</option>
                        <option value="Inactivo">Inactivo</option>
                      </select>
                    </div>
                    <div class="form-group float-left">
                      <button type="reset" class="btn btn-danger mr-3">Limpiar</button>
                      <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-md-6 col-sm-6 float-right justify-content-end">
              <form action="ServletDivisionesRUD" class="form-inline my-2 my-lg-0 justify-content-end float-right" method="post">
                  <input type="hidden" name="opc" value="S">
                  <input name="buscador" class="form-control mr-sm-2" type="search" placeholder="Buscar por Nombre o Id" aria-labelledby="Buscar por Nombre o Id">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
              </form>
        </div>

        <div class="col-12">
          <div class="card mt-3 table-responsive">
            <div style="background-color: #00AB84" class="container-fluid card-header justify-content-center text-center text-white">
              Divisiones Académicas
            </div>

            <table class="table table-striped tableDivisionesAcademicas">
              <thead class="thead">
              <tr>
                <th class="text-center">#</th>
                <th class="text-center">División Académica</th>
                <th class="text-center">Estado</th>
                <th class="text-center">Acciones</th>
              </tr>
              </thead>

              <tbody>
              <c:forEach items="${listaDivisiones}" var="divisionesAcademicas" varStatus="status">
                <tr>
                  <td class="text-center">
                      ${divisionesAcademicas.idDivisionAcademica}
                  </td>

                  <td >
                      <input type="hidden" name="idDivision" value="${divisionesAcademicas.idDivisionAcademica}">
                      ${divisionesAcademicas.nombreDivisionAcademica}
                  </td>

                  <td class="text-center">
                      ${divisionesAcademicas.estado}
                  </td>
                  <td class="text-center justify-content-center">
                    <form action="ServletDivisionesRUD" method="post">
                      <input type="hidden" name="idDivision" value="${divisionesAcademicas.idDivisionAcademica}">
                      <input type="hidden" name="opc" value="R">
                      <button class="btn btn-info"><i class="fas fa-edit"></i> Modificar</button>
                    </form>
                    <form action="ServletDivisionesRUD" method="post">
                      <input type="hidden" name="idDivision" value="${divisionesAcademicas.idDivisionAcademica}">
                      <input type="hidden" name="opc" value="D">
                      <button class="btn btn-danger mt-1"><i class="fas fa-trash-alt"></i> Eliminar</button>
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

    <br>
    <hr>

    <div class="container mt-4">
      <div class="row">
        <div class="col-md-6 col-sm-6">
          <button type="button" class="btn btn-info" data-toggle="modal" data-target="#contenedorModal" data-backdrop="false">Crear Carrera</button>
          <!-- Modal Agregar nueva division -->
          <div class="modal fade" tabindex="-1" role="dialog" id="contenedorModal" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">

                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModal">Crear Carrera</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>

                <div class="modal-body">
                  <form action="ServletCarrera" method="post">
                    <div class="form-group">
                      <label for="nombreCarrera">Carrera</label>
                      <input class="form-control" type="text" name="nombreCarrera" id="nombreCarrera" required>
                    </div>
                    <div class="form-group">
                      <label for="divisionCarrera">División a la que Pertenece </label>
                      <select name="divisionCarrera" class="form-control" id="divisionCarrera" required>
                        <c:forEach items="${listaDivisiones}" var="division" varStatus="status">
                        <option value="${division.idDivisionAcademica}">${division.nombreDivisionAcademica}</option>
                        </c:forEach>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="estadoCarrera">Estado </label>
                      <select name="estadoCarrera" class="form-control" id="estadoCarrera" required>
                        <option value="Activo">Activo</option>
                        <option value="Inactivo">Inactivo</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <button type="reset" class="btn btn-danger mr-3">Limpiar</button>
                      <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-md-6 col-sm-6 float-right justify-content-end">
          <form action="ServletCarrerasRUD" class="form-inline my-2 my-lg-0 justify-content-end float-right" method="post">
            <input type="hidden" name="opc" value="S">
            <input name="buscador" class="form-control mr-sm-2" type="search" placeholder="Buscar por Nombre" aria-labelledby="Buscar por Nombre o Id">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
          </form>
        </div>

        <div class="col-12">
          <div class="card mt-3 table-responsive">
            <div style="background-color: #00AB84" class="card-header justify-content-center text-white text-center">
              Carreras
            </div>

            <table class="table table-striped tableCarreras">
              <thead>
              <tr>
                <th scope="col" class="text-center">#</th>
                <th scope="col" class="text-center">Carrera</th>
                <th scope="col" class="text-center">Division Perteneciente</th>
                <th scope="col" class="text-center">Estado</th>
                <th scope="col" class="text-center">Acciones</th>
              </tr>
              </thead>

              <tbody>
              <c:forEach items="${listaCarreras}" var="carrera" varStatus="status">
                <tr>
                  <td class="text-center">${carrera.idCarrera}</td>
                  <td >${carrera.nombreCarrera}</td>
                  <td class="text-center">${carrera.idDivisionAcademica}</td>
                  <td class="text-center">${carrera.estado}</td>
                  <td class="text-center justify-content-center">

                        <form action="ServletCarrerasRUD" method="post">
                          <input type="hidden" name="idCarrera" value="${carrera.idCarrera}">
                          <input type="hidden" name="opc" value="R">
                          <button class="btn btn-info"><i class="fas fa-edit"></i> Editar</button>
                        </form>

                        <form action="ServletCarrerasRUD">
                          <input type="hidden" name="idCarrera" value="${carrera.idCarrera}">
                          <input type="hidden" name="opc" value="D">
                          <button class="btn-danger btn mt-1" ><i class="fas fa-trash-alt"> Eliminar</i></button>
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