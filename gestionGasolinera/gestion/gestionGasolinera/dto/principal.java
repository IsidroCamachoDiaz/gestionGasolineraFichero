package gestionGasolinera.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		int opcion=0;
		Scanner leer = new Scanner (System.in);
		List <gestion> bd = new LinkedList <gestion>();
		
		do {
		System.out.println("1-Repostaje Normal");
		System.out.println("2-Repostaje factura");
		System.out.println("3-Ver todos los repostajes");
		System.out.println("0-Salir");
		System.out.println("Bienvenido Introduzca un opcion: ");
		opcion = leer.nextInt();
		
		switch(opcion) {
		case 1:
			
			break;
			
		
		}
		
		
		}while(opcion!=0);
		leer.close();
	}

}
