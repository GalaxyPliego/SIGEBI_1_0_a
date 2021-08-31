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


  <title>SIGEBI | Historial de Becas</title>


  <style>
    .bg-azulutez {
      color: #fff;
      background-color: #1E2D50;
    }
    .bg-azulutez2 {
      color: #fff;
      background-color: #1AB289;
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

  <div class="row-12 text-center p-2 cabecera">Historial de Becas</div>

  <div class="container">

    <div class="row">
      <div class="col-4">

        <br>
        <div class="text-center">
          <img class="img-thumbnail bg-light" src="https://image.flaticon.com/icons/png/512/1077/1077063.png" width="245"
               height="100" alt="UserIcon" id="UserIcon">
        </div>

        <hr>

        <div class="text-center">
          <h4> ${sessionScope.nombre} ${sessionScope.primerApellido} ${sessionScope.segundoApellido} </h4>
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
        <div class="card">
          <h5 class="card-header bg-azulutez2"><center>Beca Actual</center></h5>
          <div class="card-body">
            <h5 class="card-title text-dark">${Beca.nombreBeca} </h5>
            <div>
              <ul class="list-unstyled" >
                <li>
                  <b>Fecha de solicitud: </b> ${Beca.fecha_solicitud}
                </li>




                <li>
                  <b>Porcentaje: </b> <a class="text-info">${Beca.porcentaje} %</a>
                </li>
                <li>
                  <b>Estado: </b>${Beca.estado}
                </li>

                <div class="text-center">
                  <li class="float-right text-info">
                    <b>Veredicto: </b> <h4><b>(${Beca.veredicto})</b></h4>
                  </li>
                </div>

              </ul>
            </div>


          </div>
        </div>


        <br>
        <br>





        <h5 ><center>Historial de Becas</center></h5>

        <c:forEach items="${becaPasada}" var="primeraBeca" varStatus="status" >


          <div class="row   bg-azulutez" >
            <div class="col-12">
            </div>
          </div>


          <div class="card">
            <div class="card-body">
                ${status.count}
              <h5 class="card-title text-dark">${primeraBeca.nombreBeca} </h5>
              <ul class="list-unstyled" >
                <li>
                  <b>Fecha de solicitud: </b> ${primeraBeca.fecha_solicitud}
                </li>

                <li>
                  <b>Porcentaje: </b> <a class="text-info">${primeraBeca.porcentaje} %</a>
                </li>
                <li>
                  <b>Estado: </b>${primeraBeca.estado}
                </li>

                <div class="text-center">
                  <li class="float-right text-info">
                    <b>Veredicto: </b> <h4><b>(${primeraBeca.veredicto})</b></h4>
                  </li>
                </div>

              </ul>

            </div>
          </div>


          <br>
          <hr>


        </c:forEach>



































      </div>







    </div>























  </div>

</section>
