package test;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class TestStaxStreamWriter {

	public static void main(String[] args) {
		TestStaxStreamWriter writer = new TestStaxStreamWriter();
		writer.write();
	}

	public void write() {
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		try {
			XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("data\\output2.xml"));

			writer.writeStartDocument();
			writer.writeStartElement("document");
			writer.writeStartElement("data");
			writer.writeAttribute("name", "value");
			writer.writeEndElement();
			writer.writeEndElement();
			writer.writeEndDocument();

			writer.flush();
			writer.close();

		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
