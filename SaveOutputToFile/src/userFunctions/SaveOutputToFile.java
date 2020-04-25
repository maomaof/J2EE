package userFunctions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import TestData.Step;
import utility.MBTPaths;
import utility.Utility;

/**
 * SaveOutputToFile Function to store variable into file
 * <br>
 * Syntax: SaveOutputToFile(filename,variable)
 * <br>
 * Input: 1.Name of store file, the file will save at @inputsFileFolder\@containerName folder <br>
 * 			E.g. 'Admin_InstallFile' is the name of input graph and input file name is V2C.v2c <br>
 *                The target file will place at ...\pluginInputs\inputFiles\Admin_InstallFile\V2C.v2c <br>
 *        2.Variable name, its value will be store. <br>
 *        	E.g  out={{handle}}
 * <br>
 * Return code -1 on failure and 0 on success
 * @author Xiyu Feng
 */

public class SaveOutputToFile implements userFunctionsInterface {

	public void saveFile(String fileName, String content) throws IOException {
		
		OutputStreamWriter pw = null;
		pw = new OutputStreamWriter(new FileOutputStream(fileName), "GBK");
		pw.write(content);
		pw.close();
	}

	@Override
	public Step executeFunction(Step st) {

		st.setActualReturnCode("0");
		MBTPaths.executionLog.debug("inputParameter:" + st.getInputs());
		
		List<String> args = st.getInputs();
		String fileName = args.get(0);
		String content = args.get(1);
		String filePath = MBTPaths.inputFilesFolder + MBTPaths.containerName;
		
		content = content.substring(content.lastIndexOf("=")+1);
		content = Utility.processInput(content);
		
		File file = new File(filePath);
		if(!file.exists())
		{
		    file.mkdirs();
		}
		
		fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
		filePath = filePath + fileName;
		
		MBTPaths.executionLog.debug("Path:" + filePath);
		MBTPaths.executionLog.debug("Content:" + content);

		try {
			saveFile(filePath, content);
		} catch (IOException e) {
			e.printStackTrace();
			st.setActualReturnCode("-1");
			st.setActualResponse("\n Save file failure\n Exception:\n"+e.getMessage());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			st.setActualReturnCode("-1");
			st.setActualResponse("\n Save file function error\n Exception:\n"+e.getMessage());
		}
		
		return st;
	}

}
