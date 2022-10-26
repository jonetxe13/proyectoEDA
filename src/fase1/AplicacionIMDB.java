package fase1;


import java.util.Scanner;


public class AplicacionIMDB {
	
	public static void main(String[] args){
		CatalogoIMDB catalogo = new CatalogoIMDB();

          //TO DO: ...
		
	    //TO DO: Cargar pelculas	
		
		catalogo.cargarPeliculas("/data/films.txt");
		//catalogo.imprimirInfoPelicula("Gaslicht");

	    //TO DO Cargar intrpretes
	
		
		//Men
		Scanner sc = new Scanner(System.in);
		int opcion=-1;
		
		while(opcion!=0) {
			System.out.println("Escoja una opcion:");
			System.out.println("1. Mostrar informacion de pelicula");
			System.out.println("2. Mostrar informacion de interprete");
			System.out.println("3. Anadir voto a pelocula");

			System.out.println("0. Salir");
			opcion = Integer.parseInt(sc.nextLine());
			switch(opcion) {
			   case 1:
				    //TO DO
				   	Scanner titulo = new Scanner(System.in);
				
					for(Pelicula pelicula: catalogo.getMiCatalogo().getListaPeliculas()) {
						if(pelicula.getTitulo().equals(titulo.nextLine())) catalogo.imprimirInfoPelicula(pelicula.getTitulo());
					}
			        break;
	              // TO DO
			}
		}
		sc.close();
		

	}

}