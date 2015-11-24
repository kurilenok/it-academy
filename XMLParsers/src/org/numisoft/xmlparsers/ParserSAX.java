package org.numisoft.xmlparsers;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * This class is SAX-type parser
 * 
 * */
public class ParserSAX extends AbstractParser {

	@Override
	public void parse(File file) {

		System.out.println("SAX parser activated");
		System.out.println("======================");

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean isFirstName = false;
				boolean isLastName = false;
				boolean isAge = false;
				boolean isFaculty = false;

				@Override
				public void startElement(String uri, String localName, String qName,
						Attributes attributes) throws SAXException {

					if (qName.equalsIgnoreCase("firstName")) {
						isFirstName = true;
					}

					if (qName.equalsIgnoreCase("lastName")) {
						isLastName = true;
					}

					if (qName.equalsIgnoreCase("age")) {
						isAge = true;
					}

					if (qName.equalsIgnoreCase("faculty")) {
						isFaculty = true;
					}

				}

				@Override
				public void characters(char ch[], int start, int length) throws SAXException {

					if (isFirstName) {
						System.out.print(new String(ch, start, length) + " ");
						isFirstName = false;
					}

					if (isLastName) {
						System.out.println(new String(ch, start, length));
						isLastName = false;
					}

					if (isAge) {
						System.out.println("Age: " + new String(ch, start, length));
						isAge = false;
					}

					if (isFaculty) {
						System.out.println("Faculty : " + new String(ch, start, length));
						System.out.println("----------------------");
						isFaculty = false;
					}

				}

			};

			saxParser.parse(new FileInputStream(file), handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
