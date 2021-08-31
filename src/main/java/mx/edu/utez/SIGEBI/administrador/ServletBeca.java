package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanBecas;
import mx.edu.utez.SIGEBI.modelo.DaoBecas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletBeca", value = "/ServletBeca")
public class ServletBeca extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al ServletBecas por doGet");
        request.setCharacterEncoding("UTF-8");
        DaoBecas daoBeca = new DaoBecas();
        List<BeanBecas> listaBecas = daoBeca.listar();
        request.setAttribute("listaBecas", listaBecas);
        request.getRequestDispatcher("/WEB-INF/administrador/becas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al SErvlet becas metodo doPost");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
