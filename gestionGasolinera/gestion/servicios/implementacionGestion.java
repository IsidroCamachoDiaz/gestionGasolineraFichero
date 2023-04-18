/**
 * 
 */
package servicios;

import java.io.PrintWriter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.gestion;

/**
 * @author Isidro Camacho
 *
 */
public class implementacionGestion implements interfazGestion {

	@Override
	public List<gestion> repostajeNormal(List<gestion> bd,PrintWriter pw) {
		pw.println("Entro al metodo respotajeNormal");
		Scanner leer = new Scanner (System.in);
		gestion repostaje = new gestion();
		//SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
		Date fecha= new Date();
		repostaje.setFecha(fecha);
		System.out.println("Introduzca la cantidad que desea meter gasolina: ");
		try {
		repostaje.setImporte(leer.nextDouble());
		repostaje.setLitros(repostaje.getImporte() * 0.762);
		}catch(InputMismatchException i) {
			System.out.println("Error No puso el formato correcto");
			pw.println("Error No puso el formato correcto");
		}
		
		repostaje.setMatricula(null);
		repostaje.setDni(null);
		bd.add(repostaje);
		pw.println("Creo un repostaje Normal");
		return bd;
	}

	@Override
	public List<gestion> repostajeFactura(List<gestion> bd,PrintWriter pw) {
		pw.println("Entro al metodo respotajeFactura");
		Scanner leer = new Scanner (System.in);
		gestion repostaje = new gestion();
		//SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
		Date fecha= new Date();
		repostaje.setFecha(fecha);
		try {
		System.out.println("Introduzca la cantidad que desea meter gasolina: ");
		repostaje.setImporte(leer.nextDouble());
		repostaje.setLitros(repostaje.getImporte() * 0.762);
		System.out.println("Introduzca su DNI: ");
		repostaje.setDni(leer.next().toUpperCase());
		System.out.println("Introduzca su Matricula: ");
		repostaje.setMatricula(leer.next().toUpperCase());
		}catch(InputMismatchException i) {
			System.out.println("Error No puso el formato correcto");
			pw.println("Error No puso el formato correcto");
		}
		bd.add(repostaje);
		pw.println("Creo un repostaje Factura");
		return bd;
	}

	@Override
	public void monstrarRepostaje(List<gestion> bd,PrintWriter pw) {
		pw.println("Entro al metodo mostrarRepostaje");
		Scanner leer = new Scanner (System.in);
		if(bd.isEmpty())
			System.out.println("No se ha realizado ningun repostaje");
		else {
			System.out.println("1-Repostaje Normal");
			System.out.println("2-Repostaje Factura");
			System.out.println("3-Todos");
			System.out.println("Que tipo de Repostaje desea ver: ");
			int opcion=0;
			try {
			opcion = leer.nextInt();
			}catch(InputMismatchException i) {
				System.out.println("Error No puso el formato correcto");
				pw.println("Error No puso el formato correcto");
			}catch(Exception e) {
				System.out.println("Se produjo un error"+e.getMessage());
			}
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
				mostrar(bd,pw);
				break;
				default:
					System.out.println("El numero introducido no tienen una opcion");
			}
			pw.println("Mostro repostajes");
		}
		
	}

	@Override
	public List<gestion> modificarRepostaje(List<gestion> bd,PrintWriter pw) {
		pw.println("Entro al metodo modificarRepostaje");
		Scanner leer = new Scanner (System.in);
		mostrar(bd,pw);
		System.out.println("Que repostaje desea modificar: ");
		int opcion =0;
		try {
		opcion = leer.nextInt();
		}catch(InputMismatchException i) {
			System.out.println("Error No puso el formato correcto");
			pw.println("Error No puso el formato correcto");
		}catch(Exception e) {
			System.out.println("Se produjo un error"+e.getMessage());
		}
		if(opcion>bd.size())
			System.out.println("No existe ese registro");
		else {
			try {
			System.out.println("Introduzca la cantidad que desea meter gasolina: ");
			bd.get(opcion).setImporte(leer.nextDouble());
			bd.get(opcion).setLitros(bd.get(opcion).getImporte() * 0.762);
			if(bd.get(opcion).getMatricula()!=null) {
			System.out.println("Matricula: ");
			bd.get(opcion).setMatricula(leer.next());
			System.out.println("DNI: ");
			bd.get(opcion).setDni(leer.next());
			}
			pw.println("Modifico un repostaje");
			}catch(InputMismatchException i) {
				System.out.println("Error No puso el formato correcto");
				pw.println("Error No puso el formato correcto");
			}catch(IndexOutOfBoundsException iu){
				System.out.println("Introdujo un indice fuera de los parametros");
				pw.println("Error Introdujo un indice fuera de los parametros");
				
			}catch(Exception e) {
				System.out.println("Se produjo un error"+e.getMessage());
			}
		}
		
		return bd;
	}

	@Override
	public List<gestion> eliminarRepostaje(List<gestion> bd,PrintWriter pw) {
		pw.println("Entro al metodo eliminarRepostaje");
		Scanner leer = new Scanner (System.in);
		mostrar(bd,pw);
		if(!bd.isEmpty()) {
		System.out.println("Que repostaje desea eliminar: ");
		int opcion=0;
		try {
		opcion= leer.nextInt();
		bd.remove(opcion);
		pw.println("Elimino un repostaje");
		}catch(InputMismatchException i) {
			System.out.println("Error No puso el formato correcto");
			pw.println("Error No puso el formato correcto");
		}catch(IndexOutOfBoundsException iu){
			System.out.println("Introdujo un indice fuera de los parametros");
			pw.println("Error Introdujo un indice fuera de los parametros");
			
		}catch(Exception e) {
			System.out.println("Se produjo un error"+e.getMessage());
		}
	}
		return bd;
	}

	@Override
	public void mostrar(List<gestion> bd,PrintWriter pw) {
		pw.println("Entro al metodo mostrar");
		if(!bd.isEmpty()) {
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
		else
			System.out.println("No introdujo ningun repostaje");
		
	}


	

}
