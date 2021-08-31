package mx.edu.utez.SIGEBI.comite_becas;

import mx.edu.utez.SIGEBI.modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletMostrarFormulario", value = "/ServletMostrarFormulario")
public class ServletMostrarFormulario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo_beca = request.getParameter("tipoBeca") != null? request.getParameter("tipoBeca") : "-";
        int tipoBeca = Integer.parseInt(tipo_beca);
        String id_solicitud = request.getParameter("id_solicitud1") != null? request.getParameter("id_solicitud1") : "-";
        int idSolicitud = Integer.parseInt(id_solicitud);
        DaoHistorial daoHistorial = new DaoHistorial();
        BeanRequisitos beanRequisitos = new BeanRequisitos();

        beanRequisitos = daoHistorial.findRequisitos(idSolicitud);
        request.setAttribute("id_solicitud", idSolicitud);
        switch(tipoBeca){
            case 1:
                request.setAttribute("requisitos", beanRequisitos);
                request.getRequestDispatcher("WEB-INF/alumno/ConsultarAcademica.jsp").forward(request, response);
                break;
            case 2:
                request.setAttribute("requisitos",beanRequisitos);
                request.getRequestDispatcher("WEB-INF/alumno/ConsultarMadresSolteras.jsp").forward(request,response);
                break;
            case 3:
                request.setAttribute("requisitos",beanRequisitos);
                BeanExtracurricular beanExtracurricular = daoHistorial.requisitosExtra(beanRequisitos.getIdRequisitos());
                request.setAttribute("extra", beanExtracurricular);
                System.out.println(beanExtracurricular.getTaller_proyecto());
                request.getRequestDispatcher("WEB-INF/alumno/ConsultarActExtra.jsp").forward(request,response);
                break;

            case 4:
                request.setAttribute("requisitos",beanRequisitos);
                BeanPersonalAdmin beanPersonalAdmin = daoHistorial.findRequisitosPersonal(beanRequisitos.getIdRequisitos());
                request.setAttribute("personalAdmin", beanPersonalAdmin);
                request.getRequestDispatcher("WEB-INF/alumno/ConsultarPersonalAdmin.jsp").forward(request,response);
                break;
            case 5:
                request.setAttribute("requisitos",beanRequisitos);
                request.setAttribute("id_requisito", beanRequisitos.getIdRequisitos());
                request.getRequestDispatcher("WEB-INF/alumno/ConsultarComunidad_Disc.jsp").forward(request,response);
                break;
            default:

        }

    }
}
