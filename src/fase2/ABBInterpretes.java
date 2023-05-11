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
		if(!this.isEmpty()) {
			 this.root.info = this.root.eliminarInterprete(nombre);
			 return this.root.info;
		}
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
	
	
	
	
//	public void eliminarNodo(String nombre) {
//	    root = eliminarNodoAux(root, nombre);
//	}
//
//	
//	
//	private NodoABBInterpretes eliminarNodoAux(NodoABBInterpretes nodo, String nombre) {
//	    // Caso base: si el nodo es nulo, no hay nada que eliminar
//	    if (nodo == null) {
//	        return null;
//	    }
//	    
//	    
//	    // Si el nombre buscado es menor que el del nodo actual, busca en el subárbol izquierdo
//	    if (nombre.compareTo(nodo.info.getName()) < 0) {
//	        nodo.left = eliminarNodoAux(nodo.left, nombre);
//	    }
//	    // Si el nombre buscado es mayor que el del nodo actual, busca en el subárbol derecho
//	    else if (nombre.compareTo(nodo.info.getName()) > 0) {
//	        nodo.right = eliminarNodoAux(nodo.right, nombre);
//	    }
//	    // Si el nombre buscado es igual al del nodo actual, elimina el nodo y reorganiza el árbol
//	    else {
//	        // Si el nodo tiene al menos un hijo, reemplázalo por el nodo que tenga
//	        if (nodo.left == null) {
//	            return nodo.right;
//	        } else if (nodo.right == null) {
//	            return nodo.left;
//	        }
//	        
//	        // Si el nodo tiene dos hijos, busca el sucesor en orden y reemplázalo
//	        NodoABBInterpretes sucesor = buscarSucesor(nodo.right);
//	        nodo.info = sucesor.info;
//	        nodo.right = eliminarNodoAux(nodo.right, sucesor.info.getName());
//	    }
//	    
//	    return nodo;
//	}
//
//	private NodoABBInterpretes buscarSucesor(NodoABBInterpretes nodo) {
//		
//	    NodoABBInterpretes actual = nodo;
//	    while (actual.left != null) {
//	        actual = actual.left;
//	    }
//	    return actual;
//	}	
}

