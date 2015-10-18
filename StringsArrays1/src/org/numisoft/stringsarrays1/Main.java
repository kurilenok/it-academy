package org.numisoft.stringsarrays1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input text: ");
		String text = scanner.nextLine();

		System.out.print("Input symbol: ");
		String replacement = scanner.next();

		System.out.println("Input index: ");
		int index = scanner.nextInt();

		String[] words = text.split("\\s");

		for (int i = 0; i < words.length; i++) {
			System.out.print("");

			if (index < words[i].length()) {
				String temp = "";
				temp += words[i].substring(0, index - 1);
				temp += replacement;
				temp += words[i].substring(index, words[i].length());

				words[i] = temp;
			}
			System.out.print(words[i] + " ");

		}
	}
}
