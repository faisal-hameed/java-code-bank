package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * DisAdvantages(No Schema Validation)
 * Advantages(support of xml writing,control over application,Memory efficient)
 * It is Iterator style API
 * It is a pull API stands for (Simple typed API for XML)
 */

public class TestStaxEventReader {

	public List<Parent> parents = new ArrayList<Parent>();
	public List<Child> childs = new ArrayList<Child>();

	private Stack<String> elementStack = new Stack<String>();
	private Stack<Object> objectStack = new Stack<Object>();

	public static void main(String[] args) {
		TestStaxEventReader temp = new TestStaxEventReader();
		temp.parse();

		for (Iterator iter = temp.parents.iterator(); iter.hasNext();) {
			Parent bean = (Parent) iter.next();
			System.out.println(bean);
			for (Iterator iterator = bean.getChilds().iterator(); iterator.hasNext();) {
				Child type = (Child) iterator.next();
				System.out.println(type);
			}
		}
		System.out.println("obj stack size " + temp.objectStack.size());
		System.out.println("elm stack size " + temp.elementStack.size());
	}

	private void parse() {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		// factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
		InputStream xmlInput = null;
		try {
			xmlInput = new FileInputStream("data\\test.xml");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			XMLStreamReader streamReader = factory.createXMLStreamReader(xmlInput);
			while (streamReader.hasNext()) {
				int event = streamReader.next();
				if (event == XMLStreamConstants.START_ELEMENT) {
					String qName = streamReader.getLocalName();
					System.out.println("start element " + qName);
					// if ("conternts".equals(qName)) {
					// eventReader.next();
					// continue;
					// }
					this.elementStack.push(qName);
					if ("parent".equals(qName)) {
						// String id = startElement.getAttributeByName(new
						// QName("id")).toString();
						// String name = startElement.getAttributeByName(new
						// QName("name")).toString();
						Parent parent = new Parent();
						this.objectStack.push(parent);
						this.parents.add(parent);
					} else if ("child".equals(qName)) {
						// String id = startElement.getAttributeByName(new
						// QName("id")).toString();
						Child child = new Child();
						// child.setId(id);
						this.objectStack.push(child);
						this.childs.add(child);
					}
				}
				if (event == XMLStreamConstants.END_ELEMENT) {
					// EndElement endElement = event.asEndElement();
					String qName = streamReader.getLocalName();
					System.out.println("end element " + qName);
					this.elementStack.pop();
					if ("parent".equals(qName) || "child".equals(qName)) {
						Object object = this.objectStack.pop();
						if ("parent".equals(qName)) {
							Parent parent = (Parent) object;
							parent.setChilds(this.childs);
							this.childs = new ArrayList<Child>();
						} else if ("child".equals(qName)) {
							// Do nothing
						}
					}
				}
				if (event == XMLStreamConstants.CHARACTERS) {
					String character = streamReader.getLocalName();
					System.out.println("character " + character);
					// if (character == null || character.isWhiteSpace())
					// continue; // ignore white space
					// String value = character.getData();
					// System.out.println("character is " + value);
					// if ("child".equals(currentElement())) {
					// Child child = (Child) this.objectStack.peek();
					// child.setValue(value);
					// }
				}
				// handle more event types here...
			}

		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private String currentElement() {
		return this.elementStack.peek();
	}

	private String currentElementParent() {
		if (this.elementStack.size() < 2)
			return null;
		return this.elementStack.get(this.elementStack.size() - 2);
	}

}
