package br.com.fvm.model;

import java.io.Serializable;
import java.util.List;


public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7109942876923812085L;

	
	private int id;

	private String name;

	private String description;
	
	private Double price;
	
	private List<Item> items;
	
	private List<Item> itemsAdditional;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}	
	

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

	public List<Item> getItemsAdditional() {
		return itemsAdditional;
	}

	public void setItemsAdditional(List<Item> itemsAdditional) {
		this.itemsAdditional = itemsAdditional;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + "]";
	}
	
	

}
