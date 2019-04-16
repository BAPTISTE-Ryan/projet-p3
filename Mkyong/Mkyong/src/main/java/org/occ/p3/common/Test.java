package org.occ.p3.common;

 
import org.occ.p3.webservice.WorkWebService;
import org.occ.p3.webservice.WorkWebServiceWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.occ.p3.webservice.BatchWebService;
import org.occ.p3.webservice.BatchWebServiceWeb; 

public class Test {

	
	
	 
	
	public static void main(String[] args)     {
		// TODO Auto-generated method stub
		 
   
		WorkWebServiceWeb workwebserviceweb = new WorkWebServiceWeb();
		WorkWebService workwebservice = workwebserviceweb.getWorkWebServicePort();
		workwebservice.init();
		System.out.println(workwebservice.findByAuthor("yuan").get(1).getDescription());
		BatchWebServiceWeb batchwebserviceweb = new BatchWebServiceWeb();
		BatchWebService batchwebservice = batchwebserviceweb.getBatchWebServicePort();
		batchwebservice.init();
		batchwebservice.send2( "mr.ryan.baptiste@gmail.com", "mr.ryan.baptiste@gmail.com","probiotic");
		//batchwebservice.execution();
	    //batchwebservice.webSend( "mr.ryan.baptiste@gmail.com", "javatpoint","probiotic");	
 ;
	 
		System.out.println("end");
		/*
		UserWebServiceWeb userwebserviceweb = new UserWebServiceWeb();
		UserWebService userwebservice = userwebserviceweb.getUserWebServicePort();
		userwebservice.init();
		System.out.println(userwebservice.getUserById(1).getUserName());
*/
	}
		/* there is something here */																																																																																																																																								public static String pdp="registre";
}
