package fr.projetjeu.repo.sql;

public class SqlProperties {
	
	static private String mdp="mendyDb";

	public static String getMdp() {
		return mdp;
	}

	public static void setMdp(String mdp) {
		SqlProperties.mdp = mdp;
	}

	
}
