/***********************************************************************
 * (C) Copyright 2011 SafeNet, Inc. All rights reserved. This software
 * contains proprietary information, which shall not be reproduced or
 * transferred to other documents and shall not be disclosed to others
 * or used for manufacturing or any other purpose without prior written
 * permission of SafeNet, Inc.
 **********************************************************************/
/*******************Revision History*************************************
 * Written By: Debasish Pradhan
 * Last Updated Date: 14-Feb-2011
 * Objective: class to read XML File and return child elements
 ************************************************************************/
package selenium.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import renchuTool.RenchuTool;

import org.jaxen.JaxenException;
import org.jaxen.jdom.JDOMXPath;

public class ParseXMLFile extends RenchuTool {

	private Document xmlDoc = null;
	private String[] testCaseIdsStr = null;

	/**
	 * Constructor , Argument1=relative path of file location *
	 * 
	 * @param fileLocation=relative
	 *            path of fileLocation Initialization: xmlDoc,testCaseIdsStr
	 */
	@SuppressWarnings("unchecked")
	public ParseXMLFile(String fileLocation) {
		try {
			int testCaseCounter = -1;
			FileInputStream fInStream = new FileInputStream(fileLocation);

			SAXBuilder parser = new SAXBuilder();

			try {
				xmlDoc = parser.build(fInStream);

			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				/* log using log4j */
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				/* log using log4j */
			}
			Element rootElement = xmlDoc.getRootElement();
			List<Element> ElementTestCaseIds = rootElement.getChildren();
			testCaseIdsStr = new String[ElementTestCaseIds.size()];
			for (Element ElementTestCaseId : ElementTestCaseIds) {
				testCaseIdsStr[++testCaseCounter] = ElementTestCaseId.getAttributeValue("id").trim();
				pop("testCaseIdsStr[" + testCaseCounter + "]=" + testCaseIdsStr[testCaseCounter]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/* log using log4j */
		}
	}

	/**
	 * Method to get TestCases
	 * 
	 * @param=void
	 * @return test case id's in String array
	 */
	public String[] getTestCaseIds() {
		return (this.testCaseIdsStr);
	}

	/**
	 * 
	 * @param testCaseId
	 * @return test case steps in string array
	 */

	@SuppressWarnings("unchecked")
	public String[] getTestCaseSteps(String testCaseId) {
		String[] testCaseStepsStr = null;
		try {

			JDOMXPath XPathTestCaseStep = new JDOMXPath("//TCID[@id='" + testCaseId + "']/Step");
			List tcElement = XPathTestCaseStep.selectNodes(xmlDoc);
			Iterator iterator = tcElement.iterator();
			testCaseStepsStr = new String[tcElement.size()];
			int testCaseStepCounter = -1;
			while (iterator.hasNext()) {
				Element ElementTestCaseStep = (Element) iterator.next();
				testCaseStepsStr[++testCaseStepCounter] = ElementTestCaseStep.getAttributeValue("no").trim();
			}

		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testCaseStepsStr;
	}

	/**
	 * @param=testCaseId
	 * @return=testCaseDescription in String format
	 */
	@SuppressWarnings("unchecked")
	public String getTestCaseDescription(String testCaseId) {
		String testCaseDescriptionStr = null;
		try {

			JDOMXPath XPathTestCaseDescription = new JDOMXPath("//TCID[@id='" + testCaseId + "']/TestCaseDescription");
			List tcElement = XPathTestCaseDescription.selectNodes(xmlDoc);
			Iterator iterator = tcElement.iterator();
			Element ElementTestCaseDescription = (Element) iterator.next();
			testCaseDescriptionStr = ElementTestCaseDescription.getText();

		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testCaseDescriptionStr;
	}

	/**
	 * 
	 * @param testCaseId
	 * @param testStepNo
	 * @return test step description in string format
	 */
	@SuppressWarnings("unchecked")
	public String getTestStepDescription(String testCaseId, String testStepNo) {
		String testStepDescriptionStr = null;
		try {

			JDOMXPath XPathTestStepDescription = new JDOMXPath(
					"//TCID[@id='" + testCaseId + "']/Step[@no='" + testStepNo + "']/Description");
			
			List tcElement = XPathTestStepDescription.selectNodes(xmlDoc);
			Iterator iterator = tcElement.iterator();
			Element ElementTestCaseStepDesc = (Element) iterator.next();
			testStepDescriptionStr = ElementTestCaseStepDesc.getText();

		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testStepDescriptionStr;
	}

	/**
	 * 
	 * @param testCaseId
	 * @param testStepNo
	 * @return TestStepUILocator in string format
	 */
	@SuppressWarnings("unchecked")
	public String getTestStepUILocator(String testCaseId, String testStepNo) {
		String testStepUiLocatorStr = null;
		try {

			JDOMXPath XPathTestStepUiLocator = new JDOMXPath(
					"//TCID[@id='" + testCaseId + "']/Step[@no='" + testStepNo + "']/UILocator");
			List tcElement = XPathTestStepUiLocator.selectNodes(xmlDoc);
			Iterator iterator = tcElement.iterator();
			Element ElementTestStepUiLocator = (Element) iterator.next();
			testStepUiLocatorStr = ElementTestStepUiLocator.getText();

		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testStepUiLocatorStr;
	}

	/**
	 * 
	 * @param testCaseId
	 * @param testStepNo
	 * @return TestStepAction in String format
	 */

	@SuppressWarnings("unchecked")
	public String getTestStepAction(String testCaseId, String testStepNo) {
		String testStepActionStr = null;
		try {

			JDOMXPath XPathTestStepAction = new JDOMXPath(
					"//TCID[@id='" + testCaseId + "']/Step[@no='" + testStepNo + "']/Action");
			List tcElement = XPathTestStepAction.selectNodes(xmlDoc);
			Iterator iterator = tcElement.iterator();
			Element ElementTestStepAction = (Element) iterator.next();
			testStepActionStr = ElementTestStepAction.getText();

		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testStepActionStr;
	}

	/**
	 * 
	 * @param testCaseId
	 * @param testStepNo
	 * @return Step Action Parameter in String format
	 */
	@SuppressWarnings("unchecked")
	public String getTestStepActionParameter(String testCaseId, String testStepNo) {
		String testStepActionParameterStr = null;
		try {

			JDOMXPath XPathTestStepActionParameter = new JDOMXPath(
					"//TCID[@id='" + testCaseId + "']/Step[@no='" + testStepNo + "']/ActionParameter");
			List tcElement = XPathTestStepActionParameter.selectNodes(xmlDoc);
			Iterator iterator = tcElement.iterator();
			Element ElementTestStepActionParameter = (Element) iterator.next();
			testStepActionParameterStr = ElementTestStepActionParameter.getText();

		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testStepActionParameterStr;
	}

}
