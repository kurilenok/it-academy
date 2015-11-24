package org.numisoft.xmlparsers;

/**
 * This class is SINGLETON FACTORY METHOD!
 * */
public class ParserFactory {

	/* SINGLETON */
	private ParserFactory() {
	}

	private static final ParserFactory INSTANCE = new ParserFactory();

	public static ParserFactory getInstance() {
		return INSTANCE;
	}

	/* FACTORY METHOD */
	public AbstractParser getParser(String parserType) {
		switch (parserType) {
		case "DOM":
			return new ParserDOM();
		case "SAX":
			return new ParserSAX();
		case "StAX":
			return new ParserStAX();
		}
		return null;
	}

}
