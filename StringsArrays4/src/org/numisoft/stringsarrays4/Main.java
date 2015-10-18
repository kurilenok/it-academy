package org.numisoft.stringsarrays4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input text: ");
		String text = scanner.nextLine();

		System.out.println("Input word length to delete: ");
		int wordLength = scanner.nextInt();

		String[] words = text.split("\\s");

		StringBuilder newText = new StringBuilder();

		for (int i = 0; i < words.length; i++) {

			if ((words[i].length() == wordLength) && isConsonant(words[i])) {
				//
			} else {
				newText.append(words[i] + " ");
			}
		}

		System.out.print(newText);
	}

	public static boolean isConsonant(String word) {
		switch (word.toLowerCase().charAt(0)) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'y':
			return false;
		default:
			return true;
		}
	}

}
