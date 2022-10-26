package fase1;


public class Pelicula {
	private ListaInterpretes listaInterPel = new ListaInterpretes();
	private String titulo;
	private int anno;
	private float rating;
	private float votos;
	
	public Pelicula(String titulo, int anno, float rating, int votos) {
		this.anno = anno;
		this.titulo = titulo;
		this.rating = rating;
		this.votos = votos;
	}
	
	public String getTitulo() { return this.titulo; }
	public int getAnno() { return this.anno; }
	public float getRating() { return this.rating; }
	public float getVotos() { return this.votos; }
	public ListaInterpretes getListaInterpretes() { return listaInterPel; }
	/**
	* A�de un int�prete a la pel�ula
	* @param inter Int�prete a a�dir
	*/
	public void anadirInterprete(Interprete inter) {
		listaInterPel.anadirInterprete(inter);
	}
	/**
	* A�de un nuevo voto a la pel�ula.
	* POST: se han recalculado los ratings de sus int�pretes
	* @param voto
	*/
	public void anadirVoto(float voto) {
		// Ver ayuda en siguiente apartado
		if(voto != -1.0) {
			this.rating = (this.rating * votos + voto) / (votos + 1);
			this.votos += 1;
		}
	}
	public int numInterpretes() {
		return listaInterPel.getListaInterprete().size();
	}

	public String Interpretes() {
		// TODO Auto-generated method stub
		String res = null;
		for(Interprete interp: listaInterPel.getListaInterprete()) {
			res += interp.getName() + ", ";
		}
		return res;
	}
}