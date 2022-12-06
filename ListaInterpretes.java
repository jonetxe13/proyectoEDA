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

	public void annadirInterprete(Interprete inter){
		try {
			if(buscarInterprete(inter.getName()) == null) {
				lista.add(inter);
			}
			else {
				throw new InstanceAlreadyExistsException();
			}
		}
		catch( InstanceAlreadyExistsException e ) {
			System.out.println("El interprete ya se encuentra en la lista.");
		}
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
}
