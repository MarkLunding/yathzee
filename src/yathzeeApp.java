import java.util.Scanner;

public class yathzeeApp {

	public static void main(String[] args) {
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
				break;
			}
		}
		System.out.println("einde");
		scanner.close();
	}



}
