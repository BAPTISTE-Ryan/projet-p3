package org.occ.p3.service;

 


import org.occ.p3.model.Borrow;
import org.occ.p3.model.Work;
import org.springframework.stereotype.Service; 
import javax.mail.*;  
import javax.mail.internet.*;
 
import javax.activation.*;
import javax.annotation.PostConstruct;
import javax.jws.WebMethod; 
import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import javax.xml.datatype.XMLGregorianCalendar;



@Service
public class BatchServiceImpl implements BatchService {

	public String send(    String to, String sub, String msg) {
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		//Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("mr.ryan.baptiste@gmail.com","restauration");
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return msg;
	}
 
	
	
	
	   public  void mailMethodOne() {    
		      // Recipient's email ID needs to be mentioned.
		      String to = "mr.ryan.baptiste@gmail.com";

		      // Sender's email ID needs to be mentioned
		      String from = "mr.ryan.baptiste@gmail.com";

		      // Assuming you are sending email from localhost
		      String host = "localhost";

		      // Get system properties
		      Properties properties = System.getProperties();

		      // Setup mail server
		      properties.setProperty("mail.smtp.host", host);

		      // Get the default Session object.
		      Session session = Session.getDefaultInstance(properties);

		      try {
		         // Create a default MimeMessage object.
		         MimeMessage message = new MimeMessage(session);

		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		         // Set Subject: header field
		         message.setSubject("This is the Subject Line!");

		         // Now set the actual message
		         message.setText("This is actual message");

		         // Send message
		         Transport.send(message);
		         System.out.println("Sent message successfully....");
		      } catch (MessagingException mex) {
		         mex.printStackTrace();
		      }
		   }
	
	
	
	
	   public  void mailMethodTwo() {
		      // Recipient's email ID needs to be mentioned.
		      String to = "mr.ryan.baptiste@gmail.com";

		      // Sender's email ID needs to be mentioned
		      String from = "mr.ryan.baptiste@gmail.com";
		      final String username = "Ryan Baptiste";//change accordingly
		      final String password = "restauration";//change accordingly

		      // Assuming you are sending email through relay.jangosmtp.net
		      String host = "relay.jangosmtp.net";

		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.port", "25");

		      // Get the Session object.
		      Session session = Session.getInstance(props,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(username, password);
			   }
		         });

		      try {
			   // Create a default MimeMessage object.
			   Message message = new MimeMessage(session);
			
			   // Set From: header field of the header.
			   message.setFrom(new InternetAddress(from));
			
			   // Set To: header field of the header.
			   message.setRecipients(Message.RecipientType.TO,
		               InternetAddress.parse(to));
			
			   // Set Subject: header field
			   message.setSubject("Testing Subject");
			
			   // Now set the actual message
			   message.setText("Hello, this is sample for to check send " +
				"email using JavaMailAPI ");

			   // Send message
			   Transport.send(message);

			   System.out.println("Sent message successfully....");

		      } catch (MessagingException e) {
		         throw new RuntimeException(e);
		      }
 
		      
	   
	   }
	
	
		public  void mailMethodThree(Session session, String toEmail, String subject, String body){
			try
		    {
		      MimeMessage msg = new MimeMessage(session);
		      //set message headers
		      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		      msg.addHeader("format", "flowed");
		      msg.addHeader("Content-Transfer-Encoding", "8bit");

		      msg.setFrom(new InternetAddress("mr.ryan.baptiste@gmail.com", "NoReply-JD"));

		      msg.setReplyTo(InternetAddress.parse("mr.ryan.baptiste@gmail.com", false));

		      msg.setSubject(subject, "UTF-8");

		      msg.setText(body, "UTF-8");

		      msg.setSentDate(new Date());

		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		      System.out.println("Message is ready");
	    	  Transport.send(msg);  

		      System.out.println("EMail Sent Successfully!!");
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		}
	   
		public  void TLSEmail( ) {
			final String fromEmail = "mr.ryan.baptiste@gmail.com"; //requires valid gmail id
			final String password = "restauration"; // correct password for gmail id
			final String toEmail = "mr.ryan.baptiste@gmail.com"; // can be any email id 
			
			System.out.println("TLSEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			
	                //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			
			mailMethodThree(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");
			
		}
		
	
		public  void SSLEmail( ) {
			final String fromEmail = "mr.ryan.baptiste@gmail.com"; //requires valid gmail id
			final String password = "restauration"; // correct password for gmail id
			final String toEmail = "mr.ryan.baptiste@gmail.com"; // can be any email id 
			
			System.out.println("SSLEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
			props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
			props.put("mail.smtp.port", "465"); //SMTP Port
			
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			
			Session session = Session.getDefaultInstance(props, auth);
			System.out.println("Session created");
			mailMethodThree(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");

		    mailMethodThree(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

		    mailMethodThree(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");

		}
		
		
		
	 /*

	@Autowired
	UserService userService;
	@Autowired
	WorkService workwebservice;
	@Autowired
	MemberService memberService;
	
	
	
	
	@WebMethod
	public  void main(String[] args)
	  {
		 System.out.println("inside");
		 send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
				  "javatpoint","###########################################################################################");	  send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
						  "javatpoint","###########################################################################################");  

		 String  messRandom = "\r\n" + 
		 		"Dear Mr Smith,\r\n" + 
		 		"\r\n" + 
		 		"According to our records, the items listed below which are currently on loan to you are overdue. Please either renew them or return them to the library immediately. Fines are accruing on them on a daily basis, so the longer you leave it the more you will have to pay. \r\n" + 
		 		"\r\n" + 
		 		"Yours sincerely," ;
		 
		 
		 
		  
		 List<Work> worksAuthor = workwebservice.findByAuthor("yuan");
		  System.out.println(workwebservice.getWorkById(2).getAuthor());
		  System.out.println(worksAuthor.get(0).getTitle());
		
		System.out.println("sucess");
	 
		;
	  
		List<Borrow> borrows=userService.getUserById(1).getBorrow();
		
		System.out.println("after");
		
		Date date = new Date();
		GregorianCalendar defaultEndDate = new GregorianCalendar();
		defaultEndDate.setTime(date);
		
		for (int j = 1; j < 7; j++) {
			if(userService.getUserById(j).getBorrow()!=null) {
				if(userService.getUserById(j).getBorrow().size()!=0) {
			borrows=userService.getUserById(j).getBorrow();
					
					
												GregorianCalendar beginDate =   date2greg(borrows.get(1).getStartBorrowDate());
												GregorianCalendar endDate = null;
												
												if(borrows.get(1).getEndBorrowDate()==null) {endDate = defaultEndDate;}else {
												  endDate = date2greg(borrows.get(1).getEndBorrowDate());
												}
												
												
											      System.out.println(beginDate.getTime()+" "+endDate.getTime()+" "+beginDate.compareTo(endDate));
										 
												
												 
												for (int i = 0; i < borrows.size(); i++) {
										 
													  beginDate =   date2greg(borrows.get(i).getStartBorrowDate() );
													  if(borrows.get(i).getEndBorrowDate()==null) {endDate = defaultEndDate;}else {
														  endDate = date2greg(borrows.get(i).getEndBorrowDate() );
														}
														
											
												      if (getDays(beginDate,endDate)>14 && !borrows.get(i).getStatus().equals("TERMINE")) {
												    	  		System.out.println( "bibliot \n"+"_______________________________________________________________________"
										    	  						   +"\n user::"+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()
										    	  						   +"\n email:: "+memberService.getMemberById(borrows.get(i).getUserBorrowingId()).getEmailadress()
												    	  						   +"\n  book title::"+workwebservice.getWorkById(borrows.get(i).getBook().getWorkId()).getTitle()
												    	  						   +"\n  delay::"+getDays(beginDate,endDate)+" days"
												    	  						   +"\n  satus::"+borrows.get(i).getStatus()
												    	  						   +"\n _______________________________________________________________________"
												    	  							);
														
														
												    	  		send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
												    					  "bibliotheca universalis"+"["+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()+"]",
												    					  "Dear mr "+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()+"  According to our records, the items listed below which are currently on loan to you are overdue. Please either renew them or return them to the library immediately. Fines are accruing on them on a daily basis, so the longer you leave it the more you will have to pay"
												    					  +"_______________________________________________________________________"
												    	  						   +"\n user::"+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()
												    	  						 +"\n email::"+memberService.getMemberById(borrows.get(i).getUserBorrowingId()).getEmailadress()
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
		
		System.out.println("done");
		send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
				  "javatpoint","###########################################################################################");	  send("mr.ryan.baptiste@gmail.com",pdp,"mr.ryan.baptiste@gmail.com",
						  "javatpoint","###########################################################################################");  
 
				  System.out.println("someside");
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
	*/
	 /* (non-Javadoc)
	 * @see org.occ.p3.service.BatchService#send(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
  

	 /*
	 public GregorianCalendar date2greg(Date date) {
		     
		    GregorianCalendar calendar = new GregorianCalendar();
		    calendar.setTime(date);
			return calendar;
		  }
	*/
	   
}