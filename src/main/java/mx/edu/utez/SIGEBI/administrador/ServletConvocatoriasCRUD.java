package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanConvocatorias;
import mx.edu.utez.SIGEBI.modelo.DaoConvocatorias;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletConvocatoriasCRUD", value = "/ServletConvocatoriasCRUD")
public class ServletConvocatoriasCRUD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : " - ";

        switch (opc){
            case "R" :
                int idConvocatorias = 0;
                try{
                    String idString = request.getParameter("idConvocatoria") != null ? request.getParameter("idConvocatoria") : " 0 ";
                    idConvocatorias = Integer.parseInt(idString);
                }catch (Exception ex){
                    ex.printStackTrace();
                    idConvocatorias = 0;
                }
                DaoConvocatorias daoConvocatorias = new DaoConvocatorias();
                BeanConvocatorias Convocatorias = daoConvocatorias.encontrarporId(idConvocatorias);
                request.setAttribute("Convocatorias", Convocatorias);
                request.getRequestDispatcher("/WEB-INF/administrador/convocatorias.jsp").forward(request, response);
                break;

            case "U" :

                String idString = request.getParameter("idConvocatoria") != null ? request.getParameter("idConvocatoria") : " 0 ";
                String fechaInicio = request.getParameter("fechaInicio") != null ? request.getParameter("fechaInicio"): "";
                String fechaFin = request.getParameter("fechaFin") != null ? request.getParameter("fechaFin"): "";
                String estado = request.getParameter("estado")!= null ? request.getParameter("estado"): "";
                String idBeca2 = request.getParameter("idBeca")!= null ? request.getParameter("idBeca"): "0";
                String idUsuario = request.getParameter("idAdministrador")!= null ? request.getParameter("idAdministrador"): "0";

                try{
                    BeanConvocatorias actualizarConvocatoria = new BeanConvocatorias(Integer.parseInt(idString), fechaInicio, fechaFin, estado, Integer.parseInt(idBeca2), Integer.parseInt(idUsuario));
                    DaoConvocatorias daoConvocatoria = new DaoConvocatorias();
                    boolean result = daoConvocatoria.actualizar(actualizarConvocatoria);
                    if (result){
                        request.setAttribute("mensaje", "Convocatorias Actualizada");
                    }else{
                        request.setAttribute("mensaje", "Error al Actualizar");
                    }
                    List<BeanConvocatorias> listaConvocatorias = daoConvocatoria.listar();
                    request.setAttribute("Convocatorias",listaConvocatorias);
                    request.getRequestDispatcher("/WEB-INF/administrador/convocatorias.jsp").forward(request,response);
                }catch (Exception ex){
                    ex.printStackTrace();

                }

                request.setAttribute("mensaje", "Error al Actualizar");
                request.getRequestDispatcher("/WEB-INF/administrador/convocatorias.jsp").forward(request, response);

                break;
            case "D" :
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
