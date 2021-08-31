package mx.edu.utez.SIGEBI.controlador;

import mx.edu.utez.SIGEBI.modelo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String correo = request.getParameter("correoInstitucional") != null ? request.getParameter("correoInstitucional") : "-";
        String clave = request.getParameter("contrasenia") != null ? request.getParameter("contrasenia") : "-";
        DaoUsuario daoUsuario = new DaoUsuario();
        BeanUsuarios usuario = daoUsuario.login(correo, clave);

        if (correo.equals(usuario.getCorreo()) && clave.equals(usuario.getClave())) {
            HttpSession session = request.getSession(true);
            session.setAttribute("login", "ok");
            session.setAttribute("rol", usuario.getRol());
            session.setAttribute("idUsuario", usuario.getIdUsuario());
            session.setAttribute("nombre", usuario.getNombre());
            session.setAttribute("primerApellido", usuario.getPrimerApellido());
            session.setAttribute("segundoApellido", usuario.getSegundoApellido());
            session.setAttribute("correo", usuario.getCorreo());
            session.setAttribute("clave", usuario.getClave());
            session.setAttribute("estado",usuario.getEstado());
            session.setAttribute("divisionAcademica",usuario.getIdDivisionAcademica());

            switch (usuario.getRol()) {
                case 1:
                    List<BeanConvocatorias> convocatoriasList = DaoConvocatorias.findConvocatorias();
                    request.setAttribute("Lista_Convocatorias", convocatoriasList);
                    session.setAttribute("idAlumno", usuario.getIdUsuario());


                    BeanAlumnos unAlumno = null;
                    DaoAlumno dao = new DaoAlumno();
                    unAlumno = dao.findById(usuario.getIdUsuario());


                    request.setAttribute("alumno",unAlumno);
                    System.out.println(usuario.getIdUsuario());

                    request.getRequestDispatcher("WEB-INF/alumno/infoAlumno.jsp").forward(request, response);
                    break;

                case 2:
                    DaoDivisionesAcademicas daoDivisiones = new DaoDivisionesAcademicas();
                    DaoDivisionesAcademicas daoDivisionesCarreras = new DaoDivisionesAcademicas();
                    List<BeanDivisionesAcademicas> listaDivisiones = daoDivisiones.listar();
                    request.setAttribute("listaDivisiones", listaDivisiones);
                    List<BeanCarreras> listaCarreras = daoDivisionesCarreras.listarCarreras();
                    request.setAttribute("listaCarreras", listaCarreras);
                    request.getRequestDispatcher("/WEB-INF/administrador/carrerasDivisiones.jsp").forward(request, response);
                    break;

                case 3:
                    daoDivisiones = new DaoDivisionesAcademicas();
                    listaDivisiones = daoDivisiones.listar();
                    request.setAttribute("listaDivisiones", listaDivisiones);
                    request.getRequestDispatcher("/WEB-INF/comite_becas/cuentaComite.jsp").forward(request,response);
                    break;

                default:
                    request.setAttribute("message", "Tipo de Rol incorrecto");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
            }


        } else {
            request.setAttribute("message", "<div class=\"row alert alert-warning\" role=\"alert\" name=\"message\" id=\"message\">Datos de acceso incorrectos</div>");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }
}














