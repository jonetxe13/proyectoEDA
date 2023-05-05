package fase2;

import fase1.Interprete;

public class NodoABBInterpretes {
	
	Interprete info;
	
	public NodoABBInterpretes(Interprete info2){
		this.info = info2;
	}
	
	NodoABBInterpretes left;
	NodoABBInterpretes right;
	
	public Interprete getInfo(){
		return this.info;
	}
	
	public NodoABBInterpretes getLeft(){
		return this.left;
	}
	
	public NodoABBInterpretes getRight(){
		return this.right;
	}
	
	public boolean hasLeft() {
		return null != this.left;
	}
	
	public boolean hasRight() {
		return null != this.right;
	}
	/**
	* Busca un int�rprete en la lista y lo devuelve
	* @param nombre Nombre del int�rprete a buscar
	* @return el Interprete (si est� en la lista), null en caso contrario
	*/
	public Interprete buscarInterprete(String nombre) {
//		System.out.println(nombre.compareTo(this.info.getName()));
//		System.out.println(this.hasLeft());
//		System.out.println(this.hasRight());
		if (nombre.compareTo(this.info.getName()) == 0)
			return this.info;
		
		else if (nombre.compareTo(this.info.getName())<0) {
			if (this.hasLeft()) {
				return this.left.buscarInterprete(nombre);
			}
			else return null;
		}
		else {
			if (this.hasRight()) {
				return this.right.buscarInterprete(nombre);
			}
			else return null;
		}
	}
	
	/**
	* A�ade un int�rprete a la lista
	* @param inter Int�rprete a a�adir
	*/
	public void annadirInterprete(Interprete inter) {
//		System.out.println(inter.compareTo(this.info));
		if (inter.compareTo(this.info)<0) { //elem debe ir antes que el actual
			 if (this.hasLeft()) this.left.annadirInterprete(inter);
			 
			 else this.left = new NodoABBInterpretes(inter);
		}
		else { //elem debe ir despu�s que el actual
			 if (this.hasRight()) this.right.annadirInterprete(inter);
			 else this.right = new NodoABBInterpretes(inter);
		}

	}
	/**
	* Elimina el nodo mas peque�o
	* @return el valor del nodo
	*/
	public ResultadoRemoveMin removeMin() {
		 ResultadoRemoveMin resul = new ResultadoRemoveMin();
		 
		 if(!this.hasLeft()) {//El m�nimo es el actual
			 resul.elValor = this.info;
		 	resul.elNodo = this.right;
		 }else { //El m�nimo est� en el sub�rbol izquierdo
			 ResultadoRemoveMin resulLeft = this.left.removeMin();
			 this.left = resulLeft.elNodo;
			 resul.elValor = resulLeft.elValor;
			 resul.elNodo = this;
		 }
		 return resul;
	}
	
	/**
	* Elimina un int�rprete del �rbol (puede seguir estando en las listas de
	* int�rpretes de las pel�culas)
	* @param nombre Nombre del int�rprete a eliminar
	* @return el Interprete (si se ha eliminado), null en caso contrario
	*/
	public Interprete eliminarInterprete(String nombre){
		int comp = nombre.compareTo(this.info.getName());
		
		if(comp==0) {//Caso (a): this es el nodo a eliminar
			if(!this.hasLeft()) return this.right.info; //Caso (a1)
			else if(!this.hasRight()) return this.left.info; //Caso (a2)
			else {//Caso (a3): Tiene los dos subarboles, sustituir por el valor m�nimo del subarbol derecho
				ResultadoRemoveMin min = this.right.removeMin();
				this.right = min.elNodo;
				this.info = min.elValor;
				return this.info;
			}
		}
		else if(comp<0){//Caso (b) El elemento a eliminar, si est�, estar� en el sub�rbol izq
			 if(this.hasLeft()) this.left.info = this.left.eliminarInterprete(nombre);
			 return this.info;
			
		}else {//comp>0: Caso (c) El elemento a eliminar, si est�, estar� en el sub�rbol dcho
			 if (this.hasRight()) this.right.info = this.right.eliminarInterprete(nombre);
			 return this.info;
		}
	}

	/**
	* Devuelve el n� de elementos del �rbol.
	* @return n� de elementos del �rbol
	*/

//	private int size(Node node) {
//	    if (node == null) {
//	        return 0;
//	    }
//	    return 1 + size(node.getLeft()) + size(node.getRight());
//	}
}
