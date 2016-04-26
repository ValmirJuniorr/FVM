package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="fvm",name = "Products")
@SequenceGenerator(name = "ProductSequence", sequenceName = "SQ_ID_PRODUCT", allocationSize = 1)
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7109942876923812085L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSequence")
	@Column(name = "Id_Product")
	private int id;

	@Column(name = "Name_Product")
	private String name;

	@Column(name = "Description_Product")
	private String description;
	
	@Column(name = "Price_Product")
	private Double price;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Itens_Products")
	private List<Item> items;

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

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + "]";
	}
	
	

}
