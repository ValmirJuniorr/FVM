package br.com.fvm.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
	
	public User getById(int id) {	
		return this.manager.find(User.class, id);
	}


	public List<User> getAll() {
		String query="select u from User u";
		TypedQuery<User> users=this.manager.createQuery(query, User.class);		
		return users.getResultList();
	}
	

	@Transactional
	public void delete(User user) {
		this.manager.remove(this.manager.contains(user) ? user : manager.merge(user));
	}
		
	

	@Transactional
	public void update(User user) {
		manager.merge(user);
		
	}

	@Transactional
	public boolean autentic(User user) {
		//String query="select u from User u where";
		Query query=this.manager.createNamedQuery("User.findByLogin");
		query.setParameter("login", user.getLogin());
		User user1=(User) query.getSingleResult();
		if(user1!=null){
			if(user1.getPassword().equals(user.getPassword())){
				return true;
			}			
		}		
		return false;
	}
	

}
