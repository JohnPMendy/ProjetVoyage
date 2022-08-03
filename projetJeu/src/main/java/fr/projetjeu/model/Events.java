package fr.projetjeu.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Events {

	// Variables
	private Scanner sc = new Scanner(System.in);
	private int id;
	private int reponse;
	// Liste des objets pour un evenement particulier
	private ArrayList<Objet> listeObjetEvent = new ArrayList<>();
	Personnage perso = new Personnage();

	// Getters et setters
	public Personnage getPerso() {
		return perso;
	}

	public void setPerso(Personnage perso) {
		this.perso = perso;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReponse() {
		return reponse;
	}

	public void setReponse(int reponse) {
		this.reponse = reponse;
	}

	public ArrayList<Objet> getListeObjetEvent() {
		return listeObjetEvent;
	}

	public void setListeObjetEvent(ArrayList<Objet> listeObjetEvent) {
		this.listeObjetEvent = listeObjetEvent;
	}

	public void affichageSituation() {

		if (id == 0)
		// Exemple,
		{
			System.out.println("Question " + id + ": Vous devez voyager, quel moyen de locomotion?");
			System.out.println("Reponse 1: Avion");
			System.out.println("Reponse 2: Bateau");
			System.out.println("Reponse 3: A la nage");
			System.out.println("Inserez votre réponse (1,2 ou 3) : ");
			reponse = sc.nextInt();

			if (reponse == 1 || reponse == 2) {
				id = id + 1;
			}

			else if (reponse == 3) {
				System.out.println("Vous êtes mort");

				perso.setAlive(false);

			}

			else {
				System.out.println("Vous n'avez pas saisi une valeur adequate");

			}

		}

		else if (id == 1 && reponse == 1) {
			System.out.println("Question " + id + ": Durant le trajet en avion, ouvrir le cockpit?");
			System.out.println("Reponse 1: Oui");
			System.out.println("Reponse 2: Non");
			System.out.println("Inserez votre réponse (1 ou 2) : ");
			reponse = sc.nextInt();

			if (reponse == 1) {
				System.out.println("Vous êtes mort");

				perso.setAlive(false);
			}

			else if (reponse == 2) {
				id = id + 1;
			}

			else {
				System.out.println("Vous n'avez pas saisi une valeur adequate");

			}

		}

		else if (id == 1 && reponse == 2) {
			System.out.println("Question " + id + ": Durant le trajet en bateau, sauter par dessus bord?");
			System.out.println("Reponse 1: Oui");
			System.out.println("Reponse 2: Non");
			System.out.println("Inserez votre réponse (1 ou 2) : ");
			reponse = sc.nextInt();

			if (reponse == 1) {
				System.out.println("Vous êtes mort");
				perso.setAlive(false);
			}

			else if (reponse == 2) {
				id = id + 1;
			}

			else {
				System.out.println("Vous n'avez pas saisi une valeur adequate");

			}

		}

		else {
			System.out.println("D'autres questions à venir... FIN");
			perso.setAlive(false);

		}

	}

}
