package ec.edu.ups.ppw.demoPPW.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Factura implements Serializable {
@Id
@GeneratedValue
@Column(name="fac_id")
private int idFactura;
@Column(name="fac_numero")
private int numeroFactura;
@Column(name="fac_fecha")
private Date fecha;
@Column(name="fac_subtotal")
private double subtotal;
@Column(name="fac_iva")
private double iva;
@Column(name="fac_total")
private double total;
//relaciones
@OneToOne
@JoinColumn(name="cli_cedula")
private Cliente cliente;
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="fac_codigo")
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
