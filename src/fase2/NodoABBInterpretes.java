package fase2;

import fase1.Interprete;

public class NodoABBInterpretes{
	
	Interprete info;
	
	public NodoABBInterpretes(Interprete info2){
		this.info = info2;
	}
	
	NodoABBInterpretes left;
	NodoABBInterpretes right;
	
	public boolean hasLeft() {
		return this.left == null;
	}
	
	public boolean hasRight() {
		return this.right == null;
	}
	
	public boolean contains(Interprete inter) {
		if (inter.getName().equals(this.info.getName()))
			return true;
		
		else if (inter.compareTo(this.info)<0) {
			if (this.hasLeft()) {
				return this.left.contains(inter);
			}
			else return false;
		}
		else {
			if (this.hasRight()) {
				return this.right.contains(inter);
			}
			else return false;
		}
	}
	
}
