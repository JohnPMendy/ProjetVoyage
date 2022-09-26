package fr.projetjeu.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Partie {
	private int personnageId;
	private int eventId;
	private int compteurTour;

	private Date date; // comprend le jour et l'heure

	public int getPersonnageId() {
		return personnageId;
	}

	public void setPersonnageId(int personnageId) {
		this.personnageId = personnageId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getCompteurTour() {
		return compteurTour;
	}

	public void setCompteurTour(int compteurTour) {
		this.compteurTour = compteurTour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// Methodes

	// Avance d'un certain nombre d'heure ou de jours a la date du jeu
	public void avancerTemps(int nbHeures, int nbJours, int nbMois) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(this.date);
		cal.add(Calendar.HOUR, nbHeures);
		cal.add(Calendar.DAY_OF_MONTH, nbJours);

		this.date = cal.getTime();

	}

	public void pause() {

		System.out.println("Mise en pause");

	}

	public void jouer() {
		boolean partieFinie = false;
		// Event currentEvent
		while (partieFinie == false) {

			// currentEvent = faireTournerEvenement
			// ON FAIT TOURNER LES EVENTS

		}
	}

}
