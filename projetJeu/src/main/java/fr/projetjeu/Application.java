package fr.projetjeu;

import java.awt.event.ActionEvent;

import fr.projetjeu.model.Events;

public class Application {

	//static ActionEvent ae;
	
	public static void main(String[] args) {

		Events events = new Events();
		ActionEvent ae = new ActionEvent(args, 0, null);
		events.setId(0);
		events.getPerso().setAlive(true);

		do {
			events.CreationInterface();
			events.actionPerformed(ae);
			events.testApplication();
		} while (events.getPerso().isAlive() == true);

	}


}
