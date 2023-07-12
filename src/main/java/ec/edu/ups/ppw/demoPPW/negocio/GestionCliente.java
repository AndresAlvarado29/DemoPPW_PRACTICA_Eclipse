package ec.edu.ups.ppw.demoPPW.negocio;

import java.util.List;

import ec.edu.ups.ppw.demoPPW.dao.ClienteDAO;
import ec.edu.ups.ppw.demoPPW.dao.VehiculoDAO;
import ec.edu.ups.ppw.demoPPW.modelo.Cliente;
import ec.edu.ups.ppw.demoPPW.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCliente {
	@Inject
	private ClienteDAO clienteDAO;
	@Inject
	private VehiculoDAO vehiculoDAO;

	public void guardarClientes(Cliente cliente) throws Exception {
		if (!this.isCedulaValida(cliente.getCedula()))
			throw new Exception("Cedula Incorrecta");

		if (clienteDAO.read(cliente.getCedula()) == null) {
			try {
				clienteDAO.insert(cliente);
			} catch (Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		} else {
			try {
				clienteDAO.update(cliente);
			} catch (Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	public void actualizarCliente(Cliente cliente) throws Exception{
		for (Cliente clientes : clienteDAO.getAll()) {
			if(clientes.getCedula().equals(cliente.getCedula())) {
				try {
					clienteDAO.update(cliente);
				} catch (Exception e) {
					throw new Exception("No se encontro el id: "+ e.getMessage());
				}
			}
		}
	}

	private boolean isCedulaValida(String cedula) {
		return cedula.length() == 10;
	}

	public List<Cliente> listar() {
		return clienteDAO.getAll();
	}
	//vehiculos

	public void guardarVehiculos(Vehiculo vehiculo) throws Exception {
		if (!this.isPlacaValida(vehiculo.getPlaca()))
			throw new Exception("Placa Incorrecta");

		if (vehiculoDAO.read(vehiculo.getPlaca()) == null) {
			try {
				vehiculoDAO.insert(vehiculo);
			} catch (Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		} else {
			try {
				vehiculoDAO.update(vehiculo);
			} catch (Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	private boolean isPlacaValida(String placa) {
		return placa.length() == 7;
	}
	public void actualizarVehiculo(Vehiculo vehiculo) throws Exception{
		for (Vehiculo vehiculos : vehiculoDAO.getAll()) {
			if(vehiculos.getPlaca().equals(vehiculo.getPlaca())) {
				try {
					vehiculoDAO.update(vehiculo);
				} catch (Exception e) {
					throw new Exception("No se encontro el id: "+ e.getMessage());
				}
			}
		}
	}
	
	public List<Vehiculo> listarVehiculos(){
		return vehiculoDAO.getAll();
	}
}
