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
	int [] blokkeer = {0,0,0,0,0};

	YahtzeeSpel() {
		for (int i = 0; i < 5; i++) {
			this.dobbelstenen.add(new Dobbelsteen());
		}
	}

	void spelen() {
		Scanner scanner = new Scanner(System.in);
		boolean playOn = true;
		while (playOn) {
			System.out.println("Geef een letter op: q = Quit");
			String invoer = scanner.nextLine();
			invoer = invoer.toLowerCase();
			switch (invoer) {
			case "q":
				playOn = false;
				break;
			default:
				System.out.print("| ");
				for (Dobbelsteen dobbelsteen : dobbelstenen) {
					dobbelsteen.waarde = dobbelsteen.werpen();
					System.out.print(dobbelsteen.waarde + " | ");
				}
				System.out.println();
				vasthouden();
				break;
			}
			
		}
		System.out.println("einde");

		scanner.close();
	}
	void vasthouden () {
//		ArrayList<Integer> teBlokkeren = new ArrayList<>();
		Scanner blokscan = new Scanner(System.in);
		System.out.println("Welke posities wilt u vasthouden? 0 voor geen anders bv 124"); 
		String invoer = blokscan.nextLine();
		boolean juisteInvoer = true;
		for (int i = 0; i <invoer.length(); i++){
			int getal = Character.getNumericValue(invoer.charAt(i));
			System.out.println(getal);
			if(getal>0 && getal<6) {
				blokkeer[getal-1] = 1;
			} else {
				System.out.println("De waarde " + getal + "is geen geldige postie. Voer waardes in van 1 t/m 5:");
				juisteInvoer = false;
			}
		}
		if (!juisteInvoer) {
			this.vasthouden();
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