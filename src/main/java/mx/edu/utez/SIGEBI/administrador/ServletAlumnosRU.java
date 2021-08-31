package mx.edu.utez.SIGEBI.administrador;

import mx.edu.utez.SIGEBI.modelo.BeanAlumnos;
import mx.edu.utez.SIGEBI.modelo.BeanDivisionesAcademicas;
import mx.edu.utez.SIGEBI.modelo.DaoAlumno;
import mx.edu.utez.SIGEBI.modelo.DaoDivisionesAcademicas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAlumnosRU", value = "/ServletAlumnosRU")
public class ServletAlumnosRU extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al Servlet Alumnos por doGet");
        request.setCharacterEncoding("UTF-8");
        DaoAlumno daoAlumno = new DaoAlumno();
        BeanAlumnos beanAlumno = new BeanAlumnos();
        List<BeanAlumnos> listaAlumnos = new ArrayList<>();
        int idAlumno;
        String opc = request.getParameter("opc") != null ? request.getParameter("opc") : " - ";

        switch (opc) {
            case "R":
                System.out.println("opcion R");
                try {
                    String idString = request.getParameter("idAlumno") != null ? request.getParameter("idAlumno") : " 0 ";
                    idAlumno = Integer.parseInt(idString);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    idAlumno = 0;
                }
                beanAlumno = daoAlumno.encontrarporId(idAlumno);
                request.setAttribute("alumno", beanAlumno);
                request.getRequestDispatcher("/WEB-INF/administrador/editarAlumnos.jsp").forward(request, response);
                break;

            case "U" :
                System.out.println("opcion U");
                String idString = request.getParameter("idAlumno") != null ? request.getParameter("idAlumno") : " 0 ";
                idAlumno = Integer.parseInt(idString);
                String estado = request.getParameter("estado")!= null? request.getParameter("estado"): "" ;

                try{
                    beanAlumno = new BeanAlumnos(idAlumno, estado);
                    boolean result = daoAlumno.actualizar(beanAlumno);
                    listaAlumnos = daoAlumno.listAlumnos();
                    System.out.println("Listo las Divisiones por el ServletDivisionesRUD");
                    if (result){
                        request.setAttribute("mensaje", "Alumno Actualizado");
                    }else{
                        request.setAttribute("mensaje", "Error al Actualizar");
                    }
                    request.setAttribute("listaAlumnos", listaAlumnos);
                    request.getRequestDispatcher("/WEB-INF/administrador/alumnos.jsp").forward(request, response);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;
/*
            case "S":

                try {
                    String buscador = request.getParameter("buscador") != null ? request.getParameter("buscador") : " - ";
                    listaAlumnos = daoAlumno.listaBuscador(buscador);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                request.setAttribute("listaAlumnos", listaAlumnos);
                request.getRequestDispatcher("WEB-INF/administrador/alumnos.jsp").forward(request, response);
                break;*/

            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entro al Servlet Alumnos metodo doPost");
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
