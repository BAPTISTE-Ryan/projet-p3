package org.occ.p3.controlersfinal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.occ.p3.webservice.Borrow;
import org.occ.p3.webservice.BorrowWebService;
import org.occ.p3.webservice.BorrowWebServiceWeb;
import org.occ.p3.webservice.MemberWebService;
import org.occ.p3.webservice.MemberWebServiceWeb;
import org.occ.p3.webservice.User;
import org.occ.p3.webservice.UserWebService;
import org.occ.p3.webservice.UserWebServiceWeb;

 

@SuppressWarnings("unused")
@Controller
public class MemberControler {
	/*
	 * SET @@global.time_zone = '+00:00'; SET @@session.time_zone = '+00:00';
	 * SELECT @@global.time_zone, @@session.time_zone;
	 */

	// TODO PUT THESE THINGS IN THE CORRECT SERVICES

	 

//	WebServiceClient borrowService = new WebServiceClient();
	
	//WebServiceClient userService   = new WebServiceClient();

	//WebServiceClient memberservice = new WebServiceClient();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String entryPoint(ModelMap model, HttpServletRequest request) {

		return "login.jsp";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(ModelMap model, HttpServletRequest request) {

		UserWebServiceWeb userwebserviceweb = new UserWebServiceWeb();
		UserWebService userService = userwebserviceweb.getUserWebServicePort();	

 
		MemberWebServiceWeb memberwebserviceweb = new MemberWebServiceWeb();
		MemberWebService memberservice = memberwebserviceweb.getMemberWebServicePort();
		userService.init();	
		memberservice.init();
		ModelAndView m = new ModelAndView();

		if (request.getSession().getAttribute("connected") != null) {
		
			if (request.getSession().getAttribute("userId") != null) {

				Integer globalUserMemberId = (Integer) request.getSession().getAttribute("userId");
				User user = userService.getUserById(globalUserMemberId);

				m.addObject("name", memberservice.getMemberById(globalUserMemberId).getName());
				m.addObject("adress", memberservice.getMemberById(globalUserMemberId).getAddress());
				m.addObject("birthdate", memberservice.getMemberById(globalUserMemberId).getBirthdate());
				m.addObject("email", memberservice.getMemberById(globalUserMemberId).getEmailadress());
				m.addObject("profilepic", memberservice.getMemberById(globalUserMemberId).getProfilePicture());
				if (memberservice.getMemberById(globalUserMemberId).getBorrow().size()!=0) {
					List<Borrow> borrows = user.getBorrow();
					m.addObject("listOfBorrows", borrows);
					
					m.addObject("firstBookTitleBorrow", "");
					m.addObject("firstBookAuthorBorrow", "");
					m.addObject("listOfBorrows", null);
				}

				

				m.setViewName("userPAGES.jsp");

				System.out.println("userPages");
				//System.out.println(memberservice.getMemberById(globalUserMemberId).getCurrentBorrows().toString());
				//request.getSession().setAttribute("currentBorrows",
				//		memberservice.getMemberById((Integer) request.getSession().getAttribute("userId"))
				//				.getCurrentBorrows().toString());
			} else {

				m.setViewName("loginPAGES.jsp");
				System.out.println(" else user option connected: " + request.getSession().getAttribute("connected")
						+ "userId: " + request.getSession().getAttribute("userId"));

			}
		} else {
			m.setViewName("loginPAGES.jsp");
			System.out.println("else connected option connected: " + request.getSession().getAttribute("connected")
					+ " userId: " + request.getSession().getAttribute("userId"));
		}

		return m;
	}

	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public ModelAndView exit(ModelMap model, HttpServletRequest request) {
		ModelAndView m = new ModelAndView();

 
		 
		
		m.setViewName("loginPAGES.jsp");
		request.getSession().setAttribute("connected", false);
		request.getSession().setAttribute("userId", null);
		request.getSession().setAttribute("profilepic", "");

		request.getSession().setAttribute("menu", "Connexion");
		return m;
	}

	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
	public ModelAndView user(ModelMap model, HttpServletRequest request) {

		MemberWebServiceWeb memberwebserviceweb = new MemberWebServiceWeb();
		MemberWebService memberservice = memberwebserviceweb.getMemberWebServicePort();
		memberservice.init();
		
	 
		ModelAndView m = new ModelAndView("userPAGES.jsp");
		System.out.println("before member");
		System.out.println(memberservice.getMemberById(1).getName());
 
		System.out.println("aftermember");
		m.addObject("member", memberservice.getMemberById(1).getName());
		return m;
	}

	@RequestMapping(value = "/authentificate", method = RequestMethod.GET)
	public ModelAndView authentificate(ModelMap model, HttpServletRequest request) {

		UserWebServiceWeb userwebserviceweb = new UserWebServiceWeb();
		UserWebService userService = userwebserviceweb.getUserWebServicePort();	
		userService.init();
		 
		MemberWebServiceWeb memberwebserviceweb = new MemberWebServiceWeb();
		MemberWebService memberservice = memberwebserviceweb.getMemberWebServicePort();
		memberservice.init();
	 
		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		ModelAndView toReturn = new ModelAndView();

		if (userService.authentificate(userName, password)) {
			toReturn.setViewName("mainPAGES.jsp");

			request.getSession().setAttribute("connected", true);
			request.getSession().setAttribute("menu", "Deconnexion");
			Integer userId = userService.getUserByName(userName).getId();

			request.getSession().setAttribute("profilepic", memberservice.getMemberById(userId).getProfilePicture());

			User user = userService.getUserById(userId);
			List<Borrow> borrows = user.getBorrow();
			toReturn.addObject("listOfBorrows", borrows);
			request.getSession().setAttribute("userId", userId);

			request.getSession().setAttribute("userName", userName);
			toReturn.addObject("message", "Connection sucessful with id" + userId);
			toReturn.addObject("userName", "<div></div> <br> -> User :" + userName);
			request.getSession().setAttribute("user", user);
			//request.getSession().setAttribute("currentBorrows",
			//		memberservice.getMemberById((Integer) request.getSession().getAttribute("userId"))
			//				.getCurrentBorrows().toString());

		} else {
			toReturn.setViewName("mainPAGES.jsp");
			toReturn.addObject("message", "This USER and PASSWORD combination does not exist");
			request.getSession().setAttribute("connected", false);
			request.getSession().setAttribute("menu", "Connexion");
			request.getSession().setAttribute("profilepic", "");

		}
		return toReturn;

	}

}
