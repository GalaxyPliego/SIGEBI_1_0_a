package mx.edu.utez.SIGEBI.controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletGo", value = "/ServletGo")
public class ServletGo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Variable que almacena la ruta

        String to;
        HttpSession session = request.getSession(false);
        Object rol = session.getAttribute("rol");
        String userId = rol.toString();
        System.out.println(userId);

        switch (userId){

            case "1":
                to = request.getParameter("to") != null ? request.getParameter("to") : "ServletConvocatoriasAlumnos";
                //este metodo redirige a otras vistas
                request.getRequestDispatcher("WEB-INF/" + to).forward(request, response);

                break;

            case "2":
                to = request.getParameter("to") != null ? request.getParameter("to") : "ServletDivisionAcademica";
                //este metodo redirige a otras vistas
                request.getRequestDispatcher(to).forward(request, response);

                break;

            case "3":
                to = request.getParameter("to") != null ? request.getParameter("to") : "ServletComite";
                //este metodo redirige a otras vistas
                request.getRequestDispatcher("WEB-INF/" + to).forward(request, response);

                break;
        }
    }
}
