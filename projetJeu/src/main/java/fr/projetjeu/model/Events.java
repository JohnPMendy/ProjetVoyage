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

import fr.projetjeu.repo.sql.EventsRepositorySql;
import fr.projetjeu.service.EventsService;

public class Events {

	// Variables
	private Scanner sc = new Scanner(System.in);
	private int id;
	private static int numReponse;
	private static String histoire = "";
	private static ArrayList<String> reponse = new ArrayList<String>();
	
	// Instantiations 
	EventsRepositorySql ers = new EventsRepositorySql();
	Inventaire i = new Inventaire();

	// Liste des objets pour un evenement particulier
	private ArrayList<Objet> listeObjetEvent = new ArrayList<>();
	Personnage perso = new Personnage();

	// Getters et setters

	public static int getNumReponse() {
		return numReponse;
	}

	public static String getHistoire() {
		return histoire;
	}

	public static void setHistoire(String histoire) {
		Events.histoire = histoire;
	}

	public static void setNumReponse(int numReponse) {
		Events.numReponse = numReponse;
	}

	public static ArrayList<String> getReponse() {
		return reponse;
	}

	public static void setReponse(ArrayList<String> reponse) {
		Events.reponse = reponse;
	}

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
	private static JButton btn1 = new JButton(""); // Réponse 1
	private static JButton btn2 = new JButton(""); // Réponse 2
	private static JButton btn3 = new JButton(""); // Réponse 3
	private static JButton btninventaire = new JButton("Inventaire"); // Bouton Inventaire

	public void TestApp() {
		JFrame frame = new JFrame();
		dialog = new JDialog(frame, "Jeu : Le voyageur malchanceux.", true);
		dialog.setLayout(null);
		JLabel label = new JLabel("Bienvenue, veuillez commencer la partie.", SwingConstants.CENTER);
		JLabel labelID = new JLabel("id " + id);

		JButton startgame = new JButton("Commencer Partie");

		startgame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				id = 1;
				histoire = ers.findById(1).getHistoire();
				reponse.add(0, "En avion");
				reponse.add(1, "En bateau");
				reponse.add(2, "À la nage");
			//	testApplication();
				label.setText(histoire);
				btn1.setText((String) reponse.get(0));
				btn2.setText((String) reponse.get(1));
				btn3.setText((String) reponse.get(2));
				labelID.setText("id " + id);
				rd(3);
				btninventaire.setVisible(true);
				
			}

		});

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				numReponse = 1;
				testApplication();
				labelID.setText("id " + id);
				label.setText(histoire);
				btn1.setText((String) reponse.get(0));
				btn2.setText((String) reponse.get(1));
				btn3.setText((String) reponse.get(2));

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				numReponse = 2;
				testApplication();
				labelID.setText("id " + id);
				label.setText(histoire);
				btn1.setText((String) reponse.get(0));
				btn2.setText((String) reponse.get(1));
				btn3.setText((String) reponse.get(2));

			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				numReponse = 3;
				testApplication();
				labelID.setText("id " + id);
				label.setText(histoire);
				btn1.setText((String) reponse.get(0));
				btn2.setText((String) reponse.get(1));
				btn3.setText((String) reponse.get(2));

			}
		});

		btninventaire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				i.getListeObjetInventaire();
			}
		});

		dialog.add(label);
		dialog.add(labelID);
		dialog.add(btn1);
		dialog.add(btn2);
		dialog.add(btn3);
		dialog.add(btninventaire);
		btn1.setBounds(70, 350, 150, 50); // x , y , taille x , taille y
		btn2.setBounds(270, 350, 150, 50);
		btn3.setBounds(470, 350, 150, 50);
		startgame.setBounds(500, 30, 200, 30);
		btninventaire.setBounds(10, 30, 200, 30);
		label.setBounds(100, 100, 500, 200);
		labelID.setBounds(10, 2, 150, 30);
		// label.setForeground(new Color(100, 100, 100)); //Couleur du texte
		label.setBackground(new Color(200, 200, 200));
		label.setOpaque(true);
		btn1.setVisible(false);
		btn2.setVisible(false);
		btn3.setVisible(false);
		btninventaire.setVisible(false);
		dialog.add(startgame);
		dialog.setSize(720, 480);
		dialog.setVisible(true);
	}

	public void rd(int i) { // RD = Réponses Disponibles


		if (i == 0) {
			btn1.setVisible(false);
			btn2.setVisible(false);
			btn3.setVisible(false);
			reponse.add(0, "");
			reponse.add(1, "");
			reponse.add(2, "");
			
			
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

		if (id == 1)

		{
			if (numReponse == 1) {
				id = 2;
				rd(2);

				histoire = ers.findById(id).getHistoire();

				reponse.add(0, "Oui");
				reponse.add(1, "Non");
				reponse.add(2, "");

			}

			else if (numReponse == 2) {
				id = 3;
				rd(2);

				histoire = ers.findById(id).getHistoire();;
				reponse.add(0, "Oui");
				reponse.add(1, "Non");
				reponse.add(2, "");
			}

			else if (numReponse == 3) {
				id = 4;
				rd(0);
				perso.setAlive(false);

				histoire = ers.findById(id).getHistoire();;

			}

		}

		else if (id == 2) {

			if (numReponse == 1) {
				id = 5;
				rd(0);
				histoire = ers.findById(id).getHistoire();;
				perso.setAlive(false);

			}

			else if (numReponse == 2) {
				id = 6;
				rd(0);
				histoire = ers.findById(id).getHistoire();;

			}

		}

		else if (id == 3) {

			if (numReponse == 1) {
				id = 7;
				rd(0);
				histoire = ers.findById(id).getHistoire();;
				perso.setAlive(false);
			}

			else if (numReponse == 2) {
				id = 8;
				rd(0);
				histoire = ers.findById(id).getHistoire();;
			}

		}

	}

}
