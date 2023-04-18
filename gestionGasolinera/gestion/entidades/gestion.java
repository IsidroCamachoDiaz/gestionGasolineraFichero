package entidades;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class gestion {
	//Constructores
	public gestion() {
		super();
	}
 public gestion(Date fecha, double litros, double importe) {
		super();
		this.fecha = fecha;
		this.litros = litros;
		this.importe = importe;
	}
 
public gestion(Date fecha, double litros, double importe, String dni, String matricula) {
	super();
	this.fecha = fecha;
	this.litros = litros;
	this.importe = importe;
	this.dni = dni;
	this.matricula = matricula;
}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getLitros() {
		return litros;
	}
	public void setLitros(double litros) {
		this.litros = litros;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	//Atributos 
	private Date fecha;
	private double litros;
	private double importe;
	private String dni;
	private String matricula;
	
}
