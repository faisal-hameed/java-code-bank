package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Advantages(Schema Validation,Memory efficient) DisAdvantages(No support of
 * xml writing,no control over application) Uses Observer Design Pattern It is a
 * push API stands for (Simple API for XML)
 */
public class TestSaxHandler extends DefaultHandler {

	public List<Parent> parents = new ArrayList<Parent>();
	public List<Child> childs = new ArrayList<Child>();

	private Stack<String> elementStack = new Stack<String>();
	private Stack<Object> objectStack = new Stack<Object>();

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("start element " + qName);
		this.elementStack.push(qName);

		if ("parent".equals(qName)) {
			String id = attributes.getValue("id");
			String name = attributes.getValue("name");
			Parent parent = new Parent(id, name);
			this.objectStack.push(parent);
			this.parents.add(parent);
		} else if ("child".equals(qName)) {
			String id = attributes.getValue("id");
			Child child = new Child();
			child.setId(id);
			this.objectStack.push(child);
			this.childs.add(child);
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
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

	public void characters(char ch[], int start, int length)
			throws SAXException {

		String value = new String(ch, start, length).trim();
		if (value.length() == 0)
			return; // ignore white space
		System.out.println("character is " + value);

		if ("child".equals(currentElement())) {
			Child child = (Child) this.objectStack.peek();
			child.setValue(value);
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

	public static void main(String argv[]) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			String file = TestSaxHandler.class.getClassLoader()
					.getResource("data/test.xml").getFile();
			InputStream xmlInput = new FileInputStream(file);

			SAXParser saxParser = factory.newSAXParser();
			TestSaxHandler handler = new TestSaxHandler();

			try {
				saxParser.parse(xmlInput, handler);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			for (Iterator iter = handler.parents.iterator(); iter.hasNext();) {
				Parent bean = (Parent) iter.next();
				System.out.println(bean);
				for (Iterator iterator = bean.getChilds().iterator(); iterator
						.hasNext();) {
					Child type = (Child) iterator.next();
					System.out.println(type);
				}
			}
			System.out.println("obj stack size " + handler.objectStack.size());
			System.out.println("elm stack size " + handler.elementStack.size());

			// System.out.println(handler.objectStack.size());
			// System.out.println(handler.elementStack.size());
		} catch (Throwable err) {
			err.printStackTrace();
		}
	}

}
