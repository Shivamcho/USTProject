package com.shivam.gmailspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mail_info {
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int infid;
	private String muinbox;
	private String musent;
	private String mudraft;
	private String mudelete;			//mu=myuser
	private String muto;
	private String musub;
	public int getInfid() {
		return infid;
	}
	public void setInfid(int infid) {
		this.infid = infid;
	}
	public String getMuinbox() {
		return muinbox;
	}
	public void setMuinbox(String muinbox) {
		this.muinbox = muinbox;
	}
	public String getMusent() {
		return musent;
	}
	public void setMusent(String musent) {
		this.musent = musent;
	}
	public String getMudraft() {
		return mudraft;
	}
	public void setMudraft(String mudraft) {
		this.mudraft = mudraft;
	}
	public String getMudelete() {
		return mudelete;
	}
	public void setMudelete(String mudelete) {
		this.mudelete = mudelete;
	}
	public String getMuto() {
		return muto;
	}
	public void setMuto(String muto) {
		this.muto = muto;
	}
	public String getMusub() {
		return musub;
	}
	public void setMusub(String musub) {
		this.musub = musub;
	}
	
	

	

	
	  
}
