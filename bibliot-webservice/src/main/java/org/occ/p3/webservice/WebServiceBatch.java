package org.occ.p3.webservice;

 


import org.occ.p3.model.Borrow;
import org.occ.p3.model.Work;
import org.occ.p3.service.MemberService;
import org.occ.p3.service.UserService;
import org.occ.p3.service.WorkService;
import org.occ.p3.service.BatchService;
import org.occ.p3.service.BatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;
import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
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
@WebService(serviceName = "BatchWebServiceWeb", name = "BatchWebService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class WebServiceBatch  
{


	static
	BatchServiceImpl batchServiceimpl = new BatchServiceImpl();

	@Autowired
	BatchService batchService;

	 @WebMethod	 public  void send( String to,String sub,String msg){batchService.send(   to, sub, msg);}  
	 @WebMethod	 public  void mailMethodOne(){batchService.mailMethodOne();} 
	 @WebMethod	 public  void mailMethodTwo(){batchService.mailMethodTwo();}  
	 @WebMethod	 public  void mailMethodThree(javax.mail.Session session, String to,String sub,String msg){batchService.mailMethodThree(session,to, sub, msg);}  
	 @WebMethod	 public  void send1( String to,String sub,String msg){batchServiceimpl.send(to, sub, msg);}  
		
 
		 BatchServiceImpl bs = new BatchServiceImpl();
	 @WebMethod	 public  void send2( String to,String sub,String msg){
		
			
			bs.send(to, sub, msg);
		 
	 
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
	 
		@PostConstruct
		public void init() {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		}
}