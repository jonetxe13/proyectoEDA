package fase1;

import java.util.ArrayList;

/**
 * @author jonetxe13
 *
 */
public class ListaPeliculas {
	private ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	
	/**
	* A�de una pel�ula a la lista
	* @param pel Pel�ula a a�dir
	*/
	public void anadirPelicula(Pelicula pel) {
		listaPeliculas.add(pel);
	}
	public ArrayList<Pelicula> getListaPeliculas(){
		return listaPeliculas;
	}
	public String imprimirLista() {
		String res = null;
		for(Pelicula pelic: listaPeliculas) {
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
		for(Pelicula pelic: listaPeliculas) {
			if(pelic.getTitulo() == titulo) return pelic;
		}
		return null;
	}

}