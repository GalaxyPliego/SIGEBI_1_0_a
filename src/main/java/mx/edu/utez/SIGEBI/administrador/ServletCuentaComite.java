package mx.edu.utez.SIGEBI.administrador;
import mx.edu.utez.SIGEBI.modelo.BeanComite;
import mx.edu.utez.SIGEBI.modelo.DaoComite;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCuentaComite", value = "/ServletCuentaComite")
public class ServletCuentaComite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoComite daoComite= new DaoComite();
        List<BeanComite> listComite= daoComite.findAll();
        request.setAttribute("listaComite",listComite);
        request.getRequestDispatcher("WEB-INF/administrador/comiteBecas.jsp").forward(request,response);
        System.out.println(listComite);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
        String primerApellido = request.getParameter("primerApellido") != null ? request.getParameter("primerApellido") : "";
        String segundoApellido = request.getParameter("segundoApellido") != null ? request.getParameter("segundoApellido") : "";
        String correo = request.getParameter("correo") != null ? request.getParameter("correo") : "";
        String estado = request.getParameter("estado")!= null ? request.getParameter("estado"):"";
        int rol = 3;
        String divisionAcademica = request.getParameter("divisionAcademica") != null ? request.getParameter("divisionAcademica"): "0";
        int idDivision = Integer.parseInt(divisionAcademica);
        BeanComite beanComite = new BeanComite();
        beanComite.setNombre(nombre);
        beanComite.setPrimerApellido(primerApellido);
        beanComite.setSegundoApellido(segundoApellido);
        beanComite.setCorreo(correo);
        beanComite.setEstado(estado);
        beanComite.setIdDivisionAcademica(idDivision);
        beanComite.setRol(rol);
        System.out.println(beanComite);
        DaoComite daoComite = new DaoComite();
        boolean result = daoComite.saveCuentaComite(beanComite);
        if (result) {
            request.setAttribute("mensaje", "Registro correcto");
        } else {
            request.setAttribute("mensaje", "Registro incorrecto");
        }
        doGet(request, response);
    }
}
