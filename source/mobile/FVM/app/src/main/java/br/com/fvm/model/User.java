package br.com.fvm.model;

public class User {
	
		
	private int Id;
	
	private String name;
	
	private String email;
	
	private String login;
	
	private String passowrd;
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", email=" + email + ", login=" + login + ", passowrd=" + passowrd
				+ "]";
	}
	
	

}
