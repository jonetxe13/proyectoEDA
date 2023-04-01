package fase3;

import java.util.Iterator;

public class Item<K, V> {
	K clave;
	V valor;
	public Iterator<Item<K, V>> iterator;

	public Item(K clave, V valor) {
		this.clave = clave;
		this.valor = valor;
	}

}