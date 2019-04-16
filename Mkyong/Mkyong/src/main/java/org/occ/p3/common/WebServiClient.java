package org.occ.p3.common;


import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.xml.datatype.XMLGregorianCalendar;

import org.occ.p3.alternative.WebServiceClient;
import org.quartz.Job;

import org.occ.p3.webservice.Borrow;
import org.occ.p3.webservice.User;
import org.occ.p3.webservice.WorkWebService;
import org.occ.p3.webservice.WorkWebServiceWeb;

@SuppressWarnings("unused")
public class WebServiClient  {

	
/*                                                                                                    */	public static String pdp="registre";
	
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
 
   
	 
	 
	 
	 
	
	 public static void main(String[] args) {
		 
		 
		 
		 
		 
		 
		 
		 
		 String  messRandom = "\r\n" + 
		 		"Dear Mr Smith,\r\n" + 
		 		"\r\n" + 
		 		"According to our records, the items listed below which are currently on loan to you are overdue. Please either renew them or return them to the library immediately. Fines are accruing on them on a daily basis, so the longer you leave it the more you will have to pay. \r\n" + 
		 		"\r\n" + 
		 		"Yours sincerely," ;
		 
		 
		 
		 
		 

		WorkWebServiceWeb workwebserviceweb = new WorkWebServiceWeb();

		WorkWebService workwebservice = workwebserviceweb.getWorkWebServicePort();
		
		workwebservice.init();
		 List<org.occ.p3.webservice.Work> worksAuthor = workwebservice.findByAuthor("yuan");
		  System.out.println(workwebservice.getWorkById(2).getAuthor());
		  System.out.println(worksAuthor.get(0).getTitle());
		
		System.out.println("sucess");
	 
		;
	 
		WebServiceClient userService   = new WebServiceClient();
		List<Borrow> borrows=userService.getUserById(1).getBorrow();
		 
		
		Date date = new Date();
		GregorianCalendar defaultEndDate = new GregorianCalendar();
		defaultEndDate.setTime(date);
		
		for (int j = 1; j < 7; j++) {
			if(userService.getUserById(j).getBorrow()!=null) {
				if(userService.getUserById(j).getBorrow().size()!=0) {
			borrows=userService.getUserById(j).getBorrow();
					
					
												GregorianCalendar beginDate =   borrows.get(1).getStartBorrowDate().toGregorianCalendar();
												GregorianCalendar endDate = null;
												
												if(borrows.get(1).getEndBorrowDate()==null) {endDate = defaultEndDate;}else {
												  endDate = borrows.get(1).getEndBorrowDate().toGregorianCalendar();
												}
												
												
											      System.out.println(beginDate.getTime()+" "+endDate.getTime()+" "+beginDate.compareTo(endDate));
										 
												
												
												// Baeldung 
											    // Quartz 
												
												for (int i = 0; i < borrows.size(); i++) {
										 
													  beginDate =   borrows.get(i).getStartBorrowDate().toGregorianCalendar();
													  if(borrows.get(i).getEndBorrowDate()==null) {endDate = defaultEndDate;}else {
														  endDate = borrows.get(i).getEndBorrowDate().toGregorianCalendar();
														}
														
											
												      if (getDays(beginDate,endDate)>14 && !borrows.get(i).getStatus().equals("TERMINE")) {
												    	  		System.out.println( "bibliot \n"+"_______________________________________________________________________"
												    	  						   +"\n user::"+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()
												    	  						   +"\n  book title::"+workwebservice.getWorkById(borrows.get(i).getBook().getWorkId()).getTitle()
												    	  						   +"\n  delay::"+getDays(beginDate,endDate)+" days"
												    	  						   +"\n  satus::"+borrows.get(i).getStatus()
												    	  						   +"\n _______________________________________________________________________"
												    	  							);
														
														
												    			  send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
												    					  "bibliotheca universalis",
												    					  "Dear mr "+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()+"  According to our records, the items listed below which are currently on loan to you are overdue. Please either renew them or return them to the library immediately. Fines are accruing on them on a daily basis, so the longer you leave it the more you will have to pay"
												    					  +"_______________________________________________________________________"
												    	  						   +"\n user::"+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()
												    	  						   +"\n  book title::"+workwebservice.getWorkById(borrows.get(i).getBook().getWorkId()).getTitle()
												    	  						   +"\n  delay::"+getDays(beginDate,endDate)+" days"
												    	  						   +"\n  satus::"+borrows.get(i).getStatus()
												    	  						   +"\n _______________________________________________________________________"
												    	  							+" bibliot \n");  
													}
												}
				}
			}
		
		}
		
		 
		  send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
				  "javatpoint","###########################################################################################");	  send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
						  "javatpoint","###########################################################################################");  
  
	} 
	 
 
}
