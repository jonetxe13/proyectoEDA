package fase2;

import javax.management.InstanceAlreadyExistsException;


import fase1.Interprete;
import fase2.NodoABBInterpretes;

public class ABBInterpretes<Interprete extends Comparable<fase1.Interprete>> implements InterfaceInterpretes {
	
	private NodoABBInterpretes root;
	
	public ABBInterpretes() {
		
	}
	
	/**
	* Devuelve si el árbol binario está vacío o no
	* @return un booleano, true si esta vacío o false si no lo está
	*/
	public boolean isEmpty() {
		return this.root == null;
	}
	
	/**
	* Devuelve el primer nodo del arbol
	* @return el nodo
	*/
	public NodoABBInterpretes getRoot() {
		return this.root;
	}
	
	/**
	* Elimina el nodo mas pequeño
	* @return el valor del nodo
	*/
	public fase1.Interprete removeMin() {
		if(this.isEmpty()) return null;
		else {
			ResultadoRemoveMin resul = root.removeMin();
			root = resul.elNodo;
			return resul.elValor;
		}
	}
	
	/**
	* Elimina un intérprete del árbol (puede seguir estando en las listas de
	* intérpretes de las películas)
	* @param nombre Nombre del intérprete a eliminar
	* @return el Interprete (si se ha eliminado), null en caso contrario
	*/
	public fase1.Interprete eliminarInterprete(String nombre) {
		if(!this.isEmpty()) {
			 this.root.info = this.root.eliminarInterprete(nombre);
			 return this.root.info;
		}
		return null;
	}
	
	/**
	* Devuelve el nº de elementos del árbol.
	* @return nº de elementos del árbol
	*/
	public int size() {
		if(!this.isEmpty()) {
			return this.root.size(0);
		}
		return -1;
	}
	/**
	* Añade un intérprete a la lista
	* @param inter Intérprete a añadir
	*/
	@Override
	public void annadirInterprete(fase1.Interprete inter){
		if (this.isEmpty()) {
			this.root = new NodoABBInterpretes(inter);
		}
		else {
			this.root.annadirInterprete(inter);
		}
	}
	/**
	* Busca un intérprete en la lista y lo devuelve
	* @param nombre Nombre del intérprete a buscar
	* @return el Interprete (si está en la lista), null en caso contrario
	*/
	public fase1.Interprete buscarInterprete(String nombre) {
		if (this.isEmpty())
			return null;
		else 
		return this.root.buscarInterprete(nombre);
	}
}
