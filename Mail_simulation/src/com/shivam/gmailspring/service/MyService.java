package com.shivam.gmailspring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shivam.gmailspring.model.Mail_info;
import com.shivam.gmailspring.model.User_info;

public interface MyService {

	public boolean UserRegistration(User_info udto);

	public boolean Compose(HttpServletRequest req);
	
	public List<Mail_info> sentInbox(String email);
	
	public boolean UserLogin(HttpServletRequest req);
	
	public List<Mail_info> inbox(String email);
	
	public List<Mail_info> draft(String email);
	
	public boolean forgetpassword(HttpServletRequest req);
	
	public boolean changepassword(HttpServletRequest req);
	
	public List<Mail_info> deletemessage(String email);
	boolean deletemsg(int mid);

	public Mail_info fullinbox(int ibid);

	public boolean permanentdeletmail(int did);

	public Mail_info fullinbox2(int ibid);

	

	

	

	
}

