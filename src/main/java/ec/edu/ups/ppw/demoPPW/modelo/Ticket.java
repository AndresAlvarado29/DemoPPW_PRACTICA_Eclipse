package ec.edu.ups.ppw.demoPPW.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {
@Id
@GeneratedValue
@Column(name="tic_id")
private int idTicket;
@Column(name="tic_fecha")
private Date fecha;
@Column(name="tic_hora_salida")
private Date horaSalida;
@Column(name="tic_hora_entrada")
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

@Override
public String toString() {
	return "Ticket [idTicket=" + idTicket + ", fecha=" + fecha + ", horaSalida=" + horaSalida + ", horaEntrada="
			+ horaEntrada + "]";
}

}