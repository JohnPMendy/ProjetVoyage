package fr.projetjeu.model;

public class JsonViews {

	//classe imbriquee pour ne pas avoir plein de fichier avec juste 
	//class XXX{}
	//projection pour tout les types simples qui ne posent pas de probleme
	public static class Common{
		
	}
	//view pour produit 
	public static class Events extends Common{
		
	}
	
	//view pour produit avec fournisseur
	public static class EventsAvecReponses extends Events{
		
	}
	
	public static class Fournisseur extends Common{
		
	}
	
	public static class FournisseurAvecProduit extends Fournisseur{
		
	}
}