package org.occ.p3.alternative;


import java.util.List;

import org.occ.p3.webservice.BorrowWebService;
import org.occ.p3.webservice.BorrowWebServiceWeb;
import org.occ.p3.webservice.Member;
import org.occ.p3.webservice.MemberWebService;
import org.occ.p3.webservice.MemberWebServiceWeb;
import org.occ.p3.webservice.User;
import org.occ.p3.webservice.UserWebService;
import org.occ.p3.webservice.UserWebServiceWeb;
import org.occ.p3.webservice.Work;
import org.occ.p3.webservice.WorkWebService;
import org.occ.p3.webservice.WorkWebServiceWeb;

 
 
public class WebServiceClient {

	
	public static List<Work> searchingByAuthor(String author){
		
		 
		WorkWebServiceWeb workwebserviceweb = new WorkWebServiceWeb();

		WorkWebService workwebservice = workwebserviceweb.getWorkWebServicePort();
		
		workwebservice.init();
		 List<Work> worksAuthor = workwebservice.findByAuthor(author);
		
		
		 
		
		return worksAuthor;
		
		
	}
	
	
	
	 public static void main(String[] args) {

		WorkWebServiceWeb workwebserviceweb = new WorkWebServiceWeb();
		WorkWebService workwebservice = workwebserviceweb.getWorkWebServicePort();
		workwebservice.init();

		List<Work> worksAuthor = workwebservice.findByAuthor("yuan");
		
		  System.out.println(worksAuthor.get(0).getTitle());
		
		System.out.println("sucess");
		System.out.println(searchingByAuthor("amina").get(1).getTitle());
		;
		
	}



	public Member getMemberById(int memberId) {
		MemberWebServiceWeb memberwebserviceweb = new MemberWebServiceWeb();
		MemberWebService memberwebservice = memberwebserviceweb.getMemberWebServicePort();
		memberwebservice.init();

		
		Member toreturn = memberwebservice.getMemberById(memberId);
		return toreturn;
	}



	public User getUserById(int globalUserMemberId) {
		UserWebServiceWeb userwebserviceweb = new UserWebServiceWeb();
		UserWebService userwebservice = userwebserviceweb.getUserWebServicePort();
		userwebservice.init();
		User toreturn = userwebservice.getUserById(globalUserMemberId);
		return toreturn;
	}



	public User  getUserByName(String userName) {
		UserWebServiceWeb userwebserviceweb = new UserWebServiceWeb();
		UserWebService userwebservice = userwebserviceweb.getUserWebServicePort();
		userwebservice.init();
		User toreturn = userwebservice.getUserByName(userName);
		return toreturn;
	}



	public boolean authentificate(String userName, String password) {
		UserWebServiceWeb userwebserviceweb = new UserWebServiceWeb();
		UserWebService userwebservice = userwebserviceweb.getUserWebServicePort();
		userwebservice.init();
		boolean toreturn = userwebservice.authentificate(userName, password);
		return toreturn;
	}



	public Boolean extendBorrow(int borrowId) {
		BorrowWebServiceWeb borrowwebserviceweb = new BorrowWebServiceWeb();
		BorrowWebService borrowwebservice = borrowwebserviceweb.getBorrowWebServicePort();
		borrowwebservice.init();

		boolean toreturn =	borrowwebservice.extendBorrow(borrowId);
		return toreturn;
	}



	public Boolean endBorrow(int borrowId) {
		BorrowWebServiceWeb borrowwebserviceweb = new BorrowWebServiceWeb();
		BorrowWebService borrowwebservice = borrowwebserviceweb.getBorrowWebServicePort();
		borrowwebservice.init();

		boolean toreturn =	borrowwebservice.endBorrow(borrowId);
		return toreturn;
	}


 


	public boolean borrowBook(int workId, int userId) {
		BorrowWebServiceWeb borrowwebserviceweb = new BorrowWebServiceWeb();
		BorrowWebService borrowwebservice = borrowwebserviceweb.getBorrowWebServicePort();
		borrowwebservice.init();

		boolean toreturn =	borrowwebservice.borrowBook(workId, userId);
		return toreturn;
	}



	public Work getWorkById(int workId) {
		WorkWebServiceWeb workwebserviceweb = new WorkWebServiceWeb();
		WorkWebService workwebservice = workwebserviceweb.getWorkWebServicePort();
		workwebservice.init();
		workwebservice.getWorkById(workId);
		return null;
	}



	 
	 
 
}
