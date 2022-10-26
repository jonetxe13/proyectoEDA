package fase1;

import java.util.ArrayList;

public class ListaInterpretes{
	private ArrayList<Interprete> listaInterpretes;
	
	public ListaInterpretes() {
		
	}
	/**
	* A�de un int�prete a la lista
	* @param inter Int�prete a a�dir
	*/
	public void anadirInterprete(Interprete inter) {
		listaInterpretes.add(inter);
	}
	public ArrayList<Interprete> getListaInterprete(){
		return listaInterpretes;
	}
	/**
	* Busca un int�prete en la lista y lo devuelve
	* @param nombre Nombre del int�prete a buscar
	* @return el Interprete (si est�en la lista), null en caso contrario
	*/
	public Interprete buscarInterprete(String nombre) {
		for(Interprete inter: listaInterpretes) {
			if(inter.getName() == nombre) return inter;
		}
		return null;
	}
}