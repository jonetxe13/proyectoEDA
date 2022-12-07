package fase1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.management.InstanceAlreadyExistsException;

import fase2.ABBInterpretes;

import fase2.InterfaceInterpretes;

public class CatalogoIMDB {
	private static CatalogoIMDB singletonONo;
	private ListaPeliculas catalogoPeliculas;
	private InterfaceInterpretes catalogoInterpretes;
	
	public CatalogoIMDB() {
		catalogoPeliculas = new ListaPeliculas();
	}

	public static CatalogoIMDB getSingletonInstance() {
		if(singletonONo == null) {
			singletonONo = new CatalogoIMDB();
		}
		else {
			System.out.println("No se puede crear otro objeto de CatalogoIMDB");
		}
		return singletonONo;
	}
	
	public ListaPeliculas getCatalogoP() {
		return catalogoPeliculas;
	}
	
  public InterfaceInterpretes getCatalogoI() {
		return catalogoInterpretes;
	}
	/**
	* Carga las pelï¿½ulas del catï¿½ogo desde el fichero indicado
	* @param nomF Nombre del fichero que contiene las pelï¿½ulas
	*/
	// Ver ayuda en siguiente apartado

	public void cargarPeliculas(String nomF) throws InstanceAlreadyExistsException {
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			while (entrada.hasNext()) {
				linea=entrada.nextLine();
				String[] arrayPuntos = linea.split("\t");
				Pelicula peli = new Pelicula(arrayPuntos[0], Integer.parseInt(arrayPuntos[1]),Float.parseFloat(arrayPuntos[2]),Integer.parseInt(arrayPuntos[3]));

				catalogoPeliculas.anadirPelicula(peli);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	/**
	* Carga los intï¿½pretes del catï¿½ogo desde el fichero indicado
	* POST: se han cargado los intï¿½pretes y se han calculado sus ratings
	* @param nomF Nombre del fichero que contiene los intï¿½pretes
	*/

	public void cargarInterpretes(String nomF) throws InstanceAlreadyExistsException {
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			while (entrada.hasNext()) {
				linea=entrada.nextLine();
				String[] arrayPuntos = linea.split("->");
				Interprete inter = new Interprete(arrayPuntos[0]);

				
				String[] listaTitulos = arrayPuntos[1].split("\\|\\|");
				
				for (String titulo: listaTitulos) {
					try {
						inter.anadirPelicula(catalogoPeliculas.buscarPelicula(titulo));
					}
					catch(NullPointerException e) {
						System.out.println("La pelicula de la lista tiene un simbolo no valido.");
					}
				}
				inter.calcularRating();
				catalogoInterpretes.annadirInterprete(inter);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	* Imprime por pantalla el n de intï¿½pretes de una pelï¿½ula y sus nombres
	* @param titulo Tï¿½ulo de la pelï¿½ula
	*/
	public void imprimirInfoPelicula(String titulo) {
		String resultado="";
		Pelicula peli = catalogoPeliculas.buscarPelicula(titulo);
		if (peli!=null) {
			resultado = " Titulo: " + peli.getTitulo() + "\n Anno: " + peli.getAnno() + "\n Rating: " + peli.getRating() + "\n Num. votos: " + peli.getVotos() + "\n Total de interpretes de la pelicula: " + peli.getNumInterpretes();
			for (int i = 0; i<peli.getListaInterpretes().tamanio();i++) {
				resultado = resultado + "\n" + "  - " + peli.getListaInterpretes().getlista().get(i).getName();
			}
			System.out.println(resultado);
		}
		else {
			System.out.println("¡ERROR!");
			System.out.println("La pelicula " + titulo + " no se encuentra.");
		}
	}
	/**
	* Imprime por pantalla el nombre del intï¿½prete, su rating y los tï¿½ulos
	* de sus pelï¿½ulas.
	* @param nombre Nombre del intï¿½prete
	*/
	public void imprimirInfoInterprete(String nombre) {
		String resultado="";
		Interprete inter = catalogoInterpretes.buscarInterprete(nombre);
		if (inter!=null) {
			resultado = " Nombre: " + inter.getName() + "\n Rating: " + inter.getRating() + "\n Numero de peliculas: " + inter.getNumPeliculas();
			for (int i = 0; i<inter.getListaPeliculas().tamanio();i++) {
				resultado = resultado + "\n" + "  - " + inter.getListaPeliculas().getLista().get(i).getTitulo();
			}
			System.out.println(resultado);
		}
		else {
			System.out.println("¡ERROR!");
			System.out.println("El interprete no se encuentra.");
		}
	}
	/**
	* Aï¿½de un nuevo voto a una pelï¿½ula
	* PRE: el valor del voto estï¿½entre 0.0 y 10.0.
	* @param titulo Tï¿½ulo de la pelï¿½ula
	* @param voto Valor del voto
	*/
	public void anadirVoto(String titulo, float voto) {
		if (0<=voto && voto<=10) {
			catalogoPeliculas.buscarPelicula(titulo).anadirVoto(voto);
			System.out.println("El nuevo rating de la pelicula es: " + catalogoPeliculas.buscarPelicula(titulo).getRating());
		}
		else {
			System.out.println("¡ERROR!");
			System.out.println("El voto no es valido.");
		}
	}
	
	public void setInterpretes(InterfaceInterpretes interpretes) {
		this.catalogoInterpretes = interpretes;
	}

	/**
	* Elimina del catálogo la película cuyo título se pasa como parámetro.
	* Además, elimina la película de la lista de películas de cada uno de los
	* intérpretes de dicha película.
	* Aquellos intérpretes que se quedan sin películas son eliminados del
	* catálogo, y al resto se les actualiza el rating.
	**/

	public Pelicula eliminarPelicula(String titulo) {

		Pelicula pel = catalogoPeliculas.buscarPelicula(titulo);
		ListaInterpretes interpretes = pel.getListaInterpretes();
		
		for(Interprete inter: interpretes.getlista()) {
			this.catalogoInterpretes.buscarInterprete(inter.getName()).getListaPeliculas().eliminarPelicula(pel);
			if(inter.getListaPeliculas() == null) {
				this.catalogoInterpretes.eliminarInterprete(inter.getName());
			}
		}
		this.catalogoPeliculas.eliminarPelicula(pel);

		return pel;
	}
	
}
