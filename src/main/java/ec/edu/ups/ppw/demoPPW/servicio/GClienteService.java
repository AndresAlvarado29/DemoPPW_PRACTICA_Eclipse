package ec.edu.ups.ppw.demoPPW.servicio;

import java.util.List;

import ec.edu.ups.ppw.demoPPW.dao.VehiculoDAO;
import ec.edu.ups.ppw.demoPPW.modelo.Cliente;
import ec.edu.ups.ppw.demoPPW.modelo.Parqueadero;
import ec.edu.ups.ppw.demoPPW.modelo.Vehiculo;
import ec.edu.ups.ppw.demoPPW.negocio.GestionCliente;
import ec.edu.ups.ppw.demoPPW.negocio.GestionParqueadero;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class GClienteService {
	@Inject
	private GestionCliente gCliente;
	@Inject
	private GestionParqueadero gParqueadero;
	//servicios
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
//servicios cliente
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Cliente cliente) {
		try {
			gCliente.guardarClientes(cliente);
			return Response.status(Response.Status.OK).entity(cliente).build();
		}catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:"+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizarCliente(Cliente cliente) {
		try {
			gCliente.actualizarCliente(cliente);
			return Response.status(Response.Status.OK).entity(cliente).build();
		}catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:"+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	@GET
	@Path("clientedatos")
	@Produces("application/json")
	public List<Cliente> clienteDatos() {
		return gCliente.listar();
	}
//servicios vehiculo
	@POST
	@Path("crearV")
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarVehiculos(Vehiculo vehiculo) {
		try {
			gCliente.guardarVehiculos(vehiculo);
			return Response.status(Response.Status.OK).entity(vehiculo).build();
		}catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:"+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	@POST
	@Path("actualizarV")
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizarVehiculo(Vehiculo vehiculo) {
		try {
			gCliente.actualizarVehiculo(vehiculo);
			return Response.status(Response.Status.OK).entity(vehiculo).build();
		}catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:"+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	@GET
	@Path("vehiculodatos")
	@Produces("application/json")
	public List<Vehiculo> vehiculoDatos() {
		return gCliente.listarVehiculos();
	}
	//servicios Parqueadero
	@POST
	@Path("crearP")
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarParqueadero(Parqueadero parqueadero) {
		try {
			gParqueadero.guardarParqueadero(parqueadero);
			return Response.status(Response.Status.OK).entity(parqueadero).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:"+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	@POST
	@Path("actualizarP")
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizarParqueadero(Parqueadero parqueadero) {
		try {
			gParqueadero.actualizarParqueadero(parqueadero);
			return Response.status(Response.Status.OK).entity(parqueadero).build();
		}catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:"+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	@GET
	@Path("parqueaderodatos")
	@Produces("application/json")
	public List<Parqueadero> parqueaderoDatos() {
		return gParqueadero.listar();
	}
}
