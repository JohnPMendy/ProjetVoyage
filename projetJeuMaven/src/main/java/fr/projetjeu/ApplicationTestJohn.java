package fr.projetjeu;

import java.util.Scanner;

import fr.projetjeu.exception.EntityNotValidException;
import fr.projetjeu.exception.EventNotFoundException;
import fr.projetjeu.exception.InvalidArgsException;
import fr.projetjeu.model.Events;
import fr.projetjeu.model.Reponse;
import fr.projetjeu.service.EventsService;

public class ApplicationTestJohn {
	static EventsService srvEvent = new EventsService();
	static Scanner sc =new Scanner(System.in);

	public static void main(String[] args) {
			Events event = srvEvent.findById(1);

			story(event);
			
			sc.close();

//		EnvironnementService srvEnvironnemnt = new EnvironnementService();
//		Environnement env = new Environnement();
//		try {
//			env = srvEnvironnemnt.findById(1);
//			System.out.println(env.getEnvironnement() + " " + env.getMeteo());
//		} catch (InvalidArgsException | EnvironnementNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	private static void story(Events event) {
//		System.out.println(event.getHistoire());
//		
//		if(event.getReponse().size()==0) {
//			return;
//		}
//		for (int i = 0; i < event.getReponse().size(); i++) {
//			System.out.println((i + 1) + ". " + event.getReponse().get(i).getTexte());
//		}
//		int choix = sc.nextInt();
//		
//		if(choix>0 && choix<=event.getReponse().size()) {
//			Reponse proposition =event.getReponse().get(choix-1);
//			event=srvEvent.findById(proposition.getProchainEvenementId());
//		}
//		
//		story(event);
	}
}
