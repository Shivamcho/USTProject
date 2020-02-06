package com.shivam.gmailspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shivam.gmailspring.model.Mail_info;
import com.shivam.gmailspring.model.User_info;
import com.shivam.gmailspring.service.MyService;

@Component
@RequestMapping("/")
public class MyConttroller {

	@Autowired
	MyService ms;


	
	HttpSession ss=null;



	@RequestMapping("/Home")
	public ModelAndView Home(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Home","user",email);
	}else{
		return new ModelAndView("Login","msg","Login First");
	}
	}
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest req) {

		return new ModelAndView("Register");
	}
	@RequestMapping("/Register")
	public String reg() {
		return "Register";
	}

	@RequestMapping(value="/UserRegistration",method=RequestMethod.POST)
	public ModelAndView UserRegistration(@ModelAttribute User_info udto) {
		boolean b=ms.UserRegistration(udto);
		if(b) {
			return new ModelAndView("Register","msg","User is  registered Sucessfully......");
		}
		else
		{
			return new ModelAndView("Register","msg","User is already registered........");
		}
	}

	
	@RequestMapping("/Login")
	public String log() {
		return "Login";
	}


	@RequestMapping(value="/UserLogin",method=RequestMethod.POST)
	public ModelAndView UserLogin(HttpServletRequest req) {

		boolean  b=ms.UserLogin(req);
		if(b) {
			String email=req.getParameter("email");

			ss=req.getSession();
			ss.setAttribute("email", email);
			String user=(String) ss.getAttribute("email");
			System.out.println("Success");
			return  new ModelAndView("Home","user",user);
		}
		else {
			System.out.println("Failed");
			return new ModelAndView("Login","msg","Invalid Id or Password");
		}
	}
	

	@RequestMapping("/Compose")
	public ModelAndView compose(HttpServletRequest req) {
		//  ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Compose");	
	}else{return new ModelAndView("Login","msg","Please Login First");
		}
	}

	@RequestMapping(value="/Compose",method=RequestMethod.POST)
	public ModelAndView Compose(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		boolean b=ms.Compose(req);
		if(email!=null){

		if(b){
			return new ModelAndView("Home","msg","Mail Successfull Sent");
		}else {
			if(email!=null) {
		
				return new ModelAndView("Home","msg","Mail did not Sent");
			}else
			{
				return new ModelAndView("Login","msg","Please Login First");
			}}}else{
				return new ModelAndView("Login","msg","Please Login First");
			}
		}
	
	

	@RequestMapping("/SentInbox")
	public ModelAndView sentInbox(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		List<Mail_info>mlist=ms.sentInbox(email);
		return new ModelAndView("SentEmail","mlist",mlist);
	}else{
		return new ModelAndView("Login","msg","Login First");	
	}
	}
	@RequestMapping("/Inbox")
	public ModelAndView Inbox(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		List<Mail_info>mlist=ms.inbox(email);
		return new ModelAndView("Inbox","mlist",mlist);
	}else{
		return new ModelAndView("Login","msg","Login First");
	}
	}
	@RequestMapping("/Draft")
	public ModelAndView draft(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		List<Mail_info>mlist=ms.draft(email);
		return new ModelAndView("Draft","mlist",mlist);
	}else{
		return new ModelAndView("Login","msg","Login First");
	}
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req) {
		ss=req.getSession(false);
		ss.invalidate();

		return new ModelAndView("ind","logout","Logout Sucessfull......");
	}
	

	@RequestMapping("/forget")
	public ModelAndView forget(HttpServletRequest req) {

		return new ModelAndView("forget");
	}

	@RequestMapping(value="/forgetpassword",method = RequestMethod.POST)
	public ModelAndView forgetpassword(HttpServletRequest req) {
		
		ss=req.getSession(false);
		boolean b=ms.forgetpassword(req);
		if(b) {
			return new ModelAndView("forget","msg","password changed");
		}
		else
		{
			return new ModelAndView("forget","msg","Invalid credintials or password not matched");

		}
	}
	
	@RequestMapping("/changepass")
	public ModelAndView changepass(HttpServletRequest req) {
		req.getSession(false);
		String email=(String)req.getAttribute("email");
		return new ModelAndView("changepass","email",email);
	}

	@RequestMapping(value="/changepassword",method = RequestMethod.POST)
	public ModelAndView changepassword(HttpServletRequest req) {
		ss=req.getSession(false);

		boolean b=ms.changepassword(req);
		if(b) {
			return new ModelAndView("changepass","msg","password changed successfully");
		}
		else
		{
			return new ModelAndView("changepass","msg","Password Not Matched");

		}
	}
	

	@RequestMapping("/deletedmsginhome")
	public ModelAndView deletemessage(HttpServletRequest req) {
		ss=req.getSession(false);
		String email=(String) ss.getAttribute("email");
		if(email!=null){
		List<Mail_info>mlist=ms.deletemessage(email);
		for (Mail_info dto : mlist) {
			System.out.println("from  "+dto.getMusent()+"  "+" deleted message"+dto.getMuinbox()  +""+dto.getMusub());
		}
		return new ModelAndView("deletedmsginhome","mlist",mlist);
		}else{
		return new ModelAndView("Login","msg","Please Login First....");
	}
		}

	@RequestMapping("/deletemsg")
	public ModelAndView deletemsg(@RequestParam int msgid,HttpServletRequest req) {
		
		ss=req.getSession(false);
		System.out.println("my session "+ss);
		String email=(String) ss.getAttribute("email");
      if(email!=null){
    	  
		boolean b=ms.deletemsg(msgid);

		if(b) 
		{
			return new ModelAndView("Home","msg","message deleted successfully");
		}
		else
		{
			return new ModelAndView("Home","msg","message Not  deleted ");

		}
      }else{
    	  return new ModelAndView("Login","msg","Please Login First....");
      }
	}
	
	@RequestMapping("/fullinbox")
	public ModelAndView fullinbox(@RequestParam int ibid) {
		String email=(String) ss.getAttribute("email");
		
		Mail_info mdto=ms.fullinbox(ibid);
		
		if(mdto!=null) 
		{
			return new ModelAndView("fullinbox","mdto",mdto);
		}
		else
		{
			return new ModelAndView("Home","msg","No message was found ");

		}
		
	}
	@RequestMapping("/Composedraft")
	public ModelAndView Composedraft(@RequestParam int ibid){
	String email=(String) ss.getAttribute("email");
		
		Mail_info mdto=ms.fullinbox2(ibid);
		
		if(mdto!=null) 
		{
			return new ModelAndView("Compose","mdto",mdto);
		}
		else
		{
			return new ModelAndView("Home","msg","No message was found ");

		}
		
	}
	@RequestMapping("/permanentdelete")
	public ModelAndView permanentdelete(@RequestParam int did){
		
		boolean b =ms.permanentdeletmail(did);
		
		if(b) 
		{
			return new ModelAndView("Home","msg","message deleted successfully");
		}
		else
		{
			return new ModelAndView("Home","msg","message Not  deleted ");

		}
		
	}
}
	
	
	
	
	



