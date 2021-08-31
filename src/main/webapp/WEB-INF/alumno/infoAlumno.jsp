<%@ page import="mx.edu.utez.SIGEBI.modelo.BeanAlumnos" %>
<%@ page import="mx.edu.utez.SIGEBI.modelo.BeanUsuarios" %>
<%@ page import="mx.edu.utez.SIGEBI.modelo.DaoAlumno" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.login==null}">
    <c:redirect url="index.jsp"> </c:redirect>
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



    <title>SIGEBI | Cuenta Alumno</title>



    <style>
        .bg-azulutez {
            color: #fff;
            background-color: #1E2D50;
        }
        .bg-azulutez2 {
            color: #fff;
            background-color: #1AB289;
        }

        button, input[type="submit"], input[type="reset"] {
            background: none;
            color: inherit;
            border: none;
            padding: 0;
            font: inherit;
            cursor: pointer;
            outline: inherit;
        }
    </style>



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

    <div class="row-12 text-center p-2 cabecera">Información de Cuenta</div>

    <div class="container">

        <div class="row">

            <div class="col-4">

                <br>
                <div class="text-center">
                    <img class="img-thumbnail bg-light" src="https://image.flaticon.com/icons/png/512/1077/1077063.png" width="245"
                         height="100" alt="UserIcon" id="UserIcon">
                </div>



                <div class="text-center">
                    <br>
                    <font color="black" face="Comic Sans MS,arial,verdana"> <h4> <b>  ${sessionScope.nombre} ${sessionScope.primerApellido} ${sessionScope.segundoApellido}  </b></h4> </font>

                </div>

                <hr>

                <div class="text-center">
                    <img id="SigeLogo" class="img-thumbnail bg-light float"
                         src="https://github.com/GalaxyPliego/SIGEBI/blob/master/src/main/webapp/img/acronimo_sigebi_gris.png?raw=true" width="300" height="75"
                         alt="SIGEBIlogo">
                </div>
            </div>


            <div class="col-8">

                <br>








                <form action="ServletAlumnoU" method="post">
                    <input type="hidden" name="opc" value="U">
                    <input type="hidden" name="idUsuario" value="${sessionScope.idUsuario}">
                    <input type="hidden" name="id_alumno" value="${sessionScope.idUsuario}">

                    <div class="card">
                        <h5 class="card-header bg-azulutez2"><center>Información Personal</center></h5>
                        <div class="card-body">

                            <div class="row">
                                <h6><b><i><center>&nbsp;&nbsp;Puedes modificar los campos con tu información, una vez que termines pulsa el botón azul:</center></i> </b> </h6>

                                <hr>
                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="nombre"> Nombre(s) </label>
                                        <input  class="form-control"  id="nombre" name="nombre" type="text" value="${sessionScope.nombre}" >
                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="primerApellido"> Primer Apellido </label>
                                        <input  class="form-control"  id="primerApellido" name="primerApellido" type="text" value="${sessionScope.primerApellido}">
                                    </div>
                                </div>




                            </div>



                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="segundoApellido"> Segundo Apellido </label>
                                        <input  class="form-control"  id="segundoApellido" name="segundoApellido" type="text" value="${sessionScope.segundoApellido}">
                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="fechaNacimiento"> Fecha de nacimiento </label>
                                        <input   type="date" class="form-control"  id="fechaNacimiento" name="fechaNacimiento"  value="${alumno.fechaNacimiento}">
                                    </div>
                                </div>




                            </div>



                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="nacionalidad"> Nacionalidad </label>
                                        <input  class="form-control"  id="nacionalidad" name="nacionalidad" type="text" value="${alumno.nacionalidad}">
                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="curp"> CURP </label>
                                        <input  class="form-control"  id="curp" name="curp" type="text" value="${alumno.curp}" >
                                    </div>
                                </div>




                            </div>

                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="sexo"> Sexo </label>
                                        <input  class="form-control"  id="sexo" name="sexo" type="text" value="${alumno.sexo}">
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="form-group">
                                        <label for="telefono"> Telefono (Casa) </label>
                                        <input  class="form-control"  id="telefono" name="telefono" type="text" value="${alumno.telefono}">
                                    </div>

                                </div>




                            </div>




                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="celular"> Celular </label>
                                        <input  class="form-control"  id="celular" name="celular" type="text" value="${alumno.celular}">
                                    </div>
                                </div>

                                <div class="col-6">

                                </div>

                            </div>
                        </div>
                    </div>

                    <br>
                    <!-- aki empiesa el otro-->
                    <div class="card">
                        <h5 class="card-header bg-azulutez2"><center>Información Académica</center></h5>
                        <div class="card-body">







                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="matricula"> Matrícula</label>
                                        <fieldset disabled>
                                            <input  class="form-control"  id="matricula" name="matricula" type="text" value="${alumno.matricula}">
                                        </fieldset>
                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="turno"> Turno </label>
                                        <fieldset disabled>
                                            <input  class="form-control"  id="turno" name="turno" type="text" value="${alumno.turno}">
                                        </fieldset>

                                    </div>
                                </div>




                            </div>





                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="idCarrera"> Carrera </label>
                                        <fieldset disabled>
                                            <input  class="form-control"  id="idCarrera" name="idCarrera" type="text" value="${alumno.idCarrera}">
                                        </fieldset>

                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="idDivisionAcademica"> División Académica </label>
                                        <fieldset disabled>
                                            <input  class="form-control"  id="idDivisionAcademica" name="idDivisionAcademica" type="text" value="${alumno.idDivisionAcademica}">
                                        </fieldset>


                                    </div>
                                </div>




                            </div>



                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="nivelAcademico">Nivel Académico </label>
                                        <fieldset disabled>
                                            <input  class="form-control"  id="nivelAcademico" name="nivelAcademico" type="text" value="${alumno.nivelAcademico}">
                                        </fieldset>

                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="correo"> Correo Institucional </label>
                                        <fieldset disabled>
                                            <input  class="form-control"  id="correo" name="correo" type="text" value="${sessionScope.correo}">
                                        </fieldset>

                                    </div>
                                </div>

                            </div>




                            <hr>
                        </div>
                    </div>


                    <br>
                    <!-- aki empiesa el otro-->
                    <div class="card">
                        <h5 class="card-header bg-azulutez2"><center>Domicilio</center></h5>
                        <div class="card-body">







                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="calle"> Calle</label>
                                        <input  class="form-control"  id="calle" name="calle" type="text" value="${alumno.calle}">
                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="colonia"> Colonia </label>
                                        <input  class="form-control"  id="colonia" name="colonia" type="text" value="${alumno.colonia}">
                                    </div>
                                </div>




                            </div>





                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="numInterior"> Número Interior </label>
                                        <input  class="form-control"  id="numInterior" name="numInterior" type="text" value="${alumno.numInterior}">
                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="numExterior"> Número Exterior </label>
                                        <input  class="form-control"  id="numExterior" name="numExterior" type="text" value="${alumno.numExterior}">
                                    </div>
                                </div>




                            </div>



                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="codigoPostal">Código Postal </label>
                                        <input  class="form-control"  id="codigoPostal" name="codigoPostal" type="text" value="${alumno.codigoPostal}">
                                    </div>
                                </div>

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="delegacion"> Municipio </label>
                                        <input  class="form-control"  id="delegacion" name="delegacion" type="text" value="${alumno.delegacion}">
                                    </div>
                                </div>




                            </div>





                            <div class="row">

                                <div class="col-6">

                                    <div class="form-group">
                                        <label for="entidadFederativa"> Estado </label>
                                        <input  class="form-control"  id="entidadFederativa" name="entidadFederativa" type="text" value="${alumno.entidadFederativa}">
                                    </div>
                                </div>

                                <div class="col-6">


                                </div>
                            </div>

                            <div class="row">
                                <div class="col-8">
                                </div>
                                <div class="col-4">
                                    <button class="btn btn-info" type="submit"><i class="fas fa-edit"></i> Modificar Información</button>
                                    <b> ${mensaje} </b>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <br>
                <br>
            </div>
        </div>
    </div>
</section>
</div>
</div>

<!-- Optional JavaScript; choose one of the two! -->
<script src="${pageContext.request.contextPath}/js/sideBar.js"></script>



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