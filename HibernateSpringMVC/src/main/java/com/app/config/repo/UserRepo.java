package com.app.config.repo;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.config.entity.User;

@Repository
public class UserRepo {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public Optional<User> getUser(String userName) {
		
		User user = (User) entityManager.createQuery("SELECT r FROM User r WHERE r.username = :name")
				.setParameter("name", userName)
				.getSingleResult();
		return Optional.of(user);
		
	}

}
