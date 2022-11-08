package fase1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CatalogoIMDB {
	private static CatalogoIMDB singletonONo;
	private ListaPeliculas catalogoPeliculas;
	private ListaInterpretes catalogoInterpretes;
	
	public CatalogoIMDB() {
		catalogoPeliculas = new ListaPeliculas();
		catalogoInterpretes = new ListaInterpretes();
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
	
	/**
	* Carga las pel�ulas del cat�ogo desde el fichero indicado
	* @param nomF Nombre del fichero que contiene las pel�ulas
	*/
	public void cargarPeliculas(String nomF) {
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));
			String lines;
			while(entrada.hasNext()) {
				String res = "";
				int finalNombre = 0; //donde ya el tipo no es string
				String floating = "";
				String anno = "";
				String votos = "";
				lines = entrada.nextLine();
				String linesSeparated[] = lines.split("\t"); //info de las peliculas separadas por cada tab
				for(int i = 0; i < linesSeparated.length - 1; i++) {
					if(linesSeparated[i].contains("a") || linesSeparated[i].contains("e") || linesSeparated[i].contains("-")) {
						res += linesSeparated[i] + " ";					
					}
					else {
						finalNombre = i;
						break;
					}
				}
				Pelicula pelic = new Pelicula(linesSeparated[0]);
				
				pelic.setAnno(Integer.parseInt(linesSeparated[1]));
				pelic.setRating(Float.parseFloat(linesSeparated[2]));
				pelic.setAnno(Integer.parseInt(linesSeparated[3]));

				catalogoPeliculas.anadirPelicula(pelic);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	// Ver ayuda en siguiente apartado
	/**
	* Carga los int�pretes del cat�ogo desde el fichero indicado
	* POST: se han cargado los int�pretes y se han calculado sus ratings
	* @param nomF Nombre del fichero que contiene los int�pretes
	*/
	public void cargarInterpretes(String nomF) {
		try {
			
			Scanner entrada = new Scanner(new FileReader(nomF));
			String lines;
			while(entrada.hasNext()) {
				String res = "";
				int finalNombre = 0; //donde ya el tipo no es string

				lines = entrada.nextLine();
				String linesSeparated[] = lines.split("->"); //info de las peliculas separadas por cada tab
				Interprete inter = new Interprete( linesSeparated[0] );
				
				String linesSeparated2[] = linesSeparated[1].split("\\|\\|");
				for( String titulo: linesSeparated2 ) {
					inter.anadirPelicula(new Pelicula(titulo));
				}
				catalogoInterpretes.anadirInterprete(inter);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	* Imprime por pantalla el n de int�pretes de una pel�ula y sus nombres
	* @param titulo T�ulo de la pel�ula
	*/
	public void imprimirInfoPelicula(String titulo) {
		Pelicula pelic = catalogoPeliculas.buscarPelicula(titulo);
		System.out.println("Titulo: " + pelic.getTitulo());
		System.out.println("Numero de interpretes en la pelicula: " + pelic.numInterpretes());
		System.out.println("\nInterpretes: " + pelic.Interpretes());
	}
	/**
	* Imprime por pantalla el nombre del int�prete, su rating y los t�ulos
	* de sus pel�ulas.
	* @param nombre Nombre del int�prete
	*/
	public void imprimirInfoInterprete(String nombre) {
		Interprete inter = catalogoInterpretes.buscarInterprete(nombre);
		System.out.println(inter.getName() + "\n");
		System.out.println(inter.getRating() + "\n");
		System.out.println(inter.getListaPeliculas().imprimirLista() + "\n");					
	}
	/**
	* A�de un nuevo voto a una pel�ula
	* PRE: el valor del voto est�entre 0.0 y 10.0.
	* @param titulo T�ulo de la pel�ula
	* @param voto Valor del voto
	*/
	public void anadirVoto(String titulo, float voto) {
		catalogoPeliculas.buscarPelicula(titulo).anadirVoto(voto);;
		
	}
	
	public ListaPeliculas getMiCatalogoPeliculas() {
		return catalogoPeliculas;
	}
}