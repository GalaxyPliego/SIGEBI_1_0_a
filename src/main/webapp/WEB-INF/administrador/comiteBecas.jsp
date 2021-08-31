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
    <div class="row-12 text-center p-2 cabecera">Comité de becas</div>
    <div class="container mt-4">
        <div class="row">

            <div class="col-md-2 col-sm-10">
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#contenedor-modal"
                        data-backdrop="false">Agregar miembro
                </button>
            </div>
            <!-- Buscador-->
            <div class="col-md-10 col-sm-2 float-right justify-content-end">
                <form action="ServletCuentaComiteCRUD" method="post" class="form-inline my-2 my-lg-0 justify-content-end float-right">
                    <input type="hidden" name="opc" value="S">
                    <input type="search" id="buscador"  name="buscador" class="form-control mr-sm-2"   placeholder="Buscar por nombre o numero">
                    <button type="submit" class="btn btn-outline-success my-2 my-sm-0">Buscar</button>
                </form>
            </div>
            <div class="col-md-3">
                <!-- Modal Agregar una nueva cuenta del comite -->
                <div class="modal fade" tabindex="-1" role="dialog" id="contenedor-modal"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar nuevo miembro al Comité de
                                    Becas</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body ">
                                <form action="ServletCuentaComite" method="post">
                                    <div class=" ">
                                        <div class="form-group ">
                                            <label for="nombre">Nombre(s)</label>
                                            <input class="form-control" type="text" name="nombre" id="nombre"
                                                   placeholder="Nombre">
                                        </div>
                                        <div class="form-group ">
                                            <label for="primerApellido">Primer Apellido</label>
                                            <input class="form-control" type="text" name="primerApellido"
                                                   id="primerApellido"
                                                   placeholder="Apellido">
                                        </div>
                                        <div class="form-group ">
                                            <label for="segundoApellido">Segundo Apellido</label>
                                            <input class="form-control" type="text" name="segundoApellido"
                                                   id="segundoApellido"
                                                   placeholder="Apellido">
                                        </div>
                                        <div class="form-group ">
                                            <label for="correo">Correo Elecronico</label>
                                            <input class="form-control" type="text" name="correo" id="correo"
                                                   placeholder="correo@utez.edu.mx">
                                        </div>
                                        <div class=" form-group ">
                                            <label for="estado">Estado</label>
                                            <select class="form-control" id="estado" name="estado">
                                                <option value="Activo">Activo</option>
                                                <option value="Inactivo">Inactivo</option>
                                            </select>
                                        </div>
                                        <div class=" form-group ">
                                            <label for="divisionAcademica">División Academica</label>
                                            <select class="form-control" id="divisionAcademica" name="divisionAcademica">
                                                <option>-</option>
                                                <option value="1">División Académica Económica-Administrativa</option>
                                                <option value="2"> División Académica de Mecánica Industrial</option>
                                                <option value="3">División Académica de Tecnologías de la Información y
                                                    Comunicación
                                                </option>
                                                <option value="4">División Académica de Terapia Física</option>
                                            </select>
                                        </div>
                                        <div class="form-group float-left">
                                            <button type="reset" class="btn btn-danger mr-3">Limpiar</button>
                                            <button type="submit" class="btn btn-primary">Guardar</button>
                                        </div>
                                    </div>
                                </form>
                                <button type="submit"
                                        href="${pageContext.request.contextPath}/ServletGo?to=administrador/cuentaComiteUD.jsp"></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-12">
                <div class="card mt-3 table-responsive">
                    <div style="background-color: #00AB84"
                         class="container-fluid card-header justify-content-center text-center text-white">
                        Comité de Becas
                    </div>
                    <!-- Tabla consulta de usuarios-->
                    <table class="table table-striped tableDivisionesAcademicas">
                        <thead class="thead">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Clave</th>
                            <th>Estado</th>
                            <th>Division Academica</th>
                            <th>Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaComite}" var="usuarios" varStatus="status">
                            <tr>
                                <td scope="row">${status.count}</td>
                                <td>${usuarios.nombre} ${usuarios.primerApellido} ${usuarios.segundoApellido}</td>
                                <td>${usuarios.correo}</td>
                                <td>${usuarios.clave}</td>
                                <td>${usuarios.estado}</td>
                                <td>${usuarios.idDivisionAcademica}</td>
                                <td>
                                    <form action="ServletCuentaComiteCRUD" method="post">
                                        <input type="hidden" name="idUser" value="${usuarios.idUsuario}">
                                        <input type="hidden" name="opc" value="R">
                                        <Button type="submit" class="btn btn-info"><i class="fas fa-edit"></i>
                                            Modificar
                                        </Button>
                                    </form>

                                    <form class="mt-1" action="ServletCuentaComiteCRUD" method="post">
                                        <input type="hidden" name="idUser" value="${usuarios.idUsuario}">
                                        <input type="hidden" name="opc" value="D">
                                        <Button type="submit" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Eliminar
                                        </Button>
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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
            crossorigin="anonymous"></script>

</body>
</html>