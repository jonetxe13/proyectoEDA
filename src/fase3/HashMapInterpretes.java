package fase3;

import java.lang.String;
import fase1.Interprete;
import fase2.InterfaceInterpretes;

public class HashMapInterpretes implements InterfaceInterpretes{

	Item<String, fase1.Interprete>[] tabla;
	int maxsize;
	Item<String, fase1.Interprete> noItem;
	int size;

	public HashMapInterpretes(int maxsize) {
		this.maxsize = maxsize;
		this.tabla = (Item<String, fase1.Interprete>[]) new Item[maxsize];
		this.noItem = new Item<String, fase1.Interprete>(null, null);
		this.size = 0;
	}

	public int hash(String clave) {
		return Math.abs(clave.hashCode() % maxsize);
	}

	public void print() {

		for (int i = 0; i < maxsize; i++) {
			if (tabla[i] != null) {
				if (tabla[i].equals(noItem))
					System.out.println(i + ": noItem");
				else
					System.out.println(i + ": (" + tabla[i].clave + "," + tabla[i].valor + ")");
			} else
				System.out.println(i + ": null");
		}
		System.out.println("Nº de elementos de la tabla: " + size);
	}

	public fase1.Interprete remove(String clave) {
		int indice = hash((String) clave);
		boolean encontrado = false;
		while (!encontrado && tabla[indice] != null) {
			if (tabla[indice].equals(noItem))
				indice = (indice + 1) % maxsize;
			else if (tabla[indice].clave.equals(clave))
				encontrado = true;
			else
				indice = (indice + 1) % maxsize;
		}
		fase1.Interprete resultado = null;
		if (encontrado) {
			resultado = tabla[indice].valor;
			tabla[indice] = noItem;
			size--;
		}
		return resultado;
	}

	// Pre: hay huecos libres
	public fase1.Interprete put(String clave, fase1.Interprete valor) {
		// En caso de que el factor de carga supere el 0,5 habría que redimensionar(no
		// lo vamos a hacer)
		int indice = hash(clave);
		boolean encontrado = false;
		int reserva = -1;
		while (!encontrado && tabla[indice] != null) {
			if (tabla[indice].equals(noItem)) {
				if (reserva == -1) {
					reserva = indice;
				}
				indice = (indice + 1) % maxsize;
			} else if (tabla[indice].clave.equals(clave))
				encontrado = true;
			else
				indice = (indice + 1) % maxsize;
		}
		fase1.Interprete resultado = null;
		if (encontrado) {
			resultado = tabla[indice].valor;
			tabla[indice].valor = valor;
		} else {
			if (reserva != -1)
				indice = reserva;
			tabla[indice] = new Item<String, fase1.Interprete>(clave, valor);
			size++;
		}
		return resultado;
	}

	public boolean containsKey(String clave) {
		int indice = hash((String) clave);
		boolean b = false;
		while (tabla[indice] != null && !b) {
			if (tabla[indice].clave.equals(clave)) { // encontrado
				b = true;
			} else if (tabla[indice].equals(noItem)) { // noItem
				indice = (indice + 1) % maxsize;
			} else { // otro elemento
				indice = (indice + 1) % maxsize;
			}
		}
		return b;
	}

	@Override
	public void annadirInterprete(String clave, fase1.Interprete valor) {
		// TODO Auto-generated method stub
		int indice = hash(clave);
//		System.out.println(indice);
		boolean encontrado = false;
		int reserva = -1;
		
	 	while(!encontrado && tabla[indice]!=null) {
	 		if(tabla[indice].equals(noItem)) {
	 			if(reserva==-1) {
	 				reserva = indice;
	 			}
	 			indice = (indice+1)%maxsize;
	 		}else if (tabla[indice].clave.equals(clave)) encontrado = true;
	 		else indice = (indice + 1)%maxsize;
	 	}
	 	
	 	fase1.Interprete resultado;
	 	if(encontrado) {
	 		resultado = tabla[indice].valor;
	 		tabla[indice].valor = valor;
	 	}
	 	else {
	 		if(reserva!=-1) indice = reserva;
	 		tabla[indice]=new Item<String, fase1.Interprete>(clave,valor);
	 		size++;
	 	}
		
	}

	@Override
	public fase1.Interprete eliminarInterprete(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public fase1.Interprete buscarInterprete(String nom) {
		int indice = hash(nom);
		while (tabla[indice] != null) {
			if (tabla[indice].clave.equals(nom)) {
				return tabla[indice].valor;
			} else {
				indice = (indice + 1) % maxsize;
			}
		}
		return null;
	}

}
