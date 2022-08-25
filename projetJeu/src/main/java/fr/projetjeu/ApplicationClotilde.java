package fr.projetjeu;

import fr.projet.service.ReponseService;
import fr.projetjeu.model.Reponse;

public class ApplicationClotilde {
	public static void main(String[] args) {
		
		ReponseService  srvReponse = new ReponseService();
		
		Reponse maReponse = new Reponse();
		maReponse.setTexte("Oui");
		maReponse.setEvenementId(1);
		maReponse.setProchainEvenementId(2);
		
		srvReponse.save(maReponse);
	}
	
	
}
