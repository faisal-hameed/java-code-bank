package xpath;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XpathTest {
    private String file = "data/xpath-file.xml";

    public static void main(String[] args) {
        XpathTest parser = new XpathTest();
        try {
            parser.testXpath();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testXpath() throws IOException, ParserConfigurationException, XPathExpressionException, SAXException {
        InputStream fileSt = getClass().getClassLoader().getResourceAsStream(file);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(fileSt);
        XPath xPath = XPathFactory.newInstance().newXPath();

        System.out.println("Get nodes with path (/Tutorials/Tutorial)");
        String expression = "/Tutorials/Tutorial";
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
        System.out.println(nodeList.getLength());

        System.out.println("Get node with path (tutId=02)");
        String tutId = "02";
        expression = "/Tutorials/Tutorial[@tutId=" + "'" + tutId + "'" + "]";
        xPath = XPathFactory.newInstance().newXPath();
        Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
        System.out.println(node);

        System.out.println("Get node with name (title=Guava)");
        String name = "Guava";
        expression = "//Tutorial[descendant::title[text()=" + "'" + name + "'" + "]]";
        nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
        System.out.println(nodeList.getLength());

    }

}
