package org.occ.p3.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.occ.p3.model.Work;
import org.occ.p3.service.MemberService;
import org.occ.p3.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class WorkControler {

	@Autowired
	MemberService memberservice;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model, HttpServletRequest request) {
		System.out.println("voucher biking chocolate in spoonfed vanilla outRun");

		if (request.getSession().getAttribute("connected") != null
				&& request.getSession().getAttribute("connected").equals("true")) {
			request.getSession().setAttribute("currentBorrows",
					memberservice.getMemberById((Integer) request.getSession().getAttribute("userId"))
							.getCurrentBorrows().toString());
		} else {
			request.getSession().setAttribute("currentBorrows", "");
		}
		return new ModelAndView("mainPAGES.jsp");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView entryPoint(ModelMap model, HttpServletRequest request) {

		if (request.getSession().getAttribute("connected") != null
				&& request.getSession().getAttribute("connected").equals("true")) {
			request.getSession().setAttribute("currentBorrows",
					memberservice.getMemberById((Integer) request.getSession().getAttribute("userId"))
							.getCurrentBorrows().toString());
		} else {
			request.getSession().setAttribute("currentBorrows", "");
		}
		return new ModelAndView("mainPAGES.jsp");
	}

	// loginPage
	@Autowired
	WorkService workservice;

	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap model, HttpServletRequest request) {
		System.out.println("voucher biking chocolate in spoonfed vanilla outRun");
		return new ModelAndView("homePage.jsp");
	}

//
	@RequestMapping(value = "/searchByAuthor", method = RequestMethod.POST)
	public ModelAndView doSearch(HttpServletRequest request) {
		ModelAndView m = new ModelAndView("resultsPAGES.jsp");

		String authorName = request.getParameter("searchAuthor");

		List<Work> works = workservice.findByAuthor(authorName);

		ArrayList work = (ArrayList) works;
		m.addObject("listOfWorks", work);

		return m;
	}

	@RequestMapping(value = "/resultsPage", method = RequestMethod.POST)
	public ModelAndView printHello2(ModelMap model, HttpServletRequest request) {

		request.setAttribute("something", "we have arrived here");

		String author = request.getParameter("search");
		System.out.println("initilization");
		System.out.println(author);
		List<Work> works = workservice.findByAuthor(author);
		System.out.println("after find by author");
		ArrayList ary = (ArrayList) works;

		System.out.println("arfter cast");
		System.out.println(ary.size());
		System.out.println("after size");
		ModelAndView m = new ModelAndView("resultsPage.jsp");
		System.out.println("after model creation");
		System.out.println("________");
		System.out.println("________");
		System.out.println("________");
		System.out.println("________");
		System.out.println(ary.size());
		System.out.println("after size");
		String g = works.get(0).getDescription();
		m.addObject("listOfWorks", works);

		return m;
	}

}
