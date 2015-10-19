package org.numisoft.stringsarrays5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input text: ");
		String text = scanner.nextLine();

		char[] charArray = text.toCharArray();

		boolean isUnique = true;

		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					System.out.println("String contains duplicate chars");
					isUnique = false;
					return;
				}
			}
		}

		if (isUnique) {
			System.out.println("String does not contain duplicate chars");
		}

	}

}
