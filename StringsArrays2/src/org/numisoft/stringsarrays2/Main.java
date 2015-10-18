package org.numisoft.stringsarrays2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Input text: ");

		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine().toLowerCase();

		String newText = text.replaceAll(" ", "");

		// print chars

		for (char symbol : newText.toCharArray()) {
			System.out.print(symbol + "  ");
		}

		System.out.println();

		// print numbers

		for (char symbol : newText.toCharArray()) {

			// align one-digit numbers (1-10) with chars

			if ((symbol - 'a' + 1) < 10) {
				System.out.print(symbol - 'a' + 1 + "  ");
			} else {
				System.out.print(symbol - 'a' + 1 + " ");
			}
		}

	}
}
