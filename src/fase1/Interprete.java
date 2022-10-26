package fase1;


public class Interprete{
	private String name;
	private ListaPeliculas listaPeliculas;
	private float rating;
	private float votos;
	
	public Interprete(String name, Pelicula pelicula) {
		this.name = name;
		listaPeliculas.anadirPelicula(pelicula);
	}
	
	public String getName() { return this.name; }
	public float getRating() { return this.rating; }
	public ListaPeliculas getListaPeliculas() { return this.listaPeliculas; }
	/**
	* Calcula y asigna el rating del int�prete en base al rating de sus pel�ulas
	*/
	public void calcularRating() { // Ver ayuda en siguiente apartado
		
		for( Pelicula pelic: listaPeliculas.getListaPeliculas()) {
			rating += pelic.getRating()*pelic.getVotos();
			votos += pelic.getVotos();
		}
		rating = rating / votos;
	}
	
	/**
	* A�de una pel�ula al int�prete
	* @param pel Pel�ula a a�dir
	* POST: El rating del int�prete NO se modifica en este momento
	*/
	public void anadirPelicula(Pelicula pel) {
		listaPeliculas.anadirPelicula(pel);
	}
}