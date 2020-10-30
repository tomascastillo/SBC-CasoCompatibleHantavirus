package Main;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import model.Persona;
import model.PresentaSintomasIniciales;
import model.Sintomas;
import model.TieneFiebre;
import util.KnowledgeSessionHelper;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KieContainer container = KnowledgeSessionHelper.createRuleBase();
		String sessionName = "ksession-rules";
		KieSession session = KnowledgeSessionHelper.getStatefulKnowledgeSession(container, sessionName);
		session.addEventListener(buildEventListener());
		Persona p = new Persona();
		/*FUE MORDIDO********************/
		//p.setTuvoContactoConRoedor(true);
		/*PRUEBA FIEBRE***********************************************************************************/
		//p.setTemperaturaCorporal(40);
		
		/*******************************************************************************************/
		p.setInhaloHecesRoedor(false);
		p.setFueMordidoPorRoedor(true);
		p.setTemperaturaCorporal(36);
		Sintomas s = new Sintomas ();
		s.setPresentaDolorDeCabeza(true);
		p.setSintomas(s);
		session.insert(p);
		session.fireAllRules();

		
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
