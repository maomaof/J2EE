
package selenium.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/*
 * 读取配置文件
 * 设置，获取配置文件中的值
 */

public class ConfigurationReader {
	private Properties properties;
	private FileInputStream inStream;

	public ConfigurationReader(String fileLocation) {

		try {
			inStream = new FileInputStream(fileLocation);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/* log using log4j */
		}
		try {
			properties = new Properties();
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/* log using log4j */
		}
	}

	public String getPropertyValue(String propertyName) {

		return (properties.getProperty(propertyName));

	}

	public void setPropertyValue(String properName, String value) {
		properties.setProperty(properName, value);
		try {
			properties.store(new FileOutputStream("ConfigurationFiles/configuration.properties"), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
