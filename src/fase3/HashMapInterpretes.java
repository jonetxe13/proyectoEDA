package fase3;
import java.util.HashMap;

public class HashMapInterpretes extends HashMap{

	Item[] tabla;
	int maxsize;
	Item noItem;
	int size;

	public HashMapInterpretes(int maxsize) {
		this.maxsize = maxsize;
		this.tabla = (Item[]) new Item[maxsize];
		this.noItem = new Item(null, null);
		this.size = 0;
	}

	public void print() {

		for (int i = 0; i < maxsize; i++) {
			if (tabla[i] != null) {
				if (tabla[i].equals(noItem))
					System.out.println(i + ": noItem");
				else
					System.out.println(i + ": (" + tabla[i].clave + "," + tabla[i].valor + ")");
			} else
				System.out.println(i + ": null");
		}
		System.out.println("N� de elementos de la tabla: " + size);
	}
}
