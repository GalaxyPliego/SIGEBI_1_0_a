package mx.edu.utez.SIGEBI.modelo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ServiceMail {
    private final Properties PROPERTIES = new Properties();
    private String password;
    private Session session;

    private void init(){
        PROPERTIES.put("mail.smtp.host", "smtp.gmail.com");
        PROPERTIES.put("mail.smtp.port", 587);
        PROPERTIES.put("mail.smtp.starttls.enable", "true");
        PROPERTIES.put("mail.smtp.mail.sender", "20203tn129@utez.edu.mx");
        PROPERTIES.put("mail.smtp.user", "20203tn129@utez.edu.mx");
        PROPERTIES.put("mail.smtp.auth", "true");
        password = "clave:*";
        session = Session.getDefaultInstance(PROPERTIES,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("20203tn129@utez.edu.mx", password);
                    }
                }
        );
    }

    public boolean sendEmailHtml(String correo, String clave){

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "\t<meta name=\"x-apple-disable-message-reformatting\">\n" +
                "\t<title></title>\n" +
                "\t<style>\n" +
                "\t\ttable, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "\t<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\" style=\"padding:0;\">\n" +
                "\t\t\t\t<table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td align=\"center\" style=\"padding:40px 0 30px 0;background:#002e5d;\">\n" +
                "\t\t\t\t\t\t\t<img src=\"INT_SIGEBI/img/identificador_sigebi_blanco.png\" alt=\"\" width=\"300\" style=\"height:auto;display:block;\" />\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td style=\"padding:36px 30px 42px 30px;\">\n" +
                "\t\t\t\t\t\t\t<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"padding:0 0 36px 0;color:#153643;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif; text-align: center;\">!Tu registro fue exitoso¡ :D</h1>\n" +
                "                                        <br>\n" +
                "                                        <p style=\"font-size:20px;margin:0 0 20px 0;font-family:Arial,sans-serif;\"><strong>Contraseña: </strong>" + clave + "</p>\n" +
                "                                        <br>\n" +
                "\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">Por tu seguridad te recomendamos cambiar la contraseña una vez ingreses al sistema</p>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</table>\n" +
                "</body>\n" +
                "</html>";

        init();
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress( (String) PROPERTIES.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(correo));

            message.setContent(html, "text/html; chaset=utf-8");
            Transport.send(message);
            /*
            Transport transport = session.getTransport("smtp");
            transport.connect((String)PROPERTIES.get("mail.smtp.user"), clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            */
            return true;
        }catch (MessagingException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
