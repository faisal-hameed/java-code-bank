package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {

	public static void main(String[] args) {

	}

	public void parse() {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			Document document = builder.parse(new FileInputStream(
					"data\\test.xml"));

			Element rootElement = document.getDocumentElement();

			NodeList nodes = rootElement.getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node instanceof Element) {
					// a child element to process
					Element child = (Element) node;
					String attribute = child.getAttribute("width");

					String attrValue = child.getAttribute("attrName");
					Attr attri = child.getAttributeNode("attrName");

					System.out.println("Value : " + attrValue);
				}
			}

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void validateSchema(Document document) {
		Schema schema = null;
		try {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language);
			schema = factory.newSchema(new File("data\\test.xml"));

			Validator validator = schema.newValidator();

			validator.validate(new DOMSource(document));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
