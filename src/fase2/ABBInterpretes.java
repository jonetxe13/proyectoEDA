package fase2;

import javax.management.InstanceAlreadyExistsException;


import fase1.Interprete;
import fase2.NodoABBInterpretes;

public class ABBInterpretes<Interprete extends Comparable<fase1.Interprete>> implements InterfaceInterpretes {
	
	private NodoABBInterpretes root;
	
	public ABBInterpretes( fase1.Interprete info ) {
		this.root = new NodoABBInterpretes(info);
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public fase1.Interprete buscarInterprete(String nombre) {
		return null;
	}
	
	public fase1.Interprete eliminarInterprete(String nombre) {
		return null;
	}
	
	public int size() {
		return 0;
	}

	@Override
	public void anadirInterprete(fase1.Interprete inter) throws InstanceAlreadyExistsException {
		// TODO Auto-generated method stub
		
	};
	
	public boolean contains(fase1.Interprete inter) {
		if (this.isEmpty())
			return false;
		else return this.root.contains(inter);
	}
}
