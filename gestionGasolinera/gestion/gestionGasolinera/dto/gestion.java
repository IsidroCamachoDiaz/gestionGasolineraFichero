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
	public List <gestion> repostajeFactura(List <gestion> bd) {
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
		Scanner leer = new Scanner (System.in);
		if(bd.isEmpty())
			System.out.println("No se ha realizado ningun repostaje");
		else {
			System.out.println("1-Repostaje Normal");
			System.out.println("2-Repostaje Factura");
			System.out.println("3-Todos");
			System.out.println("Que tipo de Repostaje desea ver: ");
			int opcion = leer.nextInt();
			switch(opcion) {
			case 1:
				for(int e=0;e<bd.size();e++) {
					if(bd.get(e).getMatricula()==null) {
					System.out.println("Fecha: "+bd.get(e).getFecha());
					System.out.println("Importe: "+bd.get(e).getImporte());
					System.out.println("Litros: "+bd.get(e).getLitros());
					}
				}
				break;
			case 2:
				for(int e=0;e<bd.size();e++) {
					if(bd.get(e).getMatricula()!=null) {
					System.out.println("Fecha: "+bd.get(e).getFecha());
					System.out.println("Importe: "+bd.get(e).getImporte());
					System.out.println("Litros: "+bd.get(e).getLitros());
					System.out.println("DNI: "+bd.get(e).getDni());
					System.out.println("Matricula: "+bd.get(e).getMatricula());
					}
				}
				break;
			case 3:
				gestion repostaje = new gestion();
				repostaje.mostrar(bd);
				break;
				default:
					System.out.println("El numero introducido no tienen una opcion");
			}
		}	
	}
	public List <gestion> modificarRepostaje(List <gestion> bd) {
		Scanner leer = new Scanner (System.in);
		gestion repostaje = new gestion();
		repostaje.mostrar(bd);
		System.out.println("Que repostaje desea modificar: ");
		int opcion = leer.nextInt();
		if(opcion>bd.size())
			System.out.println("No existe ese registro");
		else {
			System.out.println("Introduzca la cantidad que desea meter gasolina: ");
			bd.get(opcion).setImporte(leer.nextDouble());
			bd.get(opcion).setLitros(bd.get(opcion).getImporte() * 0.762);
			if(bd.get(opcion).matricula!=null) {
			System.out.println("Matricula: ");
			bd.get(opcion).setMatricula(leer.next());
			System.out.println("DNI: ");
			bd.get(opcion).setDni(leer.next());
			}
		}
		return bd;
	}
	public List <gestion> eliminarRepostaje(List <gestion> bd) {
		Scanner leer = new Scanner (System.in);
		gestion repostaje = new gestion();
		repostaje.mostrar(bd);
		System.out.println("Que repostaje desea eliminar: ");
		int opcion = leer.nextInt();
		bd.remove(opcion);
		return bd;
	}
	public void mostrar(List <gestion> bd) {
		for(int e=0;e<bd.size();e++) {
			System.out.println("Numero: "+e);
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
