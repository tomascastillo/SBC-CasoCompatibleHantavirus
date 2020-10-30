package model;

public class Roedor {
	Especie especie;

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Roedor(Especie especie) {
		super();
		this.especie = especie;
	}

	public Roedor() {
		super();
	}

	@Override
	public String toString() {
		return "Roedor [especie=" + especie + "]";
	}
	
	
}
