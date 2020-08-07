package com.pbz.demo.hello.Unit;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pbz.demo.hello.controller.ImageController;
import com.pbz.demo.hello.util.ExecuteCommand;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class VideoTest {
	
	@Autowired
	private ImageController VideoOperator = null;
	
	private static String FILENAME_SRT = "test.srt";
	private static String FILENAME_MP3 = "test.mp3";
	private static String FILENAME_MP4 = "vFinal.mp4";
	private static String FILENAME_JSON = "scenario.json";
	private static String resourcePath;
	private static final boolean isWindows = System.getProperty("os.name").startsWith("Windows");
	
	
	@BeforeClass
	public static void setup() throws Exception {
		
		File resourcesDirectory = new File("src/test/resources");
		resourcePath = resourcesDirectory.getAbsolutePath();
		
		File srtFile = new File(System.getProperty("user.dir") + "/" + FILENAME_SRT);
		srtFile.delete();
		File mp3File = new File(System.getProperty("user.dir") + "/" + FILENAME_MP3);
		mp3File.delete();		
		File mp4File = new File(System.getProperty("user.dir") + "/" + FILENAME_MP4);
		mp4File.delete();
	}
	 
	@AfterClass
	public static void clearENV() throws Exception {
		
		File srtFile = new File(System.getProperty("user.dir") + "/" + FILENAME_SRT);
		srtFile.delete();
		File mp3File = new File(System.getProperty("user.dir") + "/" + FILENAME_MP3);
		mp3File.delete();	
		File mp4File = new File(System.getProperty("user.dir") + "/" + FILENAME_MP4);
		mp4File.delete();
	}
	
	@Test
	public void TEST_combineSubtiteAndAudio2MP4() throws Exception {
				
		File srtFile = new File(resourcePath + "\\" + FILENAME_SRT);
		if (!srtFile.exists()) {
			System.out.println(FILENAME_SRT + " not found");
			Assert.fail("Cannot found srt file:" + FILENAME_SRT);
		}
		File mp3File = new File(resourcePath + "\\" + FILENAME_MP3);
		if (!srtFile.exists()) {
			System.out.println(FILENAME_MP3 + " not found");
			Assert.fail("Cannot found mp3 file:" + FILENAME_MP3);
		}
		
		String srtFilePath =srtFile.getPath();
		String mp3FilePath =mp3File.getPath();
		String targetPath = System.getProperty("user.dir") + "\\";
		
		String suffix = isWindows ? ".bat" : ".sh";
		String cmd = resourcePath + "\\" + "copy" + suffix;
		String[] args = {srtFilePath, targetPath};
		if (!ExecuteCommand.executeCommand(cmd, args)) {
			Assert.fail("Copy srt file failed");
		}
		args[0] = mp3FilePath;
		if (!ExecuteCommand.executeCommand(cmd, args)) {
			Assert.fail("Copy mp3 file failed");
		}
		
		/*Runtime rt = Runtime.getRuntime();
        Process p_srtCopy = rt.exec("cmd.exe /c copy /Y " + srtFilePath + " " + targetPath);
        System.out.println(p_srtCopy.toString());
        if (p_srtCopy != null) {
        	p_srtCopy.destroy();
        	p_srtCopy=null;
        }
        Process p_mp3Copy = rt.exec("cmd.exe /c copy /Y " + mp3FilePath + " " + targetPath);
        System.out.println(p_mp3Copy.toString());
        if (p_mp3Copy != null) {
        	p_mp3Copy.destroy();
        	p_mp3Copy=null;
        }*/
		//above need enforce, need add copy result check and wait time
				
		VideoOperator.combineSubtiteAndAudio2MP4(srtFile.getName(), mp3File.getName());
		
		File mp4File = new File(targetPath + FILENAME_MP4);
		if (!mp4File.exists()) {
			System.out.println(FILENAME_MP4 + " not found");
			Assert.fail("Generate mp4 failed.");
		}
		else
		{
			mp4File.delete();//Due to output filename hard code, clear mp4 for next cases.
		}
	}
	
	@Test
	public void TEST_generateVideoByscenario() throws Exception {
		
		File jsonFile = new File(resourcePath + "\\" + FILENAME_JSON);
		if (!jsonFile.exists()) {
			System.out.println(FILENAME_JSON + " not found");
			Assert.fail("Cannot found json file:" + FILENAME_JSON);
		}
		
		String jsonFilePath =jsonFile.getPath();
		String targetPath = System.getProperty("user.dir") + "\\";
		
		String suffix = isWindows ? ".bat" : ".sh";
		String cmd = resourcePath + "\\" + "copy" + suffix;
		String[] args = {jsonFilePath, targetPath};
		if (!ExecuteCommand.executeCommand(cmd, args)) {
			Assert.fail("Copy json file failed");
		}
		
		VideoOperator.generateVideoByscenario(FILENAME_JSON);
		
		File mp4File = new File(targetPath + FILENAME_MP4);
		if (!mp4File.exists()) {
			System.out.println(FILENAME_MP4 + " not found");
			Assert.fail("Generate mp4 failed.");
		}
		else
		{
			mp4File.delete();//Due to output filename hard code, clear mp4 for next cases.
		}
		
	}
}
