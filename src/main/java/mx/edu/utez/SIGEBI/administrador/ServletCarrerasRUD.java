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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletCarrerasRUD", value = "/ServletCarrerasRUD")
public class ServletCarrerasRUD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro a Servlet Carreras por doGet");
        request.setCharacterEncoding("UTF-8");
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : " - ";
        int idCarrera;
        DaoCarreras daoCarreras;
        BeanCarreras beanCarreras;
        BeanDivisionesAcademicas beanDivisiones;
        daoCarreras = new DaoCarreras();
        List<BeanDivisionesAcademicas> listaDivisiones = new ArrayList<>();
        List<BeanCarreras> listaCarreras;
        DaoDivisionesAcademicas daoDivision = new DaoDivisionesAcademicas();

        switch (opc){

            case "R":
                System.out.println("opcion R");
                try {
                    String idString = request.getParameter("idCarrera") != null ? request.getParameter("idCarrera") : " 0 ";
                    idCarrera = Integer.parseInt(idString);
                    daoCarreras = new DaoCarreras();
                    DaoDivisionesAcademicas daoDivisiones = new DaoDivisionesAcademicas();
                    beanCarreras = daoCarreras.encontrarporId(idCarrera);
                    listaDivisiones = daoDivisiones.listar();
                    request.setAttribute("listaDivisiones", listaDivisiones);
                    request.setAttribute("carrera", beanCarreras);
                    request.getRequestDispatcher("/WEB-INF/administrador/editarCarreras.jsp").forward(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    idCarrera = 0;
                }
                break;

            case "U" :
                String idString = request.getParameter("idCarrera") != null ? request.getParameter("idCarrera") : " 0 ";
                idCarrera = Integer.parseInt(idString);
                System.out.println("U: idCarrera = " + idCarrera);
                String nombreCarrera = request.getParameter("nombreCarrera")!= null? request.getParameter("nombreCarrera"): "" ;
                System.out.println("U: nombreCarrera = " + nombreCarrera);
                String estado = request.getParameter("estadoCarrera")!= null? request.getParameter("estadoCarrera"): "" ;
                System.out.println("U: estadoCarrera = " + estado);
                String divisionCarrera = request.getParameter("divisionCarrera");
                int idDivision = Integer.parseInt(divisionCarrera);
                System.out.println("U: idCarrera = " + idDivision);
                try{
                    beanCarreras = new BeanCarreras(idCarrera, nombreCarrera, estado, idDivision);

                    DaoDivisionesAcademicas daoDivisiones = new DaoDivisionesAcademicas();
                    boolean result = daoCarreras.actualizar(beanCarreras);
                    listaDivisiones = daoDivisiones.listar();
                    System.out.println("Listo las Divisiones por el ServletDivisionesRUD");
                    listaCarreras = daoDivisiones.listarCarreras();
                    System.out.println("Listo las carreras por el ServletDivisionesRUD");
                    if (result){
                        request.setAttribute("mensaje", "Division Actualizada");
                    }else{
                        request.setAttribute("mensaje", "Error al Actualizar");
                    }
                    request.setAttribute("listaDivisiones", listaDivisiones);
                    request.setAttribute("listaCarreras", listaCarreras);
                    request.getRequestDispatcher("/WEB-INF/administrador/carrerasDivisiones.jsp").forward(request, response);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;


            case "D":
                System.out.println("Entro a D");
                try {
                    String carrera = request.getParameter("idCarrera") != null ? request.getParameter("idCarrera") : " 0 ";
                    idCarrera = Integer.parseInt(carrera);
                    System.out.println(idCarrera);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    idCarrera = 0;
                }
                daoCarreras = new DaoCarreras();

                boolean result = daoCarreras.eliminar(idCarrera);
                System.out.println(result);
                listaDivisiones = daoDivision.listar();
                System.out.println("Resigtro eliminado");
                listaCarreras = daoDivision.listarCarreras();
                request.setAttribute("listaCarreras", listaCarreras);
                request.setAttribute("listaDivisiones", listaDivisiones);
                request.getRequestDispatcher("WEB-INF/administrador/carrerasDivisiones.jsp").forward(request, response);
                break;

            case "S":

                try {
                    String buscador = request.getParameter("buscador") != null ? request.getParameter("buscador") : " - ";
                    listaCarreras = daoCarreras.listaBuscador(buscador);
                    listaDivisiones = daoDivision.listar();
                    request.setAttribute("listaCarreras", listaCarreras);
                    request.setAttribute("listaDivisiones", listaDivisiones);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("WEB-INF/administrador/carrerasDivisiones.jsp").forward(request, response);
                break;


            default:
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
