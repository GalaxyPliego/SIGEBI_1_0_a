package mx.edu.utez.SIGEBI.comite_becas;

import mx.edu.utez.SIGEBI.modelo.BeanListado;
import mx.edu.utez.SIGEBI.modelo.DaoGuardarSolicitud;
import mx.edu.utez.SIGEBI.modelo.DaoHistorial;
import mx.edu.utez.SIGEBI.modelo.DaoListado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletEnviarinfo", value = "/ServletEnviarinfo")
public class ServletEnviarinfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int convocatoria=0;
        try{
            String tipo_Beca = request.getParameter("tipoBeca") != null ? request.getParameter("tipoBeca") : "0";
            convocatoria = Integer.parseInt(tipo_Beca);

        }
        catch (Exception ex) {
            convocatoria=0;
        }

                /*DaoHistorial dahistorial= new DaoHistorial();
                List <BeanListado> historial_solicitudes = dahistorial.findByConvocatorias(convocatoria);
                request.setAttribute("listaSolicitudes",historial_solicitudes);*/

        //Tipos Becas
        DaoListado daotiposBecas= new DaoListado();

        //Consulta especifica para becaAcademica
        List<BeanListado> listaSolicitudesAcademica = daotiposBecas.findByBecaAcademica(convocatoria);
        request.setAttribute("listaSolicitudesAcademica", listaSolicitudesAcademica);
        System.out.println(listaSolicitudesAcademica);

        //Consulta especifica para BecaMadres
        List<BeanListado> listaSolicitudesMadres = daotiposBecas.findBecaMadres(convocatoria);
        request.setAttribute("listaSolicitudesMadres", listaSolicitudesMadres);

        //Consulta especifica para BecaAdmin
        List<BeanListado> listaSolicitudesAdmin = daotiposBecas.findByBecasAdmin(convocatoria);
        request.setAttribute("listaSolicitudesAdmin", listaSolicitudesAdmin);

        //COnsulta especifica para BecaDiscapacidades
        List<BeanListado> listaSolicitudesDiscapacidades = daotiposBecas.findByBecasDiscapacidad(convocatoria);
        request.setAttribute("listaSolicitudesDiscapacidades", listaSolicitudesDiscapacidades);

        //Consulta especifica para BecaActividades
        List<BeanListado> listaSolicitudesActividades = daotiposBecas.findByBecasextra(convocatoria);
        request.setAttribute("listaSolicitudesActividades", listaSolicitudesActividades);

        request.getRequestDispatcher("WEB-INF/comite_becas/historialComite.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoListado daoListado = new DaoListado();
        String comentario = request.getParameter("comentario") != null ? request.getParameter("comentario") : "0";
        String veredicto = request.getParameter("veredicto") != null ? request.getParameter("veredicto") : "0";
        String porcentaje = request.getParameter("porcentaje") != null ? request.getParameter("porcentaje") : "0";
        String id_solicitud = request.getParameter("id_solicitud")!= null ? request.getParameter("id_solicitud"):"0";
        int solicitud = Integer.parseInt(id_solicitud);
        int porciento = Integer.parseInt(porcentaje);
        BeanListado listado = new BeanListado();
        listado.setComentario(comentario);
        listado.setVerdicto(veredicto);
        listado.setPorcentaje(porciento);
        listado.setId_solicitud(solicitud);
        listado.setEstado("");
        System.out.println("Entra al ServletEnviarinfo"+listado);
        boolean result = daoListado.saveResultadosListas(listado);
        System.out.println(result);
        if (result) {

            request.setAttribute("mensaje", "Registro correcto");
        } else {
            request.setAttribute("mensaje", "Registro incorrecto");
        }
        doGet(request, response);
    }

}
