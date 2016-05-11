package br.com.fvm.model;

import java.util.Date;
import java.util.List;

public class Order {

	private int id;
	
	private Date dateOpen;
	
	private Date dateRealized;
	
	private Date dateIN_ATTENDANCE;
	
	private Date dateDELIVERED;
	
	private State state;
	
	private User user;
	
	private User employee;
	
	
	private List<Product> products;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDateOpen() {
		return dateOpen;
	}


	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}


	public Date getDateRealized() {
		return dateRealized;
	}


	public void setDateRealized(Date dateRealized) {
		this.dateRealized = dateRealized;
	}


	public Date getDateIN_ATTENDANCE() {
		return dateIN_ATTENDANCE;
	}


	public void setDateIN_ATTENDANCE(Date dateIN_ATTENDANCE) {
		this.dateIN_ATTENDANCE = dateIN_ATTENDANCE;
	}


	public Date getDateDELIVERED() {
		return dateDELIVERED;
	}


	public void setDateDELIVERED(Date dateDELIVERED) {
		this.dateDELIVERED = dateDELIVERED;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User getEmployee() {
		return employee;
	}


	public void setEmployee(User employee) {
		this.employee = employee;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
