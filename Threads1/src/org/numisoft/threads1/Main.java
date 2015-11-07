package org.numisoft.threads1;

public class Main {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		t1.setName("Thread 1: ");
		t2.setName("Thread 2: ");

		t1.start();
		t2.start();

	}

	static synchronized void print10() {
		int k = 0;
		for (int i = 0; i < 25; i++) {

			StringBuilder sb = new StringBuilder();
			sb.append(Thread.currentThread().getName());
			for (int j = 0; j < 20; j++) {
				sb.append(++k + " ");

			}
			System.out.println(sb);

		}
	}

}
