package control.bean;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Item;
import model.dao.ItemDao;

import java.io.IOException;
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
	
	private Item item=new Item();

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public void add() {
		this.itemDao.add(item);
		item = new Item();
		//return "/index?faces-redirect=true";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listItem.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*

	public String delete(Product product) {
		productDao.delete(product);
		return "index?faces-redirect=true";

	}*/
	
	public void delete(Item item) {
		itemDao.delete(item);
	}

	public void update() {
		itemDao.update(item);
	}
	
	public List<Item> getItems(){
		return this.itemDao.getAll();
	}
	
	private String goToList() {
		return "/admin/item/listItem";

	}
	
	private String goToAdd() {
		return "/admin/item/addItem";

	}


}