package org.ilyaklimov.flightmaster;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

@Stateless
public class UserEJB {
	@PersistenceContext(unitName = "flightmasterPU")
	EntityManager em;
	
	@NotNull
	public User createUser(@NotNull User user){
		em.persist(user);
		return user;
	}
	
	@NotNull
	public User updateUser(@NotNull User user){
		em.merge(user);
		return user;
	}
	
	public void deleteUser(@NotNull User user){
		em.remove(user);
	}
	
	public User findUserByLogin(@NotNull String login){
		return em.createNamedQuery("", User.class).setParameter("login", login).getSingleResult();
		
	}
}
