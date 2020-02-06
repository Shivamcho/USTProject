package com.shivam.gmailspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User_info {

	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int uid;
	private String mun;    //mun=myusername
	private String mnum;
	@Column(unique=true)
	private String email;
	private String password;
	private String squestion;
	private String sanswer;
	 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="uid")
	private List<Mail_info> infolist;


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getMun() {
		return mun;
	}


	public void setMun(String mun) {
		this.mun = mun;
	}


	public String getMnum() {
		return mnum;
	}


	public void setMnum(String mnum) {
		this.mnum = mnum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSquestion() {
		return squestion;
	}


	public void setSquestion(String squestion) {
		this.squestion = squestion;
	}


	public String getSanswer() {
		return sanswer;
	}


	public void setSanswer(String sanswer) {
		this.sanswer = sanswer;
	}


	public List<Mail_info> getInfolist() {
		return infolist;
	}


	public void setInfolist(List<Mail_info> infolist) {
		this.infolist = infolist;
	}


}
