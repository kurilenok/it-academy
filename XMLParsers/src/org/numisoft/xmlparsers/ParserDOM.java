package org.numisoft.xmlparsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This class is DOM-type parser
 * 
 * */
public class ParserDOM extends AbstractParser {

	@Override
	public void parse(File file) {

		System.out.println("DOM parser activated");
		System.out.println("======================");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			doc = builder.parse(file);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element root = doc.getDocumentElement();
		// System.out.println(root.getTagName());

		NodeList nodeList = root.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				// System.out.println(element.getNodeName());
				System.out.print(element.getElementsByTagName("firstName").item(0).getTextContent()
						+ " ");
				System.out.println(element.getElementsByTagName("lastName").item(0)
						.getTextContent());
				System.out.println("Age: "
						+ element.getElementsByTagName("age").item(0).getTextContent());
				System.out.println("Faculty: "
						+ element.getElementsByTagName("faculty").item(0).getTextContent());
				System.out.println("----------------------");

			}

		}

	}

}
