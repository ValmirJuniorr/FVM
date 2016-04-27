package control.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import model.User;
import model.dao.UserDao;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6329060854449082560L;

	@EJB
	private UserDao userDao;

	private User user;
	
	@PostConstruct
	public void init() {
		this.user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public void add() {
		this.userDao.add(user);
		String mensage = "O User: " + user.getName() + " Foi Adicionado!";
		user = new User();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada Com sucesso", mensage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	/*
	 * 
	 * public String delete(Product product) { productDao.delete(product);
	 * return "index?faces-redirect=true";
	 * 
	 * }
	 */

	public void delete(User user) {
		userDao.delete(user);
	}		

	public String editUser() {
		return "editUser";

	}

	public void update() {
		userDao.update(user);
		String mensage = "no update: id:"+user.getId()+ "name: "+ user.getName() + " Foi Atualizado!";
		user = new User();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada Com sucesso", mensage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);

	}

	public List<User> getUsers() {
		return this.userDao.getAll();
	}
	
	public String voltar(){
		return "listUsers";
	}

}