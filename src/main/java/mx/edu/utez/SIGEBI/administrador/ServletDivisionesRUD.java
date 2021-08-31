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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletDivisionesRUD", value = "/ServletDivisionesRUD")
public class ServletDivisionesRUD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al RUD por doGet");
        request.setCharacterEncoding("UTF-8");
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : " - ";
        int idDivision = 0;
        List<BeanDivisionesAcademicas> listaDivisiones = new ArrayList<>();
        List<BeanCarreras> listaCarreras = new ArrayList<>();
        DaoDivisionesAcademicas daoDivision = new DaoDivisionesAcademicas();

        switch (opc) {
            case "R":
                System.out.println("opcion R");
                try {
                    String idString = request.getParameter("idDivision") != null ? request.getParameter("idDivision") : " 0 ";
                    idDivision = Integer.parseInt(idString);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    idDivision = 0;
                }
                DaoDivisionesAcademicas daoDivisiones = new DaoDivisionesAcademicas();
                BeanDivisionesAcademicas beanDivision = daoDivisiones.encontrarporId(idDivision);
                request.setAttribute("divisionesAcademicas", beanDivision);
                request.getRequestDispatcher("/WEB-INF/administrador/editarDivisiones.jsp").forward(request, response);
                break;

            case "U" :
                System.out.println("opcion U");
                String idString = request.getParameter("idDivision") != null ? request.getParameter("idDivision") : " 0 ";
                idDivision = Integer.parseInt(idString);
                String nombreDivision = request.getParameter("nombreDivision")!= null? request.getParameter("nombreDivision"): "" ;
                String estado = request.getParameter("estadoDivision")!= null? request.getParameter("estadoDivision"): "" ;

                try{
                    BeanDivisionesAcademicas beanDivisiones = new BeanDivisionesAcademicas(idDivision, nombreDivision,  estado);
                    boolean result = daoDivision.actualizar(beanDivisiones);
                    listaDivisiones = daoDivision.listar();
                    System.out.println("Listo las Divisiones por el ServletDivisionesRUD");
                    listaCarreras = daoDivision.listarCarreras();
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
                System.out.println("opcion D");
                idDivision = 0;
                try {
                    String division = request.getParameter("idDivision") != null ? request.getParameter("idDivision") : " 0 ";
                    idDivision = Integer.parseInt(division);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    idDivision = 0;
                }
                boolean result = daoDivision.eliminar(idDivision);
                listaDivisiones = daoDivision.listar();
                System.out.println("Resigtro eliminado");
                listaCarreras = daoDivision.listarCarreras();
                request.setAttribute("listaDivisiones", listaDivisiones);
                request.setAttribute("listaCarreras", listaCarreras);
                request.getRequestDispatcher("WEB-INF/administrador/carrerasDivisiones.jsp").forward(request, response);
                break;


            case "S":

                try {
                    String buscador = request.getParameter("buscador") != null ? request.getParameter("buscador") : " - ";
                    listaDivisiones = daoDivision.listaBuscador(buscador);
                    listaCarreras = daoDivision.listarCarreras();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                request.setAttribute("listaCarreras", listaCarreras);
                request.setAttribute("listaDivisiones", listaDivisiones);
                request.getRequestDispatcher("WEB-INF/administrador/carrerasDivisiones.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("entró al Servlet Divisiones RUD por doPost");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}