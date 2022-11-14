package fase1;

import java.util.ArrayList;

import javax.management.InstanceAlreadyExistsException;

public class ListaInterpretes{
	private ArrayList<Interprete> lista;
	
	public ListaInterpretes() {
		lista= new ArrayList<Interprete>();
	}
	/**
	* A�de un int�prete a la lista
	* @param inter Int�prete a a�dir
	*/
	public Interprete getInterprete(int index) {
		return lista.get(index);
	}

	public ArrayList<Interprete> getlista(){
		return lista;
	}

	public void anadirInterprete(Interprete inter) throws InstanceAlreadyExistsException {
		if (buscarInterprete(inter.getName()).equals(null)) {
			lista.add(inter);
		}
		else {throw new InstanceAlreadyExistsException();}
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
}
