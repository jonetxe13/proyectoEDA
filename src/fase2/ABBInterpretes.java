package fase2;

import javax.management.InstanceAlreadyExistsException;


import fase1.Interprete;
import fase2.NodoABBInterpretes;

public class ABBInterpretes<Interprete extends Comparable<fase1.Interprete>> implements InterfaceInterpretes {
	
	private NodoABBInterpretes root;
	
	public ABBInterpretes() {
		
	}
	
	public boolean isEmpty() { //FALTA POR HACER ESTE *****************************
		return this.root == null;
	}
	
	public NodoABBInterpretes getRoot() {
		return this.root;
	}
	public fase1.Interprete removeMin() {
		if(this.isEmpty()) return null;
		else {
			ResultadoRemoveMin resul = root.removeMin();
			root = resul.elNodo;
			return resul.elValor;
		}
	}
	
	public fase1.Interprete eliminarInterprete(String nombre) {
		if(!this.isEmpty()) {
			 this.root.info = this.root.eliminarInterprete(nombre);
			 return this.root.info;
		}
		return null;

	}
	
	public int size() { // FALTA POR HACER ESTE ***********************************
		return 0;
	}

	@Override
	public void annadirInterprete(fase1.Interprete inter){
		if (this.isEmpty()) {
			this.root = new NodoABBInterpretes(inter);
		}
		else {
			this.root.annadirInterprete(inter);
		}
		
	};
	
	public fase1.Interprete buscarInterprete(String nombre) { // Arreglar esto *********************
		if (this.isEmpty())
			return null;
		else 
		return this.root.buscarInterprete(nombre);
	}
}
