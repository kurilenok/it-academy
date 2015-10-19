package stringsarrays6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input first line: ");
		String text1 = scanner.nextLine();

		System.out.println("Input second line: ");
		String text2 = scanner.nextLine();

		char[] charArray1 = text1.toCharArray();
		char[] charArray2 = text2.toCharArray();

		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		if ((new String(charArray1)).equals(new String(charArray2))) {
			System.out.println("Lines have same set of chars");
		} else {
			System.out.println("Lines have different set of chars");
		}

	}

}
