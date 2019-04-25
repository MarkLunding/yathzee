package yathzee;

import java.util.Random;

public class Dobbelsteen {
	int waarde;

	int werpen() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

}
