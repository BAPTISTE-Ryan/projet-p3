package org.occ.p3.service;

import javax.jws.WebMethod;
import javax.mail.Session;

public interface BatchService {

 
	public String  send( String to, String sub, String msg);
	public void    mailMethodOne();
	public void    mailMethodTwo();
	public void    mailMethodThree(Session session, String toEmail, String subject, String body);
		
}