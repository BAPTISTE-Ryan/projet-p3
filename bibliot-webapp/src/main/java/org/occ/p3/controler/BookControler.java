package org.occ.p3.controler;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.occ.p3.model.Book;
import org.occ.p3.service.BookService;
import org.occ.p3.model.User;
import org.occ.p3.model.Work;
import org.occ.p3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookControler {

	@Autowired
	BookService bookService;
	/*
	@RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)

    public @ResponseBody Work sayHello (@PathVariable Integer workId) {
        return bookService.getworkById(workId);
        
    }
    */	
	// TODO MAKE SEARCH BOOKS WITH FILTERS 

	 
	
	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public String printHello2(ModelMap model, HttpServletRequest request) {

		String author="laura";
		String title="romance novel";
		String type="novel";
		String publicationyear="2002";
	/*
	 List<Work> b = (ArrayList)bookService.FindByworkAuthor(author);
	 System.out.println(b.get(0).getTitle());
	 System.out.println(b.get(1).getTitle());
	 +bookService.FindByworkTitle(title).getId().toString() 
	 +bookService.FindByworkType(type).getId().toString()
	 +bookService.FindByworkYear(publicationyear).getId().toString()
	 */
		
		return "mainPage.jsp";
	}
 
	
 
	
 
	
	
	
}
