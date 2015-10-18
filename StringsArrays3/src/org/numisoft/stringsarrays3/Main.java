package org.numisoft.stringsarrays3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Input text: ");
		String text = scanner.nextLine();

		String newText = text.replaceAll("(?u)[^\\pL ]", "");

		System.out.println(newText);

	}

}
