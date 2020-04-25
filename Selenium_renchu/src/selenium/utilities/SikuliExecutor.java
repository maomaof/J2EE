package selenium.utilities;
import org.sikuli.script.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SikuliExecutor {
	
	static Class SikuliClass;
	static Method sikuliMethods[];
	static int totalMethods;
	static int totalParameters;
	static Class parameterTypes[];
	static Screen sikuli=new Screen();
	static int j;
	static ConfigurationReader Conf=new ConfigurationReader("ConfigurationFiles/configuration.properties");
	static double timeOut = Double.parseDouble(Conf.getPropertyValue("sikTimeOut"));
	
	
	public static void sikuliCommandExecutor(String Action,String UiLocator,String ActionParameter) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, FindFailed, NumberFormatException, InterruptedException
	{	
		Settings.MinSimilarity=Double.parseDouble(Conf.getPropertyValue("sikuliMinimumSimilarity"));
		sikuli.setAutoWaitTimeout(timeOut);
		
		if(Action.equalsIgnoreCase("open"))
		{	if(UiLocator!="")
				App.open(UiLocator);
			else
				App.open(ActionParameter);
		}
		else if(Action.equalsIgnoreCase("focus"))
		{
				if(UiLocator!=""&&ActionParameter!="")
					App.focus(UiLocator, Integer.parseInt(ActionParameter));
				else if (UiLocator!="")
					App.focus(UiLocator);
				else
					App.focus(ActionParameter);
				
		}
		else if(Action.equalsIgnoreCase("close"))
		{
			if(UiLocator!="")
				App.close(UiLocator);
			else
				App.close(ActionParameter);
			
		}
	
		
		else if(Action.equalsIgnoreCase("waitForVisible"))
		{
			
			sikuli.wait(UiLocator);
		}
		else if(Action.equalsIgnoreCase("wait"))
		{
			Thread.sleep(Long.parseLong(ActionParameter));
		}
		
		else
		{
		
		
		
		Object[] args;
		SikuliClass = Class.forName("org.sikuli.script.Region");
		
		
		Class[] param;
		if(UiLocator!=""&&ActionParameter!="") //storing parameters
		{		
				param=new Class[]{Object.class,String.class};
				args = new Object[]{new String(UiLocator),new String(ActionParameter)};
		}
		else if(UiLocator!=""||ActionParameter!="")
		{	param=new Class[]{Object.class};
			if(UiLocator!="")
			{	
			args = new Object[]{new String(UiLocator)};
			}
			else
			{	
				param=new Class[]{String.class};
				args = new Object[]{new String(ActionParameter)};
			}
		}
		else
		{
			param=null;
			args = null;
		}
		
		Method sikuliMethod=SikuliClass.getMethod(Action,  param);
		sikuliMethod.invoke(sikuli, args);
		
		}
			
		
		
		}

}
