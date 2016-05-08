package br.com.fvm.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	@SuppressWarnings("unchecked")
	public List<Item> getAll() {
		Query query = this.manager.createQuery("select i from Item i");
		return query.getResultList();
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
