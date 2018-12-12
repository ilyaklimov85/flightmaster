package org.ilyaklimov.flightmaster;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

@Named
@Stateless
public class UserEJB {
	@PersistenceContext(unitName = "flightmasterPU")
	private EntityManager em;
	
	@NotNull
	public AppUser createUser(@NotNull AppUser user){
		em.persist(user);
		return user;
	}
	
	@NotNull
	public AppUser updateUser(@NotNull AppUser user){
		em.merge(user);
		return user;
	}
	
	public void deleteUser(@NotNull AppUser user){
		em.remove(user);
	}
	
	public List<AppUser> findUsersByLogin(@NotNull String login) {
		return em.createNamedQuery(AppUser.FIND_BY_LOGIN, AppUser.class)
				.setParameter("login", login).getResultList();

	}
	
	public List<AppUser> findAllUsers(){
		return em.createNamedQuery(AppUser.FIND_ALL, AppUser.class).getResultList();
	}
}
