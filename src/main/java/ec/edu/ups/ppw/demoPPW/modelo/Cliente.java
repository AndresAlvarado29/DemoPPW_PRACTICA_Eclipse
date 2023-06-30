package ec.edu.ups.ppw.demoPPW.modelo;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{
	@Id
	@Column(name="cli_cedula")
	private String cedula;
	@Column(name="cli_nombre")
	private String nombre;
	@Column(name="cli_apellido")
	private String apellido;
	@Column(name="cli_telefono")
	private String telefono;
	@Column(name="cli_direccion")
	private String direccion;
	//relacion
	@OneToMany
	@JoinColumn(name="cli_cedula")
	private List<Vehiculo> vehiculo;
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
