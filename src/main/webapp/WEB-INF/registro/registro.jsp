<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/StylesInicioSesion.css">

    <!-- favicoin link -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicoin.png" type="image/x-icon">

    <title>SIGEBI | Registro</title>
</head>


<body>
<nav class="navbar navbar-expand-lg navegador">
    <div class="navbar-header">
        <a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/img/acronimo_sigebi_blanco.png" alt="" class="acronimoNav"></a>
    </div>
</nav>


<div class="container contenidoRegistro">

    <div class="row border">

        <form action="${pageContext.request.contextPath}/ServletRegistro" method="POST" id="formRegistro">

            <div class="col-12 cabecerasRegistro">
                <h3>Información Personal</h3>
            </div>


            <div class="form-row justify-content-center p-4">
                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="nombres">Nombre(s)</label>
                    <input class="form-control" type="text" name="nombres" id="nombres" placeholder="Nombre(s)" required>
                </div>

                <div class="col-md-4 col-sm-12  form-group ">
                    <label for="primerApellido">Primer Apellido</label>
                    <input class="form-control" type="text" name="primerApellido" id="primerApellido" placeholder="Apellido Paterno" required>
                </div>

                <div class="col-md-4 col-sm-12  form-group ">
                    <label for="segundoApellido">Segundo Apellido</label>
                    <input class="form-control" type="text" name="segundoApellido" id="segundoApellido" placeholder="Apellido Materno" required>
                </div>

                <div class="col-md-4 col-sm-12  form-group ">
                    <label for="fechaNacimiento">Fecha de Nacimiento</label>
                    <input required class="form-control" type="date" name="fechaNacimiento" id="fechaNacimiento" placeholder="">
                </div>

                <div class="col-md-4 col-sm-12  form-group ">
                    <label for="nacionalidad">Nacionalidad</label>
                    <input required class="form-control" type="text" name="nacionalidad" id="nacionalidad" placeholder="Nacionalidad">
                </div>

                <div class="col-md-4 col-sm-12  form-group ">
                    <label for="curp">CURP</label>
                    <input required class="form-control" type="text" name="curp" id="curp" placeholder="CURP">
                </div>

                <div class="col-md-4 col-sm-12  form-group ">
                    <label for="celular">Celular</label>
                    <input required class="form-control" type="number" name="celular" id="celular" placeholder="Celular">
                </div>

                <div class="col-md-4 col-sm-12  form-group ">
                    <label for="telefono">Teléfono</label>
                    <input class="form-control" type="number" name="telefono" id="telefono" placeholder="Teléfono (opcional)">
                </div>

                <div  class="col-md-4 col-sm-12  form-group">
                    <label for="sexo">Sexo</label>
                    <select required class="form-control" name="sexo" id="sexo">
                        <option value="Hombre">Hombre</option>
                        <option value="Mujer">Mujer</option>
                    </select>
                </div>
            </div>
            <br>

            <div class="col-12 cabecerasRegistro">
                <h3>Domicilio</h3>
            </div>

            <div class="form-row justify-content-center p-4">
                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="estado">Estado</label>
                    <input required class="form-control" type="text" name="estado" id="estado" placeholder="Estado">
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="delegacion">Delegación/Municipio</label>
                    <input required class="form-control" type="text" name="delegacion" id="delegacion" placeholder="Delegación/Municipio">
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="codigoPostal">Código Postal</label>
                    <input required class="form-control" type="text" name="codigoPostal" id="codigoPostal" placeholder="Código Postal">
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="colonia">Colonia/Asentamiento</label>
                    <input required class="form-control" type="text" name="colonia" id="colonia" placeholder="Colonia/Asentamiento">
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="calle">Calle</label>
                    <input required class="form-control" type="text" name="calle" id="calle" placeholder="Calle">
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="numeroExt">Número Exterior</label>
                    <input required class="form-control" type="text" name="numeroExt" id="numeroExt" placeholder="Número Exterior">
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="numeroInt">Número Interior</label>
                    <input class="form-control" type="text" name="numeroInt" id="numeroInt" placeholder="Número Interior (opcional)">
                </div>
            </div>


            <div class="col-12 cabecerasRegistro p">
                <h3>Información Académica</h3>
            </div>

            <div class="form-row justify-content-center p-4">
                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="matricula">Matrícula</label>
                    <input required class="form-control" type="text" name="matricula" id="matricula" placeholder="Matrícula">
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="turno">Turno</label>
                    <select required name="turno" class="form-control" id="turno">
                        <option value="matutino">Matutino</option>
                        <option value="vespertino">Vespertino</option>
                    </select>
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="divisionAcademica">Divisió Académica</label>
                    <select required name="divisionAcademica" id="divisionAcademica" class="form-control">
                        <option value="0">Seleccione...</option>
                        <c:forEach items="${listaDivisiones}" var="divisionesAcademicas" varStatus="estatus">
                            <option value="${divisionesAcademicas.idDivisionAcademica}">${divisionesAcademicas.nombreDivisionAcademica}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="carrera">Carrera</label>
                    <select required name="carrera" id="carrera" class="form-control">
                        <option value="0">Seleccione...</option>
                        <c:forEach items="${listaCarreras}" var="carrera" varStatus="estatus">
                            <option value="${carrera.idCarrera}">${carrera.nombreCarrera}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="nivelAcademico">Nivel Académico</label>
                    <select required name="nivelAcademico" class="form-control" id="nivelAcademico">
                        <option value="Tecnico Superior Universitario">Tecnico Superior Universitario </option>
                        <option value="Ingeniería">Ingeniería</option>
                        <option value="Licenciatura">Licenciatura</option>
                    </select>
                </div>

                <div class="col-md-4 col-sm-12 form-group ">
                    <label for="correo">Correo Institucional</label>
                    <input required class="form-control" type="email" name="correo" id="correo" placeholder="Correo Institucional">

                </div>

                <input class="btn btn-danger m-5" type="reset" value="Limpiar">
                <input class="btn btn-success m-5" type="submit" data-toggle="modal" data-target="#modal" value="Registrarse">

            </div>
        </form>
    </div>
</div>




<!-- Optional JavaScript; choose one of the two! -->

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