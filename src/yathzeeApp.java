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
				break;
			}
		}
		System.out.println("einde");

		scanner.close();
	}

}

class Dobbelsteen {
	int waarde;

	int werpen() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

}