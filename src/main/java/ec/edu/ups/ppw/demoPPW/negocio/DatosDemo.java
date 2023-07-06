package ec.edu.ups.ppw.demoPPW.negocio;

import java.util.Date;

import ec.edu.ups.ppw.demoPPW.dao.ClienteDAO;
import ec.edu.ups.ppw.demoPPW.dao.DetalleFacturaDAO;
import ec.edu.ups.ppw.demoPPW.dao.FacturaDAO;
import ec.edu.ups.ppw.demoPPW.dao.ParqueaderoDAO;
import ec.edu.ups.ppw.demoPPW.dao.TicketDAO;
import ec.edu.ups.ppw.demoPPW.dao.VehiculoDAO;
import ec.edu.ups.ppw.demoPPW.modelo.Cliente;
import ec.edu.ups.ppw.demoPPW.modelo.DetalleFactura;
import ec.edu.ups.ppw.demoPPW.modelo.Factura;
import ec.edu.ups.ppw.demoPPW.modelo.Parqueadero;
import ec.edu.ups.ppw.demoPPW.modelo.Ticket;
import ec.edu.ups.ppw.demoPPW.modelo.Vehiculo;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private ClienteDAO daoCliente;
	@Inject
	private TicketDAO daoTicket;
	@Inject
	private FacturaDAO daoFactura;
	@Inject
	private DetalleFacturaDAO daoDetalleFactura;
	@Inject
	private VehiculoDAO daoVehiculo;
	@Inject
	private ParqueaderoDAO daoParqueadero;

	@PostConstruct
	public void init() {
		System.out.println("Hola UPS");
		/*//parqueadero
				Parqueadero p = new Parqueadero();
				p.setTelefono("0999252488");
				p.setNombre("elPepe");
				p.setEspacios(20);
				p.setDireccion("cuenca");
				daoParqueadero.insert(p);	*/
				// cliente2
				Cliente c1 = new Cliente();
				c1.setCedula("0105164362");
				c1.setApellido("Gonzales");
				c1.setDireccion("Cuenca");
				c1.setNombre("Juan");
				c1.setTelefono("0999252488");
				daoCliente.insert(c1);
			//Parqueadero p = new Parqueadero();
			//	p.addCliente(c1);
			//	daoParqueadero.update(p);
				
					if(daoParqueadero.read(102)!=null) {
						daoParqueadero.read(102).addCliente(c1);
						daoParqueadero.update(daoParqueadero.read(102));
						}
					
				// vehiculo del cliente 2
				Vehiculo v1 = new Vehiculo();
				v1.setColor("blanco");
				v1.setPlaca("AYC-0215");
				v1.setMarca("gtx");
				v1.setModelo("vts");
				v1.setTipoVehiculo("triciclo");
				c1.addVehiculo(v1);
				// ticket vehiculo 2
				Ticket t1 = new Ticket();
				t1.setFecha(new Date());
				t1.setHoraEntrada(new Date());
				t1.setHoraSalida(new Date());
				c1.addTicket(t1);
				daoVehiculo.insert(v1);
				daoTicket.insert(t1);
				// Factura cliente 1
				Factura f1 = new Factura();
				f1.setNumeroFactura("01001-011001");
				f1.setFecha(new Date());
				f1.setSubtotal(2.25);
				f1.setIva(0.12);
				f1.setTotal(f1.total(f1.getSubtotal(), f1.getIva()));
				f1.setCliente(c1);
				// detalle factura cliente 1
				DetalleFactura d1 = new DetalleFactura();
				d1.setCantidad(5);
				d1.setCostoUnitario(1.25);
				d1.setDetalle("estacionamiento");
				d1.setCostoTotal(d1.getCantidad() * d1.getCostoUnitario());
				d1.setTicket(t1);
				f1.addDetalle(d1);
				daoFactura.insert(f1);
			
		System.out.println(daoFactura.getAll());
		System.out.println(daoCliente.getAll());
	
	}
}
