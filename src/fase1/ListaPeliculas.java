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
			lista.add(pel);
	}

	public ArrayList<Pelicula> getLista(){
		return lista;
	}

	/**
	* Imprime los titulos de las peliculas
	* @return Un String con la lista de las peliculas
	*/
	public String imprimirLista() {
		String res = "";
		for(Pelicula pelic: lista) {
			res += pelic.getTitulo() + ", ";
		}
		return res;
	}

	/**
	* Busca una pelï¿½ula en la lista y la devuelve
	* @param titulo Tï¿½ulo de la pelï¿½ula a buscar
	* @return la Pelï¿½ula (si estï¿½en la lista), null en caso contrario
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
	/**
	* Elimina de la lista la película pasada como parámetro.
	* @param pel: película a eliminar
	* @return true si se ha eliminado, false en caso contrario
	*/
	public boolean eliminarPelicula(Pelicula pel) {//FALTA POR COMPROBAR *****************************
		if(lista.remove(pel)) {
			lista.remove(pel);
			return true;
		}
		else { return false; }
	}
}
