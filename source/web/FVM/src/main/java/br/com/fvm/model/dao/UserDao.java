package br.com.fvm.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.fvm.model.User;

@Stateless
public class UserDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void add(User user) {
		manager.merge(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		Query query = this.manager.createQuery("select u from User u");
		return query.getResultList();
	}
	

	@Transactional
	public void delete(User user) {
		this.manager.remove(this.manager.contains(user) ? user : manager.merge(user));
	}
		
	

	@Transactional
	public void update(User user) {
		manager.merge(user);
		
	}
	

}
