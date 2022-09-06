package fr.projetjeu.ui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fr.projetjeu.exception.NegativeIdException;
import fr.projetjeu.exception.ReponseNotFoundException;
import fr.projetjeu.model.Events;
import fr.projetjeu.model.Inventaire;
import fr.projetjeu.model.Reponse;
import fr.projetjeu.service.EventsService;
import fr.projetjeu.service.ReponseService;

public class InterfaceGraphique {
	
	EventsService es = new EventsService();
	Inventaire i = new Inventaire();
	ReponseService rs = new ReponseService();
	Events events = new Events();
	
	private int numReponse;
	int id = events.getId();
	String histoire = events.getHistoire();
	List<Reponse> reponse = new ArrayList<Reponse>();

	
	private Dialog dialog;
	private JButton btn1 = new JButton(""); // Réponse 1
	private JButton btn2 = new JButton(""); // Réponse 2
	private JButton btn3 = new JButton(""); // Réponse 3
	private JButton startgame = new JButton("Commencer Partie");
	private JButton btninventaire = new JButton("Inventaire"); // Bouton Inventaire
	private JFrame frame = new JFrame();
	private JLabel label = new JLabel("Bienvenue, veuillez commencer la partie.", SwingConstants.CENTER);
	private JLabel labelID = new JLabel("id " + events.getId());
	
	public void TestApp() {
		dialog = new JDialog(frame, "Jeu : Le voyageur malchanceux.", true);
		dialog.setLayout(null);

		startgame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				id = 1;
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

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				numReponse = 2;
				testApplication();
				labelID.setText("id " + id);
				label.setText(histoire);

			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				numReponse = 3;
				testApplication();
				labelID.setText("id " + id);
				label.setText(histoire);
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

			histoire = es.findById(id).getHistoire();

		}

		else if (i == 1) {

			// Les bouttons
			btn1.setVisible(true);
			btn1.setBounds(130, 350, 450, 50);
			btn2.setVisible(false);
			btn3.setVisible(false);

			// Recup de la réponse depuis la BDD
			try {
				reponse.add(0, rs.findByEvenementId(id).get(0));
				

			} catch (NegativeIdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Ajout de la réponse dans un bouton
			btn1.setText(reponse.get(0).getTexte());

			// Recup de l'histoire depuis la BDD
			histoire = es.findById(id).getHistoire();
		}

		else if (i == 2) {
			btn1.setVisible(true);
			btn1.setBounds(130, 350, 200, 50);
			btn2.setVisible(true);
			btn2.setBounds(370, 350, 200, 50);
			btn3.setVisible(false);

			try {
				reponse.add(0, rs.findByEvenementId(id).get(0));
				reponse.add(1, rs.findByEvenementId(id).get(1));

			} catch (NegativeIdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			btn1.setText(reponse.get(0).getTexte());
			btn2.setText(reponse.get(1).getTexte());

			histoire = es.findById(id).getHistoire();

		}

		else {
			
			
			btn1.setVisible(true);
			btn2.setVisible(true);
			btn3.setVisible(true);

			btn1.setBounds(70, 350, 150, 50);
			btn2.setBounds(270, 350, 150, 50);
			btn3.setBounds(470, 350, 150, 50);

			try {
				reponse.add(0, rs.findByEvenementId(id).get(0));
				reponse.add(1, rs.findByEvenementId(id).get(1));
				reponse.add(2, rs.findByEvenementId(id).get(2));

			} catch (NegativeIdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			btn1.setText(reponse.get(0).getTexte());
			btn2.setText(reponse.get(1).getTexte());
			btn3.setText(reponse.get(2).getTexte());

			histoire = es.findById(id).getHistoire();
			
			labelID.setText("id " + id);
			label.setText(histoire);
			
			

		}
	}

	public void testApplication() {

		try {
			id = rs.findByEvenementId(id).get(numReponse - 1).getProchainEvenementId().getId();
		} catch (NegativeIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			rd(rs.findByEvenementId(id).size());
			System.out.println(rs.findByEvenementId(id).size());
		} catch (NegativeIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ReponseNotFoundException e) {
			rd(0);
		}

	}
	
}
