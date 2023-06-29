package ec.edu.ups.ppw.demoPPW.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {
@Id
@GeneratedValue
private int idTicket;
private Date fecha;
private Date horaSalida;
private Date horaEntrada;
public int getIdTicket() {
	return idTicket;
}
public void setIdTicket(int idTicket) {
	this.idTicket = idTicket;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public Date getHoraSalida() {
	return horaSalida;
}
public void setHoraSalida(Date horaSalida) {
	this.horaSalida = horaSalida;
}
public Date getHoraEntrada() {
	return horaEntrada;
}
public void setHoraEntrada(Date horaEntrada) {
	this.horaEntrada = horaEntrada;
}

}
