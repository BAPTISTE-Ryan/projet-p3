package org.occ.p3.controlersfinal;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.occ.p3.webservice.Borrow;
import org.occ.p3.webservice.BorrowWebService;
import org.occ.p3.webservice.BorrowWebServiceWeb;
import org.occ.p3.webservice.User;
import org.occ.p3.webservice.UserWebService;
import org.occ.p3.webservice.UserWebServiceWeb;
import org.occ.p3.webservice.WorkWebService;
import org.occ.p3.webservice.WorkWebServiceWeb;

@Controller
public class BorrowControler {
	
 
	

	@RequestMapping(value = "/Extend", method = RequestMethod.GET , params = {"borrow"})
	public ModelAndView Extend(@RequestParam(value="borrow", required = true ) Integer borrowId, HttpServletRequest request) { 


		 
		BorrowWebServiceWeb borrowwebserviceweb = new BorrowWebServiceWeb();
		BorrowWebService borrowService = borrowwebserviceweb.getBorrowWebServicePort();
		borrowService.init();

		
		ModelAndView modelAndViews = new ModelAndView();
		Boolean borrowExtend = borrowService.extendBorrow(borrowId);
		modelAndViews.addObject("feedBackBorrowMessage","le pr�t de  bien �t� prolong�");
		//request.getSession().setAttribute("currentBorrows", memberservice.getMemberById((Integer) request.getSession().getAttribute("userId")).getCurrentBorrows().toString());
		System.out.println(borrowExtend);
		modelAndViews.setViewName("/borrowlist");
		return modelAndViews;
	}

	
	@RequestMapping(value = "/borrowEnd", method = RequestMethod.GET, params = {"borrow"})
	public ModelAndView borrowEnd(@RequestParam(value="borrow", required = true ) Integer borrowId, HttpServletRequest request) {


		BorrowWebServiceWeb borrowwebserviceweb = new BorrowWebServiceWeb();
		BorrowWebService borrowService = borrowwebserviceweb.getBorrowWebServicePort();
        borrowService.init();

		 
		ModelAndView modelAndViews = new ModelAndView();
		Boolean borrowEnd = borrowService.endBorrow(borrowId);
		System.out.println(borrowEnd);
		modelAndViews.addObject("feedBackBorrowMessage","le pr�t a bien �t� termin�");
		//request.getSession().setAttribute("currentBorrows", memberservice.getMemberById((Integer) request.getSession().getAttribute("userId")).getCurrentBorrows().toString());
		modelAndViews.setViewName("/borrowlist");
		return modelAndViews;
	}

	@RequestMapping(value = "/borrowlist", method = RequestMethod.GET)
	public ModelAndView borrowListMethods(HttpServletRequest request) {

		WorkWebServiceWeb workwebserviceweb = new WorkWebServiceWeb();
		WorkWebService workservice = workwebserviceweb.getWorkWebServicePort();

		UserWebServiceWeb userwebserviceweb = new UserWebServiceWeb();
		UserWebService userService = userwebserviceweb.getUserWebServicePort();	
		
		workservice.init();
		userService.init();
		ModelAndView modelAndView = new ModelAndView("borrowPAGES.jsp");

		int userId = (Integer) request.getSession().getAttribute("userId");

		User user = userService.getUserById(userId);

		List<Borrow> borrows = user.getBorrow();
		List<String> titles = new ArrayList<String>();
		List<String> authors = new ArrayList<String>();
		
		for (int i = 0; i < borrows.size(); i++) {
			System.out.println( borrows.size());
			int workId = borrows.get(i).getBook().getWorkId();
			
			
			
			titles.add(workservice.getWorkById(workId).getAuthor());
			authors.add(workservice.getWorkById(workId).getTitle());
		}
	modelAndView.addObject("titles", titles);
		modelAndView.addObject("authors", authors);
		modelAndView.addObject("listOfBorrows", borrows);


		return modelAndView;
	}
	@RequestMapping(value = "/borrow", method = RequestMethod.GET , params = {"workId"})
	public ModelAndView borrowing(@RequestParam(value="workId", required = true ) Integer workId, HttpServletRequest request) { 



		BorrowWebServiceWeb borrowwebserviceweb = new BorrowWebServiceWeb();
		BorrowWebService borrowService = borrowwebserviceweb.getBorrowWebServicePort();
		borrowService.init();
	
		System.out.println("workId r�cup�re = " + workId);
		ModelAndView modelAndView = new ModelAndView();

		Integer userId = (Integer) request.getSession().getAttribute("userId");



		if (userId != null) {
			userId = (int) userId;
			System.out.println("id:" + userId);
			// use a result page after the borrow
			boolean borrowStatus = borrowService.borrowBook(workId, userId);

			if (borrowStatus == false) {
				modelAndView.addObject("customMessage", "erreur sur le pr�t");
				System.out.println("erreur sur le pr�t");
				modelAndView.setViewName("errorPAGES.jsp");
				return modelAndView;
			}

			modelAndView.setViewName("/borrowlist");
			modelAndView.addObject("feedBackBorrowMessage", "Pr�t du livre r�ussi");

		} else {
			
			String view = "loginPAGES.jsp";
			
			modelAndView.addObject("customMessage", "utilisateur non connect� et vue non retourn�");
			
			modelAndView.setViewName(view);
		}

		return modelAndView;
	}

}
