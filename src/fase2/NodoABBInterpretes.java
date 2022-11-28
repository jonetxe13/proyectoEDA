package fase2;

import fase1.Interprete;

public class NodoABBInterpretes<Interprete extends Comparable<fase1.Interprete>>{
	
	fase1.Interprete info;
	
	public NodoABBInterpretes(fase1.Interprete info2){
		this.info = info2;
	}
	
	NodoABBInterpretes left;
	NodoABBInterpretes right;
	
	public boolean hasLeft() {
		return this.left == null;
	}
	
	public boolean hasRight() {
		return this.right == null;
	}
	
	public fase1.Interprete buscarInterprete(String nombre) {
		if (nombre.equals(this.info.getName()))
			return this.info;
		
		else if (nombre.compareTo(this.info.getName())<0) {
			if (this.hasLeft()) {
				return this.left.buscarInterprete(this.info.getName());
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
	
	public void annadirNodo(fase1.Interprete inter) {
		if (inter.compareTo(this.info)<0) { //elem debe ir antes que el actual
			 if (this.hasLeft()) this.left.annadirNodo(inter);
			 
			 else this.left = new NodoABBInterpretes<Interprete>(inter);
		}
		else { //elem debe ir después que el actual
			 if (this.hasRight()) this.right.annadirNodo(inter);
			 else this.right = new NodoABBInterpretes<Interprete>(inter);
		}

	}
	
	public ResultadoRemoveMin removeMin() {
		 ResultadoRemoveMin resul = new ResultadoRemoveMin();
		 
		 if(!this.hasLeft()) {//El mínimo es el actual
			 resul.elValor = this.info;
		 	resul.elNodo = this.right;
		 }else { //El mínimo está en el subárbol izquierdo
			 ResultadoRemoveMin resulLeft = this.left.removeMin();
			 this.left = resulLeft.elNodo;
			 resul.elValor = resulLeft.elValor;
			 resul.elNodo = this;
		 }
		 return resul;
	}
	
	public fase1.Interprete eliminarInterprete(String nombre){
		int comp = nombre.compareTo(this.info.getName());
		
		if(comp==0) {//Caso (a): this es el nodo a eliminar
			if(!this.hasLeft()) return this.right.info; //Caso (a1)
			else if(!this.hasRight()) return this.left.info; //Caso (a2)
			else {//Caso (a3): Tiene los dos subarboles, sustituir por el valor mínimo del subarbol derecho
				ResultadoRemoveMin<Interprete> min = this.right.removeMin();
				this.right = min.elNodo;
				this.info = min.elValor;
				return this.info;
			}
		}
		else if(comp<0){//Caso (b) El elemento a eliminar, si está, estará en el subárbol izq
			 if(this.hasLeft()) this.left.info = this.left.eliminarInterprete(nombre);
			 return this.info;
			
		}else {//comp>0: Caso (c) El elemento a eliminar, si está, estará en el subárbol dcho
			 if (this.hasRight()) this.right.info = this.right.eliminarInterprete(nombre);
			 return this.info;
		}
	}
}
