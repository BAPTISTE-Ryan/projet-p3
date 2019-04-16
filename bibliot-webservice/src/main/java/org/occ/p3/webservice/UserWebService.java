package org.occ.p3.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Member;
import org.occ.p3.model.User;
import org.occ.p3.model.Work;
import org.occ.p3.service.MemberService;
import org.occ.p3.service.UserService;
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
@WebService(serviceName = "UserWebServiceWeb", name = "UserWebService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class UserWebService {

	@Autowired
	UserService userservice;

	@WebMethod
	public User getUserById(int userId) {
		return userservice.getUserById(userId);
	}

	@WebMethod
	public User getUserByName(String userName) {
		return userservice.getUserByName(userName);
	}

	@WebMethod
	public User getUserByPassword(int userPassword) {
		return userservice.getUserByPassword(userPassword);
	}

	@WebMethod
	public User saveNewUser(User user) {
		return userservice.saveNewUser(user);
	}

	@WebMethod
	public boolean authentificate(String user, String password) {
		return userservice.authentificate(user, password);
	}

	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}
