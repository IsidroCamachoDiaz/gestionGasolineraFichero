package gestionGasolinera.dto;

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
	
	public List <gestion> repostajeNormal(List <gestion> bd) {
		Scanner leer = new Scanner (System.in);
		gestion repostaje = new gestion();
		//SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
		Date fecha= new Date();
		repostaje.setFecha(fecha);
		System.out.println("Introduzca la cantidad que desea meter gasolina: ");
		repostaje.setImporte(leer.nextDouble());
		repostaje.setLitros(repostaje.getImporte() * 0.762);
		repostaje.setMatricula(null);
		repostaje.setDni(null);
		bd.add(repostaje);
		return bd;
	}
	public List <gestion> monstrarRepostajeFactura(List <gestion> bd) {
		Scanner leer = new Scanner (System.in);
		gestion repostaje = new gestion();
		//SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
		Date fecha= new Date();
		repostaje.setFecha(fecha);
		System.out.println("Introduzca la cantidad que desea meter gasolina: ");
		repostaje.setImporte(leer.nextDouble());
		repostaje.setLitros(repostaje.getImporte() * 0.762);
		System.out.println("Introduzca su DNI: ");
		repostaje.setDni(leer.next().toUpperCase());
		System.out.println("Introduzca su Matricula: ");
		repostaje.setMatricula(leer.next().toUpperCase());
		bd.add(repostaje);
		return bd;
	}
	public void monstrarRepostaje(List <gestion> bd) {
		if(bd.isEmpty())
			System.out.println("No se ha realizado ningun repostaje");
		else {
		for(int e=0;e<bd.size();e++) {
			System.out.println("Fecha: "+bd.get(e).getFecha());
			System.out.println("Importe: "+bd.get(e).getImporte());
			System.out.println("Litros: "+bd.get(e).getLitros());
			if(bd.get(e).getMatricula()!=null) {
				System.out.println("DNI: "+bd.get(e).getDni());
				System.out.println("Matricula: "+bd.get(e).getMatricula());
			}
		}
		
		}
	}
		

	
}
