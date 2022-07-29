package Badis;

import java.util.Scanner;

public class Tests {

	public static void main(String[] args) {
		Events.setId(0);
		int initialisation = Events.getId();
		Scanner sc = new Scanner(System.in);
		Events.setEstmort(false);

		do {
			Events.affichageSituation();
		} while (Events.isEstmort() == false);

	}

}
