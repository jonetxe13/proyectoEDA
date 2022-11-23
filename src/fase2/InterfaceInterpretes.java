package fase2;

import fase1.Interprete;

public interface InterfaceInterpretes {
	public void anadirInterprete(Interprete inter);
	public Interprete buscarInterprete(String nom);
	public Interprete eliminarInterprete(String nom);
	public int size();
}
