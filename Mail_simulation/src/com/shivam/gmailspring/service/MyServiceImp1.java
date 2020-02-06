package com.shivam.gmailspring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shivam.gmailspring.dao.MyDAO;
import com.shivam.gmailspring.model.Mail_info;
import com.shivam.gmailspring.model.User_info;
@Component
public class MyServiceImp1 implements MyService{
 @Autowired
 MyDAO mdao;
	@Override
	public boolean UserRegistration(User_info udto) {
		// TODO Auto-generated method stub
		boolean b=mdao.UserRegistration(udto);
		return b;
	}
	@Override
	public boolean UserLogin(HttpServletRequest req) {
		// TODO Auto-generated method stub
	    boolean	b=mdao.UserLogin(req);
		
		return b;
	}
	@Override
	public boolean Compose(HttpServletRequest req) {
		// TODO Auto-generated method stub
		boolean b=mdao.Compose(req);
		return b;
	}
	@Override
	public List<Mail_info> sentInbox(String email) {
		// TODO Auto-generated method stub
		
		return mdao.sentInbox(email);
	}
	@Override
	public List<Mail_info> inbox(String email) {
		
		return mdao.inbox(email);
	}
	@Override
	public List<Mail_info> draft(String email) {

		return mdao.draft(email);
	}
	
	public boolean forgetpassword(HttpServletRequest req) {
		
		boolean b=mdao.forgetpassword(req);
		return b;
	}
	@Override
	public boolean changepassword(HttpServletRequest req) {
		boolean b=mdao.changepassword(req);
		return b;
	}
	@Override
	public List<Mail_info> deletemessage(String email) {
		
		return mdao.deletemessage(email);
	}
	@Override
	public boolean deletemsg(int mid) {
		
		
		return mdao.deletemsg(mid);
	}
	@Override
	public Mail_info fullinbox(int ibid) {
		
		return mdao.fullinbox(ibid);
	}
	@Override
	public boolean permanentdeletmail(int did) {
		// TODO Auto-generated method stub
		return mdao.permanentdeletmail(did);
	}
	@Override
	public Mail_info fullinbox2(int ibid) {
		// TODO Auto-generated method stub
		return mdao.fullinbox2(ibid);
	}

	
	

}
