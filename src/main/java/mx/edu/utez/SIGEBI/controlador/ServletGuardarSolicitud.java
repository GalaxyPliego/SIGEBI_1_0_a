package mx.edu.utez.SIGEBI.controlador;

import mx.edu.utez.SIGEBI.modelo.BeanSolicitudAlumnos;
import mx.edu.utez.SIGEBI.modelo.DaoGuardarSolicitud;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@WebServlet(name = "ServletGuardarSolicitud", value = "/ServletGuardarSolicitud")
@MultipartConfig
public class ServletGuardarSolicitud extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int registroCorrecto = 0;

        //Requisitos de la Solicitud de Beca
        String Beca = request.getParameter("tipoBeca")!=null ? request.getParameter("tipoBeca") : "0";

        int tipoBeca = Integer.parseInt(Beca);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime fecha = LocalDateTime.now();
        String fechaBeca = dtf.format(fecha);


        String matricula = request.getParameter("matricula") != null ? request.getParameter("matricula") : "0";


        String IdConvocatoria = request.getParameter("idConvocatoria") != null ? request.getParameter("idConvocatoria") : "0";
        int idConvocatoria = Integer.parseInt(IdConvocatoria);


        DaoGuardarSolicitud daoGuardarSolicitud = new DaoGuardarSolicitud();
        boolean solicitudAlumno = daoGuardarSolicitud.guardarSolicitud(fechaBeca, matricula, idConvocatoria);


        if(solicitudAlumno) {

            //Requisitos Generales
            int idSolicitud = daoGuardarSolicitud.obtenerIdSolicitud(matricula, fechaBeca);
            String CuatrimestreAnterior = request.getParameter("cuatrimestreAnterior") != null ? request.getParameter("cuatrimestreAnterior") : "0";
            int cuatrimestreAnterior = Integer.parseInt(CuatrimestreAnterior);
            String CuatrimestreActual = request.getParameter("cuatrimestreActual") != null ? request.getParameter("cuatrimestreActual") : "0";
            int cuatrimestreActual = Integer.parseInt(CuatrimestreActual);
            String Promedio = request.getParameter("promedio") != null ? request.getParameter("promedio") : "0";
            float promedio = Float.parseFloat(Promedio);
            System.out.println(promedio);
            Part boleta = request.getPart("boleta") != null ? request.getPart("boleta") : null;
            String motivos = request.getParameter("motivos") != null ? request.getParameter("motivos") : "0";


            boolean requisitos_becas = daoGuardarSolicitud.guardarRequisitos(cuatrimestreAnterior, cuatrimestreActual, promedio, boleta.getInputStream(), motivos, idSolicitud, tipoBeca);
            int idRequisitos = daoGuardarSolicitud.obtenerIdRequisistos(idSolicitud);


            switch (tipoBeca) {
                case 1:
                    System.out.println("Requisitos guardados de la Beca Academica: " +requisitos_becas);
                    registroCorrecto ++;
                    break;
                case 2:

                    Part actaHijo = request.getPart("actaHijo") != null ? request.getPart("actaHijo") : null;
                    Part actaMadre = request.getPart("actaMadre") != null ? request.getPart("actaMadre") : null;
                    boolean registroMadres = daoGuardarSolicitud.guardarBecaMadres(idRequisitos, actaHijo.getInputStream(), actaMadre.getInputStream());
                    System.out.println("Registro correcto madres solteras: " + registroMadres);
                    registroCorrecto ++;
                    break;
                case 3:
                    String nombreTaller = request.getParameter("nombreTaller") !=null ? request.getParameter("nombreTaller") : "";
                    boolean registroActExtra = daoGuardarSolicitud.guardarBecaActExtra(idRequisitos, nombreTaller);
                    registroCorrecto ++;
                    System.out.println("Registro correcto actividad extra: " + registroActExtra);

                    break;
                case 4:

                    String nombreFamiliar = request.getParameter("nombreFamiliar") !=null ? request.getParameter("nombreFamiliar") : " ";
                    String parentesco = request.getParameter("parentesco") !=null ?  request.getParameter("parentesco") : " ";
                    String areaTrabajoPersonal = request.getParameter("areaTrabajoPersonal") != null? request.getParameter("areaTrabajoPersonal") : "";
                    String areaTrabajo = request.getParameter("areaTrabajo") !=null? request.getParameter("areaTrabajo") : "";
                    registroCorrecto ++;
                    boolean registroPersonalAdmin = daoGuardarSolicitud.guardarPersonalAdmin(idRequisitos, nombreFamiliar, parentesco, areaTrabajoPersonal, areaTrabajo);

                    System.out.println("Requisitos guardados beca Personal Administrativo: " +registroPersonalAdmin);

                    break;
                case 5:

                    Part constancia = request.getPart("constancia") !=null?  request.getPart("constancia") : null;
                    boolean registroBecaComunDisc = daoGuardarSolicitud.guardarComunDisc(idRequisitos, constancia.getInputStream());
                    registroCorrecto ++;
                    System.out.println("Requisitos guardados beca Comunidad Indigena o Discapacidad: " +registroBecaComunDisc);

                    break;
                default:
                    System.out.println("Tipo de beca invalido");
                    break;
            }

            request.setAttribute("opc", "H");
            request.setAttribute("matricula", matricula);

            if (registroCorrecto>=1){
                request.setAttribute("mensaje", "Tu beca ya fue solicitada");
                request.setAttribute("opc", "H");
                request.setAttribute("matricula", matricula);

                System.out.println("Entro");
                registroCorrecto=0;
            }else{
                request.setAttribute("mensaje", "Hubo un error al procesar tu beca");
                request.setAttribute("mensaje", "Recuerda que solo puedes solicitar una");
                request.setAttribute("opc", "H");
                request.setAttribute("matricula", matricula);
                System.out.println("Entro al else");
                registroCorrecto=0;
            }

        }else{
            request.setAttribute("mensaje", "Error al procesar la solicitud");
        }
    }
}
