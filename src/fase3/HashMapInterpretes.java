package fase3;

import java.util.HashSet;
import java.util.LinkedList;

import fase1.Interprete;
import fase2.InterfaceInterpretes;

public class HashMapInterpretes<K, Interprete> implements InterfaceInterpretes{
	
	Item<K, fase1.Interprete>[] tabla;
	int maxsize;
	Item<K, fase1.Interprete> noItem;
	int size;
	
	public HashMapInterpretes(int maxsize) {
		this.maxsize = maxsize;
		this.tabla = (Item<K, fase1.Interprete>[]) new Item[maxsize];
		this.noItem = new Item<K, fase1.Interprete>(null, null);
		this.size = 0;
	}
	
	@Override
	public void annadirInterprete(fase1.Interprete inter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public fase1.Interprete buscarInterprete(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public fase1.Interprete eliminarInterprete(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
