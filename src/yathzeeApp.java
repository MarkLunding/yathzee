import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class yathzeeApp {

	public static void main(String[] args) {
		YahtzeeSpel yahtzee = new YahtzeeSpel();
		yahtzee.spelen();
	}

}

class YahtzeeSpel {
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
	int[] blokkeer = { 0, 0, 0, 0, 0 };

	YahtzeeSpel() {
		for (int i = 0; i < 5; i++) {
			this.dobbelstenen.add(new Dobbelsteen());
		}
	}

	void spelen() {
		Scanner scanner = new Scanner(System.in);
		Speler speler = new Speler();
		boolean playOn = true;
		while (playOn) {
			System.out.println("Druk op <ENTER> voor een worp. Stop het spel met q (van Quit)");
			String invoer = scanner.nextLine();
			invoer = invoer.toLowerCase();
			switch (invoer) {
			case "q":
			case "Q":
				playOn = false;
				break;
			case "":
				int x = 0;
				Worp worp = new Worp();
				for (Dobbelsteen dobbelsteen : dobbelstenen) {
					if (blokkeer[x] == 0) {
						dobbelsteen.waarde = dobbelsteen.werpen();
						worp.worp[x] = dobbelsteen.waarde;
					} else {
						worp.worp[x] = dobbelsteen.waarde;
					}

					x++;
				}
				worp.toonWorp();
				speler.worpGeschiedenis.add(worp);
				vasthouden();
				break;
			default:
				System.out.println("Invoer ongeldig.");

			}

		}
		System.out.println("einde");

	}

	void vasthouden() {
		resetVasthouden();
		Scanner blokscan = new Scanner(System.in);
		System.out.println("Welke posities wilt u vasthouden? 0 voor geen anders bv 124");
		String invoer = blokscan.nextLine();
		boolean juisteInvoer = true;
		for (int i = 0; i < invoer.length(); i++) {
			int getal = Character.getNumericValue(invoer.charAt(i));
			if (getal > 0 && getal < 6) {
				blokkeer[getal - 1] = 1;
			} else if (getal > 5) {
				System.out.println("De waarde " + getal + "is geen geldige postie. Voer waardes in van 1 t/m 5:");
				juisteInvoer = false;

			}
		}
		if (!juisteInvoer) {
			this.vasthouden();
		}

	}

	void resetVasthouden() {
		for (int i = 0; i < blokkeer.length; i++) {
			blokkeer[i] = 0;
		}
	}

}

class Dobbelsteen {
	int waarde;

	int werpen() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

}

class Worp {
	int[] worp = new int[5];

	void toonWorp() {
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

class Speler {
	ArrayList<Worp> worpGeschiedenis = new ArrayList<>();
}