package org.numisoft.xmlparsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * This class is SAX-type parser
 * 
 * */
public class ParserStAX extends AbstractParser {

	@Override
	public void parse(File file) {

		System.out.println("StAX parser activated");
		System.out.println("======================");

		boolean isFirstName = false;
		boolean isLastName = false;
		boolean isAge = false;
		boolean isFaculty = false;

		XMLInputFactory factory = XMLInputFactory.newFactory();
		try {
			XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));
			while (reader.hasNext()) {
				int res = reader.next();
				if (res == reader.START_ELEMENT) {
					if (reader.getLocalName().equals("firstName"))
						isFirstName = true;
					else if (reader.getLocalName().equals("lastName"))
						isLastName = true;
					else if (reader.getLocalName().equals("age"))
						isAge = true;
					else if (reader.getLocalName().equals("faculty"))
						isFaculty = true;
				} else if (res == reader.CHARACTERS) {
					if (isFirstName) {
						System.out.print(reader.getText() + " ");
						isFirstName = false;
					} else if (isLastName) {
						System.out.println(reader.getText());
						isLastName = false;
					} else if (isAge) {
						System.out.println("Age: " + reader.getText());
						isAge = false;
					} else if (isFaculty) {
						System.out.println("Faculty: " + reader.getText());
						isFaculty = false;
					}
				}
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}

	}

}
