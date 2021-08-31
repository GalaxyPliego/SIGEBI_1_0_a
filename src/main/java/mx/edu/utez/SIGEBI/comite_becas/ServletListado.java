package mx.edu.utez.SIGEBI.comite_becas;

import mx.edu.utez.SIGEBI.modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ServletListado", value = "/ServletListado")
public class ServletListado extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoGuardarSolicitud daoid_solicitud = new DaoGuardarSolicitud();
        List<BeanListado> listSolicitudes = daoid_solicitud.listadoSolicitudes();
        request.setAttribute("listadeSolicitudes", listSolicitudes);
        request.getRequestDispatcher("WEB-INF/comite_becas/listadoComite.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : "";
        DaoListado daoListado = new DaoListado();

        switch (opc) {
            case "R":
                String tipo_Beca = request.getParameter("tipoBeca") != null ? request.getParameter("tipoBeca") : "0";
                int tipoBeca = Integer.parseInt(tipo_Beca);
                List<BeanListado> solicitudAlumnos = daoListado.listadoSolictudes(tipoBeca);
                request.setAttribute("listadodeSolicitudes", solicitudAlumnos);
                request.setAttribute("tipoBeca", tipo_Beca);
                request.getRequestDispatcher("WEB-INF/comite_becas/listadoComite.jsp");
                break;

            default:
                break;
        }


        doGet(request, response);
    }
}


