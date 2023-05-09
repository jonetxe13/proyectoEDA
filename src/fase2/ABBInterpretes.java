package fase2;

import javax.management.InstanceAlreadyExistsException;


import fase1.Interprete;
import fase2.NodoABBInterpretes;

public class ABBInterpretes implements InterfaceInterpretes {
	
	private NodoABBInterpretes root;
	
	public ABBInterpretes() {
		
	}
	
	/**
	* Devuelve si el �rbol binario est� vac�o o no
	* @return un booleano, true si esta vac�o o false si no lo est�
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
	* Elimina el nodo mas peque�o
	* @return el valor del nodo
	*/
	public Interprete removeMin() {
		if(this.isEmpty()) return null;
		else {
			ResultadoRemoveMin resul = root.removeMin();
			root = resul.elNodo;
			return resul.elValor;
		}
	}
	
	/**
	* Elimina un int�rprete del �rbol (puede seguir estando en las listas de
	* int�rpretes de las pel�culas)
	* @param nombre Nombre del int�rprete a eliminar
	* @return el Interprete (si se ha eliminado), null en caso contrario
	*/
	public Interprete eliminarInterprete(String nombre) {
		if (root != null) root = root.delete(nombre);
		return null;
	}
	
	/**
	* Devuelve el n� de elementos del �rbol.
	* @return n� de elementos del �rbol
	*/
    public int size() {
        return size(root);
    }

    // método privado auxiliar para calcular el tamaño del árbol
    private int size(NodoABBInterpretes node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    
	/**
	* A�ade un int�rprete a la lista
	* @param inter Int�rprete a a�adir
	*/
	@Override
	public void annadirInterprete(Interprete inter){
		if (this.isEmpty()) {
			this.root = new NodoABBInterpretes(inter);
		}
		else {
			this.root.annadirInterprete(inter);
		}
	}
	/**
	* Busca un int�rprete en la lista y lo devuelve
	* @param nombre Nombre del int�rprete a buscar
	* @return el Interprete (si est� en la lista), null en caso contrario
	*/
	public Interprete buscarInterprete(String nombre) {
		if (this.isEmpty())
			return null;
		else 
		return this.root.buscarInterprete(nombre);
	}
}
