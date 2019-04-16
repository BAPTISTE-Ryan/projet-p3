package org.occ.p3.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Work;
import org.occ.p3.service.MemberService;
import org.occ.p3.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Service
@WebService(serviceName = "WorkWebServiceWeb",name = "WorkWebService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class WorkWebService {

	
 
	@Autowired
	WorkService workservice;

 
	 
	@WebMethod
	public List<Work> findByAuthor(String author) {
		return workservice.findByAuthor(author);
		 
	} 
	
	@WebMethod
	public Work getWorkById(int workId) {
		return workservice.getWorkById(workId);
		 
	} 
	 
	
	    @PostConstruct
	    public void init() {
	        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	    }
}
