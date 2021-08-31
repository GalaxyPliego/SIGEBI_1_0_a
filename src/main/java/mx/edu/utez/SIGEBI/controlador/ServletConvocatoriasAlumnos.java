package mx.edu.utez.SIGEBI.controlador;

import mx.edu.utez.SIGEBI.modelo.BeanConvocatorias;
import mx.edu.utez.SIGEBI.modelo.DaoConvocatorias;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletConvocatoriasAlumnos", value = "/ServletConvocatoriasAlumnos")
public class ServletConvocatoriasAlumnos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BeanConvocatorias> convocatoriasList = DaoConvocatorias.findConvocatorias();
        request.setAttribute("Lista_Convocatorias", convocatoriasList);
        request.getRequestDispatcher("WEB-INF/alumno/convocatoriasAlumno.jsp").forward(request, response);
    }
}
