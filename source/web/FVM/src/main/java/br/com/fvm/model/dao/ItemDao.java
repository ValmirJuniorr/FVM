package br.com.fvm.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.fvm.model.Item;

@Stateless
public class ItemDao {

	@PersistenceContext
	private EntityManager manager;
	// private List<Product> products=null;

	@Transactional
	public void add(Item item) {
		manager.merge(item);
	}
	
	public Item getById(int id) {	
		return this.manager.find(Item.class, id);
	}

	public List<Item> getAll() {
		String query="select i from Item i";
		TypedQuery<Item> items=this.manager.createQuery(query, Item.class);		
		return items.getResultList();		
	}
	public List<Item> getAllEager() {
		String query="select item from Item item join fetch item.products";
		TypedQuery<Item> items=this.manager.createQuery(query, Item.class);		
		return items.getResultList();
	}

	@Transactional
	public void delete(Item item) {
		this.manager.remove(this.manager.contains(item) ? item : manager.merge(item));
	}

	@Transactional
	public void update(Item item) {
		manager.merge(item);
	}

	/*
	 * public void setProducts(List<Product> products) { this.products =
	 * products; }
	 */

}
