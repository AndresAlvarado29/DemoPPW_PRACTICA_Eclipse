package ec.edu.ups.ppw.demoPPW.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Factura implements Serializable {
@Id
@Column(name="id_factura")
private int idFactura;
@GeneratedValue
private int numeroFactura;
private Date fecha;
private double subtotal;
private double iva;
private double total;
//relacion
@OneToMany
@JoinColumn(name="id_factura")
private List<DetalleFactura> detalles;
public int getIdFactura() {
	return idFactura;
}
public void setIdFactura(int idFactura) {
	this.idFactura = idFactura;
}
public int getNumeroFactura() {
	return numeroFactura;
}
public void setNumeroFactura(int numeroFactura) {
	this.numeroFactura = numeroFactura;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public double getIva() {
	return iva;
}
public void setIva(double iva) {
	this.iva = iva;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}

}
