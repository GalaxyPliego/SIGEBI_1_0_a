package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanAlumnos;
import mx.edu.utez.SIGEBI.modelo.DaoAlumno;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletAlumnos", value = "/ServletAlumnos")
public class ServletAlumnos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al Servlet Alumnos por doGet");
        request.setCharacterEncoding("UTF-8");
        DaoAlumno daoAlumno = new DaoAlumno();
        List<BeanAlumnos> listAlumnos = daoAlumno.listAlumnos();
        request.setAttribute("listaAlumnos", listAlumnos);
        request.getRequestDispatcher("/WEB-INF/administrador/alumnos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al Servlet Alumnos metodo doPost");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
