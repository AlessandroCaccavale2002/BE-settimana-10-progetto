package it.cinema.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class EntityManagerHelper {
	
	private static EntityManagerFactory emFactory;
	
	public static EntityManager getEntityManager1() {
	 return getEmfactory().createEntityManager();
}

	public static EntityManagerFactory getEmfactory() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("filmPS");
		}
		return emFactory;
	}
	}

    

    