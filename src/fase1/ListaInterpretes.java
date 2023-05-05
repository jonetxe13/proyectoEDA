package fase1;

import java.util.ArrayList;

import javax.management.InstanceAlreadyExistsException;

import fase2.InterfaceInterpretes;
import fase2.NodoABBInterpretes;

public class ListaInterpretes implements InterfaceInterpretes{
	private ArrayList<Interprete> lista;
	
	public ListaInterpretes() {
		lista= new ArrayList<Interprete>();
	}

	public Interprete getInterprete(int index) {
		return lista.get(index);
	}

	public ArrayList<Interprete> getlista(){
		return lista;
	}

	/**
	* A�ade un int�rprete a la lista
	* @param inter Int�rprete a a�adir
	*/
	public void annadirInterprete(Interprete inter){
				lista.add(inter);
	}
	
	/**
	* Busca un int�prete en la lista y lo devuelve
	* @param nombre Nombre del int�prete a buscar
	* @return el Interprete (si est�en la lista), null en caso contrario
	*/
	public Interprete buscarInterprete(String nombre) {
		for(Interprete inter: lista) {
			if(inter.getName().equals(nombre)) return inter;
		}
		return null;
	}

	/**
	* Devuelve el tama�o de la lista
	* @return un entero con el tama�o
	*/
	public int tamanio(){
	    return lista.size();
	}
	
	@Override
	public Interprete eliminarInterprete(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		return lista.size();
	}
	
	public int sizeI(NodoABBInterpretes root) {
		return 0;
	}
}
