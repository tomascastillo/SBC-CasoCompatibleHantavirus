package model;

public enum Especie {
	COLILARGO,NO_DETERMINADO;
public  Boolean isa(Especie especie) {
		
		return this.toString() == especie.toString();
		
	} 
}
