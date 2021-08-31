package mx.edu.utez.SIGEBI.comite_becas;
import mx.edu.utez.SIGEBI.modelo.BeanConvocatorias;
import mx.edu.utez.SIGEBI.modelo.DaoConvocatorias;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ServletConvocatoriasComite", value = "/ServletConvocatoriasComite")
public class ServletConvocatoriasComite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BeanConvocatorias> convocatoriasList = DaoConvocatorias.findConvocatorias();
        request.setAttribute("Lista_ConvocatoriasComite", convocatoriasList);
        request.getRequestDispatcher("WEB-INF/comite_becas/convocatorias.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
