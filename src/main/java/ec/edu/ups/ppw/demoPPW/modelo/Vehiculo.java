package ec.edu.ups.ppw.demoPPW.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Vehiculo {
@Id
@Column(name="veh_placa")
private String placa;
@Column(name="veh_marca")
private String marca;
@Column(name="veh_modelo")
private String modelo;
@Column(name="veh_color")
private String color;
//relaciones
//@OneToMany
//@JoinColumn(name="veh_placa")
//private List<Ticket> tickets;
@OneToOne
@JoinColumn(name="tip_id")
private TipoVehiculo tipoVehiculo;
public String getPlaca() {
	return placa;
}
public void setPlaca(String placa) {
	this.placa = placa;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}


}
