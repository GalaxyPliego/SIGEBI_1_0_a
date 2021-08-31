package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanBecas;
import mx.edu.utez.SIGEBI.modelo.DaoBeca;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletBecaRU", value = "/ServletBecaRU")
public class ServletBecaRU extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entró al servletBecaRU por doGet");
        request.setCharacterEncoding("UTF-8");
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : " - ";
        String idString;
        DaoBeca daoBeca = new DaoBeca();
        BeanBecas beanBeca = new BeanBecas();
        List<BeanBecas> listaBecas = new ArrayList<>();

        switch (opc){

            case "R":
                int idBeca;
                try {
                    beanBeca.setIdBeca(Integer.parseInt(request.getParameter("idBeca")));
                    beanBeca = daoBeca.encontrarporId(beanBeca.getIdBeca());
                    request.setAttribute("beca", beanBeca);
                    listaBecas = daoBeca.listar();
                    request.setAttribute("listaBecas", listaBecas);

                }catch (Exception ex){
                    ex.printStackTrace();
                    idBeca = 0;
                }
                request.getRequestDispatcher("/WEB-INF/administrador/editarBeca.jsp").forward(request, response);
                break;

            case "U":

                beanBeca.setIdBeca(Integer.parseInt(request.getParameter("idBeca") != null ? request.getParameter("idBeca") : " 0 "));
                beanBeca.setTipoBeca(request.getParameter("tipoBeca") != null ? request.getParameter("tipoBeca") : " - ");
                beanBeca.setEstado(request.getParameter("estado") != null ? request.getParameter("estado") : " - ");
                try {
                    daoBeca.actualizar(beanBeca);
                    listaBecas = daoBeca.listar();
                    request.setAttribute("listaBecas", listaBecas);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("/WEB-INF/administrador/becas.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("ServletBeca").forward(request, response);
                break;

            case "S":

                try {
                    String buscador = request.getParameter("buscador") != null ? request.getParameter("buscador") : " - ";
                    listaBecas = daoBeca.listaBuscador(buscador);
                    request.setAttribute("listaBecas", listaBecas);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("WEB-INF/administrador/becas.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}