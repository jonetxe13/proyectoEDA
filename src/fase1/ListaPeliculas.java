package fase1;

import java.util.ArrayList;

import java.util.Collection;

import java.util.Collection;
import java.util.Collections;

import javax.management.InstanceAlreadyExistsException;

/**
 * @author jonetxe13
 *
 */
public class ListaPeliculas{
	private ArrayList<Pelicula> lista;
	
	public ListaPeliculas() {
		lista= new ArrayList<Pelicula>();
	}
		
	public void anadirPelicula(Pelicula pel) throws InstanceAlreadyExistsException{		

		if (!lista.contains(pel)) {
			lista.add(pel);
		}
		else {  /**throw new InstanceAlreadyExistsException();**/}
	}

	public ArrayList<Pelicula> getLista(){
		return lista;
	}

	public String imprimirLista() {
		String res = "";
		for(Pelicula pelic: lista) {
			res += pelic.getTitulo() + ", ";
		}
		return res;
	}

	/**
	* Busca una pel�ula en la lista y la devuelve
	* @param titulo T�ulo de la pel�ula a buscar
	* @return la Pel�ula (si est�en la lista), null en caso contrario
	*/
	public Pelicula buscarPelicula(String titulo) {
		int min = 0;
		int max = lista.size();
		int pos = 0;
		while(min <= max) {
			pos = (min+max)/2;
			
			if( titulo.compareTo(lista.get(pos).getTitulo()) == 0 ) {
				return lista.get(pos);
			}
			else if( titulo.compareTo(lista.get(pos).getTitulo()) > 0 ) {
				min = pos+1;
			}
			else {
				max = pos-1;
			}
		}
		return null;
	}

	public Pelicula getPelicula(int index) {
		return lista.get(index);
	}
	
	public int tamanio() {
		return lista.size();
	}
	
	public boolean eliminarPelicula(Pelicula pel) {//FALTA POR COMPROBAR *****************************
		if(lista.remove(pel)) {
			lista.remove(pel);
			return true;
		}
		else { return false; }
	}

	public void anadirPrimeraPelicula(Pelicula peli) {
		// TODO Auto-generated method stub
		lista.add(peli);
	}
}
