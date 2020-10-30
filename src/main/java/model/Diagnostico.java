package model;

public class Diagnostico {
	DiagnosticoFinal diagnosticoFinal;

	public DiagnosticoFinal getDiagnosticoFinal() {
		return diagnosticoFinal;
	}

	public void setDiagnosticoFinal(DiagnosticoFinal diagnosticoFinal) {
		this.diagnosticoFinal = diagnosticoFinal;
	}

	public Diagnostico(DiagnosticoFinal diagnosticoFinal) {
		super();
		this.diagnosticoFinal = diagnosticoFinal;
	}

	public Diagnostico() {
		diagnosticoFinal=DiagnosticoFinal.NO_DETERMINADO;
	}

	@Override
	public String toString() {
		return "Diagnostico [diagnosticoFinal=" + diagnosticoFinal + "]";
	}
	
	
}
