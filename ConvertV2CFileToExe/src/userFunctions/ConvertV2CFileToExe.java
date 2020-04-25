package userFunctions;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;

public class ConvertV2CFileToExe {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("C:\\Z_MyWork\\file.txt")); 
		String arr2 = br.readLine(); 
		byte[] base64File = Base64.getDecoder().decode(arr2);
		ByteArrayOutputStream output = new ByteArrayOutputStream(); 
		try {
			InputStream bais = new ByteArrayInputStream(base64File);
			GZIPInputStream gs = new GZIPInputStream(bais); 
			
			int numBytesRead = 0; 
			byte[] tempBytes = new byte[6000]; 
			try { 
				while ((numBytesRead = gs.read(tempBytes, 0, tempBytes.length)) != -1) { 
					output.write(tempBytes, 0, numBytesRead); 
				} 
			} catch (ZipException e) { 
				e.printStackTrace(); 
			} 
		} catch (Exception e) {
			e.printStackTrace(); 
		} 
		FileOutputStream fos = new FileOutputStream("C:\\Z_MyWork\\file.exe"); 
		fos.write(output.toByteArray()); 
		fos.close();

	}

}
