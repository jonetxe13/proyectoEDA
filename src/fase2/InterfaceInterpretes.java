package fase2;

import javax.management.InstanceAlreadyExistsException;

import fase1.Interprete;

public interface InterfaceInterpretes {
	public void annadirInterprete(Interprete inter);
	public Interprete buscarInterprete(String nom);
	public Interprete eliminarInterprete(String nom);
	public int size();
	public int sizeI(NodoABBInterpretes root);
}
