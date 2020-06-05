package br.com.unirios.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManagerFactory factory = null;
	private static EntityManager em = null;
	
	public static EntityManager gerEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("ProjetoEstagio");
		}
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}
}
