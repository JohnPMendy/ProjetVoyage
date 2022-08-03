package fr.projetjeu;

import fr.projetjeu.model.Events;

public class Application {

	public static void main(String[] args) {
		Events events = new Events();
		events.setId(0);
		events.getPerso().setAlive(true);

		do {
			events.affichageSituation();
		} while (events.getPerso().isAlive()==true);

	}
}
