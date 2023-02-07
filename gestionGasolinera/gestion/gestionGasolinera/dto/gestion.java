package gestionGasolinera.dto;

import java.text.Format;
import java.text.SimpleDateFormat;
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

	private Date fecha;
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

	private double litros;
	private double importe;
	private String dni;
	private String matricula;
	
	public List <gestion> repostajeNormal(List <gestion> bd) {
		Scanner leer = new Scanner (System.in);
		gestion repostaje = new gestion();
		//SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
		repostaje.fecha= new Date();
		System.out.println("Introduzca la cantidad que desea meter gasolina: ");
		double cantidad = leer.nextDouble();
		double litros = cantidad * 0.762F;
		
		
		
		return null;
	}

	
}
