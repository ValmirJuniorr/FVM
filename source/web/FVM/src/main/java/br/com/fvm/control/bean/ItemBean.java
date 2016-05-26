package br.com.fvm.control.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import br.com.fvm.model.Item;
import br.com.fvm.model.dao.ItemDao;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class ItemBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7806608884326793820L;

	@EJB
	private ItemDao itemDao;

	private Item item;
	
	@PostConstruct
	public void init() {
		this.item = new Item();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}


	public void add() {
		this.itemDao.add(item);
		String mensage = "O item: " + item.getName() + " Foi Adicionado!";
		item = new Item();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operaçãoo Realizada Com sucesso", mensage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	/*
	 * 
	 * public String delete(Product product) { productDao.delete(product);
	 * return "index?faces-redirect=true";
	 * 
	 * }
	 */

	public void delete(Item item) {
		itemDao.delete(item);
	}

	public String editItem() {		
		return "editItem";

	}

	public void update() {
		itemDao.update(item);
		String mensage = "no update: id:"+item.getId()+ "name: "+ item.getName() + " Foi Atualizado!";
		item = new Item();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação Realizada Com sucesso", mensage);
		RequestContext.getCurrentInstance().showMessageInDialog(message);

	}

	public List<Item> getItems() {
		return this.itemDao.getAll();
	}
	
	public String voltar(){
		return "listItems";
	}

}