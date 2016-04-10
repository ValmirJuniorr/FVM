package model.dao.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Product;

@Stateless
public class ProductRepository {

	@PersistenceContext
	private EntityManager manager;
	//private List<Product> products=null;
	

	
	public void add(Product product) {
		manager.merge(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		Query query = this.manager.createQuery("select p from Product p");
		return query.getResultList();
	}
	
	public List<Product> getProducts() {
		/*if(products==null){
		setProducts(getAll());
		}
		return products;*/
		return getAll();
	}

	public void delete(Product product) {
		manager.remove(manager.contains(manager.contains(product) ? product : manager.merge(product)));
		System.out.println("oi ta auqi");
	}
		
	

	public void update(Product product) {
		manager.merge(product);
		
	}
	
/*
	public void setProducts(List<Product> products) {
		this.products = products;
	}	*/

	
}
