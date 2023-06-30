package ec.edu.ups.ppw.demoPPW.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.demoPPW.modelo.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class FacturaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@PersistenceContext
private EntityManager em;

public void insert(Factura factura) {
	em.persist(factura);
}
public void update(Factura factura) {
	em.merge(factura);
}
public Factura read(int codigo) {
	Factura f= em.find(Factura.class, codigo);
	return f;
}
public void delete(int codigo) {
	Factura f = em.find(Factura.class, codigo);
	em.remove(f);
}
public List<Factura> getAll(){
	String jpql = "SELECT f FROM Factura f";
	Query q = em.createQuery(jpql);
	return q.getResultList();
}
}
