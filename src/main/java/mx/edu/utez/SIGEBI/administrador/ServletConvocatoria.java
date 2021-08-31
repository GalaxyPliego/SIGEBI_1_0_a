package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanConvocatorias;
import mx.edu.utez.SIGEBI.modelo.DaoConvocatorias;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletConvocatoria", value = "/ServletConvocatoria")
public class ServletConvocatoria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entró al ServletConvocatoria por el metodo de Get");
        DaoConvocatorias daoConvocatorias = new DaoConvocatorias();
        List<BeanConvocatorias> listaConvocatorias = daoConvocatorias.listar();
        request.setAttribute("listaConvocatorias", listaConvocatorias);
        List<BeanConvocatorias> listaadmin = daoConvocatorias.listar2();
        request.setAttribute("listaadmin", listaadmin);
        List<BeanConvocatorias> listaBecas = daoConvocatorias.listar3();
        request.setAttribute("listaBecas", listaBecas);
        request.getRequestDispatcher("/WEB-INF/administrador/convocatorias.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al servlet do post ServletConvocatorias");
        request.setCharacterEncoding("UTF-8");

        String fechaInicio = request.getParameter("fechaInicio") != null ? request.getParameter("fechaInicio"): "";
        String fechaFin = request.getParameter("fechaFin") != null ? request.getParameter("fechaFin"): "";
        String estado = request.getParameter("estado")!= null ? request.getParameter("estado"): "";
        String beca = request.getParameter("beca")!= null ? request.getParameter("beca"): "";
        int idBeca2 = Integer.parseInt(beca);
        String admin = request.getParameter("admin")!= null ? request.getParameter("admin"): "";
        int idUsuario = Integer.parseInt(admin);

        BeanConvocatorias beanConvocatoria = new BeanConvocatorias();
        beanConvocatoria.setFechaInicio(fechaInicio);
        beanConvocatoria.setFechaFin(fechaFin);
        beanConvocatoria.setEstado(estado);
        beanConvocatoria.setIdBeca2(idBeca2);
        beanConvocatoria.setIdUsuario(idUsuario);

        System.out.println(beanConvocatoria.getFechaInicio());
        System.out.println(beanConvocatoria.getFechaFin());
        System.out.println(beanConvocatoria.getEstado());
        System.out.println(beanConvocatoria.getIdBeca2());
        System.out.println(beanConvocatoria.getIdUsuario());

        DaoConvocatorias daoConvocatoria = new DaoConvocatorias();
        boolean result = daoConvocatoria.insertar(beanConvocatoria);

        if (result){
            request.setAttribute("mensaje", "Resgitro Correcto");
        }else{
            request.setAttribute("mensaje", "Registro Incorrecto");
        }

        doGet(request, response);
    }
}

