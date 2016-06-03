package br.com.fvm.control.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class Msgs implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5438015666249602664L;
	private String welcome;
	
	@PostConstruct
	private void init(){
		this.welcome="Bem Vindo ao FVM";
	}
	

	public String getWelcome() {
		return this.welcome;
	}
}
