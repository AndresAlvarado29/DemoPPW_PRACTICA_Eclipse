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
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@PersistenceContext
		private EntityManager em;

		public void insert(Cliente cliente) {
			em.persist(cliente);
		}

		public void update(Cliente cliente) {
			em.merge(cliente);
		}

		public Cliente read(String cedula) {
			Cliente c = em.find(Cliente.class, cedula);
			return c;
		}

		public void delete(String cedula) {
			Cliente c = em.find(Cliente.class, cedula);
			em.remove(c);
		}

		public List<Cliente> lista(){
			String jpql = "SELECT c FROM Cliente c";
			Query q = em.createQuery(jpql);
			List<Cliente> clientes = q.getResultList();
			for (Cliente cliente : clientes) {
				System.out.println("Cédula: " + cliente.getCedula());
				System.out.println("Nombre: " + cliente.getNombre());
		        System.out.println("Apellido: " + cliente.getApellido());
		        System.out.println("Celular: " + cliente.getTelefono());
		        System.out.println("Direccion: " + cliente.getDireccion());
		        System.out.println("Vehiculo: " + cliente.getVehiculo());
		        System.out.println("Ticket: " + cliente.getTickets());
			}
			return clientes;
		}
		public List<Cliente> getAll(){
			String jpql = "SELECT c FROM Cliente c";
			Query q = em.createQuery(jpql);
			return q.getResultList();
		}
		
		
		
}
