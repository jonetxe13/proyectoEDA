package fase1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.InstanceAlreadyExistsException;

public class Interprete{
	private String name;
	private ListaPeliculas listaPeliculas;
	private int numPeliculas;
	private float rating;
	private ArrayList<ArrayList<Interprete>>grafo;
	
	public Interprete(String name) {
		this.grafo = new ArrayList<ArrayList<Interprete>>();
		this.name = name;
		rating = -1;
		numPeliculas = 0;
		listaPeliculas = new ListaPeliculas();
	}
	
	public String getName() { return this.name; }
	public float getRating() { return this.rating; }
	public int getNumPeliculas() { return this.numPeliculas; }
	public ListaPeliculas getListaPeliculas() { return this.listaPeliculas; }
	
  /**
	 * Calcula y asigna el rating del int�rprete en base al rating de sus pel�culas.
	 */
	public void calcularRating() {
		int cont = 0;
		float rating = 0;
		for(int i = 0; i < listaPeliculas.getLista().size(); i++) {
			if(listaPeliculas.getLista().get(i).getListaInterpretes().equals(getName())){
				rating = rating + listaPeliculas.getLista().get(i).getRating();
				cont++;
			}
		}
		this.rating = rating/cont;
	}
	
	/**
	 * A�ade una pel�cula al int�rprete.
	 * @param pel Pel�cula a a�adir.
	 * POST: El rating del int�rprete NO se modifica en este momento.
	 */
	public void anadirPelicula(Pelicula pel) {
		try {
			pel.anadirInterprete(this);
			listaPeliculas.anadirPelicula(pel);
			numPeliculas++;
		} catch (InstanceAlreadyExistsException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Compara dos nombres de interpretes
	* @return Si son iguales devuelve 0. Si es menor -1 y si es mayor 1.
	*/
	public int compareTo(Interprete inter) {
		if(this.getName().equals(inter.getName())) return 0;
		else if(this.getName().compareTo(inter.getName()) < 0) return -1;
		return 1;
	}
	
	public HashSet<Interprete> obtenerAdyacentes() { //recorrido por anchura
		Interprete nodo;
		Integer i;
		
		HashSet<Interprete> adyacentes = new HashSet<Interprete>();
		
		for (Pelicula peli: listaPeliculas.getLista()) {
			for(Interprete inter: peli.getListaInterpretes().getlista()) {
				adyacentes.add(inter);	
			}
		}
		return adyacentes;
	}
}
