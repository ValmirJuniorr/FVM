package br.com.fvm.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import br.com.fvm.model.Order;
@Stateless 
public class OrderDao {

	@PersistenceContext
	private EntityManager manager;
	// private List<Product> products=null;

	@Transactional
	public void add(Order order) {
		manager.merge(order);
	}
	
	public Order getById(int id) {	
		return this.manager.find(Order.class, id);
	}

	public List<Order> getAll() {
		String query="select i from Order i";
		TypedQuery<Order> orders=this.manager.createQuery(query, Order.class);		
		return orders.getResultList();
	}

	@Transactional
	public void delete(Order order) {
		this.manager.remove(this.manager.contains(order) ? order: manager.merge(order));
	}

	@Transactional
	public void update(Order order) {
		manager.merge(order);
	}


	
}
