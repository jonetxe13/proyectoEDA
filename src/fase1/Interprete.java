package fase1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.InstanceAlreadyExistsException;

public class Interprete{
	private String name;
	private ListaPeliculas listaPeliculas;
	private float rating;
	private ArrayList<ArrayList<Interprete>>grafo;
	
	public Interprete(String name) {
		this.grafo = new ArrayList<ArrayList<Interprete>>();
		this.name = name;
		rating = -1;
		listaPeliculas = new ListaPeliculas();
	}
	
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	public float getRating() { return this.rating; }
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
//	    HashSet<Interprete> adyacentes = new HashSet<Interprete>();
//	    Queue<Interprete> cola = new LinkedList<Interprete>();
//	    HashSet<Interprete> visitados = new HashSet<Interprete>();
//	    Interprete aux;
//	    cola.add(this);
//	    visitados.add(this);
//	    while(!cola.isEmpty()) {
//	        aux = cola.remove();
////	        System.out.println("Removed from queue: " + aux.getName());
//	        for(int i = 0; i < aux.listaPeliculas.getLista().size(); i++) {
//	            for(int j = 0; j < aux.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().size(); j++) {
//	                if(!aux.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().get(j).equals(aux)) {
////	                    System.out.println("Adding to queue: " + aux.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().get(j).getName());
//	                    adyacentes.add(aux.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().get(j));
//	                    if (!visitados.contains(aux.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().get(j))) {
//	                        cola.add(aux.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().get(j));
//	                        visitados.add(aux.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().get(j));
//	                    }
//	                }
//	            }
//	        }
//	    }
//	    return adyacentes;
	    HashSet<Interprete> adyacentes = new HashSet<Interprete>();
	    for(int i = 0; i < this.listaPeliculas.getLista().size(); i++) {
	        for(int j = 0; j < this.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().size(); j++) {
	            if(!this.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().get(j).equals(this)) {
	                adyacentes.add(this.listaPeliculas.getLista().get(i).getListaInterpretes().getlista().get(j));
	            }
	        }
	    }
	    return adyacentes;

//		 Interprete nodo;
//		 Integer i;
//		
//		 HashSet<Interprete> adyacentes = new HashSet<Interprete>();
//		
//		 for (Pelicula peli: listaPeliculas.getLista()) {
//		 	for(Interprete inter: peli.getListaInterpretes().getlista()) {
//		 		adyacentes.add(inter);	
//		 	}
//		 }
//		 return adyacentes;
	}
}
