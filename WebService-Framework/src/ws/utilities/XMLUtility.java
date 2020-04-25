package ws.utilities;
import ws.driver.*;
import ws.library.*;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom.Document;
import org.jdom.input.DOMBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

/**
 * XML handling utility
 * 
 * 
 * @author hsingh2
 * 
 */
public class XMLUtility {

	/**
	 * Print the XML document
	 * 
	 * @param document
	 * @throws Exception
	 */
	public static void printXML(Document document) throws Exception {
		XMLOutputter outputter = new XMLOutputter();
		outputter.setFormat(Format.getPrettyFormat());
		outputter.output(document, System.out);
	}

	/**
	 * 
	 * Convert from String to JDOM
	 * 
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Document strToJDOM(String xmlStr) throws Exception {

		DOMBuilder builder = new DOMBuilder();
		Document jdomDoc = builder.build(toW3CDOM(xmlStr));
		return jdomDoc;

	}

	/**
	 * Convert from JDOM to String
	 * 
	 * @param document
	 * @return
	 * @throws Exception
	 */
	public static String XMLtoStr(Document document) throws Exception {
		XMLOutputter outputter = new XMLOutputter();
		outputter.setFormat(Format.getPrettyFormat());
		StringWriter sw = new StringWriter();
		outputter.output(document, sw);
		return (sw.toString());
	}

	public  static org.w3c.dom.Document toW3CDOM(String xmlString)
			throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document document = builder.parse(new InputSource(
				new StringReader(xmlString)));
		return document;
	}
}
