package org.numisoft.threads2;

public class Customer implements Runnable {

	private int counter;

	String[] items = { "Kartoshka", "Gamburger", "McNuggets", "Kola", "Maffin", "Milkshake" };

	public Customer(int counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		System.out.println("Customer " + counter + " in");

		int k = 0;
		String name = Thread.currentThread().getName();

		for (int i = 0; i < items.length; i++) {

			System.out.println("Customer " + counter + " @ Kassa "
					+ name.substring(name.length() - 1) + ": " + items[i]);
		}

		// for (int i = 0; i < 5; i++) {
		//
		// StringBuilder sb = new StringBuilder();
		// sb.append("Customer " + counter + " @ Counter " +
		// name.substring(name.length() - 1)
		// + " /// ");
		// for (int j = 0; j < 20; j++) {
		// sb.append(++k);
		// }
		// System.out.println(sb);
		// }

		System.out.println("Customer " + counter + " out\nKassa "
				+ name.substring(name.length() - 1) + ": svobodnaja kassa!");

	}
}
