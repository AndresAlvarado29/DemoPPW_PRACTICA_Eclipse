package ec.edu.ups.ppw.demoPPW.negocio;

import ec.edu.ups.ppw.demoPPW.dao.ClienteDAO;
import ec.edu.ups.ppw.demoPPW.modelo.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCliente {
	@Inject
	private ClienteDAO clienteDAO;

	public void guardarClinetes(Cliente cliente) throws Exception {
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

	private boolean isCedulaValida(String cedula) {
		return cedula.length() == 10;
	}

	public void guardarClientes(String cedula, String nombre, String direccion) {

	}
}
