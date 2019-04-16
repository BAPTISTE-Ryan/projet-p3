package org.occ.p3.alternative;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mailsendtest {

	
	
	
	
	
	public static void main(String[] args)
	  {
		 System.out.println("inside");
		 send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
				  "javatpoint","###########################################################################################");	  send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
						  "javatpoint","###########################################################################################");
				
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
 	public static String pdp="registre";
	
	 public static int getDays(GregorianCalendar g1, GregorianCalendar g2) {
		  int elapsed = 0;
		  GregorianCalendar gc1, gc2;
		  if (g2.after(g1)) {
		     gc2 = (GregorianCalendar) g2.clone();
		     gc1 = (GregorianCalendar) g1.clone();
		  }
		  else   {
		     gc2 = (GregorianCalendar) g1.clone();
		     gc1 = (GregorianCalendar) g2.clone();
		  }
		  gc1.clear(Calendar.MILLISECOND);
		  gc1.clear(Calendar.SECOND);
		  gc1.clear(Calendar.MINUTE);
		  gc1.clear(Calendar.HOUR_OF_DAY);
		  gc2.clear(Calendar.MILLISECOND);
		  gc2.clear(Calendar.SECOND);
		  gc2.clear(Calendar.MINUTE);
		  gc2.clear(Calendar.HOUR_OF_DAY);
		  while ( gc1.before(gc2) ) {
		     gc1.add(Calendar.DATE, 1);
		     elapsed++;
		  }
		  return elapsed;
		  }
	
	 
	 public static void send(final String from,final String password,String to,String sub,String msg){  
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
  }  

	 
	 public GregorianCalendar date2greg(Date date) {
		     
		    GregorianCalendar calendar = new GregorianCalendar();
		    calendar.setTime(date);
			return calendar;
		  }
	


}
