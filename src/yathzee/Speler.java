package yathzee;

import java.util.ArrayList;

public class Speler {
	String naam;
	ArrayList<Worp> worpGeschiedenis = new ArrayList<>();

	void toonSpelerStart(String speler) {
		System.out.println("================================");
		System.out.println("Speler " + speler + " is aan de beurt");
	}

	void toonSpelerEinde(String speler) {
		System.out.println("Speler " + speler + " is uitgespeeld.");
		
		System.out.println();
		System.out.println("Uw worpen zijn: ");
		int i=1;
		for(Worp worp : worpGeschiedenis) {
			System.out.print("Worp " + i + ": [");
			for (int j = 0; j < worp.worp.length; j++) {
				System.out.print(worp.worp[j]);
			}
			System.out.println("]");
			i++;
		}
		
		System.out.println("================================");
		System.out.println();
	}

}
