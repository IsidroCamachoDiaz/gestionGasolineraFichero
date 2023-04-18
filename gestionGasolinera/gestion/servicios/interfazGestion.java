package servicios;

import java.io.PrintWriter;
import java.util.List;

import entidades.gestion;

public interface interfazGestion {

	public List <gestion> repostajeNormal(List <gestion> bd,PrintWriter pw);
	public List <gestion> repostajeFactura(List <gestion> bd,PrintWriter pw);
	public void monstrarRepostaje(List <gestion> bd,PrintWriter pw);
	public List <gestion> modificarRepostaje(List <gestion> bd,PrintWriter pw);
	public List <gestion> eliminarRepostaje(List <gestion> bd,PrintWriter pw);
	public void mostrar(List <gestion> bd,PrintWriter pw);
}
