package servicios;

import java.io.FileWriter;
import java.io.PrintWriter;

public interface interfazEscritura {
	public PrintWriter Abrir(String ruta);
	public PrintWriter Escribir(PrintWriter pw,String texto);
	public void Cerrar(PrintWriter fichero);

}