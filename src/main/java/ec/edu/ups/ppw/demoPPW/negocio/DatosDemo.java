package ec.edu.ups.ppw.demoPPW.negocio;

import ec.edu.ups.ppw.demoPPW.dao.ClienteDAO;
import ec.edu.ups.ppw.demoPPW.modelo.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private ClienteDAO daoCliente;

	@PostConstruct
	public void init() {
		System.out.println("Hola UPS");

		Cliente c = new Cliente();
		c.setCedula("0106154362");
		c.setApellido("Alvarado");
		c.setNombre("Andres");
		c.setTelefono("0999252488");
		daoCliente.insert(c);
		Cliente c1 = new Cliente();
		c1.setCedula("0106154370");
		c1.setApellido("Alvarado");
		c1.setNombre("Andrea");
		c1.setTelefono("0999252488");
		daoCliente.insert(c1);
		daoCliente.getAll();
	}
}
