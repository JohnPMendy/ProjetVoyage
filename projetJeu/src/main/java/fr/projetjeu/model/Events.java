package fr.projetjeu.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Events {

	// Variables
	private Scanner sc = new Scanner(System.in);
	private static int id;
	private static int reponse;
	private static int answer;
	private static String histoire ="";
	private static String r1 = "";
	private static String r2 = "";
	private static String r3 = "";
	
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


	public ArrayList<Objet> getListeObjetEvent() {
		return listeObjetEvent;
	}

	public void setListeObjetEvent(ArrayList<Objet> listeObjetEvent) {
		this.listeObjetEvent = listeObjetEvent;
	}

	private static JDialog dialog;
	private static JButton btn1 = new JButton("");
	private static JButton btn2 = new JButton("");
	private static JButton btn3 = new JButton("");

	public void TestApp() {
		JFrame frame = new JFrame();
		dialog = new JDialog(frame, "Jeu : Le voyageur malchanceux.", true);
		dialog.setLayout(null);
		JLabel label = new JLabel("Bienvenue, veuillez commencer la partie.", SwingConstants.CENTER);
		JLabel labelID = new JLabel("Events: " + id);

		JButton startgame = new JButton("Commencer Partie");

		startgame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				histoire = "Question 0: Vous devez voyager, quel moyen de locomotion?";
				r1 = "En avion";
				r2 = "En bateau";
				r3 = "À la nage";
				testApplication();
				label.setText(histoire);
				btn1.setText(r1);
				btn2.setText(r2);
				btn3.setText(r3);
				id = 0;
				labelID.setText("Events: " + id);
				rd(3);
			}

		});

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reponse = 1;
				testApplication();
				labelID.setText("Events: " + id);
				label.setText(histoire);
				btn1.setText(r1);
				btn2.setText(r2);
				btn3.setText(r3);

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reponse = 2;
				testApplication();
				labelID.setText("Events: " + id);
				label.setText(histoire);
				btn1.setText(r1);
				btn2.setText(r2);
				btn3.setText(r3);

			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				reponse = 3;
				testApplication();
				labelID.setText("Events: " + id);
				label.setText(histoire);
				btn1.setText(r1);
				btn2.setText(r2);
				btn3.setText(r3);

			}
		});

		dialog.add(label);
		dialog.add(labelID);
		dialog.add(btn1);
		dialog.add(btn2);
		dialog.add(btn3);
		btn1.setBounds(70, 350, 150, 50); // x , y , taille x , taille y
		btn2.setBounds(270, 350, 150, 50);
		btn3.setBounds(470, 350, 150, 50);
		startgame.setBounds(500, 30, 200, 30);
		label.setBounds(100, 100, 500, 200);
		labelID.setBounds(10, 10, 150, 30);
		// label.setForeground(new Color(100, 100, 100)); //Couleur du texte
		label.setBackground(new Color(200, 200, 200));
		label.setOpaque(true);
		btn1.setVisible(false);
		btn2.setVisible(false);
		btn3.setVisible(false);
		dialog.add(startgame);
		dialog.setSize(720, 480);
		dialog.setVisible(true);
	}

	public void rd(int i) { // RD = Réponses Disponibles

		if (i == 0) {
			btn1.setVisible(false);
			btn2.setVisible(false);
			btn3.setVisible(false);
		}

		else if (i == 1) {
			btn1.setVisible(true);
			btn1.setBounds(130, 350, 450, 50);
			btn2.setVisible(false);
			btn3.setVisible(false);
		}

		else if (i == 2) {
			btn1.setVisible(true);
			btn1.setBounds(130, 350, 200, 50);
			btn2.setVisible(true);
			btn2.setBounds(370, 350, 200, 50);
			btn3.setVisible(false);
		}

		else {
			btn1.setVisible(true);
			btn2.setVisible(true);
			btn3.setVisible(true);
			
			btn1.setBounds(70, 350, 150, 50); 
			btn2.setBounds(270, 350, 150, 50);
			btn3.setBounds(470, 350, 150, 50);
		}
	}

	public void testApplication() {

		if (id == 0) 

		{
			if (reponse == 1) {
				id = 1;
				rd(2);

				histoire = "Question 1: Durant le trajet en avion, ouvrir le cockpit?";
				r1 = "Oui";
				r2 = "Non";
				r3 = "";
				
				
				
			}

			else if (reponse == 2) {
				id = 2;
				rd(2);
				
				histoire = "Question 1: Durant le trajet en bateau, sauter par dessus bord?";
				r1 = "Oui";
				r2 = "Non";
				r3 = "";
			}

			else if (reponse == 3) { 
				id = 3;
				rd(0);
				perso.setAlive(false);
				
				histoire = "Vous êtes mort.";

			}

		}

		else if (id == 1) {

			
			if (reponse == 1) {
				id = 4;
				rd(0);
				histoire = "Vous êtes mort.";
				perso.setAlive(false);

			}

			else if (reponse == 2) {
				id = 5;
				rd(0);
				histoire = "A suivre...";

			}

		}

		else if (id == 2) {

			if (reponse == 1) {
				id = 6;
				rd(0);
				histoire = "Vous êtes mort.";
				perso.setAlive(false);
			}

			else if (reponse == 2) {
				id = 7;
				rd(0);
				histoire = "A suivre...";
			}

			
		}

	}

}
