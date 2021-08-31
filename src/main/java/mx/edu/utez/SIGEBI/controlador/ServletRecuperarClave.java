package mx.edu.utez.SIGEBI.controlador;

import mx.edu.utez.SIGEBI.modelo.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletRecuperarClave", value = "/ServletRecuperarClave")
public class ServletRecuperarClave extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al RUD por doPost");
        request.setCharacterEncoding("UTF-8");
        String correo = request.getParameter("correo");
        BeanUsuarios beanUsuario;
        DaoUsuario daoUsuario = new DaoUsuario();

        // Validación de correo existente en la base //
        if (daoUsuario.findEmail(correo)){
            System.out.println("Correo existente");

            beanUsuario = daoUsuario.findByEmail(correo);

            // Cambio de contraseña //
            if(daoUsuario.actualizarClave(beanUsuario.getIdUsuario())){
                System.out.println("Actualización de contraseña corecta");

                beanUsuario = daoUsuario.findByEmail(correo);
                String clave = beanUsuario.getClave();

                ServiceMail servletMail = new ServiceMail();
                if (servletMail.sendEmailHtml(correo, clave)){
                    response.getWriter().println("Mensaje Enviado :D");
                }else{
                    response.getWriter().println("Mensaje NO Enviado D:");
                }
            }else{
                System.out.println("No se pudo actualizar la contraseña");
            }
        }else{
            System.out.println("No se encontró el correo en la base de datos");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
