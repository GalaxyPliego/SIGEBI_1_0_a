package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanCarreras;
import mx.edu.utez.SIGEBI.modelo.BeanDivisionesAcademicas;
import mx.edu.utez.SIGEBI.modelo.DaoDivisionesAcademicas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDivisionAcademica", value = "/ServletDivisionAcademica")
public class ServletDivisionAcademica extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entró al servletDivision Academica por el metodo de Get");
        DaoDivisionesAcademicas daoDivisiones = new DaoDivisionesAcademicas();
        DaoDivisionesAcademicas daoDivisionesCarreras = new DaoDivisionesAcademicas();
        List<BeanDivisionesAcademicas> listaDivisiones = daoDivisiones.listar();
        List<BeanCarreras> listaCarreras = daoDivisionesCarreras.listarCarreras();
        request.setAttribute("listaDivisiones", listaDivisiones);
        request.setAttribute("listaCarreras", listaCarreras);
        request.getRequestDispatcher("/WEB-INF/administrador/carrerasDivisiones.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al servlet do post ServletDivisionAcademica");
        request.setCharacterEncoding("UTF-8");
        String nombreDivision = request.getParameter("nombreDivisionAcademica") != null ? request.getParameter("nombreDivisionAcademica") : "";
        String estado = request.getParameter("estadoDivision") != null ? request.getParameter("estadoDivision") : "";

        BeanDivisionesAcademicas beanDivision = new BeanDivisionesAcademicas();
        beanDivision.setNombreDivisionAcademica(nombreDivision);
        beanDivision.setEstado(estado);

        System.out.println(beanDivision.getNombreDivisionAcademica());
        System.out.println(beanDivision.getEstado());

        DaoDivisionesAcademicas daoDivision = new DaoDivisionesAcademicas();
        boolean result = daoDivision.insertar(beanDivision);

        if (result){
            request.setAttribute("mensaje", "Resgitro Correcto");
        }else{
            request.setAttribute("mensaje", "Registro Incorrecto");
        }

        doGet(request, response);
    }
}
