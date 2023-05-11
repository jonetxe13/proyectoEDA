package fase1;


import java.awt.event.InputEvent;
import java.nio.file.Path;
import java.util.Scanner;

import javax.management.InstanceAlreadyExistsException;

import fase2.ABBInterpretes;
import fase2.NodoABBInterpretes;


public class AplicacionIMDB {
	
	public static void main(String[] args) throws InstanceAlreadyExistsException{
		CatalogoIMDB catalogo = new CatalogoIMDB();
	    //TO DO: Cargar pelculas	

		System.out.println("¡Bienvenid@ a la aplicacion de IMDB!\n"
				+ "Cargando peliculas...");



		long inicio = System.nanoTime();

		catalogo.cargarPeliculas(Path.of("src/data") + "/films_tiny.txt");

		long terminar = System.nanoTime();
		System.out.println(((terminar - inicio)/1000000) + " ms");
			
				
		ABBInterpretes arbol = new ABBInterpretes();
		catalogo.setInterpretes(arbol);
		
		System.out.println("En el catalogo hay " + catalogo.getCatalogoP().tamanio() + " peliculas.");
		//System.out.println("En el catalogo hay " + catalogo.getCatalogoP().tamanio() + " peliculas.");
		System.out.println("Cargando interpretes...");
		long startTime = System.nanoTime();
		catalogo.cargarInterpretes(Path.of("src/data") + "/cast_tiny.txt");

		long endTime = System.nanoTime();
		System.out.println(((endTime - startTime)/1000000) + " ms");
		
		System.out.println("En el catalogo hay " + catalogo.getCatalogoI().size() + " interpretes. \n");
		
		// esto no vaaa************
		try {
		catalogo.imprimirCamino("Lockwood, Melinda", "McConnell, Claudia (I)");
		}
		catch (NullPointerException o) {
			System.out.println("El Camino no se ha encontrado.");
		}
		
		
		// esto no vaaa************

		//Men
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		
		while(opcion!=0) {

			System.out.println("\n Escoja una opcion:");
			System.out.println("  1. Mostrar informacion de pelicula");
			System.out.println("  2. Mostrar informacion de interprete");
			System.out.println("  3. Anadir voto a pelicula");
			System.out.println("  4. Eliminar pelicula");
			System.out.println("  5. Eliminar Interprete");
			System.out.println("  0. Salir");
			
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
			   case 1:
				    System.out.println("Introduce el titulo de la pelicula a buscar: ");
				
				    	String titulo = sc.nextLine();
				    	
				    if(catalogo.getCatalogoP().buscarPelicula(titulo)!=null) {
				    	catalogo.imprimirInfoPelicula(titulo);
				    }
				    else {
				    	System.out.println("¡ERROR!");
				    	System.out.println("La pelicula '" + titulo + "' no se encuentra en el catalogo");
				    }
				    
					break;

			   case 2:
				   System.out.println("Introduce el nombre del interprete a buscar: ");
				   
					   String nombre = sc.nextLine();
					   
					   if (catalogo.getCatalogoI().buscarInterprete(nombre)!=null) {
						   catalogo.imprimirInfoInterprete(nombre);
					   }
					   else {
						   System.out.println("¡ERROR!");
						   System.out.println("El interprete '" + nombre + "' no se escuentra en el catalogo");
					   }
				   
				   break;

			   case 3: 
				  System.out.println("Introduce el titulo de la pelicula a la cual le quieras annadir el voto: \n"); 
				  
					  String peli = sc.nextLine();
					  
					  if(catalogo.getCatalogoP().buscarPelicula(peli) != null){
						  System.out.println("Introduce el numero del voto que quieras annadir: ");
						  float voto = Float.parseFloat(sc.nextLine());
						  catalogo.anadirVoto(peli, voto);
					  }
					  else{
						  System.out.println("¡ERROR!");
						  System.out.println("La pelicula '" + peli + "' no se encuentra en el catalogo");
					  }
				  

				    
				   break;
				   
			   case 4: 
				   System.out.println("Introduzca el titulo de una pelicula: \n");
				   
				   String titul = sc.nextLine();
				   
				   if(catalogo.getCatalogoP().buscarPelicula(titul)!=null) {
					   catalogo.eliminarPelicula(titul);
					   System.out.println("En el catalogo quedan " + catalogo.getCatalogoP().tamanio() + " peliculas y " + catalogo.getCatalogoI().size() + " interpretes. \n");
				   }
				   else {
					   System.out.println("¡ERROR!");
					   System.out.println("La pelicula '" + titul + "' no se encuentra en el catalogo");
				   }
				   break;
				  
				   
			   case 5: 
				   System.out.println("Introduzca el nombre de un interprete: \n");
				   
				   String nomb = sc.nextLine();
				   
				   if(catalogo.getCatalogoI().buscarInterprete(nomb)!=null) {
					   catalogo.getCatalogoI().eliminarInterprete(nomb);
					   System.out.println("En el catalogo quedan " + catalogo.getCatalogoP().tamanio() + " peliculas y " + catalogo.getCatalogoI().size() + " interpretes. \n");
				   }
				   else {
					   System.out.println("¡ERROR!");
					   System.out.println("El interprete '" + nomb + "' no se encuentra en el catalogo");
				   }
				   break;
			   
				   
			   case 0:
				   System.out.println("Cerrando... ");
				   break;
			}
			
		}
		sc.close();
		

	}

}
