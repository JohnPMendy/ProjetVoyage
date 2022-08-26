package fr.projetjeu;

import java.util.ArrayList;
import java.util.List;

import fr.projetjeu.exception.NegativeIdException;
import fr.projetjeu.model.Reponse;
import fr.projetjeu.service.ReponseService;

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
