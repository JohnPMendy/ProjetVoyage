package fr.projetjeu;

import fr.projetjeu.model.Events;

public class Application {

	// static ActionEvent ae;

	public static void main(String[] args) {

		Events events = new Events();

		events.setId(0);
		events.getPerso().setAlive(true);
		
		// pas sur si le do while serve a quelque chose maintenant...
		do {
			events.TestApp();
			// events.actionPerformed(ae);
		} while (events.getPerso().isAlive() == true);

		System.out.println("Partie terminée");
		System.exit(0);
	}

}
