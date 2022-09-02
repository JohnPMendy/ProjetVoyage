package fr.projetjeu.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fr.projetjeu.exception.NegativeIdException;
import fr.projetjeu.exception.ReponseNotFoundException;
import fr.projetjeu.service.EventsService;
import fr.projetjeu.service.ReponseService;

@Entity
@Table(name = "evenement")
public class Events {

	// Variables (SQL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evt_id")
	private int id;
	
	@Column(name = "evt_histoire", length = 2000, nullable = true)
	private static String histoire = "";
	
	@OneToMany(mappedBy = "evenementId")
	private ArrayList<Reponse> reponses = new ArrayList<Reponse>();
	
	@OneToOne(mappedBy = "prochainEvenementId")
	private Reponse reponse;
	
	// Variables (Java)
	private Scanner sc = new Scanner(System.in);
	//private static int numReponse;
	
	//private static ArrayList<String> reponse = new ArrayList<String>();

	// Instantiations
	EventsService es = new EventsService();
	Inventaire i = new Inventaire();
	ReponseService rs = new ReponseService();

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
				histoire = es.findById(id).getHistoire();

				try {
					reponse.add(0, rs.findByEvenementId(id).get(0).getTexte());
					reponse.add(1, rs.findByEvenementId(id).get(1).getTexte());
					reponse.add(2, rs.findByEvenementId(id).get(2).getTexte());

				} catch (NegativeIdException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// testApplication();
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
				reponse.add(0, rs.findByEvenementId(id).get(0).getTexte());

			} catch (NegativeIdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Ajout de la réponse dans un bouton
			btn1.setText((String) reponse.get(0));

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
				reponse.add(0, rs.findByEvenementId(id).get(0).getTexte());
				reponse.add(1, rs.findByEvenementId(id).get(1).getTexte());

			} catch (NegativeIdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			btn1.setText((String) reponse.get(0));
			btn2.setText((String) reponse.get(1));

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
				reponse.add(0, rs.findByEvenementId(id).get(0).getTexte());
				reponse.add(1, rs.findByEvenementId(id).get(1).getTexte());
				reponse.add(2, rs.findByEvenementId(id).get(2).getTexte());

			} catch (NegativeIdException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			btn1.setText((String) reponse.get(0));
			btn2.setText((String) reponse.get(1));
			btn3.setText((String) reponse.get(2));

			histoire = es.findById(id).getHistoire();

		}
	}

	public void testApplication() {

		try {
			id = rs.findByEvenementId(id).get(numReponse - 1).getProchainEvenementId();
		} catch (NegativeIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			rd(rs.findByEvenementId(id).size());
		} catch (NegativeIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (ReponseNotFoundException e) {
			rd(0);
		}

	}

}
