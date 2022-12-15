package fase3;

public class Item<K, Interprete> {
	K clave;
	fase1.Interprete valor;
	
	public Item(K clave, fase1.Interprete valor) {
		this.clave = clave;
		this.valor = valor;
	}
}
