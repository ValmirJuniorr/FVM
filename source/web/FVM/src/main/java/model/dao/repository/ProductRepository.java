package model.dao.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.Product;

@Stateless
public class ProductRepository {

	@PersistenceContext
	private EntityManager manager;
	//private List<Product> products=null;
	

	@Transactional
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
	
/*
	public void setProducts(List<Product> products) {
		this.products = products;
	}	*/

	
}
