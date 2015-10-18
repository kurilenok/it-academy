package org.numisoft.stringsarrays2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Input text: ");

		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine().toLowerCase();

		String newText = text.replaceAll(" ", "");

		for (char symbol : newText.toCharArray()) {
			System.out.print(symbol + "  ");
		}

		System.out.println();

		for (char symbol : newText.toCharArray()) {

			if ((symbol - 'a' + 1) < 10) {
				System.out.print(symbol - 'a' + 1 + "  ");
			} else {
				System.out.print(symbol - 'a' + 1 + " ");
			}
		}

	}
}
