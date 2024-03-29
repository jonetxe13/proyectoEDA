package fase1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
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
		if (singletonONo == null) {
			singletonONo = new CatalogoIMDB();
		} else {
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
	 * Carga las pel�ulas del cat�ogo desde el fichero indicado
	 * 
	 * @param nomF Nombre del fichero que contiene las pel�ulas
	 */
	// Ver ayuda en siguiente apartado

	/**
	 * @param nomF
	 * @throws InstanceAlreadyExistsException
	 */
	public void cargarPeliculas(String nomF) throws InstanceAlreadyExistsException {
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String[] arrayPuntos = linea.split("\t");
				Pelicula peli = new Pelicula(arrayPuntos[0], Integer.parseInt(arrayPuntos[1]),
						Float.parseFloat(arrayPuntos[2]), Integer.parseInt(arrayPuntos[3]));
				catalogoPeliculas.anadirPelicula(peli);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga los int�pretes del cat�ogo desde el fichero indicado POST: se han
	 * cargado los int�pretes y se han calculado sus ratings
	 * 
	 * @param nomF Nombre del fichero que contiene los int�pretes
	 */

	public void cargarInterpretes(String nomF) throws InstanceAlreadyExistsException {
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String[] arrayPuntos = linea.split("->");
				Interprete inter = new Interprete(arrayPuntos[0]);
				String[] listaTitulos = arrayPuntos[1].split("\\|\\|");
				for (String titulo : listaTitulos) {
					try {
						inter.anadirPelicula(catalogoPeliculas.buscarPelicula(titulo));
					} catch (NullPointerException e) {
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
	 * Imprime por pantalla el n de int�pretes de una pel�ula y sus nombres
	 * 
	 * @param titulo T�ulo de la pel�ula
	 */
	public void imprimirInfoPelicula(String titulo) {
		String resultado = "";
		Pelicula peli = catalogoPeliculas.buscarPelicula(titulo);
		if (peli != null) {
			resultado = " Titulo: " + peli.getTitulo() + "\n Anno: " + peli.getAnno() + "\n Rating: " + peli.getRating()
					+ "\n Num. votos: " + peli.getVotos() + "\n Total de interpretes de la pelicula: "
					+ peli.getNumInterpretes();
			for (int i = 0; i < peli.getListaInterpretes().tamanio(); i++) {
				resultado = resultado + "\n" + "  - " + peli.getListaInterpretes().getlista().get(i).getName();
			}
			System.out.println(resultado);
		} else {
			System.out.println("¡ERROR!");
			System.out.println("La pelicula " + titulo + " no se encuentra en el catalogo.");
		}
	}

	/**
	 * Imprime por pantalla el nombre del int�prete, su rating y los t�ulos de
	 * sus pel�ulas.
	 * 
	 * @param nombre Nombre del int�prete
	 */
	public void imprimirInfoInterprete(String nombre) {
		String resultado = "";
		Interprete inter = catalogoInterpretes.buscarInterprete(nombre);
		if (inter != null) {
			resultado = " Nombre: " + inter.getName() + "\n Rating: " + inter.getRating() + "\n Numero de peliculas: "
					+ inter.getListaPeliculas().tamanio();
			for (int i = 0; i < inter.getListaPeliculas().tamanio(); i++) {
				resultado = resultado + "\n" + "  - " + inter.getListaPeliculas().getLista().get(i).getTitulo();
			}
			System.out.println(resultado);
		} else {
			System.out.println("�ERROR!");
			System.out.println("El interprete no se encuentra.");
		}
	}

	/**
	 * A�de un nuevo voto a una pel�ula PRE: el valor del voto est�entre 0.0 y
	 * 10.0.
	 * 
	 * @param titulo T�ulo de la pel�ula
	 * @param voto   Valor del voto
	 */
	public void anadirVoto(String titulo, float voto) {
		if (0 <= voto && voto <= 10) {
			catalogoPeliculas.buscarPelicula(titulo).anadirVoto(voto);
			System.out.println(
					"El nuevo rating de la pelicula es: " + catalogoPeliculas.buscarPelicula(titulo).getRating());
		} else {
			System.out.println("¡ERROR!");
			System.out.println("El voto no es valido.");
		}
	}

	/**
	 * Inicializa el conjunto de int�rpretes del cat�logo con el conjunto de
	 * int�rpretes que se le pasa como par�metro
	 * 
	 * @param int�rpretes: conjunto de int�rpretes
	 */
	public void setInterpretes(InterfaceInterpretes interpretes) {
		this.catalogoInterpretes = interpretes;
	}

	/**
	 * Elimina del cat�logo la pel�cula cuyo t�tulo se pasa como par�metro. Adem�s,
	 * elimina la pel�cula de la lista de pel�culas de cada uno de los int�rpretes
	 * de dicha pel�cula. Aquellos int�rpretes que se quedan sin pel�culas son
	 * eliminados del cat�logo, y al resto se les actualiza el rating.
	 **/
	public Pelicula eliminarPelicula(String titulo) {

		Pelicula pel = catalogoPeliculas.buscarPelicula(titulo);
		ListaInterpretes interpretes = pel.getListaInterpretes();

		for (Interprete inter : interpretes.getlista()) {
			inter.getListaPeliculas().eliminarPelicula(pel);
			this.catalogoInterpretes.eliminarInterprete(inter.getName());
		}
		this.catalogoPeliculas.eliminarPelicula(pel);

		return pel;
	}

	/**
	 * Devuelve la distancia m�nima entre dos int�rpretes dados.
	 * 
	 * @param inter1: nombre del primer int�rprete
	 * @param inter2: nombre del segundo int�rprete
	 * @return: distancia m�nima entre ambos int�rpretes. En caso de que no est�n
	 *          conectados, devuelve -1.
	 */
	public int distancia(String inter1, String inter2) {

		HashMap<String, Integer> visitados = new HashMap<String, Integer>();

		Queue<Interprete> cola = new LinkedList<Interprete>();
		Interprete inter;
		cola.add(catalogoInterpretes.buscarInterprete(inter1));
		visitados.put(inter1, 0);

		boolean encontrado = false;

		while (!cola.isEmpty() && !encontrado) {
			inter = cola.remove();

			if (inter.getName().equals(inter2))
				encontrado = true;
			else {
				for (Interprete aux : inter.obtenerAdyacentes()) {
					if (!visitados.containsKey(aux.getName())) {
						cola.add(aux);
						visitados.put(aux.getName(), visitados.get(inter.getName()) + 1);
					}
				}
			}
		}
		if (encontrado)
			return visitados.get(inter2);
		else
			return -1;
	}

	/**
	 * Imprime el camino m�s corto entre dos int�rpretes. Si no existe camino,
	 * imprime un mensaje indicando este hecho.
	 * 
	 * @param inter1: nombre del primer int�rprete
	 * @param inter2: nombre del segundo int�rprete
	 */
	public void imprimirCamino(String inter1, String inter2) {
		
		HashMap<String, String> visitados = new HashMap<String, String>();

		Queue<Interprete> cola = new LinkedList<Interprete>();
		Interprete inter;
		cola.add(catalogoInterpretes.buscarInterprete(inter1));

		visitados.put(inter1, null);

		boolean encontrado = false;

		while (!cola.isEmpty() && !encontrado) {
			inter = cola.remove();
			if (inter.getName().equals(inter2)) {
				encontrado = true;
			}
			else {
				for (Interprete aux : inter.obtenerAdyacentes()) {
					if (!visitados.containsKey(aux.getName())) {
						cola.add(aux);
						visitados.put(aux.getName(), inter.getName());
					}
				}
			}
		}
		if (encontrado) {
			String camino = "";
			String aux = inter2;
			while (aux != null) {
				camino = aux + " -> " + camino;
				aux = visitados.get(aux);
			}
			System.out.println("[ " + camino + " ]");
		} else
			System.out.println("No existe camino entre los interpretes");
	}
}
