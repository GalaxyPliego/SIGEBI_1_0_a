package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanConvocatorias;
import mx.edu.utez.SIGEBI.modelo.DaoConvocatorias;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletConvocatoriasRUD", value = "/ServletConvocatoriasRUD")
public class ServletConvocatoriasRUD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al RUD por doGet");
        request.setCharacterEncoding("UTF-8");
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : " - ";
        int idConvocatorias = 0;

        switch (opc) {
            case "R":
                System.out.println("opcion R");
                try {
                    String idString = request.getParameter("idConvocatorias") != null ? request.getParameter("idConvocatorias") : " 0 ";
                    idConvocatorias = Integer.parseInt(idString);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    idConvocatorias = 0;
                }
                DaoConvocatorias daoConvocatorias = new DaoConvocatorias();
                BeanConvocatorias beanConvocatoria = daoConvocatorias.encontrarporId(idConvocatorias);
                request.setAttribute("Convocatorias", beanConvocatoria);
                request.getRequestDispatcher("/WEB-INF/administrador/editarConvocatorias.jsp").forward(request, response);
                break;

            case "U" :
                System.out.println("opcion U");
                String idString = request.getParameter("idConvocatoria") != null ? request.getParameter("idConvocatoria") : "0";
                idConvocatorias = Integer.parseInt(idString);
                System.out.println("D: idConvocatoria = " + idConvocatorias);
                String fechaInicio = request.getParameter("fechaInicio")!= null? request.getParameter("fechaInicio"): "" ;
                System.out.println("D: fechaInicio = " + fechaInicio);
                String fechaFin = request.getParameter("fechaFin")!= null? request.getParameter("fechaFin"): "" ;
                System.out.println("D: fechaFin = " + fechaFin);
                String estado = request.getParameter("estado")!= null? request.getParameter("estado"):  "";
                System.out.println("D: estado = " + estado);
                String beca = request.getParameter("beca") != null ? request.getParameter("beca") : "0";
                int idBeca2 = Integer.parseInt(beca);
                System.out.println("D: idBeca2 = " + idBeca2);
                String admin = request.getParameter("admin") != null ? request.getParameter("admin") : "0";
                int idUsuario = Integer.parseInt(admin);
                System.out.println("D: idUsuario = " + idUsuario);
                try{
                    BeanConvocatorias beanConvocatorias = new BeanConvocatorias(idConvocatorias, fechaInicio,  fechaFin, estado, idBeca2, idUsuario);
                    DaoConvocatorias daoConvocatoria = new DaoConvocatorias();
                    boolean result = daoConvocatoria.actualizar(beanConvocatorias);
                    List<BeanConvocatorias> listaConvocatorias = daoConvocatoria.listar();
                    System.out.println("Listo las Convocatorias por el ServletConvocatoriasRUD");
                    if (result){
                        request.setAttribute("mensaje", "Convocatoria Actualizada");
                    }else{
                        request.setAttribute("mensaje", "Error al Actualizar");
                    }
                    request.setAttribute("listaConvocatorias", listaConvocatorias);
                    request.getRequestDispatcher("/WEB-INF/administrador/convocatorias.jsp").forward(request, response);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;

            case "D":
                System.out.println("opcion D");
                try {
                    String division = request.getParameter("idConvocatorias") != null ? request.getParameter("idConvocatorias") : " 0 ";
                    idConvocatorias = Integer.parseInt(division);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    idConvocatorias = 0;
                }
                DaoConvocatorias daoConvocatoria = new DaoConvocatorias();
                boolean result = daoConvocatoria.eliminar(idConvocatorias);
                List<BeanConvocatorias> listaConvocatorias = daoConvocatoria.listar();
                System.out.println("Resigtro eliminado");
                request.setAttribute("listaConvocatorias", listaConvocatorias);
                request.getRequestDispatcher("WEB-INF/administrador/convocatorias.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("entró al Servlet Convocatorias RUD por doPost");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}