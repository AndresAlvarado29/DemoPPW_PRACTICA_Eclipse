package ec.edu.ups.ppw.demoPPW.servicio;

import java.util.List;

import ec.edu.ups.ppw.demoPPW.dao.VehiculoDAO;
import ec.edu.ups.ppw.demoPPW.modelo.Cliente;
import ec.edu.ups.ppw.demoPPW.modelo.Vehiculo;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("clientes")
public class GClienteService {
	@Inject
	private VehiculoDAO vehiculoDAO;
	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola mundo";
	}
	
	@GET
	@Path("suma")
	public String suma(@QueryParam("a") int a, @QueryParam("b") int b) {
	return "R = " + (a + b);
	}
	
	@GET
	@Path("multiplicacion/{a}/{b}")
	public String multiplicacion(@PathParam("a") int a, @PathParam("b") int b) {
		return "R = " + (a * b); 
	}
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Cliente misDatos() {
		Cliente p = new Cliente();
		p.setCedula("0106154362");
		p.setNombre("Andres");
		p.setApellido("Alvarado");
		return p;
	}
	
	@GET
	@Path("vehiculodatos")
	@Produces("application/json")
	public List<Vehiculo> vehiculoDatos() {
		return vehiculoDAO.getAll();
	}
}
