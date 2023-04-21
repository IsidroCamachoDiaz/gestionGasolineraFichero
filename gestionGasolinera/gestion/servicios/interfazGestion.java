package servicios;

import java.io.PrintWriter;
import java.util.List;

import entidades.gestion;

public interface interfazGestion {
	
	/***
	 * Crea un repostaje normal y escribe en el fichero las acciones
	 * @param bd
	 * @param pw
	 * @return
	 */
	public List <gestion> repostajeNormal(List <gestion> bd,PrintWriter pw);
	/**
	 * Crea un repostaje factura y escribe en el fichero las acciones
	 * */
	public List <gestion> repostajeFactura(List <gestion> bd,PrintWriter pw);
	/**
	 * Muestra los reportajes y escribe en el fichero las acciones
	 * */
	public void monstrarRepostaje(List <gestion> bd,PrintWriter pw);
	/**
	 *Modifica un repostaje y escribe en el fichero las acciones
	 * */
	public List <gestion> modificarRepostaje(List <gestion> bd,PrintWriter pw);
	/**
	 * Elimina un repostaje y escribe en el fichero las acciones
	 * */
	public List <gestion> eliminarRepostaje(List <gestion> bd,PrintWriter pw);
	/**
	 * Muestra un repostaje y escribe en el fichero las acciones
	 * */
	public void mostrar(List <gestion> bd,PrintWriter pw);
}
