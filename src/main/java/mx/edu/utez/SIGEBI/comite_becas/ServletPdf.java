package mx.edu.utez.SIGEBI.comite_becas;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mx.edu.utez.SIGEBI.util.ConnectionMySQL;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.awt.*;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "ServletPdf", value = "/ServletPdf")
public class ServletPdf extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try (Connection con = ConnectionMySQL.getConnection();) {
            PreparedStatement p = con.prepareStatement(" select matricula, nombre, veredicto, porcentaje, id_convocatoria  from solicitudes_especificas");
            ResultSet rset = p.executeQuery();
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            //String tipo_Beca = request.getParameter("tipoBeca") != null ? request.getParameter("tipoBeca") : "0";
            //int tipoBeca = Integer.parseInt(tipo_Beca);
            // p.setInt(1, tipoBeca);
            PdfPTable table = new PdfPTable(new float[]{136,136,136,136,136});
            table.setWidthPercentage(100);
            PdfPCell celdainicio = new PdfPCell(new Paragraph("Becas", FontFactory.getFont("Esphimere")));
            celdainicio.setColspan(5);

            table.addCell(celdainicio);
            table.addCell(new Paragraph("Matricula", FontFactory.getFont("arial",10, Font.BOLD, BaseColor.BLACK)));
            table.addCell(new Paragraph("Nombre", FontFactory.getFont("arial",10, Font.BOLD, BaseColor.BLACK)));
            table.addCell(new Paragraph("Veredicto", FontFactory.getFont("arial",10, Font.BOLD, BaseColor.BLACK)));
            table.addCell(new Paragraph("Porcentaje", FontFactory.getFont("arial",10, Font.BOLD, BaseColor.BLACK)));
            table.addCell(new Paragraph("Tipo de Beca", FontFactory.getFont("arial",10, Font.BOLD, BaseColor.BLACK)));
            while(rset.next()) {
                table.addCell(rset.getString("matricula"));
                table.addCell(rset.getString("nombre"));
                table.addCell(rset.getString("veredicto"));
                table.addCell(rset.getString("porcentaje"));
                table.addCell(rset.getString("id_convocatoria"));
            }
            document.add(table);
            document.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
