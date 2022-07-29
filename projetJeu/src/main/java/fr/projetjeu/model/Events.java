package fr.projetjeu.model;

import java.util.Scanner;

public class Events {
	static Scanner sc = new Scanner(System.in);

	public static boolean isEstmort() {
		return estmort;
	}

	public static void setEstmort(boolean estmort) {
		Events.estmort = estmort;
	}

	private static int id;
	private static boolean estmort;

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Events.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	private String question;

	// Je sais pas trop cmb de situations on aura...

	// 4 réponses max me parait pas trop excessif.
	public static int reponse;

	// Mis en commentaire parce que j'ai pas encore la classe Objet (Mahmoud)
	// private ArrayList<Objet> listeObjetEvent = new ArrayList<Objet>();

	public static void affichageSituation() {

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
				setEstmort(true);

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
				setEstmort(true);
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
				setEstmort(true);
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
			setEstmort(true);
		}

	}

}
