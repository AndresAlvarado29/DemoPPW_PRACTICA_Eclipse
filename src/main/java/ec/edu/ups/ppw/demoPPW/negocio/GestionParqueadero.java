package ec.edu.ups.ppw.demoPPW.negocio;

import java.util.List;

import ec.edu.ups.ppw.demoPPW.dao.ParqueaderoDAO;
import ec.edu.ups.ppw.demoPPW.modelo.Parqueadero;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionParqueadero {
@Inject
private ParqueaderoDAO parqueaderoDAO;

public void guardarParqueadero(Parqueadero parqueadero) throws Exception {
	if(parqueaderoDAO.read(parqueadero.getIdParqueadero())==null) {
		try {
			parqueaderoDAO.insert(parqueadero);
		} catch (Exception e) {
			throw new Exception("Error al insertar: " + e.getMessage());
		}
	}else {
		try {
			parqueaderoDAO.update(parqueadero);
		} catch (Exception e) {
			throw new Exception("Error al actualizar:"+e.getMessage());
		}
	}
}
public void actualizarParqueadero(Parqueadero parqueadero) throws Exception{
	for (Parqueadero parqueaderos : parqueaderoDAO.getAll()) {
		if(parqueadero.getIdParqueadero()==parqueaderos.getIdParqueadero()) {
			try {
				parqueaderoDAO.update(parqueadero);
			} catch (Exception e) {
				throw new Exception("No se encontro el id: "+ e.getMessage());
			}
		}
	}
}
public List<Parqueadero> listar(){
	return parqueaderoDAO.getAll();
}
}
