package mx.edu.utez.SIGEBI.administrador;
import mx.edu.utez.SIGEBI.modelo.BeanComite;
import mx.edu.utez.SIGEBI.modelo.BeanDivisionesAcademicas;
import mx.edu.utez.SIGEBI.modelo.DaoComite;
import mx.edu.utez.SIGEBI.modelo.DaoDivisionesAcademicas;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletCuentaComiteCRUD", value = "/ServletCuentaComiteCRUD")
public class ServletCuentaComiteCRUD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : "-";
        switch (opc) {
            case "R":
                System.out.println("Entre a la opción R");
                int idUser = 0;
                try {
                    String idUsuarioString = request.getParameter("idUser") != null ? request.getParameter("idUser") : "0";
                    idUser = Integer.parseInt(idUsuarioString);
                    DaoDivisionesAcademicas daoDivisionesAcademicas = new DaoDivisionesAcademicas();
                    List<BeanDivisionesAcademicas> listaDivisiones = new ArrayList<>();
                    listaDivisiones=daoDivisionesAcademicas.listar();
                    request.setAttribute("listaDivisiones",listaDivisiones);
                } catch (Exception ex) {
                    idUser = 0;
                }
                DaoComite daoRead = new DaoComite();
                BeanComite beanComite = daoRead.findById(idUser);
                request.setAttribute("usuarios", beanComite);
                request.getRequestDispatcher("WEB-INF/administrador/cuentaComiteUD.jsp").forward(request, response);
                break;
            case "U":
                String idUsuarioString = request.getParameter("idUser") != null ? request.getParameter("idUser") : "0";
                String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String primerApellido = request.getParameter("primerApellido") != null ? request.getParameter("primerApellido") : "";
                String segundoApellido = request.getParameter("segundoApellido") != null ? request.getParameter("segundoApellido") : "";
                String correo = request.getParameter("correo") != null ? request.getParameter("correo") : "";
                String clave = request.getParameter("clave") != null ? request.getParameter("clave") : " ";
                String estado = request.getParameter("estado") != null ? request.getParameter("estado") : "";
                String divisionAcademica = request.getParameter("divisionAcademica") != null ? request.getParameter("divisionAcademica") : "0";
                int idDivision = Integer.parseInt(divisionAcademica);
                try {
                    BeanComite usuariosUpdate = new BeanComite(Integer.parseInt(idUsuarioString), nombre, primerApellido, segundoApellido, correo, clave, estado, idDivision);
                    DaoComite daoUpdate = new DaoComite();
                    boolean result = daoUpdate.update(usuariosUpdate);
                    if (result) {
                        request.setAttribute("mensaje", "Actualizado");
                    } else {
                        request.setAttribute("mensaje", "Error al actualizar la información");
                    }
                    List<BeanComite> listComite = daoUpdate.findAll();
                    request.setAttribute("listaComite", listComite);
                    request.getRequestDispatcher("WEB-INF/administrador/comiteBecas.jsp").forward(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            case "D": {
                String idUsuarioStringD = request.getParameter("idUser") != null ? request.getParameter("idUser") : "0";
                try {
                    BeanComite usuariosDelete = new BeanComite(Integer.parseInt(idUsuarioStringD), "", "", "", "", "", "", 0);
                    DaoComite daoDelete = new DaoComite();
                    boolean result = daoDelete.delete(usuariosDelete);
                    if (result) {
                        request.setAttribute("mensaje", "Información actualizada correctamente");
                    } else {
                        request.setAttribute("mensaje", "Error al actualizar la información");
                    }
                    List<BeanComite> listComite = daoDelete.findAll();
                    request.setAttribute("listaComite", listComite);
                    request.getRequestDispatcher("WEB-INF/administrador/comiteBecas.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "S": {
                DaoComite daoComite = new DaoComite();
                try {
                    String buscador = request.getParameter("buscador");
                    List<BeanComite> listSearch = daoComite.buscadorList(buscador);
                    request.setAttribute("listaComite", listSearch);
                    System.out.println("Entro al Servlet");
                    System.out.println(listSearch);
                    System.out.println(buscador);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("WEB-INF/administrador/comiteBecas.jsp").forward(request, response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
