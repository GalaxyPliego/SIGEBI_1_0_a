package mx.edu.utez.SIGEBI.controlador;


import mx.edu.utez.SIGEBI.modelo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletRegistro", value = "/ServletRegistro")
public class ServletRegistro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoDivisionesAcademicas daoDivisiones = new DaoDivisionesAcademicas();
        List<BeanDivisionesAcademicas> listaDivisiones = daoDivisiones.listar();
        request.setAttribute("listaDivisiones", listaDivisiones);
        List<BeanCarreras> listaCarreras = daoDivisiones.listarCarreras();
        request.setAttribute("listaCarreras", listaCarreras);
        request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombres")!= null ? request.getParameter("nombres"): "";
        String primerApellido = request.getParameter("primerApellido")!= null ? request.getParameter("primerApellido"): "";
        String segundoApellido = request.getParameter("segundoApellido")!= null ? request.getParameter("segundoApellido"): "";
        String correo = request.getParameter("correo")!= null ? request.getParameter("correo"): "";
        String estado = "activo";
        int tipoRol = 1;
        String divisionAcademica = request.getParameter("divisionAcademica")!= null ? request.getParameter("divisionAcademica"): "0";
        int idDivision = Integer.parseInt(divisionAcademica);

        DaoRegistro daoRegistro = new DaoRegistro();
        boolean usuarioNuevo = daoRegistro.registrar(nombre, primerApellido, segundoApellido, correo, estado, tipoRol, idDivision);
        System.out.println(usuarioNuevo);

        String matricula = request.getParameter("matricula");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String telefono = request.getParameter("telefono") !=null? request.getParameter("telefono") : "0";
        System.out.println("Telefono"+telefono);
        String celular = request.getParameter("celular");
        String curp = request.getParameter("curp");
        String nivelAcademico = request.getParameter("nivelAcademico");
        String carrera = request.getParameter("carrera");
        String turno = request.getParameter("turno");
        String sexo = request.getParameter("sexo");
        String nacionalidad = request.getParameter("nacionalidad");
        String colonia = request.getParameter("colonia");
        String numeroInt = request.getParameter("numeroInt");
        String numeroExt = request.getParameter("numeroExt");
        String entidadFederativa = request.getParameter("estado");
        String delegacion = request.getParameter("delegacion");
        String codigoPostal = request.getParameter("codigoPostal");
        String calle = request.getParameter("calle");

        BeanUsuarios datosUsuario = daoRegistro.obtenerUsuario(correo);
        System.out.println(datosUsuario.getIdDivisionAcademica());
        boolean alumnoNuevo = daoRegistro.registrarAlumno(datosUsuario.getIdUsuario(), matricula, fechaNacimiento, telefono, celular, curp, nivelAcademico, carrera, turno, sexo, nacionalidad, colonia, numeroInt, numeroExt, entidadFederativa, delegacion, codigoPostal, calle, datosUsuario.getIdDivisionAcademica());
        System.out.println(alumnoNuevo);
        if (alumnoNuevo){
            request.setAttribute("message", "<div class=\"row alert alert-success\" role=\"alert\" name=\"message\" id=\"message\">Registro completado con éxito, te hemos mandado tu contraseñá a tu correo insitucional para que puedas ingresar al sistema :D</div>");
        }else{
            request.setAttribute("message", "<div class=\"row alert alert-warning\" role=\"alert\" name=\"message\" id=\"message\">A ocurrido un error al completar el registro, por favor verifica tus datos e intentalo nuevamente D:</div>");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
