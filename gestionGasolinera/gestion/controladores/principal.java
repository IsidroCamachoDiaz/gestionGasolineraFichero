package controladores;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import entidades.gestion;
import servicios.implementacionEscritura;
import servicios.implementacionGestion;
import servicios.interfazEscritura;
import servicios.interfazGestion;

public class principal {

	public static void main(String[] args) {
		int opcion;
		Scanner leer = new Scanner (System.in);
		List <gestion> bd = new LinkedList <gestion>();
		//Se crea las interfaces
		interfazGestion interfaz = new implementacionGestion();
		interfazEscritura interfazEs= new implementacionEscritura();
		//Creamos un objeto PrintWriter y la ruta
		PrintWriter pw =interfazEs.Abrir("C:\\Users\\Isidro Camacho\\Desktop\\ficheros\\log.txt");
		do {
			//Imprime el menu
		System.out.println("1-Repostaje Normal");
		System.out.println("2-Repostaje factura");
		System.out.println("3-Ver repostajes");
		System.out.println("4-Modificar Repostaje");
		System.out.println("5-Eliminar Repostaje");
		System.out.println("0-Salir");
		System.out.println("Bienvenido Introduzca un opcion: ");
		opcion=0;
		try {
			//Coge el valor si no pone el formato correcto entra en la excepcion
		opcion = leer.nextInt();
		}catch(InputMismatchException i) {
			System.out.println("Error No puso el formato correcto");
			interfazEs.Escribir(pw, "Error No puso el formato correcto");
		}catch(NoSuchElementException i2) {
			System.out.println("Error No existe el elemento");
			interfazEs.Escribir(pw, "Error No puso el formato correcto");
		}catch(Exception e) {
			System.out.println("Se produjo un error"+e.getMessage());
		}
		if(opcion<0||opcion>5) 
			System.out.println("No introdujo ninguna opcion del menu");
		
		switch(opcion) {
		case 1:
			//Crea un repostaje Normal
			interfazEs.Escribir(pw, "Opcion Repostaje Normal elegida");
			interfaz.repostajeNormal(bd,pw);
			break;
		case 2:
			//Crea un repostaje Factura
			interfazEs.Escribir(pw, "Opcion Repostaje factura elegida");
			interfaz.repostajeFactura(bd,pw);			
			break;
		case 3:
			//Muestra lso repostajes
			interfazEs.Escribir(pw, "Opcion Mostar Repostajes elegida");
			interfaz.monstrarRepostaje(bd,pw);
			break;
		case 4:
			//Modifica el repostaje
			interfazEs.Escribir(pw, "Opcion Modificar Repostajes elegida");
			interfaz.modificarRepostaje(bd,pw);
			break;
		case 5:
			//Elimina el repostaje
			interfazEs.Escribir(pw, "Opcion Eliminar Repostaje elegida");
			interfaz.eliminarRepostaje(bd,pw);
			break;
		}
		
		}while(opcion!=0);
		//Se cierra el printwriter y el escaner
		interfazEs.Escribir(pw, "-------------------------");
		interfazEs.Cerrar(pw);
		leer.close();
	}

}
