package mx.edu.utez.SIGEBI.controlador;

import mx.edu.utez.SIGEBI.modelo.DaoHistorial;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet(name = "ServletObtenerActaHijo", value = "/ServletObtenerActaHijo")
public class ServletObtenerActaHijo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ServletOutputStream out = response.getOutputStream();
            String id = request.getParameter("id") != null ? request.getParameter("id") : "0";
            int idRequisitos = Integer.parseInt(id);
            DaoHistorial daoHistorial = new DaoHistorial();
            Blob imagen = daoHistorial.getActaHijo(idRequisitos);
            if (imagen!=null) {
                response.setContentType("image/png");
                InputStream in = null;
                in = imagen.getBinaryStream();
                int lenght = (int) imagen.length();

                int bufferSize = 1024;
                byte[] buffer = new byte[bufferSize];

                while ((lenght = in.read(buffer)) != -1) {
                    out.write(buffer, 0, lenght);
                }
                in.close();
                out.flush();
            }else{
                System.out.println("Error con la imagen");
            }
        }catch (IOException | SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
