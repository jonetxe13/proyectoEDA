package fase2;

import fase1.Interprete;
import fase2.NodoABBInterpretes;

public class ABBInterpretes<NodoABBInterpretes> implements InterfaceInterpretes {
	
	private NodoABBInterpretes root;
	
	public ABBInterpretes( Interprete info ) {
		this.root = new NodoABBInterpretes(info);
	}
	
	public boolean isEmpty() {
		return false;
	}
	public void anadirInterprete(Interprete inter) {
		
	}
	
	public Interprete buscarInterprete(String nombre) {
		return null;
	}
	
	public Interprete eliminarInterprete(String nombre) {
		return null;
	}
	
	public int size() {
		return 0;
	};
}
