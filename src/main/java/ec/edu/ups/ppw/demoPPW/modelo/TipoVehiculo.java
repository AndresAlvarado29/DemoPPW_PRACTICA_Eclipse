package ec.edu.ups.ppw.demoPPW.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TipoVehiculo{
@Id
@GeneratedValue
@Column(name="tip_id")
private int idTipo;
@Column(name="tip_vehiculo")
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
