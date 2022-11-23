package fase1;

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
			listaPeliculas.anadirPelicula(pel);
			numPeliculas++;
		} catch (InstanceAlreadyExistsException e) {
			e.printStackTrace();
		}
	}
}
