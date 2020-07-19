package com.pbz.demo.hello.Unit;

import java.io.File;
import java.util.Map;

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
	private FileController fileOpreation = null;

	@Test
	public void TEST_saveJson2File() throws Exception {

		String fileName = "xiyu.json";
		String filePath = System.getProperty("user.dir") + "/" + fileName;
		File file = new File(filePath);
		file.delete();

		String JsonString = "{\"a\": NULL}";
		String respJson = fileOpreation.saveJson2File(fileName, JsonString);

		Assert.assertEquals(JsonString, respJson);
		if (!file.exists()) {
			Assert.fail("generate file not exist");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void TEST_downLoadFileToServer() throws Exception {

		String fileName = "5.mp3";
		String filePath = System.getProperty("user.dir") + "/" + fileName;
		File file = new File(filePath);
		file.delete();

		String url = "https://littleflute.github.io/english/NewConceptEnglish/Book2/" + fileName;
		Map<String, Object> respObject = (Map<String, Object>) fileOpreation.downLoadFileToServer(url);

		System.out.println(respObject.toString());
		Assert.assertEquals(200, respObject.get("code"));
		if (!file.exists()) {
			Assert.fail("generate file not exist");
		}
	}
}
