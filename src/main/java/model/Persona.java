package model;

/**
 * @author Tomi
 *
 */
public class Persona {
	Boolean tuvoContactoConRoedor;
	Boolean tuvoContactoConPersonaInfectada;
	Boolean inhaloHecesRoedor;
	Boolean fueMordidoPorRoedor;
	public Sintomas sintomas;
	TieneRiesgoDeContagio tieneRiesgoDeContagio;
	PresentaSintomasIniciales presentaSintomasIniciales;
	Integer temperaturaCorporal;
	Diagnostico diagnostico;
	public Boolean getTuvoContactoConRoedor() {
		return tuvoContactoConRoedor;
	}
	public void setTuvoContactoConRoedor(Boolean tuvoContactoConRoedor) {
		this.tuvoContactoConRoedor = tuvoContactoConRoedor;
	}
	public Boolean getTuvoContactoConPersonaInfectada() {
		return tuvoContactoConPersonaInfectada;
	}
	public void setTuvoContactoConPersonaInfectada(Boolean tuvoContactoConPersonaInfectada) {
		this.tuvoContactoConPersonaInfectada = tuvoContactoConPersonaInfectada;
	}
	public Boolean getInhaloHecesRoedor() {
		return inhaloHecesRoedor;
	}
	public void setInhaloHecesRoedor(Boolean inhaloHecesRoedor) {
		this.inhaloHecesRoedor = inhaloHecesRoedor;
	}
	public Boolean getFueMordidoPorRoedor() {
		return fueMordidoPorRoedor;
	}
	public void setFueMordidoPorRoedor(Boolean fueMordidoPorRoedor) {
		this.fueMordidoPorRoedor = fueMordidoPorRoedor;
	}
	public TieneRiesgoDeContagio getTieneRiesgoDeContagio() {
		return tieneRiesgoDeContagio;
	}
	public void setTieneRiesgoDeContagio(TieneRiesgoDeContagio tieneRiesgoDeContagio) {
		this.tieneRiesgoDeContagio = tieneRiesgoDeContagio;
	}
	public PresentaSintomasIniciales getPresentaSintomasIniciales() {
		return presentaSintomasIniciales;
	}
	public void setPresentaSintomasIniciales(PresentaSintomasIniciales presentaSintomasIniciales) {
		this.presentaSintomasIniciales = presentaSintomasIniciales;
	}
	public Integer getTemperaturaCorporal() {
		return temperaturaCorporal;
	}
	public void setTemperaturaCorporal(Integer temperaturaCorporal) {
		this.temperaturaCorporal = temperaturaCorporal;
	}
	
	public Persona() {
		sintomas = new Sintomas ();
		diagnostico = new Diagnostico();
		sintomas.setTieneFiebre(TieneFiebre.NO_DETERMINADO);
		this.presentaSintomasIniciales=PresentaSintomasIniciales.NO_DETERMINADO;
		
	}
	public Sintomas getSintomas() {
		return sintomas;
	}
	public void setSintomas(Sintomas sintomas) {
		this.sintomas = sintomas;
	}
	public void setTieneFiebre(TieneFiebre b) {
		this.sintomas.setTieneFiebre(b);
	}
	public void setDiagnosticoFinal(DiagnosticoFinal d) {
		
		this.diagnostico.setDiagnosticoFinal(d);
	}
	
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Persona(Boolean tuvoContactoConRoedor, Boolean tuvoContactoConPersonaInfectada, Boolean inhaloHecesRoedor,
			Boolean fueMordidoPorRoedor, TieneRiesgoDeContagio tieneRiesgoDeContagio,
			PresentaSintomasIniciales presentaSintomasIniciales, Integer temperaturaCorporal) {
		super();
		this.tuvoContactoConRoedor = tuvoContactoConRoedor;
		this.tuvoContactoConPersonaInfectada = tuvoContactoConPersonaInfectada;
		this.inhaloHecesRoedor = inhaloHecesRoedor;
		this.fueMordidoPorRoedor = fueMordidoPorRoedor;
		this.tieneRiesgoDeContagio = tieneRiesgoDeContagio;
		this.presentaSintomasIniciales = presentaSintomasIniciales;
		this.temperaturaCorporal = temperaturaCorporal;
		this.sintomas = new Sintomas();
		this.diagnostico= new Diagnostico();
	}
	@Override
	public String toString() {
		return "Persona [tuvoContactoConRoedor=" + tuvoContactoConRoedor + ", tuvoContactoConPersonaInfectada="
				+ tuvoContactoConPersonaInfectada + ", inhaloHecesRoedor=" + inhaloHecesRoedor
				+ ", fueMordidoPorRoedor=" + fueMordidoPorRoedor + ", tieneRiesgoDeContagio=" + tieneRiesgoDeContagio
				+ ", presentaSintomasIniciales=" + presentaSintomasIniciales + ", temperaturaCorporal="
				+ temperaturaCorporal + ", sintomas=" + sintomas.toString() +"\nDIAG FINAL: " +diagnostico.toString()+"]";
	}
	
	
	
}
