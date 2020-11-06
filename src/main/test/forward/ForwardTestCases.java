package forward;

import javax.enterprise.context.BeforeDestroyed;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import model.Diagnostico;
import model.DiagnosticoFinal;
import model.Especie;
import model.Persona;
import model.Roedor;
import model.Sintomas;
import util.KnowledgeSessionHelper;

public class ForwardTestCases {
	//el nombre tiene que ser igual al kmodule.xml
	String sessionName = "ksession-rules";

	KieSession session;
	static KieContainer kieContainer;

	FactHandle automovilDir;

	public ForwardTestCases() {
	}
	
	//se ejecuta en cada caso de prueba
	@BeforeClass
	public static void beforeallTestSetup() {
		//Creamos un container vacio para volcar la base de reglas y a partir del mismo inicializar la base de hechos
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	private void prepareKnowledgeSession() {
		//Usamos el statefull para que mantenga el estado de la base de hechos
		session = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, sessionName);
		// OutputDisplay outputDisplay = new OutputDisplay();
		//
		// ***********************session.addEventListener(buildEventListener());
	}

	@Before
	public void setUp() {
		System.out.println("***************Test start***************");
		this.prepareKnowledgeSession(); // Inicializa una nueva base de hechos
	}

	@After
	public void tearDown() {
		System.out.println("***************Test end***************\n\n");
	}

	@Test
	public void testCasoCompatiblePorMordeduraYDolorDeCabezaSinFiebre() {

		Persona p = new Persona();

		p.setInhaloHecesRoedor(false);
		p.setFueMordidoPorRoedor(true);
		p.setTemperaturaCorporal(36);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(true);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(false);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		//inserta en la base de hechos
		session.insert(p);
		
		//ejecutamos el motor de inferencia. dispara el encadenamiento hacia adelante
		session.fireAllRules();

		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "COMPATIBLE_CASO_HANTAVIRUS";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoCompatiblePorMordeduraYDolorDeCabezaConFiebre() {

		Persona p = new Persona();

		p.setInhaloHecesRoedor(false);
		p.setFueMordidoPorRoedor(true);
		p.setTemperaturaCorporal(39);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(true);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(false);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");session.insert(p);
		session.fireAllRules();

		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "COMPATIBLE_CASO_HANTAVIRUS";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoCompatiblePorInhalacionYMordeduraYDolorDeColumnaYVomitosConFiebre() {

		Persona p = new Persona();

		p.setInhaloHecesRoedor(true);
		p.setFueMordidoPorRoedor(true);
		p.setTemperaturaCorporal(39);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(true);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(true);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();

		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "COMPATIBLE_CASO_HANTAVIRUS";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoCompatiblePorInhalacionYDolorDeColumnaSinFiebre() {

		Persona p = new Persona();

		p.setInhaloHecesRoedor(true);
		p.setFueMordidoPorRoedor(false);
		p.setTemperaturaCorporal(36);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(true);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();

		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "COMPATIBLE_CASO_HANTAVIRUS";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoCompatiblePorInhalacionYContactoConDolorDeColumnaYMuscularSinFiebre() {

		Persona p = new Persona();

		p.setInhaloHecesRoedor(true);
		p.setFueMordidoPorRoedor(false);
		p.setTemperaturaCorporal(36);
		p.setTuvoContactoConPersonaInfectada(true);
		p.setTuvoContactoConRoedor(true);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(true);
		s.setPresentaDolorParteBajaDeLaColumna(true);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();

		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "COMPATIBLE_CASO_HANTAVIRUS";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoCompatiblePorContactoYFiebre() {

		Persona p = new Persona();
		p.setInhaloHecesRoedor(false);
		p.setFueMordidoPorRoedor(true);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(true);
		p.setTemperaturaCorporal(39);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(false);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();
		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "COMPATIBLE_CASO_HANTAVIRUS";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoNoDeterminadoTuvoContactoSinSintomas() {

		Persona p = new Persona();
		p.setInhaloHecesRoedor(false);
		p.setFueMordidoPorRoedor(true);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(true);
		p.setTemperaturaCorporal(36);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(false);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();
		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "NO_DETERMINADO";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoNoDeterminadoConDolorAbdominalSinContacto() {

		Persona p = new Persona();
		p.setInhaloHecesRoedor(false);
		p.setFueMordidoPorRoedor(false);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);
		p.setTemperaturaCorporal(36);

		Sintomas s = new Sintomas();
		s.setPresentaDolorAbdominal(true);
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(false);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();
		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "NO_DETERMINADO";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoNoDeterminadoConFiebreSinContacto() {

		Persona p = new Persona();
		p.setInhaloHecesRoedor(false);
		p.setFueMordidoPorRoedor(false);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);
		p.setTemperaturaCorporal(39);

		Sintomas s = new Sintomas();
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(false);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();
		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "NO_DETERMINADO";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoNoDeterminadoConFiebreYVomitosSinContacto() {

		Persona p = new Persona();
		p.setInhaloHecesRoedor(false);
		p.setFueMordidoPorRoedor(false);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);
		p.setTemperaturaCorporal(39);

		Sintomas s = new Sintomas();
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(false);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(true);
		Roedor r = new Roedor();
		r.setEspecie(Especie.COLILARGO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		
		session.insert(p);
		session.fireAllRules();
		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "NO_DETERMINADO";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}
	
	@Test
	public void testCasoNoDeterminadoRoedorConInhalacionYDolorDeColumnaSinFiebre() {

		Persona p = new Persona();

		p.setInhaloHecesRoedor(true);
		p.setFueMordidoPorRoedor(false);
		p.setTemperaturaCorporal(36);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(true);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.NO_DETERMINADO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();

		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "NO_DETERMINADO";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}

	@Test
	public void testCasoNoDeterminadoRoedorConInhalacionYDolorDeColumnaConFiebre() {

		Persona p = new Persona();

		p.setInhaloHecesRoedor(true);
		p.setFueMordidoPorRoedor(false);
		p.setTemperaturaCorporal(39);
		p.setTuvoContactoConPersonaInfectada(false);
		p.setTuvoContactoConRoedor(false);

		Sintomas s = new Sintomas();
		s.setPresentaDolorDeCabeza(false);
		s.setTieneDiarrea(false);
		s.setPresentaDolorAbdominal(false);
		s.setPresentaDolorMuscular(false);
		s.setPresentaDolorParteBajaDeLaColumna(true);
		s.setPresentaFaltaDeAire(false);
		s.setTieneNauseas(false);
		s.setTieneVomitos(false);
		Roedor r = new Roedor();
		r.setEspecie(Especie.NO_DETERMINADO);
		
		p.setRoedor(r);
		p.setSintomas(s);
		System.out.println("\n");
		System.out.println(p);
		System.out.println("\n");
		session.insert(p);
		session.fireAllRules();

		String diagnostico = p.getDiagnostico().getDiagnosticoFinal().toString();
		String valorEsperado = "NO_DETERMINADO";
		String tieneRiesgo=p.getTieneRiesgoDeContagio().toString();
		String tieneFiebre = p.getSintomas().getTieneFiebre().toString();
		String tieneSintomasIni = p.getPresentaSintomasIniciales().toString();
		printResults(diagnostico, valorEsperado,tieneSintomasIni,tieneRiesgo,tieneFiebre);
		assert (diagnostico.equals(valorEsperado));
	}
	private static void printResults(String result, String expected,String presentaSintomas,String tieneRiesgo,String tieneFiebre) {
		System.out.println("Resultados");
		
		System.out.println("Presenta Sintomas iniciales: " + presentaSintomas);
		System.out.println("Tiene Riesgo de contagio: " + tieneRiesgo);
		System.out.println("Tiene fiebre: " + tieneFiebre);
		System.out.println("Esperaba: " + expected);
		System.out.println("Recibi: " + result);
		Boolean isOk = result.equals(expected);
		String condition = isOk ? "Ok" : "Fallo";
		System.out.println("Caso de prueba: " + condition);
	}

	private static RuleRuntimeEventListener buildEventListener() {
		return new RuleRuntimeEventListener() {
			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {

				System.out.println("Object updated \n" + event.getObject().toString());
			}

			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted \n" + event.getObject().toString());
			}

			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object deleted \n" + event.getOldObject().toString());
			}

		};
	}
}
