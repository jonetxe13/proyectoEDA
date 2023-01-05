package fase1;

import java.util.ArrayList;

import javax.management.InstanceAlreadyExistsException;

import fase2.InterfaceInterpretes;

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
	* Añade un intérprete a la lista
	* @param inter Intérprete a añadir
	*/
	public void annadirInterprete(Interprete inter){
				lista.add(inter);
	}
	
	/**
	* Busca un intï¿½prete en la lista y lo devuelve
	* @param nombre Nombre del intï¿½prete a buscar
	* @return el Interprete (si estï¿½en la lista), null en caso contrario
	*/
	public Interprete buscarInterprete(String nombre) {
		for(Interprete inter: lista) {
			if(inter.getName().equals(nombre)) return inter;
		}
		return null;
	}

	/**
	* Devuelve el tamaño de la lista
	* @return un entero con el tamaño
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

	@Override
	public void annadirInterprete(String string, Interprete inter) {
		// TODO Auto-generated method stub
		
	}
}
