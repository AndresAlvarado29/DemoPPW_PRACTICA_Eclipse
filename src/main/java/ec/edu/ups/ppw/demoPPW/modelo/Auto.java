package ec.edu.ups.ppw.demoPPW.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Auto {
@Id
@GeneratedValue
private int Id;
private String Marca;
private String Modelo;
}
