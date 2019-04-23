import java.util.Random;
import java.util.Scanner;

public class yathzeeApp {

	public static void main(String[] args) {
		YahtzeeSpel yahtzee = new YahtzeeSpel();
		yahtzee.spelen();
	}

}

class YahtzeeSpel {

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
				int dobbel1 = werpen();
				System.out.println(dobbel1);
				break;
			}
		}
		System.out.println("einde");
		scanner.close();
	}

	int werpen() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}
}