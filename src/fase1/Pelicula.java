package fase1;


public class Pelicula {
	private ListaInterpretes listaInterPel;
	private String titulo;
	private int anno;
	private float rating;
	private float votos;
  private int numInterpretes;
	
	public Pelicula(String pTitulo, int pAnno, float pRating, int pVotos) {
		titulo=pTitulo;
		anno=pAnno;
		rating=pRating;
		votos=pVotos;
		numInterpretes=0;
		listaInterpretes = new ListaInterpretes();
	}
	
	public String getTitulo() { return this.titulo; }
	public int getAnno() { return this.anno; }
	public float getRating() { return this.rating; }
	public float getVotos() { return this.votos; }
	public int getNumInterpretes() { return this.numInterpretes; }
	public ListaInterpretes getListaInterpretes() { return listaInterPel; }
	
	/**
	* A�de un int�prete a la pel�ula
	* @param inter Int�prete a a�dir
	*/
	public void anadirInterprete(Interprete inter) {	
		try {
			listaInterPel.anadirInterprete(inter);
			numInterpretes++;
		} catch (InstanceAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			this.votos++;
		}
      else{
      votos = 1;
      rating = voto;
    }
	}
}
