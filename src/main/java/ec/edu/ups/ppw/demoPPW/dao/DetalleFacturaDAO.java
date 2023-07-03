package ec.edu.ups.ppw.demoPPW.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.demoPPW.modelo.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DetalleFacturaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@PersistenceContext
private EntityManager em;

public void insert(DetalleFactura detalleFactura) {
	em.persist(detalleFactura);
}
public void update(DetalleFactura detalleFactura) {
	em.merge(detalleFactura);
}
public DetalleFactura read(int codigo) {
	DetalleFactura dF= em.find(DetalleFactura.class, codigo);
	return dF;
}
public void delete(int codigo) {
	DetalleFactura dF = em.find(DetalleFactura.class, codigo);
	em.remove(dF);
}
public List<DetalleFactura> getAll(){
	String jpql = "SELECT dF FROM DetalleFactura dF";
	Query q = em.createQuery(jpql);
	return q.getResultList();
}
}
