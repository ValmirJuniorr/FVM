package br.com.fvm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="fvm",name = "Items")
@SequenceGenerator(name = "ItemSequence", sequenceName = "SQ_ID_ITEM", allocationSize = 1, schema="fvm")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemSequence")
	@Column(name="Id_Item")
	private int id;
	
	@Column(name = "Name_Item")
	private String name;
	
	@Column(name = "Description_Product")
	private String description;
	
	@Column(name = "Price_Item")
	private Double price;	
	
	@ManyToMany(mappedBy = "items")
	private List<Product> products;
	
		
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
	
}
