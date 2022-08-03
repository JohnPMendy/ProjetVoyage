package fr.projetjeu.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Events implements ActionListener {

	// Variables
	private Scanner sc = new Scanner(System.in);
	private static int id;
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

	public static JButton btn = new JButton("1");
	public static JButton btn2 = new JButton("2");
	public static JButton btn3 = new JButton("3");
	public static JButton btn4 = new JButton("Inventaire");
	public static JButton btn5 = new JButton("Bouton Vide");
	public static Events instance = new Events();
	public static JFrame frame = new JFrame("Jeu : Le voyageur malchanceux");
	public static JLabel label = new JLabel("Je suis un JLabel");

	public void CreationInterface() {
		btn.setBounds(100, 300, 100, 30);
		btn2.setBounds(300, 300, 100, 30);
		btn3.setBounds(500, 300, 100, 30);
		btn4.setBounds(10, 10, 100, 30);
		label.setBounds(300, 100, 100, 30);

		btn.addActionListener(instance);
		btn2.addActionListener(instance);
		frame.add(btn);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(label);

		frame.setSize(720, 480);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn)) {
			frame.setVisible(false);
		}
	}

	public void testApplication() {

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
