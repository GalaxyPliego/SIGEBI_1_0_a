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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/StylesInicioSesion.css">

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
<nav class="sidebar">
    <ul class="nav-list">
        <li>
            <a href="ServletAlumnos"><i class="fas fa-backward"></i>
                <span class="links_name"> Regresar</span>
            </a>
        </li>
    </ul>
</nav>

<section>

    <div class="row-12 text-center p-2 cabecera">Información Alumno</div>

    <div class="container mt-5">
        <div class="row">
            <div class="col-12">
                <div class="col-12 cabecerasRegistro">
                    <h3>Información Personal</h3>
                </div>
                <div class="form row justify-content.center p-4">
                    <div class="col-md-4 col-sm-12 form-group">
                        <fieldset disabled>
                            <label for="nombres">Nombre(s)</label>
                            <input class="form-control disabled" aria-disabled="true" type="text" name="nombres" id="nombres" placeholder="${alumno.nombre}" required>
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12  form-group ">
                        <fieldset disabled>
                            <label for="primerApellido">Primer Apellido</label>
                            <input class="form-control" type="text" name="primerApellido" id="primerApellido" placeholder="${alumno.primerApellido}" required>
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12  form-group ">
                        <fieldset disabled>
                            <label for="segundoApellido">Segundo Apellido</label>
                            <input class="form-control" type="text" name="segundoApellido" id="segundoApellido" placeholder="${alumno.segundoApellido}" required>
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12  form-group ">
                        <fieldset disabled>
                            <label for="fechaNacimiento">Fecha de Nacimiento</label>
                            <input required class="form-control" type="text" name="fechaNacimiento" id="fechaNacimiento" placeholder="${alumno.fechaNacimiento}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12  form-group ">
                        <fieldset disabled>
                            <label for="nacionalidad">Nacionalidad</label>
                            <input required class="form-control" type="text" name="nacionalidad" id="nacionalidad" placeholder="${alumno.nacionalidad}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12  form-group ">
                        <fieldset disabled>
                            <label for="curp">CURP</label>
                            <input required class="form-control" type="text" name="curp" id="curp" placeholder="${alumno.curp}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12  form-group ">
                        <fieldset disabled>
                            <label for="celular">Celular</label>
                            <input required class="form-control" type="text" name="celular" id="celular" placeholder="${alumno.celular}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12  form-group ">
                        <fieldset disabled>
                            <label for="telefono">Teléfono</label>
                            <input class="form-control" type="text" name="telefono" id="telefono" placeholder="${alumno.telefono}">
                        </fieldset>
                    </div>

                    <div  class="col-md-4 col-sm-12  form-group">
                        <fieldset disabled>
                            <label for="sexo">Sexo</label>
                            <input class="form-control" type="text" name="sexo" id="sexo" placeholder="${alumno.sexo}">
                        </fieldset>
                    </div>
                </div>

                <br>

                <div class="col-12 cabecerasRegistro">
                    <h3>Domicilio</h3>
                </div>
                <div class="form-row justify-content-center p-4">


                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="entidadFederativa">Entidad Federativa</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="entidadFederativa" id="entidadFederativa" placeholder="${alumno.entidadFederativa}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="delegacion">Delegación/Municipio</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="delegacion" id="delegacion" placeholder="${alumno.delegacion}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="codigoPostal">Código Postal</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="codigoPostal" id="codigoPostal" placeholder="${alumno.codigoPostal}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="colonia">Colonia/Asentamiento</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="colonia" id="colonia" placeholder="${alumno.colonia}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="calle">Calle</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="calle" id="calle" placeholder="${alumno.calle}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="numExterior">Número Exterior</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="numExterior" id="numExterior" placeholder="${alumno.numExterior}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="numInterior">Número Interior</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="numInterior" id="numInterior" placeholder="${alumno.calle}">
                        </fieldset>
                    </div>
                </div>

                <br>

                <div class="col-12 cabecerasRegistro">
                    <h3>Información Académica</h3>
                </div>
                <div class="form-row justify-content-center p-4">

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="matricula">Matrícula</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="matricula" id="matricula" placeholder="${alumno.matricula}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="turno">Turno</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="turno" id="turno" placeholder="${alumno.turno}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="idDivisionAcademica">Divisió Académica</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="idDivisionAcademica" id="idDivisionAcademica" placeholder="${alumno.idDivisionAcademica}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="idCarrera">Carrera</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="idCarrera" id="idCarrera" placeholder="${alumno.idCarrera}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="nivelAcademico">Nivel Académico</label>
                        <fieldset disabled>
                            <input required class="form-control" type="text" name="nivelAcademico" id="nivelAcademico" placeholder="${alumno.nivelAcademico}">
                        </fieldset>
                    </div>

                    <div class="col-md-4 col-sm-12 form-group ">
                        <label for="correo">Correo Institucional</label>
                        <fieldset disabled>
                            <input required class="form-control" type="email" name="correo" id="correo" placeholder="${alumno.correo}">
                        </fieldset>
                    </div>



                        <div class="col-md-4 col-sm-12 form-group">
                            <form action="ServletAlumnosRU" method="post">
                                <input type="hidden" name="opc" value="U">
                                <input type="hidden" name="idAlumno" value="${alumno.idAlumno}">
                            <label for="estado">Estado </label>
                            <select name="estado" class="form-control" id="estado" required>
                                <option selected value="${alumno.estado}">${alumno.estado}</option>
                                <option value="Activo">Activo</option>
                                <option value="Inactivo">Inactivo</option>
                            </select>
                                <div class="form-group jusify-content-center float-center mt-3">
                                    <button type="submit" class="btn btn-success btn-block">Modificar</button>
                                </div>
                            </form>
                        </div>


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