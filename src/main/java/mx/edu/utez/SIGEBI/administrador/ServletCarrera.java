package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanCarreras;
import mx.edu.utez.SIGEBI.modelo.BeanDivisionesAcademicas;
import mx.edu.utez.SIGEBI.modelo.DaoCarreras;
import mx.edu.utez.SIGEBI.modelo.DaoDivisionesAcademicas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCarrera", value = "/ServletCarrera")
public class ServletCarrera extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoDivisionesAcademicas daoDivisiones = new DaoDivisionesAcademicas();
        List<BeanDivisionesAcademicas> listaDivisiones = daoDivisiones.listar();
        request.setAttribute("listaDivisiones", listaDivisiones);
        List<BeanCarreras> listaCarreras = daoDivisiones.listarCarreras();
        request.setAttribute("listaCarreras", listaCarreras);
        request.getRequestDispatcher("/WEB-INF/administrador/carrerasDivisiones.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al servlet do post");
        request.setCharacterEncoding("UTF-8");
        String nombreCarrera = request.getParameter("nombreCarrera") != null ? request.getParameter("nombreCarrera") : "";
        String divisionCarrera = request.getParameter("divisionCarrera") != null ? request.getParameter("divisionCarrera") : "";
        int idDivision = Integer.parseInt(divisionCarrera);
        String estadoCarrera = request.getParameter("estadoCarrera");

        BeanCarreras beanCarreras = new BeanCarreras();
        beanCarreras.setNombreCarrera(nombreCarrera);
        beanCarreras.setEstado(estadoCarrera);
        beanCarreras.setIdDivisionAcademica(idDivision);

        System.out.println(beanCarreras.getNombreCarrera());
        System.out.println(nombreCarrera);
        System.out.println(beanCarreras.getEstado());
        System.out.println(beanCarreras.getIdDivisionAcademica());

        DaoCarreras daoCarreras = new DaoCarreras();
        boolean result = daoCarreras.insertar(beanCarreras);

        if (result){
            request.setAttribute("mensaje", "Resgitro Correcto");
        }else{
            request.setAttribute("mensaje", "Registro Incorrecto");
        }
        doGet(request, response);
    }
}