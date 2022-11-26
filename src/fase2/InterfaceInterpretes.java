package fase2;

import javax.management.InstanceAlreadyExistsException;

import fase1.Interprete;

public interface InterfaceInterpretes {
	public void anadirInterprete(Interprete inter) throws InstanceAlreadyExistsException;
	public Interprete buscarInterprete(String nom);
	public Interprete eliminarInterprete(String nom);
	public int size();
}
