package mx.edu.utez.SIGEBI.controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletIndex", value = "/ServletIndex")
public class ServletIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to = request.getParameter("to");
        request.getRequestDispatcher("WEB-INF/" + to).forward(request, response);
    }
}