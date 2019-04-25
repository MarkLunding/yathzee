package yathzee;

import java.util.ArrayList;

public class Speler {
	ArrayList<Worp> worpGeschiedenis = new ArrayList<>();

	void toonSpelerStart(int speler) {
		System.out.println("================================");
		System.out.println("Speler " + speler + " is aan de beurt");
	}

	void toonSpelerEinde(int speler) {
		System.out.println("Speler " + speler + " is uitgespeeld.");
		System.out.println("================================");
		System.out.println();
	}

}
