package fr.projetjeu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.projetjeu.config.AppConfig;
import fr.projetjeu.model.Events;
import fr.projetjeu.model.Personnage;
import fr.projetjeu.model.Reponse;
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

			ig.TestApp();
			// events.actionPerformed(ae);

		System.out.println("Partie terminée");
		System.exit(0);
	}

}
