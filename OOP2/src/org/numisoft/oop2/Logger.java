package org.numisoft.oop2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is logging events to log.txt. This class is SINGLETON
 * 
 * */
public class Logger {

	private static final Logger INSTANCE = new Logger();

	private String message;
	private File file = new File("log.txt");
	private PrintWriter printer;

	private Logger() {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Logger getInstance() {
		return INSTANCE;
	}

	public void log(String message) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		try {
			printer = new PrintWriter(new FileWriter(file, true));
			printer.println(dateFormat.format(date) + " ->> " + message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			printer.flush();
			printer.close();
		}

	}
}
