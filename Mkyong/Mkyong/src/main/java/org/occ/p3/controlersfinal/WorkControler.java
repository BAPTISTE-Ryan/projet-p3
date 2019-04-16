
package org.occ.p3.controlersfinal;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.occ.p3.webservice.BatchWebService;
import org.occ.p3.webservice.BatchWebServiceWeb;
import org.occ.p3.webservice.Work;
import org.occ.p3.webservice.WorkWebService;
import org.occ.p3.webservice.WorkWebServiceWeb;

@Controller
public class WorkControler {
	

	//WebServiceClient memberservice = new WebServiceClient();
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model, HttpServletRequest request) {
		 
//		
		BatchWebServiceWeb batchwebserviceweb = new BatchWebServiceWeb();
		BatchWebService batchwebservice = batchwebserviceweb.getBatchWebServicePort();
		batchwebservice.init();

		try {
			batchwebservice.send("mr.ryan.baptiste@gmail.com", "javatpoint", "probiotic");
			System.out.println("iteration 0 : send2 illegal impl access ");
		} catch (Exception e) {
			System.out.println(e);
			try {
				batchwebservice.send1("mr.ryan.baptiste@gmail.com", "javatpoint", "probiotic");
				System.out.println("iteration 1 : send2 illegal impl access ");
			} catch (Exception f) {
				System.out.println(f);

				try {
					batchwebservice.send2("mr.ryan.baptiste@gmail.com", "javatpoint", "probiotic");
					System.out.println("iteration 2 : send2 illegal impl access ");
				} catch (Exception g) {

					System.out.println(g);

					System.out.println("iteration failed");
				}
			}
		}
		 
		return new ModelAndView("mainPAGES.jsp");
	}
 
 
 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView entryPoint(ModelMap model, HttpServletRequest request) {

//		if (request.getSession().getAttribute("connected") != null
//				&& request.getSession().getAttribute("connected").equals("true")) {
//			request.getSession().setAttribute("currentBorrows",
//					memberservice.getMemberById((Integer) request.getSession().getAttribute("userId"))
//							.getCurrentBorrows().toString());
//		} else {
//			request.getSession().setAttribute("currentBorrows", "");
//		}
		return new ModelAndView("mainPAGES.jsp");
	}
 
 


	 

	
	
 

	@RequestMapping(value = "/searchByAuthor", method = RequestMethod.POST)
	public ModelAndView doSearch(HttpServletRequest request) {
		
		WorkWebServiceWeb workwebserviceweb = new WorkWebServiceWeb();
		WorkWebService workwebservice = workwebserviceweb.getWorkWebServicePort();
		workwebservice.init();
			
			
		ModelAndView m = new ModelAndView("resultsPAGES.jsp");

		String authorName = request.getParameter("searchAuthor");

		//List<Work> works = workservice.findByAuthor(authorName);
		
		List<Work> works = workwebservice.findByAuthor(authorName);
		ArrayList<Work> work = (ArrayList<Work>) works;
		m.addObject("listOfWorks", work);
		System.out.println("authorName : "+authorName);
		return m;
	}

	
	
	
 

}
