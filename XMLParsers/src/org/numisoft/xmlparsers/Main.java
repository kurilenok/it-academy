package org.numisoft.xmlparsers;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File file = new File("source.xml");

		ParserFactory factory = ParserFactory.getInstance();

		AbstractParser parser = factory.getParser("DOM");
		parser.parse(file);

		parser = factory.getParser("SAX");
		parser.parse(file);

		parser = factory.getParser("StAX");
		parser.parse(file);

	}

}
