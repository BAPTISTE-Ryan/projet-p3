package org.occ.p3.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.occ.p3.consumer.repository.BookRepository;
import org.occ.p3.consumer.repository.BorrowRepository;
import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Borrow;
import org.occ.p3.model.User;
import org.occ.p3.model.Work;
import org.occ.p3.service.BorrowService;
import org.occ.p3.service.MemberService;
import org.occ.p3.service.UserService;
import org.occ.p3.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BorrowControler {

	@Autowired
	BorrowService borrowService;

	
	
	
	
	@Autowired
	UserService userService;

	
	
	
	@Autowired
	WorkService workservice;


	@Autowired
	MemberService memberservice;
	
	
	

	@RequestMapping(value = "/Extend", method = RequestMethod.GET , params = {"borrow"})
	public ModelAndView Extend(@RequestParam(value="borrow", required = true ) Integer borrowId, HttpServletRequest request) { 
		ModelAndView modelAndViews = new ModelAndView();
		Boolean borrowExtend = borrowService.extendBorrow(borrowId);
		modelAndViews.addObject("feedBackBorrowMessage","le prêt de  bien été prolongé");
		request.getSession().setAttribute("currentBorrows", memberservice.getMemberById((Integer) request.getSession().getAttribute("userId")).getCurrentBorrows().toString());
		
		modelAndViews.setViewName("/borrowlist");
		return modelAndViews;
	}

	
	@RequestMapping(value = "/borrowEnd", method = RequestMethod.GET, params = {"borrow"})
	public ModelAndView borrowEnd(@RequestParam(value="borrow", required = true ) Integer borrowId, HttpServletRequest request) {
		ModelAndView modelAndViews = new ModelAndView();
		Boolean borrowEnd = borrowService.endBorrow(borrowId);
		modelAndViews.addObject("feedBackBorrowMessage","le prêt a bien été terminé");
		request.getSession().setAttribute("currentBorrows", memberservice.getMemberById((Integer) request.getSession().getAttribute("userId")).getCurrentBorrows().toString());
		modelAndViews.setViewName("/borrowlist");
		return modelAndViews;
	}

	@RequestMapping(value = "/borrowlist", method = RequestMethod.GET)
	public ModelAndView borrowListMethods(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("borrowPAGES.jsp");

		Integer userId = (Integer) request.getSession().getAttribute("userId");

		User user = userService.getUserById(userId);

		List<Borrow> borrows = user.getBorrow();
		List<String> titles = new ArrayList<String>();
		List<String> authors = new ArrayList<String>();
		for (int i = 0; i < borrows.size(); i++) {
			Integer workId = borrows.get(i).getBook().getWorkId();
			titles.add(workservice.getWorkById(workId).getAuthor());
			authors.add(workservice.getWorkById(workId).getTitle());
		}
		request.getSession().setAttribute("currentBorrows", memberservice.getMemberById((Integer) request.getSession().getAttribute("userId")).getCurrentBorrows().toString());
		modelAndView.addObject("titles", titles);
		modelAndView.addObject("authors", authors);
		modelAndView.addObject("listOfBorrows", borrows);


		return modelAndView;
	}
	@RequestMapping(value = "/borrow", method = RequestMethod.GET , params = {"workId"})
	public ModelAndView borrowing(@RequestParam(value="workId", required = true ) Integer workId, HttpServletRequest request) { 
	
	
		System.out.println("workId récupére = " + workId);
		ModelAndView modelAndView = new ModelAndView();

		Integer userId = (Integer) request.getSession().getAttribute("userId");

		// loijmodelAndView.setViewName("userPAGES.jsp");

		if (userId != null) {

			System.out.println("id:" + userId);
			// use a result page after the borrow
			boolean borrowStatus = borrowService.borrowBook(workId, userId);

			if (borrowStatus == false) {
				modelAndView.addObject("customMessage", "erreur sur le prêt");
				System.out.println("erreur sur le prêt");
				modelAndView.setViewName("errorPAGES.jsp");
				return modelAndView;
			}

			request.getSession().setAttribute("currentBorrows", memberservice.getMemberById((Integer) request.getSession().getAttribute("userId")).getCurrentBorrows().toString());
			modelAndView.setViewName("/borrowlist");
			modelAndView.addObject("feedBackBorrowMessage", "Prêt du livre réussi");

		} else {
			String view = "loginPAGES.jsp";
			System.out.println(view);
			modelAndView.addObject("customMessage", "utilisateur non connecté et vue non retourné");
			System.out.println("no user was logged in ");
			modelAndView.setViewName(view);
		}

		return modelAndView;
	}

}
