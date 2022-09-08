package fr.projetjeu;

import fr.projetjeu.model.Events;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.ui.InterfaceGraphique;

public class ApplicationBadis {

	// static ActionEvent ae;

	public static void main(String[] args) {

		InterfaceGraphique ig = new InterfaceGraphique();
		Events events = new Events();
		Personnage perso = new Personnage();
		
		perso.setAlive(true);

		events.setId(0);
		
		// pas sur si le do while serve a quelque chose maintenant...
		do {
			ig.TestApp();
			// events.actionPerformed(ae);
		} while (perso.isAlive() == true);

		System.out.println("Partie terminée");
		System.exit(0);
	}

}
