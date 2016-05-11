package br.com.fvm.model;

import java.util.List;


public class Item {

	private int id;
	
	private String name;
	
	private String description;
	
	private Double price;	
	
	private List<Product> products;
	
	private List<Product> productsCustom;
	
	
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Product> getProductsCustom() {
		return productsCustom;
	}
	public void setProductsCustom(List<Product> productsCustom) {
		this.productsCustom = productsCustom;
	}
	
	
	

}
