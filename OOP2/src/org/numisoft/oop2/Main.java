package org.numisoft.oop2;

import java.util.Scanner;

import org.numisoft.oop2.carts.Kupe;
import org.numisoft.oop2.carts.Obschij;
import org.numisoft.oop2.carts.Platzkart;
import org.numisoft.oop2.carts.Sv;
import org.numisoft.oop2.locomotives.Elektrovoz;
import org.numisoft.oop2.locomotives.Locomotive;
import org.numisoft.oop2.locomotives.Teplovoz;

public class Main {

	public static void main(String[] args) {

		Train train = new Train();
		Locomotive locomotive;

		System.out.println("Input locomotive: ");
		System.out.println("t = Teplovoz  |  e = Electrovoz");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.next();
			if (input.equalsIgnoreCase("t")) {
				locomotive = new Teplovoz();
				train.addLocomotive(locomotive);
				break;
			}
			if (input.equalsIgnoreCase("e")) {
				locomotive = new Elektrovoz();
				train.addLocomotive(locomotive);
				break;
			}
		}

		System.out
				.println("======================================================");
		System.out.println("Input carts (max " + train.getMaxCartNumber()
				+ " carts): ");
		System.out
				.println("s = Sv  |  k = Kupe  |  p = Platzkart  |  o = Obschij");
		System.out.println("E.g.: sskkkpppooopppkk");

		scanner = new Scanner(System.in);

		char[] cartSequence = scanner.nextLine().replaceAll("[^skpo]", "")
				.toCharArray();

		for (int i = 0; i < cartSequence.length; i++) {
			switch (cartSequence[i]) {
			case 's':
				System.out.println("Cart No." + (i + 1) + " is SV");
				train.addCart(new Sv());
				break;
			case 'k':
				System.out.println("Cart No." + (i + 1) + " is Kupe");
				train.addCart(new Kupe());
				break;
			case 'p':
				System.out.println("Cart No." + (i + 1) + " is Platzkart");
				train.addCart(new Platzkart());
				break;
			case 'o':
				System.out.println("Cart No." + (i + 1) + " is Obschij");
				train.addCart(new Obschij());
				break;
			}
		}
		System.out
				.println("======================================================");

		System.out.println("Total passanger number is: "
				+ train.getTotalPassangerNumber());
		System.out.println("Total baggage number is: "
				+ train.getTotalBaggageNumber());

	}
}
