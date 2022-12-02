package fase1;


import java.awt.event.InputEvent;
import java.nio.file.Path;
import java.util.Scanner;

import javax.management.InstanceAlreadyExistsException;

import fase2.ABBInterpretes;


public class AplicacionIMDB {
	
	public static void main(String[] args) throws InstanceAlreadyExistsException{
		CatalogoIMDB catalogo = new CatalogoIMDB();

          //TO DO: ...
		
	    //TO DO: Cargar pelculas	
		catalogo.cargarPeliculas(Path.of("src/data") + "/films.txt");

		catalogo.cargarInterpretes(Path.of("src/data") + "/cast.txt");
		
		ABBInterpretes arbol = new ABBInterpretes(catalogo.getCatalogoI().buscarInterprete("Runco, David"));
		System.out.println(arbol);
		System.out.println(arbol.buscarInterprete("Runco, David").getName());
		arbol.annadirInterprete(catalogo.getCatalogoI().buscarInterprete("Alfonso, Martin"));

//		System.out.println(arbol.getRoot().getInfo().getName());
//		System.out.println(arbol.getRoot().getLeft().getInfo().getName());
//		System.out.println(arbol.getRoot().getRight());
		System.out.println(arbol.buscarInterprete("Alfonso, Martin").getName());
		arbol.eliminarInterprete("Runco, David");
		System.out.println(arbol.buscarInterprete("Runco, David"));
		
		//Men
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		
		while(opcion!=0) {
			System.out.println("------------------MENU------------------");
			System.out.println(" Escoja una opcion:");
			System.out.println("  1. Mostrar informacion de pelicula");
			System.out.println("  2. Mostrar informacion de interprete");
			System.out.println("  3. Anadir voto a pelicula");
			System.out.println("  4. Eliminar pelicula");
			System.out.println("  0. Salir");
			System.out.println("----------------------------------------");
			
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

			   case 0:
				   System.out.println("Cerrando... ");
				   break;
			}
			
		}
		sc.close();
		

	}

}
