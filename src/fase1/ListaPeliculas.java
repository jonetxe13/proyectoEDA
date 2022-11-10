package fase1;

import java.util.ArrayList;

/**
 * @author jonetxe13
 *
 */
public class lista{
	private ArrayList<Pelicula> lista;
	
	public lista() {
		lista= new ArrayList<Pelicula>();
	}
	/**
	* A�de una pel�ula a la lista
	* @param pel Pel�ula a a�dir
	*/
	public void anadirPelicula(Pelicula pel) throws InstanceAlreadyExistsException {
		if (buscarPelicula(pel.getTitulo())==null) {
			lista.add(pel);
		}
		else {throw new InstanceAlreadyExistsException();}
	}

	public ArrayList<Pelicula> getLista(){
		return lista;
	}

	public String imprimirLista() {
		String res = null;
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
		for(Pelicula pelic: lista) {
			if(pelic.getTitulo().equals(titulo)) return pelic;
		}
		return null;
	}

	public Pelicula getPelicula(int index) {
		return lista.get(index);
	}
}
