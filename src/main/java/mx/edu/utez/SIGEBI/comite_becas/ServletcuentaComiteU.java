package mx.edu.utez.SIGEBI.comite_becas;
import mx.edu.utez.SIGEBI.modelo.BeanComite;
import mx.edu.utez.SIGEBI.modelo.BeanDivisionesAcademicas;
import mx.edu.utez.SIGEBI.modelo.DaoComite;
import mx.edu.utez.SIGEBI.modelo.DaoDivisionesAcademicas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ServletcuentaComiteU", value = "/ServletcuentaComiteU")
public class ServletcuentaComiteU extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opc= request.getParameter("opc")!= null? request.getParameter("opc"):"-";
        switch (opc){
            case "U":
                String idUsuarioString = request.getParameter("idUser")!=null? request.getParameter("idUser"):"0";
                String nombre=request.getParameter("nombre")!= null? request.getParameter("nombre"):"";
                String primerApellido = request.getParameter("primerApellido") != null ? request.getParameter("primerApellido") : "";
                String segundoApellido = request.getParameter("segundoApellido") != null ? request.getParameter("segundoApellido") : "";
                String correo = request.getParameter("correo") != null ? request.getParameter("correo") : "";
                String clave= request.getParameter("clave")!= null? request.getParameter("clave"):"";
                String estado = "activo";
                String divisionAcademica = request.getParameter("divisionAcademica")!= null ? request.getParameter("divisionAcademica"): "0";
                int idDivision = Integer.parseInt(divisionAcademica);
                try {
                    BeanComite usuariosUpdate= new BeanComite(Integer.parseInt(idUsuarioString),nombre, primerApellido, segundoApellido, correo, clave,estado, idDivision);
                    DaoComite daoUpdate= new DaoComite();
                    boolean result= daoUpdate.update(usuariosUpdate);
                    if(result){
                        request.setAttribute("mensaje", "Información actualizada correctamente");
                        HttpSession session = request.getSession(true);
                        session.setAttribute("idUsuario", usuariosUpdate.getIdUsuario());
                        session.setAttribute("nombre", usuariosUpdate.getNombre());
                        session.setAttribute("primerApellido", usuariosUpdate.getPrimerApellido());
                        session.setAttribute("segundoApellido", usuariosUpdate.getSegundoApellido());
                        session.setAttribute("correo", usuariosUpdate.getCorreo());
                        session.setAttribute("clave", usuariosUpdate.getClave());
                        session.setAttribute("estado",usuariosUpdate.getEstado());
                        session.setAttribute("divisionAcademica",usuariosUpdate.getIdDivisionAcademica());
                        DaoDivisionesAcademicas daoDivisiones = new DaoDivisionesAcademicas();
                        List<BeanDivisionesAcademicas> listaDivisiones =  daoDivisiones.listar();
                        request.setAttribute("listaDivisiones", listaDivisiones);
                    }else {
                        request.setAttribute("mensaje","Error al actualizar la información");
                    }
                    List<BeanComite> listComite= daoUpdate.findAll();
                    request.setAttribute("listaComite",listComite);
                    request.getRequestDispatcher("WEB-INF/comite_becas/cuentaComite.jsp").forward(request,response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
