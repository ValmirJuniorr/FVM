package fvm.model.dao.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fvm.model.Product;

@Stateless
public class ProductRepository {

	@PersistenceContext
	private EntityManager manager;

	public void add(Product product) {
		manager.persist(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		Query query = this.manager.createQuery("select p from Product p");
		return query.getResultList();
	}
}
