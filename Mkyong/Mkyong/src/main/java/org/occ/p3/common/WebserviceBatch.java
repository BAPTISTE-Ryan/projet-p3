package org.occ.p3.common;

 
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.occ.p3.alternative.WebServiceClient;
import org.occ.p3.webservice.Borrow;
import org.occ.p3.webservice.User;
import org.occ.p3.webservice.WorkWebService;
import org.occ.p3.webservice.WorkWebServiceWeb;

public class WebserviceBatch implements Job
{

 

	public void execute(JobExecutionContext context)
	throws JobExecutionException {
		
		 
		 
		 
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
														
											
												      if (WebServiClient.getDays(beginDate,endDate)>14 && !borrows.get(i).getStatus().equals("TERMINE")) {
												    	  		System.out.println( "bibliot \n"+"_______________________________________________________________________"
										    	  						   +"\n user::"+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()
										    	  						   +"\n email:: "+userService.getMemberById(borrows.get(i).getUserBorrowingId()).getEmailadress()
												    	  						   +"\n  book title::"+workwebservice.getWorkById(borrows.get(i).getBook().getWorkId()).getTitle()
												    	  						   +"\n  delay::"+WebServiClient.getDays(beginDate,endDate)+" days"
												    	  						   +"\n  satus::"+borrows.get(i).getStatus()
												    	  						   +"\n _______________________________________________________________________"
												    	  							);
														
														
												    	  		WebServiClient.send("mr.ryan.baptiste@gmail.com",WebServiClient.pdp,"mr.ryan.baptiste@gmail.com",
												    					  "bibliotheca universalis"+"["+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()+"]",
												    					  "Dear mr "+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()+"  According to our records, the items listed below which are currently on loan to you are overdue. Please either renew them or return them to the library immediately. Fines are accruing on them on a daily basis, so the longer you leave it the more you will have to pay"
												    					  +"_______________________________________________________________________"
												    	  						   +"\n user::"+userService.getUserById(borrows.get(i).getUserBorrowingId()).getUserName()
												    	  						 +"\n email::"+userService.getMemberById(borrows.get(i).getUserBorrowingId()).getEmailadress()
												    	  						   +"\n  book title::"+workwebservice.getWorkById(borrows.get(i).getBook().getWorkId()).getTitle()
												    	  						   +"\n  delay::"+WebServiClient.getDays(beginDate,endDate)+" days"
												    	  						   +"\n  satus::"+borrows.get(i).getStatus()
												    	  						   +"\n _______________________________________________________________________"
												    	  							+" bibliot \n");  
													}
												}
				}
			}
		
		}
		
		 
		WebServiClient.send("mr.ryan.baptiste@gmail.com",WebServiClient.pdp,"mr.ryan.baptiste@gmail.com",
				  "javatpoint","###########################################################################################");	  WebServiClient.send("mr.ryan.baptiste@gmail.com",WebServiClient.pdp,"mr.ryan.baptiste@gmail.com",
						  "javatpoint","###########################################################################################");  
 
	} 
	 

		
	 
	
}