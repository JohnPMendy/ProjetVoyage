package fr.projetjeu;

import java.util.ArrayList;
import java.util.List;

import fr.projet.exception.NegativeIdException;
import fr.projet.service.ReponseService;
import fr.projetjeu.model.Reponse;

public class ApplicationClotilde {
	public static void main(String[] args) {
		
		ReponseService  srvReponse = new ReponseService();
		
//		Reponse maReponse = new Reponse();
//		maReponse.setTexte("Oui");
//		maReponse.setEvenementId(1);
//		maReponse.setProchainEvenementId(2);
//		
//		srvReponse.save(maReponse);
		int evenementId = 1;
		List<Reponse> reponses = new ArrayList<>();
		
		try {
			 reponses = srvReponse.findByEvenementId(evenementId);
		} catch (NegativeIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Reponse reponse : reponses) {
			System.out.println(reponse);
			
		}
		
}
	
	
}
