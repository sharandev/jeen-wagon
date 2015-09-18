package com.jeenwagonweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jeenwagonweb.auth.UserNotFoundException;
import com.jeenwagonweb.entity.User;

/**
 * 
 * @author sharanabasava.d
 *
 */
@Repository("userAccountDao")
public class UserAccountDaoImpl implements UserAccountDAO{
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@Override
	public User getUser(Long userId) {
		
		User user = entityManager.find(User.class, userId);
		return user;
	}

	@Override
	public Long createUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		return user.getId();
	}

	@Override
	public boolean deleteUser(Long userId) {
		
		User user = entityManager.find(User.class, userId);
		entityManager.remove(user);
		return true;
	}

	@Override
	public User updateUser(User user) {
		return entityManager.merge(user);
	}

	@Override
	public User findUserByUserName(String userName) throws UserNotFoundException {
		try {
			String qlString = "SELECT u FROM User u WHERE u.email = ?1";
			TypedQuery<User> query = entityManager.createQuery(qlString, User.class);		
			query.setParameter(1, userName);
	 
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new UserNotFoundException(e);
		}
	}

	@Override
	public List<User> listUsers() {
		return null;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
