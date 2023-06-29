package ec.edu.ups.ppw.demoPPW.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TipoVehiculo {
@Id
@GeneratedValue
@Column(name="id_tipo")
private int idTipo;
private String tipoVehiculo;

public int getIdTipo() {
	return idTipo;
}
public void setIdTipo(int idTipo) {
	this.idTipo = idTipo;
}
public String getTipoVehiculo() {
	return tipoVehiculo;
}
public void setTipoVehiculo(String tipoVehiculo) {
	this.tipoVehiculo = tipoVehiculo;
}


}
