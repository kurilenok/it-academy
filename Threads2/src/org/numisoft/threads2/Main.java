package org.numisoft.threads2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		int counter = 1;

		ExecutorService es = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 20; i++) {
			Runnable customer = new Customer(counter++);
			es.execute(customer);
		}

		es.shutdown();
	}
}
