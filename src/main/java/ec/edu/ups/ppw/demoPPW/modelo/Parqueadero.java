package ec.edu.ups.ppw.demoPPW.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Parqueadero{
@Id
@GeneratedValue
@Column(name="par_id")
private int idParqueadero;
@Column(name="par_nombre")
private String nombre;
@Column(name="par_direccion")
private String direccion;
@Column(name="par_telefono")
private String telefono;
@Column(name="par_espacios")
private int espacios;
//relacion
@OneToMany
@JoinColumn(name="par_id")
private List<Cliente> clientes;
public int getIdParqueadero() {
	return idParqueadero;
}
public void setIdParqueadero(int idParqueadero) {
	this.idParqueadero = idParqueadero;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public int getEspacios() {
	return espacios;
}
public void setEspacios(int espacios) {
	this.espacios = espacios;
}

public List<Cliente> getClientes() {
	return clientes;
}
public void setClientes(List<Cliente> clientes) {
	this.clientes = clientes;
}

public void addCliente(Cliente cliente) {
	if(clientes == null) {
		clientes = new ArrayList<Cliente>();
	}
	clientes.add(cliente);
}
@Override
public String toString() {
	return "Parqueadero [idParqueadero=" + idParqueadero + ", nombre=" + nombre + ", direccion=" + direccion
			+ ", telefono=" + telefono + ", espacios=" + espacios + ", clientes=" + clientes + "]";
}


}

