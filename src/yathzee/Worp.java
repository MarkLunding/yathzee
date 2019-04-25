package yathzee;

public class Worp {
	int[] worp = new int[5];

	void toonWorp(int worpNr, int spelerNr) {
		System.out.println();
		System.out.println("SPELER " + spelerNr + " ,  WORP: " + worpNr);
		String underScores = "_______________________________";
		System.out.println(underScores);
		System.out.println("| Positie | 1 | 2 | 3 | 4 | 5 |");
		System.out.print("| Waardes | ");
		for (int i = 0; i < worp.length; i++) {
			System.out.print(worp[i] + " | ");
		}
		System.out.println();
		for (int i = 0; i < underScores.length(); i++) {
			System.out.print((char) '\u203E');
		}
		System.out.println();
	}
}
