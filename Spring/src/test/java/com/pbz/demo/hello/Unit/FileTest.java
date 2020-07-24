package com.pbz.demo.hello.Unit;

import java.io.File;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
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
	private FileController fileOperator = null;

	@BeforeClass
	public static void setup() throws Exception {

	}

	@AfterClass
	public static void teardown() throws Exception {

	}

	@Test
	public void TEST_saveJson2File() throws Exception {

		String fileName = "xiyu.json";
		File jsonFile = new File(System.getProperty("user.dir") + "/" + fileName);
		jsonFile.delete();

		String JsonString = "{\"a\": NULL}";
		String respJson = fileOperator.saveJson2File(fileName, JsonString);

		Assert.assertEquals(JsonString, respJson);
		if (!jsonFile.exists()) {
			Assert.fail("Generate file failed.");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void TEST_downLoadFileToServer() throws Exception {

		String fileName = "5.mp3";
		File audioFile = new File(System.getProperty("user.dir") + "/" + fileName);
		audioFile.delete();

		String url = "https://littleflute.github.io/english/NewConceptEnglish/Book2/" + fileName;
		System.out.println("Begin test downLoadFileToServer");
		Map<String, Object> respObject = (Map<String, Object>) fileOperator.downLoadFileToServer(url);

		System.out.println(respObject.toString());
		Assert.assertEquals(200, respObject.get("code"));
		if (!audioFile.exists()) {
			Assert.fail("The audio file doesn't exist!");
		}
		System.out.println("End of test downLoadFileToServer");
	}
}
