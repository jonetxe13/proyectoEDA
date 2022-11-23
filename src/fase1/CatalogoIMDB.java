package fase1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.management.InstanceAlreadyExistsException;

import fase2.InterfaceInterpretes;

public class CatalogoIMDB implements InterfaceInterpretes{
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
	
	public ListaPeliculas getCatalogoP() {
		return catalogoPeliculas;
	}
	
  public ListaInterpretes getCatalogoI() {
		return catalogoInterpretes;
	}
	/**
	* Carga las pel�ulas del cat�ogo desde el fichero indicado
	* @param nomF Nombre del fichero que contiene las pel�ulas
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
	* Carga los int�pretes del cat�ogo desde el fichero indicado
	* POST: se han cargado los int�pretes y se han calculado sus ratings
	* @param nomF Nombre del fichero que contiene los int�pretes
	*/

	public void cargarInterpretes(String nomF) throws InstanceAlreadyExistsException {
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			while (entrada.hasNext()) {
				linea=entrada.nextLine();
				String[] arrayPuntos = linea.split("->");
				Interprete inter = new Interprete(arrayPuntos[0]);

				for (String peli : arrayPuntos[1].split("||")) {
				 inter.anadirPelicula(catalogoPeliculas.buscarPelicula("Hola"));
				 catalogoPeliculas.buscarPelicula(peli).anadirInterprete(inter);
				}

				inter.calcularRating();
				catalogoInterpretes.anadirInterprete(inter);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	* Imprime por pantalla el n de int�pretes de una pel�ula y sus nombres
	* @param titulo T�ulo de la pel�ula
	*/
	public void imprimirInfoPelicula(String titulo) {
		String resultado="";
		Pelicula peli = catalogoPeliculas.buscarPelicula(titulo);
		if (peli!=null) {
			resultado = "Titulo: " + peli.getTitulo() + "\n Anno: " + peli.getAnno() + "\n Rating: " + peli.getRating() + "\n Num. votos: " + peli.getVotos() + "\n Total de interpretes de la pelicula: " + peli.getNumInterpretes();
			for (int i = 0; i<peli.getListaInterpretes().tamanio();i++) {
				resultado = resultado + "\n" + peli.getListaInterpretes().getlista().get(i).getName();
			}
			System.out.println(resultado);
		}
		else {
			System.out.println("La pelicula " + titulo + " no se encuentra.");
		}
	}
	/**
	* Imprime por pantalla el nombre del int�prete, su rating y los t�ulos
	* de sus pel�ulas.
	* @param nombre Nombre del int�prete
	*/
	public void imprimirInfoInterprete(String nombre) {
		String resultado="";
		Interprete inter = catalogoInterpretes.buscarInterprete(nombre);
		if (inter!=null) {
			resultado = "Nombre: " + inter.getName() + "\n Rating: " + inter.getRating() + "\n Total de pel�culas del int�rprete: " + inter.getNumPeliculas();
			for (int i = 0; i<inter.getListaPeliculas().tamanio();i++) {
				resultado = resultado + "\n" + inter.getListaPeliculas().getLista().get(i).getTitulo();
			}
			System.out.println(resultado);
		}
		else {
			System.out.println("El int�rprete no se encuentra.");
		}
	}
	/**
	* A�de un nuevo voto a una pel�ula
	* PRE: el valor del voto est�entre 0.0 y 10.0.
	* @param titulo T�ulo de la pel�ula
	* @param voto Valor del voto
	*/
	public void anadirVoto(String titulo, float voto) {
		if (0<=voto && voto<=10) {
			catalogoPeliculas.buscarPelicula(titulo).anadirVoto(voto);
			System.out.println("El nuevo rating de la pel�cula es: " + catalogoPeliculas.buscarPelicula(titulo).getRating());
		}
		else {
			System.out.println("El voto no es v�lido.");
		}
	}
	
	public void setInterpretes(InterfaceInterpretes interpretes) {
		
	};

	@Override
	public void anadirInterprete(Interprete inter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Interprete buscarInterprete(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interprete eliminarInterprete(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Pelicula eliminarPelicula(String titulo) {
		return null;
	}
	
}
