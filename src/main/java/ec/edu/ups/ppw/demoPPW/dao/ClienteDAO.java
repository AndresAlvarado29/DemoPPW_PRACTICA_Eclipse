package ec.edu.ups.ppw.demoPPW.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.demoPPW.modelo.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO implements Serializable {
		@PersistenceContext
		private EntityManager em;

		public void insert(Cliente Cliente) {
			em.persist(Cliente);
		}

		public void update(Cliente Cliente) {
			em.merge(Cliente);
		}

		public Cliente read(String cedula) {
			Cliente p = em.find(Cliente.class, cedula);
			return p;
		}

		public void delete(String cedula) {
			Cliente p = em.find(Cliente.class, cedula);
			em.remove(p);
		}

		public List<Cliente> getAll(){
			String jpql = "SELECT p FROM Cliente p";
			Query q = em.createQuery(jpql);
			return q.getResultList();
		}
}
