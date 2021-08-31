package mx.edu.utez.SIGEBI.administrador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletGoAdministrador", value = "/ServletGoAdministrador")
public class ServletGoAdministrador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Variable que almacena la ruta
        String to = request.getParameter("to" != null ? request.getParameter("to") : "/administrador/convocatorias.jsp" );
        //este metodo redirige a otras vistas
        request.getRequestDispatcher("WEB-INF/" + to).forward(request, response);
    }
}
