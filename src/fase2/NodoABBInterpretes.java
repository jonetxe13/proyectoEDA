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
	

	 // In the Node class
	    public NodoABBInterpretes delete(String name) {
	        int comp = name.compareTo(this.info.getName());
	        if (comp < 0) {
	            if (this.left != null) this.left = this.left.delete(name);
	        } else if (comp > 0) {
	            if (this.right != null) this.right = this.right.delete(name);
	        } else {
	            if (this.left == null) return this.right;
	            else if (this.right == null) return this.left;
	            String nombre = minValue();
	            this.info.setName(nombre);
	            this.right = this.right.delete(this.info.getName());
	        }
	        return this;
	    }

	    String minValue() {
	        String minv = this.info.getName();
	        NodoABBInterpretes current = this;
	        while (current.left != null) {
	            minv = current.left.info.getName();
	            current = current.left;
	        }
	        return minv;
	    }
}