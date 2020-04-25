/*---------------------------UTILITY TO PARSE XML FILE----------------------------------*/
/*---------------------------Created By Rakhi-------------------------------------------*/
package ws.utilities;
import ws.driver.*;
import ws.library.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.input.SAXBuilder;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException;
import org.jdom.JDOMException;
import org.jdom.input.JDOMParseException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;
import org.xml.sax.InputSource;

public class XMLParser {

	private static final String E_XPATH = "//e";
	private static final String REPEAT_ELEMENT_NAME = "data";
	
	//Method To Fetch rootElement from given XML file.
	public static Element getRootElementFromXMLFile(String  fileName)
	{
		File fName=new File(fileName);
		InputStream inStream;
		Element rootElement=null;
		try {
			inStream = new FileInputStream(fName);
			SAXBuilder parser = new SAXBuilder();
			Document urlPermissionsDoc;
			urlPermissionsDoc = parser.build(inStream);
			rootElement = urlPermissionsDoc.getRootElement();
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		
		
		
		catch(JDOMParseException e)
		{
			System.out.println("ERROR: Could not parse XML input file(Exception=JDOMParseException) :" );
			System.out.println("Error At Line Number: "+e.getLineNumber());
			System.out.println("Error At Column Number: "+e.getColumnNumber());
			System.out.println("Message: "+e.getLocalizedMessage());
			
		}
		
		catch(MalformedByteSequenceException e)
		{
			System.out.println("ERROR: Could not parse XML input file(Exception=MalformedByteSequenceException) :" );
			System.out.println("Domain: "+e.getDomain());
			System.out.println("Arguments: "+e.getArguments());
			System.out.println("Key: "+e.getKey());
			System.out.println("LocalizedMessage: "+e.getLocalizedMessage());
			System.out.println("Message: "+e.getMessage());
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
		} 
		catch (JDOMException e) {
			
			e.printStackTrace();
		}
		
		return rootElement; 
	}
	
	//Method To Fetch all Children of given parent Element .
	@SuppressWarnings("unchecked")
	public static List<Element> getChildren(Element parentElement)
	{
		
		return(parentElement.getChildren());
	}
	
	
	
	//Overloaded method to fetch all children of given name of given parent element.
	
	@SuppressWarnings("unchecked")
	public static List<Element> getChildren(Element parentElement, String tagName)
	{
		List<Element> children = parentElement.getChildren(tagName);	
		return children;
	}
	
	
	//Method To Fetch a particular child from a list of Elements of given criteria and value .
	public static Element getChildFromList(List<Element> list, String attributeName, String value)
	{
		Element element=null;
		String criteriaValue;
		for(Element e:list)
		{
				criteriaValue=e.getAttributeValue(attributeName);
				
				if(criteriaValue==null)
				{
						System.out.println("Given attributename didnot not found");
						break;
				}
				else
				{
						
					if(criteriaValue.equals(value))
					{
						element=e;
						break;
					}
				}
		}
		return(element);
	}
	
	//Method To Fetch a particular child from a list at given index .
	public static Element getChildFromListAt(List<Element> list, int index)
	{
		Element element=null;
		
		if(index<1)
			System.out.println("Invalid Index, Minimum value of index is 1");
		else
			if(index>list.size())
				System.out.println("Invalid Index, value of index is greater than size of list");
			else
			{
				int count=0;
				for(Element e:list)
				{
					count++;
					if(count==index)
					{
						element=e;
						break;
					}
				}
			}
		
		return(element);
	}
	
	
	//Method To Fetch first child of given tagname and given parent element
	public static Element getFirstChild(Element e, String tagName)
	{
		
		return(e.getChild(tagName));
	}
	
	
	
	//Overloaded method to get Child Element of given tagname of given parent Element at given index
	@SuppressWarnings("unchecked")
	public static Element getChildAt(Element parentElement, String tagName, int index)
	{
		List<Element> children = parentElement.getChildren(tagName);
		
		return (getChildFromListAt(children,index));
	}
	
	//Overloaded method to get Child Element of given parent Element at given index
	@SuppressWarnings("unchecked")
	public static Element getChildAt(Element parentElement, int index)
	{
		List<Element> children = parentElement.getChildren();
		
		return (getChildFromListAt(children,index));
	}
	
	
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

	public static String fromJsonToXMLStr(String jsonStr, String rootNode,
			boolean changeToAttributes) throws Exception {
		String xmlStr = xmlStr(jsonStr, rootNode);
		org.jdom.Document doc = null;

		// if false then just replace "e" element with new element name
		if (!changeToAttributes) {
			doc = processXML(xmlStr);
		} else {
			doc = processXMLAttributes(xmlStr);
		}

		return XMLUtility.XMLtoStr(doc);
	}

	private static org.jdom.Document processXML(String xmlStr) throws Exception {
		org.jdom.Document doc = null;
		doc = XMLUtility.strToJDOM(xmlStr);
		List<Element> list = XPath.selectNodes(doc, E_XPATH);
		Element parentNode = null;
		;
		String parentNodeName = "";
		String childNodeName = "";

		if (list.size() > 0) {

			for (Element element : list) {
				parentNode = element.getParentElement();
				parentNodeName = parentNode.getName();
				childNodeName = getChildName(parentNodeName);
				element.setName(childNodeName);

			}
		}
		return doc;
	}

	private static org.jdom.Document processXMLAttributes(String xmlStr)
			throws Exception {
		org.jdom.Document doc = null;
		doc = XMLUtility.strToJDOM(xmlStr);
		List<Element> list = XPath.selectNodes(doc, E_XPATH);
		Element parentNode = null;
		;
		String parentNodeName = "";
		String childNodeName = "";

		if (list.size() > 0) {

			for (Element element : list) {
				parentNode = element.getParentElement();
				parentNodeName = parentNode.getName();
				childNodeName = getChildName(parentNodeName);
				element.setName(childNodeName);
				List<Element> children = element.getChildren();
				if (children.size() > 0) {
					List<String> arrayName = new ArrayList<String>();
					if (children.get(0).getChildren().size() == 0) {

						// /replace elements with attributes
						for (Element child : children) {
							String name = child.getName();
							element.setAttribute(name, child.getValue());
							arrayName.add(name);
						}
						// remove all the children
						for (String name : arrayName) {
							element.removeChild(name);
						}
					}
				}
			}
		}
		return doc;
	}

	private static String xmlStr(String jsonStr, String rootNode) {
		XMLSerializer serializer = new XMLSerializer();
		JSON json = JSONSerializer.toJSON(jsonStr);
		serializer.setRootName(rootNode);
		serializer.setTypeHintsEnabled(false);
		return serializer.write(json);

	}

	private static String getChildName(String str) {
		return str.substring(0, str.length() - 1);
	}

	public static boolean testIdentical(String expectedXMLOutput, String actualXMLOutput) throws Exception 
    {
    	XMLUnit.setIgnoreWhitespace(true);
        Diff myDiff = new Diff(expectedXMLOutput, actualXMLOutput);
        
        return myDiff.similar();
    }
	
	
}

	
	
	
	
	
	
	
