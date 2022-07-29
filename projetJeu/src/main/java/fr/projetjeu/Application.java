package fr.projetjeu;

import java.util.Scanner;

import fr.projetjeu.model.Events;

public class Application {

	public static void main(String[] args) {
		Events.setId(0);
		Events.setEstmort(false);

		do {
			Events.affichageSituation();
		} while (Events.isEstmort() == false);

	}
}
