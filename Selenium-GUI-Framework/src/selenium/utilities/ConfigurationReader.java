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
 * Objective: Class to read configuration/properties files
 ************************************************************************/
package selenium.utilities;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigurationReader 
{
	private Properties properties;
	private FileInputStream inStream;	
	public ConfigurationReader(String fileLocation)
	{
		
		try
		{
		inStream=new FileInputStream(fileLocation);
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*log using log4j */
		} 
		try 
		{
			properties=new Properties();
			properties.load(inStream);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*log using log4j */
		}
	}
	public String getPropertyValue(String propertyName)
	{	
			
			return(properties.getProperty(propertyName));
		
		
	}
	public void setPropertyValue(String properName,String value)
	{
		properties.setProperty(properName, value);
		try {
			properties.store(new FileOutputStream("ConfigurationFiles/configuration.properties"),null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
