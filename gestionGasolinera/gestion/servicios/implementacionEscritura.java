package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class implementacionEscritura implements interfazEscritura {

	@Override
	public PrintWriter Abrir(String ruta) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ruta,true);
            pw = new PrintWriter(fichero);

        } catch (IOException ioe) {
        	System.out.print("[ERROR] - FICHERO NO ENCONTRARO: " + fichero + "\n" + ioe);
        } 
        return pw;
	}
	@Override
	public PrintWriter Escribir(PrintWriter pw,String texto) {
		pw.println(texto);
		return pw;
	}
	
	@Override
	public void Cerrar(PrintWriter fichero) {
		fichero.close();
	}
	

}
