package fase2;

import javax.management.InstanceAlreadyExistsException;

import fase1.Interprete;

public interface InterfaceInterpretes {
	public void annadirInterprete(String string, Interprete inter);
	public Interprete eliminarInterprete(String nom);
	public int size();
	fase1.Interprete buscarInterprete(String nom);
}
