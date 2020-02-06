package com.shivam.gmailspring.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shivam.gmailspring.model.Mail_info;
import com.shivam.gmailspring.model.User_info;

@Component
public class MyDAOImp1 implements MyDAO{
	@Autowired
	SessionFactory sf;

	HttpSession ss=null;

	@Override
	public boolean UserRegistration(User_info udto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("email", udto.getEmail()));
		User_info dto=(User_info) cr.uniqueResult();
		if(dto==null) {
			ss.save(udto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else
		{
			return false;
		}

	}

	
	@Override
	public boolean UserLogin(HttpServletRequest req) {
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		Session ss=sf.openSession();
		Criteria cr =ss.createCriteria(User_info.class);
		cr.add(Restrictions.eq("password",password));
		cr.add(Restrictions.eq("email",email));
		User_info udto=(User_info) cr.uniqueResult();
		ss.beginTransaction().commit();
		ss.close();
		if(udto!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean Compose(HttpServletRequest req) {

		String	toemail=req.getParameter("email");
		String inbox=	req.getParameter("muinbox");
		String sub=req.getParameter("musub");
		this.ss=req.getSession(false);
		String useremail=(String) this.ss.getAttribute("email");
		Session ss=sf.openSession();

		Mail_info mdto=null;

		if(useremail!=null) {

			Query qry=ss.createQuery("from User_info where email='"+toemail+"'");
			User_info udto=(User_info) qry.uniqueResult();

			List<Mail_info>mlist;


			if(udto!=null) {
				mdto=new Mail_info();
				mdto.setMuto(toemail);
				mdto.setMuinbox(inbox);
				mdto.setMusent(useremail);
				mdto.setMusub(sub);

				mlist=udto.getInfolist();
				mlist.add(mdto);
				ss.saveOrUpdate(udto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}else {
				mdto=new Mail_info();
				mdto.setMudraft(toemail);
				mdto.setMusent(useremail);
				mdto.setMuinbox(inbox);
				mdto.setMusub(sub);
				qry=ss.createQuery("from User_info where email='"+useremail+"'");
				udto=(User_info) qry.uniqueResult();
				mlist=udto.getInfolist();
				mlist.add(mdto);
				ss.saveOrUpdate(udto);
				ss.beginTransaction().commit();
				ss.close();
				return false;
			}
		}
		else
		{
			ss.close();
			return false;
		}
	}
	
	@Override
	public List<Mail_info> sentInbox(String email) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("musent", email));
		cr.add(Restrictions.isNotNull("muinbox"));
		cr.add(Restrictions.isNull("mudraft"));
	//	cr.add(Restrictions.isNotNull("muinbox"));
		cr.add(Restrictions.isNull("mudelete"));
		List<Mail_info>mlist=cr.list();
		ss.close();
		return mlist;
	}
	
	@Override
	public List<Mail_info> inbox(String email) {

		Session ss=sf.openSession();
		System.out.println("em="+email);
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("muto",email));
		cr.add(Restrictions.isNull("mudraft"));
		//cr.add(Restrictions.ne("mudelete",));
		
		List<Mail_info>mlist=cr.list();
		ss.close();
		return mlist;
	}
	
	@Override
	public List<Mail_info> draft(String email) {

		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("musent", email));
		cr.add(Restrictions.isNull("mudelete"));
		cr.add(Restrictions.isNull("muto"));
		cr.add(Restrictions.isNotNull("mudraft"));
		List<Mail_info>mlist=cr.list();
		ss.close();
		return mlist;

	}

	public boolean forgetpassword(HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String squestion=req.getParameter("squestion");
		String sanswer=req.getParameter("sanswer");
		String newpassword=req.getParameter("newpassword");
		String confirmpassword=req.getParameter("confirmpassword");

		if(confirmpassword.equals(newpassword)) {
			Criteria cr=ss.createCriteria(User_info.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("squestion", squestion));
			cr.add(Restrictions.eq("sanswer", sanswer));
			User_info udto=(User_info) cr.uniqueResult();
			if(udto!=null){
				
			udto.setPassword(newpassword);
			ss.saveOrUpdate(udto);
			ss.beginTransaction().commit();
			return true;
			}
		else
		{
			return false;
			
		}
		}
		else
		{
			return false;
		}

	}
	
	@Override
	public boolean changepassword(HttpServletRequest req) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String newpw=req.getParameter("newpassword");
		String conpw=req.getParameter("confirmpassword");

		if(conpw.equals(newpw)) {
			Criteria cr=ss.createCriteria(User_info.class);
			cr.add(Restrictions.eq("email", email));
			User_info dto=(User_info) cr.uniqueResult();

			if(dto!=null) {
				dto.setPassword(newpw);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public List<Mail_info> deletemessage(String email) {

		Session ss=sf.openSession();
		Query qry=ss.createQuery("from Mail_info where (muto!='"+null+"' or muto!='"+email+"' or musent='"+email+"') and mudelete ='deleted' and mudelete!='permanentdelet' ");
		List<Mail_info>mlist=qry.list();
		
		/*Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("muto", email));
		cr.add(Restrictions.eq("mudelete","deleted"));	
		cr.add(Restrictions.isNull("mudraft"));
		List<Mail_info>mlist=cr.list();*/
		ss.close();
		return mlist;

	}

	

	@Override
	public boolean deletemsg(int mid) {

		Session ss=sf.openSession();
		
		System.out.println("msgid= "+mid);

		Mail_info mdto=ss.load(Mail_info.class, mid);

		if(mdto!=null) {
			String delmsg=	mdto.getMuinbox();

			System.out.println("msgid= "+delmsg);
			mdto.setMudelete("deleted");
			

			ss.saveOrUpdate(mdto);
			ss.beginTransaction().commit();

			ss.close();
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Mail_info fullinbox(int ibid) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("infid",ibid));
		cr.add(Restrictions.isNull("mudelete"));
		
		Mail_info mdto=(Mail_info) cr.uniqueResult();
		
		ss.close();

		return mdto;
	}


	@Override
	public boolean permanentdeletmail(int did) {
Session ss=sf.openSession();
		
		

		Mail_info mdto=ss.load(Mail_info.class, did);

		if(mdto!=null) {
			String delmsg=	mdto.getMuinbox();

			
			mdto.setMudelete("permanentdelet");
			

			ss.saveOrUpdate(mdto);
			ss.beginTransaction().commit();

			ss.close();
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public Mail_info fullinbox2(int ibid) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Mail_info.class);
		cr.add(Restrictions.eq("infid",ibid));
		cr.add(Restrictions.isNull("mudelete"));
		
		Mail_info mdto=(Mail_info) cr.uniqueResult();
		mdto.setMudelete("senddraft");
		
		ss.saveOrUpdate(mdto);
		ss.beginTransaction().commit();

		
		ss.close();
		return mdto;
		
	
	}





	

	
	
}
