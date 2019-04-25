package yathzee;

import java.util.ArrayList;
import java.util.Scanner;

public class YahtzeeSpel {
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
	ArrayList<Speler> Spelers = new ArrayList<>();
	int[] blokkeer = { 0, 0, 0, 0, 0 };

	YahtzeeSpel() {
		for (int i = 0; i < 5; i++) {
			this.dobbelstenen.add(new Dobbelsteen());
		}
		int aantalSpelers = welkomBij();
		for (int i = 0; i < aantalSpelers; i++) {
			this.Spelers.add(new Speler());
		}
	}

	void spelen() {
		Scanner scanner = new Scanner(System.in);
		boolean playOn = true;
		int spelerNr = 1;
		for (Speler speler : Spelers) {
			resetVasthouden();
			speler.toonSpelerStart(spelerNr);
			int worpNr = 1;
			while (playOn) {
				System.out.println("Druk op <ENTER> voor een worp. Stop het spel met q (van Stoppen ;-))");
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
					worp.toonWorp(worpNr, spelerNr);
					worpNr++;
					speler.worpGeschiedenis.add(worp);
					vasthouden();
					break;
				default:
					System.out.println("Invoer ongeldig.");

				}

			}
			playOn = true;

			speler.toonSpelerEinde(spelerNr);
			spelerNr++;
		}
		System.out.println("Einde van dit spel.");

	}

	int welkomBij() {
		boolean geenGeldigeInvoer = true;
		Scanner spelers = new Scanner(System.in);
		System.out.println("Welkom bij Yahtzee");
		while (geenGeldigeInvoer) {
			System.out.println("Met hoeveel spelers wilt u spelen? (1 t/m 4)");
			String invoer = spelers.nextLine();
			switch (invoer) {
			case "1":
				geenGeldigeInvoer = false;
				return 1;
			case "2":
				geenGeldigeInvoer = false;
				return 2;
			case "3":
				geenGeldigeInvoer = false;
				return 3;
			case "4":
				geenGeldigeInvoer = false;
				return 4;
			default:
				System.out.println("Invoer ongeldig.");
				break;
			}
		}
		return -1; // de methode komt hier nooit, maar eclipse vind dat deze er toch moet staan,
				   // van daar de waarde -1

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
