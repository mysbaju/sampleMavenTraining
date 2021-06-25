package commonUtils;

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

public class XmlReader {

	
	public String readXmlData(String tagname) throws ParserConfigurationException, SAXException, IOException {
		String path = System.getProperty("user.dir")+"/src/test/resources/testData/xmlObjectRepo.xml";
		File file = new File(path);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = factory.newDocumentBuilder();
		Document document = build.parse(file);
		NodeList list = document.getElementsByTagName("objRep");
		Node node1 = list.item(0);
		Element elem =(Element)node1;
		return elem.getElementsByTagName(tagname).item(0).getTextContent();
		
	}
}
