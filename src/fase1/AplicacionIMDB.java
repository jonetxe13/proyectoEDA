package fase1;


import java.awt.event.InputEvent;
import java.nio.file.Path;
import java.util.Scanner;

import javax.management.InstanceAlreadyExistsException;

import fase2.ABBInterpretes;
import fase3.HashMapInterpretes;


public class AplicacionIMDB {
	
	public static void main(String[] args) throws InstanceAlreadyExistsException{
		CatalogoIMDB catalogo = new CatalogoIMDB();
	    //TO DO: Cargar pelculas	

		System.out.println("¡Bienvenid@ a la aplicación de IMDB!\n"
				+ "Cargando películas...");


		long inicio = System.nanoTime();

		catalogo.cargarPeliculas(Path.of("src/data") + "/films_small.txt");

		long terminar = System.nanoTime();
		System.out.println((terminar - inicio)/1000000);
		
		
		System.out.println("Cargando interpretes...");

		
		HashMapInterpretes hashmap = new HashMapInterpretes(3000000);
		catalogo.setInterpretes(hashmap);
		

		System.out.println("En el catalogo hay " + catalogo.getCatalogoP().tamanio() + " peliculas.");
		System.out.println("Cargando interpretes...");
		long startTime = System.nanoTime();
		catalogo.cargarInterpretes(Path.of("src/data") + "/cast_small.txt");

		long endTime = System.nanoTime();
		System.out.println((endTime - startTime)/1000000);
		
		System.out.println("En el catalogo hay " + catalogo.getCatalogoI().size() + " interpretes. \n");
		
		
		// seccion para pruebas *****************************************************************************************************************
//		System.out.println(catalogo.getCatalogoI().buscarInterprete("Laguiller, Arlette").getName());
		System.out.println(catalogo.distancia("Laguiller, Arlette", "Powell, Josh (I)"));
		catalogo.imprimirCamino("Powell, Josh (I)", "Burgos, Gilberto");
		System.out.println(catalogo.getCatalogoI().buscarInterprete("Powell, Josh (I)").obtenerAdyacentes().contains(catalogo.getCatalogoI().buscarInterprete("Burgos, Gilberto")));
		// fin seccion para pruebas *************************************************************************************************************

		//Men
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		
		while(opcion!=0) {

			System.out.println(" Escoja una opcion:");
			System.out.println("  1. Mostrar informacion de pelicula");
			System.out.println("  2. Mostrar informacion de interprete");
			System.out.println("  3. Anadir voto a pelicula");
			System.out.println("  4. Eliminar pelicula");
			System.out.println("  5. Distancia entre dos interpretes");
			System.out.println("  6. Obtener camino mas corto entre dos interpretes");
			System.out.println("  0. Salir");
			
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
			   case 1:
				    System.out.println("Introduce el titulo de la pelicula a buscar: ");
				   	String titulo = sc.nextLine();
					catalogo.imprimirInfoPelicula(titulo);
					break;

			   case 2:
				   System.out.println("Introduce el nombre del interprete a buscar: ");
				   String nombre = sc.nextLine();
				   catalogo.imprimirInfoInterprete(nombre);
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
					   System.out.println("La pelicula no se encuentra en el catalogo");
				   }
				   break;
				   
			   case 4: 
				   System.out.println("Introduzca el titulo de una pelicula: \n");
				   catalogo.eliminarPelicula(sc.nextLine());
				   System.out.println("En el catalogo quedan " + catalogo.getCatalogoP().tamanio() + " y " + catalogo.getCatalogoI().size() + " interpretes. \n");
				   break;
			   case 5: 
				   System.out.println("Introduzca el nombre de dos interpretes: \n");
				   String inter1 = sc.nextLine();
				   String inter2 = sc.nextLine();
				   System.out.println(catalogo.distancia(inter1, inter2));
				   break;
			   case 6: 
				   System.out.println("Introduzca el nombre de dos interpretes: \n");
				   String inter3 = sc.nextLine();
				   String inter4 = sc.nextLine();
				   catalogo.imprimirCamino(inter3, inter4);
				   break;
			   case 0:
				   System.out.println("Cerrando... ");
				   break;
			}
			
		}
		sc.close();
	}

}
