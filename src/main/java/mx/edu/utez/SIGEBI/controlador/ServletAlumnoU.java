package mx.edu.utez.SIGEBI.controlador;

import mx.edu.utez.SIGEBI.modelo.BeanAlumnos;
import mx.edu.utez.SIGEBI.modelo.BeanUsuarios;
import mx.edu.utez.SIGEBI.modelo.DaoAlumno;
import mx.edu.utez.SIGEBI.modelo.DaoUsuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAlumnoU", value = "/ServletAlumnoU")
public class ServletAlumnoU extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : "-";
        HttpSession session = request.getSession(true);

        switch (opc) {

            case "R":

                request.setAttribute("mensaje", "Actualizacion realizada con exito");

                Object id_Usuario = session.getAttribute("idUsuario");
                String idUsuario1 = String.valueOf(id_Usuario);
                int idUsuario2 = Integer.parseInt(idUsuario1);
                BeanAlumnos unAlumno1 = null;
                DaoAlumno dao1 = new DaoAlumno();
                unAlumno1 = dao1.findById(idUsuario2);

                request.setAttribute("mensajexdd", "");
                request.setAttribute("alumno",unAlumno1);
                request.getRequestDispatcher("WEB-INF/alumno/infoAlumno.jsp").forward(request, response);
                break;

            case "U":
                String idUsuario = request.getParameter("idUsuario") != null ? request.getParameter("idUsuario") : "0";
                String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String primerApellido = request.getParameter("primerApellido") != null ? request.getParameter("primerApellido") : "";
                String segundoApellido = request.getParameter("segundoApellido") != null ? request.getParameter("segundoApellido") : "0";
                String correo = request.getParameter("correo") != null ? request.getParameter("correo") : "";
                String clave = request.getParameter("clave") != null ? request.getParameter("clave") : "";
                String idDivisionAcademica = request.getParameter("idDivisionAcademica") != null ? request.getParameter("idDivisionAcademica") : "";
                String matricula = request.getParameter("matricula") != null ? request.getParameter("matricula") : "";
                String fechaNacimiento = request.getParameter("fechaNacimiento") != null ? request.getParameter("fechaNacimiento") : "";
                String telefono = request.getParameter("telefono") != null ? request.getParameter("telefono") : "";
                String celular = request.getParameter("celular") != null ? request.getParameter("celular") : "";
                String curp = request.getParameter("curp") != null ? request.getParameter("curp") : "";
                String nivelAcademico = request.getParameter("nivelAcademico") != null ? request.getParameter("nivelAcademico") : "";
                String idCarrera = request.getParameter("idCarrera") != null ? request.getParameter("idCarrera") : "";
                String turno = request.getParameter("turno") != null ? request.getParameter("turno") : "";
                String sexo = request.getParameter("sexo") != null ? request.getParameter("sexo") : "";
                String nacionalidad = request.getParameter("nacionalidad") != null ? request.getParameter("nacionalidad") : "";
                String colonia = request.getParameter("colonia") != null ? request.getParameter("colonia") : "";
                String numInterior = request.getParameter("numInterior") != null ? request.getParameter("numInterior") : "";
                String numExterior = request.getParameter("numExterior") != null ? request.getParameter("numExterior") : "";
                String entidadFederativa = request.getParameter("entidadFederativa") != null ? request.getParameter("entidadFederativa") : "";
                String delegacion = request.getParameter("delegacion") != null ? request.getParameter("delegacion") : "";
                String codigoPostal = request.getParameter("codigoPostal") != null ? request.getParameter("codigoPostal") : "";
                String calle = request.getParameter("calle") != null ? request.getParameter("calle") : "";
                String id_alumno = request.getParameter("id_alumno") != null ? request.getParameter("id_alumno") : "";

                try {

                    BeanAlumnos alumnoUpdate = new BeanAlumnos(fechaNacimiento,telefono,celular,curp,sexo,nacionalidad,colonia,numInterior,numExterior,entidadFederativa,delegacion,codigoPostal,calle,Integer.parseInt(id_alumno));
                    DaoAlumno daoAlumnoUpdate = new DaoAlumno();
                    boolean result2 = daoAlumnoUpdate.update(alumnoUpdate);

                    BeanUsuarios usuarioUpdate = new BeanUsuarios(Integer.parseInt(idUsuario), nombre, primerApellido, segundoApellido, correo, clave);
                    DaoUsuario daoUpdate = new DaoUsuario();
                    boolean result = daoUpdate.update(usuarioUpdate);

                    if (result && result2 == true) {

                        request.setAttribute("mensaje", "Actualizacion realizada con exito");

                        BeanUsuarios pruebaUsuario = new BeanUsuarios();
                        session.setAttribute("idUsuario",usuarioUpdate.getIdUsuario());
                        BeanAlumnos unAlumno = null;
                        DaoAlumno dao = new DaoAlumno();
                        unAlumno = dao.findById(usuarioUpdate.getIdUsuario());

                        request.setAttribute("mensajexdd", "XD");
                        request.setAttribute("alumno",unAlumno);

                        session.setAttribute("login", "ok");
                        session.setAttribute("nombre", usuarioUpdate.getNombre());
                        session.setAttribute("primerApellido",usuarioUpdate.getPrimerApellido());
                        session.setAttribute("segundoApellido",usuarioUpdate.getSegundoApellido());
                        session.setAttribute("rol", usuarioUpdate.getRol());
                        session.setAttribute("idUsuario",usuarioUpdate.getIdUsuario());
                        session.setAttribute("correo",usuarioUpdate.getCorreo());
                        session.setAttribute("clave",usuarioUpdate.getClave());


                    } else {
                        request.setAttribute("mensaje", "Error al actualizar");
                    }
                    request.getRequestDispatcher("WEB-INF/alumno/infoAlumno.jsp").forward(request, response);
                    break;

                }catch (Exception ex) {

                    ex.printStackTrace();
                }
                request.setAttribute("mensaje", "Error al parsear");


                //request.getRequestDispatcher("WEB-INF/alumno/infoAlumno.jsp").forward(request, response);
                //break;

            case "H":

                String matricula1 = request.getParameter("matricula") != null ? request.getParameter("matricula") : "";
                System.out.println(matricula1);

                BeanAlumnos becaAlumno = null;
                DaoAlumno daoBecas = new DaoAlumno();
                becaAlumno = daoBecas.findBeca(matricula1);

                request.setAttribute("mensajeBeca", "Se encontro la info de beca");
                request.setAttribute("Beca",becaAlumno);


                List<BeanAlumnos> listaHistorial = daoBecas.findBecaPasada(matricula1);
                request.setAttribute("becaPasada", listaHistorial);






                request.getRequestDispatcher("WEB-INF/alumno/histBecas.jsp").forward(request, response);

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
