package org.occ.p3.mail;

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
public class MailControler {
	
 
	

	@RequestMapping(value = "/mailControler", method = RequestMethod.GET , params = {"borrow"})
	public ModelAndView Extend(@RequestParam(value="borrow", required = true ) Integer borrowId, HttpServletRequest request) {
		
		return null; 


		 
	}

	 
}
