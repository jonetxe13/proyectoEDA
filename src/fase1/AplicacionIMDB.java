package fase1;


import java.awt.event.InputEvent;
import java.nio.file.Path;
import java.util.Scanner;


public class AplicacionIMDB {
	
	public static void main(String[] args){
		CatalogoIMDB catalogo = new CatalogoIMDB();

          //TO DO: ...
		
	    //TO DO: Cargar pelculas	
		
		catalogo.cargarPeliculas(Path.of("src/data").toString() + "/films.txt");

	    //TO DO Cargar intrpretes
		catalogo.cargarInterpretes(Path.of("src/data").toString() + "/cast.txt");
	
		
		//Men
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		
		while(opcion!=0) {
			System.out.println("Escoja una opcion:");
			System.out.println("1. Mostrar informacion de pelicula");
			System.out.println("2. Mostrar informacion de interprete");
			System.out.println("3. Anadir voto a pelicula");
			System.out.println("4. Eliminar pelicula");

			System.out.println("0. Salir");
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
			   case 1:
				    //TO DO
				    System.out.println("Introduce el titulo de la pelicula a buscar: ");
				   	String titulo = sc.nextLine();
				
					catalogo.imprimirInfoPelicula(titulo);
			        break;
			   case 2:
				   System.out.println("Introduce el nombre del interprete a buscar: ");
				   String nombre = sc.nextLine();
				   
				   catalogo.imprimirInfoInterprete(nombre);
			   case 3: 
				   System.out.println("Introduce el voto que quieras annadir: ");
				   int voto = sc.nextInt();
				   System.out.println("Introduce el titulo de la pelicula a la que lo quieras annadir: ");
				   String nomPelicula = sc.nextLine();
				   
				   catalogo.anadirVoto(nomPelicula, voto);
				   
				   
			   case 0:
				   System.out.println("Cerrando... ");
			}
			
		}
		sc.close();
		

	}

}