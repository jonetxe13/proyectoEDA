package fase3;
import java.util.HashMap;

public class HashMapInterpretes extends HashMap{

	Item[] tabla;
	int maxsize;
	Item noItem;
	int size;

	public HashMapInterpretes(int maxsize) {
		this.maxsize = maxsize;
		this.tabla = (Item[]) new Item[maxsize];
		this.noItem = new Item(null, null);
		this.size = 0;
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

//	public V remove(K clave) {
//		int indice = hash((K) clave);
//		boolean encontrado = false;
//		while (!encontrado && tabla[indice] != null) {
//			if (tabla[indice].equals(noItem))
//				indice = (indice + 1) % maxsize;
//			else if (tabla[indice].clave.equals(clave))
//				encontrado = true;
//			else
//				indice = (indice + 1) % maxsize;
//		}
//		V resultado = null;
//		if (encontrado) {
//			resultado = tabla[indice].valor;
//			tabla[indice] = noItem;
//			size--;
//		}
//		return resultado;
//	}

	// Pre: hay huecos libres
//	public V put(K clave, V valor) {
//		// En caso de que el factor de carga supere el 0,5 habr�a que redimensionar(no
//		// lo vamos a hacer)
//		int indice = hash(clave);
//		boolean encontrado = false;
//		int reserva = -1;
//		while (!encontrado && tabla[indice] != null) {
//			if (tabla[indice].equals(noItem)) {
//				if (reserva == -1) {
//					reserva = indice;
//				}
//				indice = (indice + 1) % maxsize;
//			} else if (tabla[indice].clave.equals(clave))
//				encontrado = true;
//			else
//				indice = (indice + 1) % maxsize;
//		}
//		V resultado = null;
//		if (encontrado) {
//			resultado = tabla[indice].valor;
//			tabla[indice].valor = valor;
//		} else {
//			if (reserva != -1)
//				indice = reserva;
//			tabla[indice] = new Item<K, V>(clave, valor);
//			size++;
//		}
//		return resultado;
//	}

//	public boolean containsKey(K clave) {
//		int indice = hash((K) clave);
//		boolean b = false;
//		while (tabla[indice] != null && !b) {
//			if (tabla[indice].clave.equals(clave)) { // encontrado
//				b = true;
//			} else if (tabla[indice].equals(noItem)) { // noItem
//				indice = (indice + 1) % maxsize;
//			} else { // otro elemento
//				indice = (indice + 1) % maxsize;
//			}
//		}
//		return b;
//	}

//	public V get(K clave) {
//		int indice = hash((K) clave);
//		while (tabla[indice] != null) {
//			if (tabla[indice].clave.equals(clave)) {
//				return tabla[indice].valor;
//			} else {
//				indice = (indice + 1) % maxsize;
//			}
//		}
//		return null;
//	}
	
//	public V annadirInterpreteHash (K clave, V valor) {
//		int indice = hash(clave);
//		boolean encontrado = false;
//		int reserva = -1;
//		
//		 	while(!encontrado && tabla[indice]!=null) {
//		 		if(tabla[indice].equals(noItem)) {
//		 			if(reserva==-1) {
//		 				reserva = indice;
//		 			}
//		 			indice = (indice+1)%maxsize;
//		 		}else if (tabla[indice].clave.equals(clave)) encontrado = true;
//		 		else indice = (indice + 1)%maxsize;
//		 	}
//		 	
//		 	V resultado = null;
//		 	if(encontrado) {
//		 		resultado = tabla[indice].valor;
//		 		tabla[indice].valor = valor;
//		 	}
//		 	else {
//		 		if(reserva!=-1) indice = reserva;
//		 		tabla[indice]=new Item<K,V>(clave,valor);
//		 		size++;
//		 	}
//		return resultado;
//	}

}
