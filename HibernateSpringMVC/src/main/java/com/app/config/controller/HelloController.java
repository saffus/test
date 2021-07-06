package com.app.config.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	
	//@Autowired
	//SessionFactory sessionFactory;
	@PersistenceContext
	EntityManager entityManagerCon;
	
	@Autowired
	EntityManagerFactory entityManager;
	
	@Transactional
	@GetMapping("/path")
	public ModelAndView getHelloMessage() {
		
		//sessionFactory.getCurrentSession().createQuery("from user").getResultList();
		entityManager.createEntityManager().createQuery("FROM Instructor").getResultList().forEach(System.out::println);
		return new ModelAndView("success");
	}
	
	@Transactional
	@GetMapping("/user")
	public  ModelAndView getUsers(){
		
		//return sessionFactory.getCurrentSession().createQuery("from user").getResultList();
		entityManagerCon.createQuery("from InstructorDetail").getResultList().forEach(System.out::println);
		return new ModelAndView("success");
		
		
	}

}
