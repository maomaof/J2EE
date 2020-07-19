package com.pbz.demo.hello.Unit;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pbz.demo.hello.controller.FileController;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class FileTest {

	@Autowired
	private FileController fileOpreation =null;

	@Test
	public void TESTsaveJson2File() throws Exception {
		
		String fileName="xiyu.json";
		String filePath = System.getProperty("user.dir") + "/" + fileName;
		File file = new File(filePath);
		file.delete();
		
		String JsonString="{\"a\": NULL}";
		String respJson=fileOpreation.saveJson2File(fileName, JsonString);
		
		Assert.assertEquals(JsonString,respJson);
		if (!file.exists())
		{
			Assert.fail("generate file not exist");
		}

	}
	
	@Test
	public void TESTdownLoadFileToServer() throws Exception {
		
		String fileName="5.mp3";
		String filePath = System.getProperty("user.dir") + "/" + fileName;
		File file = new File(filePath);
		file.delete();
		
		String url= "https://littleflute.github.io/english/NewConceptEnglish/Book2/"+fileName;
		Object respObject = fileOpreation.downLoadFileToServer(url);
		
		//??如何检查返回的object???
		System.out.println(respObject.toString());
		//Assert.assertEquals(JsonString,respObject.toString(););
		if (!file.exists())
		{
			Assert.fail("generate file not exist");
		}
		
	}
}
