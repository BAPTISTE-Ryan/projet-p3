package org.occ.p3.mail;

import java.io.IOException;  
import java.io.PrintWriter;  
import org.occ.p3.mail.Identifs;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class SendMail extends HttpServlet {  
public void doGet(HttpServletRequest request,  
 HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    Identifs ids = new Identifs();
    String to=ids.emailaddr();  
    String subject="subject";  
    String msg="siome sort of kinda random message";  
          
    Mailer.send(to, subject, msg);  
    out.print("message has been sent successfully");  
    out.close();  
    }  
  
}  