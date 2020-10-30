package model;

public enum TieneFiebre {
SI,NO,NO_DETERMINADO;
public Boolean isa(TieneFiebre recomendacion) {
		
		return this.toString() == recomendacion.toString();
		
	}
}
