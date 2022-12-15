package fase1;

import java.util.HashSet;

import javax.management.InstanceAlreadyExistsException;

public class Interprete{
	private String name;
	private ListaPeliculas listaPeliculas;
	private int numPeliculas;
	private float rating;
	
	public Interprete(String name) {
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
	 * Calcula y asigna el rating del intï¿½rprete en base al rating de sus pelï¿½culas.
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
	 * Aï¿½ade una pelï¿½cula al intï¿½rprete.
	 * @param pel Pelï¿½cula a aï¿½adir.
	 * POST: El rating del intï¿½rprete NO se modifica en este momento.
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
	
	public int compareTo(Interprete inter) {
		if(this.getName().equals(inter.getName())) return 0;
		else if(this.getName().compareTo(inter.getName()) < 0) return -1;
		return 1;
	}
	
	/**
	* Devuelve un HashSet con todos los adyacentes del intérprete, es decir,
	* aquellos intérpretes con los que ha participado en alguna película.
	* @return: el HashSet con los intérpretes que son adyacentes.
	*/
	public HashSet<Interprete> obtenerAdyacentes(){ return null; }
}
