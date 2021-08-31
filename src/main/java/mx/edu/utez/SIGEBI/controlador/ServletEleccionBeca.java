package mx.edu.utez.SIGEBI.controlador;

import mx.edu.utez.SIGEBI.modelo.BeanAlumnos;
import mx.edu.utez.SIGEBI.modelo.DaoAlumno;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletEleccionBeca", value = "/ServletEleccionBeca")
public class ServletEleccionBeca extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Beca = request.getParameter("opc")!=null ? request.getParameter("opc") : "";
        int tipoBeca = Integer.parseInt(Beca);



        //Datos enviados para la solicitud
        /*String IdAlumno = request.getParameter("idAlumno")!=null? request.getParameter("idAlumno") : "";
        int idAlumno = Integer.parseInt(IdAlumno);*/
        HttpSession session = request.getSession(false);
        Object id_Usuario = session.getAttribute("idUsuario");
        String idUsuario1 = String.valueOf(id_Usuario);
        int idUsuario2 = Integer.parseInt(idUsuario1);
        String IdConvocatoria = request.getParameter("id_convocatoria")!=null? request.getParameter("id_convocatoria") : "";
        int idConvocatoria = Integer.parseInt(IdConvocatoria);

        DaoAlumno daoAlumno = new DaoAlumno();
        BeanAlumnos alumnoData = daoAlumno.getAlumnoData(idUsuario2);
        System.out.println(alumnoData.getMatricula());

        request.setAttribute("infoAlumno", alumnoData);
        request.setAttribute("idConvocatoria", idConvocatoria);
        System.out.println("Este es el idConvocatoria que se manda" + idConvocatoria);
        request.setAttribute("tipoBeca", tipoBeca);
        System.out.println("Tipo de beca que se manda" + tipoBeca);

        switch (tipoBeca){
            case 1:
                System.out.println(tipoBeca);
                request.getRequestDispatcher("/WEB-INF/alumno/formularioAcademica.jsp").forward(request, response);
                break;
            case 2:
                request.getRequestDispatcher("/WEB-INF/alumno/formularioMadresSolteras.jsp").forward(request, response);
                break;
            case 3:
                request.getRequestDispatcher("/WEB-INF/alumno/formularioActExtra.jsp").forward(request, response);
                break;
            case 4:
                request.getRequestDispatcher("/WEB-INF/alumno/formularioPersonalAdmin.jsp").forward(request, response);
                break;
            case 5:
                request.getRequestDispatcher("/WEB-INF/alumno/formularioComunidad_Disc.jsp").forward(request, response);
                break;
            default:
                System.out.println("Tipo de beca invalido");
                break;
        }
    }
}
