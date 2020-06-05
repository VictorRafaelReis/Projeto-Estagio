package br.com.unirios.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.unirios.util.EntityManagerUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		em = EntityManagerUtil.gerEntityManager();
		this.classe = (Class<Entidade>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(String campo_ordenacao) {
		if(campo_ordenacao != null)
			return em.createQuery("FROM " + classe.getName() + " ORDER BY " + campo_ordenacao).getResultList();
		else
		return em.createQuery("FROM " + classe.getName()).getResultList();	
	}
	
	public boolean salvar (Entidade entidade) {
		try {
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean editar (Entidade entidade) {
		try {
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean remover (Integer codigo) {
		Entidade entidade = em.find(classe, codigo);
		try {
			em.getTransaction().begin();
			em.remove(entidade);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			return false;
		}
	}
	
	public Entidade consultaPorCodigo (Integer codigo) {
		return em.find(classe, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public Entidade localizaPorAtributo (String atributo, String campoAserProcurado) {
		return (Entidade) em.createQuery("FROM " + classe.getName() + "WHERE " + atributo + " = :campo")
				.setParameter("campo", campoAserProcurado).getSingleResult();
	}
	
	
	
}
