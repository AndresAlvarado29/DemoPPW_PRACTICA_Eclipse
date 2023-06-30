package ec.edu.ups.ppw.demoPPW.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DetalleFactura {
@Id
@GeneratedValue
@Column(name="det_id")
private int idDetalle;
@Column(name="det_cantidad")
private double cantidad;
@Column(name="det_detalle")
private String detalle;
@Column(name="det_costo_unitario")
private double costoUnitario;
@Column(name="det_costo_total")
private double costoTotal;
public int getIdDetalle() {
	return idDetalle;
}
public void setIdDetalle(int idDetalle) {
	this.idDetalle = idDetalle;
}
public double getCantidad() {
	return cantidad;
}
public void setCantidad(double cantidad) {
	this.cantidad = cantidad;
}
public String getDetalle() {
	return detalle;
}
public void setDetalle(String detalle) {
	this.detalle = detalle;
}
public double getCostoUnitario() {
	return costoUnitario;
}
public void setCostoUnitario(double costoUnitario) {
	this.costoUnitario = costoUnitario;
}
public double getCostoTotal() {
	return costoTotal;
}
public void setCostoTotal(double costoTotal) {
	this.costoTotal = costoTotal;
}

}
