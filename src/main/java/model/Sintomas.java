package model;

public class Sintomas {
	Boolean presentaDolorMuscular;
	Boolean presentaDolorAbdominal;
	Boolean presentaFaltaDeAire;
	Boolean presentaDolorDeCabeza;
	Boolean presentaDolorParteBajaDeLaColumna;
	Boolean tieneDiarrea;
	Boolean tieneNauseas;
	Boolean tieneVomitos;
	public TieneFiebre tieneFiebre;
	public Boolean getPresentaDolorMuscular() {
		return presentaDolorMuscular;
	}
	public void setPresentaDolorMuscular(Boolean presentaDolorMuscular) {
		this.presentaDolorMuscular = presentaDolorMuscular;
	}
	public Boolean getPresentaDolorAbdominal() {
		return presentaDolorAbdominal;
	}
	public void setPresentaDolorAbdominal(Boolean presentaDolorAbdominal) {
		this.presentaDolorAbdominal = presentaDolorAbdominal;
	}
	public Boolean getPresentaFaltaDeAire() {
		return presentaFaltaDeAire;
	}
	public void setPresentaFaltaDeAire(Boolean presentaFaltaDeAire) {
		this.presentaFaltaDeAire = presentaFaltaDeAire;
	}
	public Boolean getPresentaDolorDeCabeza() {
		return presentaDolorDeCabeza;
	}
	public void setPresentaDolorDeCabeza(Boolean presentaDolorDeCabeza) {
		this.presentaDolorDeCabeza = presentaDolorDeCabeza;
	}
	public Boolean getPresentaDolorParteBajaDeLaColumna() {
		return presentaDolorParteBajaDeLaColumna;
	}
	public void setPresentaDolorParteBajaDeLaColumna(Boolean presentaDolorParteBajaDeLaColumna) {
		this.presentaDolorParteBajaDeLaColumna = presentaDolorParteBajaDeLaColumna;
	}
	public Boolean getTieneDiarrea() {
		return tieneDiarrea;
	}
	public void setTieneDiarrea(Boolean tieneDiarrea) {
		this.tieneDiarrea = tieneDiarrea;
	}
	public Boolean getTieneNauseas() {
		return tieneNauseas;
	}
	public void setTieneNauseas(Boolean tieneNauseas) {
		this.tieneNauseas = tieneNauseas;
	}
	public Boolean getTieneVomitos() {
		return tieneVomitos;
	}
	public void setTieneVomitos(Boolean tieneVomitos) {
		this.tieneVomitos = tieneVomitos;
	}
	public TieneFiebre getTieneFiebre() {
		return tieneFiebre;
	}
	public void setTieneFiebre(TieneFiebre tieneFiebre) {
		this.tieneFiebre = tieneFiebre;
	}
	public Sintomas(Boolean presentaDolorMuscular, Boolean presentaDolorAbdominal, Boolean presentaFaltaDeAire,
			Boolean presentaDolorDeCabeza, Boolean presentaDolorParteBajaDeLaColumna, Boolean tieneDiarrea,
			Boolean tieneNauseas, Boolean tieneVomitos, TieneFiebre tieneFiebre) {
		super();
		this.presentaDolorMuscular = presentaDolorMuscular;
		this.presentaDolorAbdominal = presentaDolorAbdominal;
		this.presentaFaltaDeAire = presentaFaltaDeAire;
		this.presentaDolorDeCabeza = presentaDolorDeCabeza;
		this.presentaDolorParteBajaDeLaColumna = presentaDolorParteBajaDeLaColumna;
		this.tieneDiarrea = tieneDiarrea;
		this.tieneNauseas = tieneNauseas;
		this.tieneVomitos = tieneVomitos;
		this.tieneFiebre=TieneFiebre.NO_DETERMINADO;
	}
	public Sintomas() {
		this.tieneFiebre=TieneFiebre.NO_DETERMINADO;
	}
	@Override
	public String toString() {
		return "Sintomas= [presentaDolorMuscular=" + presentaDolorMuscular + ", presentaDolorAbdominal="
				+ presentaDolorAbdominal + ", presentaFaltaDeAire=" + presentaFaltaDeAire + ", presentaDolorDeCabeza="
				+ presentaDolorDeCabeza + ", presentaDolorParteBajaDeLaColumna=" + presentaDolorParteBajaDeLaColumna
				+ ",\n tieneDiarrea=" + tieneDiarrea + ", tieneNauseas=" + tieneNauseas + ", tieneVomitos=" + tieneVomitos
				+ ", tieneFiebre=" + tieneFiebre + "]";
	}
	
	
	
}
