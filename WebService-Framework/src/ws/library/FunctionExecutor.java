package ws.library;
import ws.driver.*;
import ws.utilities.*;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


public class FunctionExecutor {

	public String execute(String functionName)
	{
		String result = null;
		String packageName = "FunctionUtil";
		File packageHandle = new File(packageName);
		File [] fileList = packageHandle.listFiles();
		for(int i=0; i<fileList.length ;i++)
		{
			File file = fileList[i];
			try
			{
				String fileName = file.getName();
				fileName = fileName.substring(0,fileName.indexOf("."));
				Class classVar = Class.forName(packageName+"."+fileName);
				Method [] methodList = classVar.getDeclaredMethods();
				for(int j=0; j< methodList.length ; j++)
				{
					Method method = methodList[j];
					if(method.getName().equals(parseMethodName(functionName)))
					{
						Type[] parameterTypes = method.getParameterTypes();
						
						String [] parameters = parseParameters(functionName);
						Object [] createdParameters = new Object[parameterTypes.length];
						for(int k=0; k < parameterTypes.length; k++)
						{
							Type type = parameterTypes[k];
							Constructor constructor = getConstructor(type);
							Object[] args = new Object[] { parameters[k]};
							if(constructor != null)
							{
								createdParameters[k] = constructor.newInstance(args);
							}
						}
						method.invoke(classVar.newInstance(), createdParameters);
						result = "Function executed succefully.";
						break;
					}
				}
			}
			catch (Exception e)
			{
				if(e instanceof NumberFormatException || e instanceof InvocationTargetException)
				{
					result = "Please provide valid input parameters.";
				}
			}
		}
		return result;
	}
	private String [] parseParameters(String function)
	{
		String parameters = function.substring(function.indexOf("(")+1,function.indexOf(")"));
		String [] parameterValues = parameters.split(",");
		return parameterValues;
	}
	
	private String parseMethodName(String function)
	{
		String functionName = function.substring(0, function.indexOf("("));
		return functionName;
	}

	public static void main(String [] a)
	{
		FunctionExecutor functionExecutor = new FunctionExecutor();
		System.out.println(functionExecutor.execute("myFunction1(421244242424,42344)"));
	}
	
	private Constructor getConstructor(Type type)
	{
		Constructor constructor = null;
		try
		{
			if(type.toString().equals("int"))
			{
				constructor = Integer.class.getConstructor(String.class);
			} 
			if(type.toString().equals("class java.lang.String"))
			{
				constructor = String.class.getConstructor(String.class);
			}
			if(type.toString().equals("float"))
			{
				constructor = Float.class.getConstructor(String.class);
			}
			if(type.toString().equals("boolean"))
			{
				constructor = Boolean.class.getConstructor(String.class);
			}
			
		}
		catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return constructor;
}
}

