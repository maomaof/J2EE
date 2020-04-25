package selenium.utilities;

import java.io.*;
import java.util.zip.*;

public class Zip {
	static final int BUFFER = 2048;
	static String files[];

	public static String createZip(String imageFiles, String ipAddr, String browser, long secondCounter) {
		String fileName = "";
		try {

			if (imageFiles != "") // if image files is not null
				files = imageFiles.split(",");

			BufferedInputStream origin = null;
			fileName = "Logs/images" + "_" + ipAddr + "_" + browser + "_" + secondCounter + ".zip";
			File zip = new File(fileName);
			if (zip.exists())
				zip.delete();

			FileOutputStream dest = new FileOutputStream(fileName);

			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

			// out.setMethod(ZipOutputStream.DEFLATED);
			byte data[] = new byte[BUFFER];
			// get a list of files from current directory
			ZipEntry entry = new ZipEntry("Images\\");
			out.putNextEntry(entry);
			if (files != null)
				for (int i = 0; i < (files.length); i++) {
					System.out.println("Adding: " + files[i]);
					FileInputStream fi = new FileInputStream("Logs/Images/" + files[i]);

					origin = new BufferedInputStream(fi, BUFFER);
					entry = new ZipEntry("Images\\" + files[i]);
					out.putNextEntry(entry);
					int count;
					while ((count = origin.read(data, 0, BUFFER)) != -1) {
						out.write(data, 0, count);
					}
					origin.close();
				}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		delete(); // to delete images
		return fileName;
	}

	public static void delete() // to delete images
	{
		if (files != null)
			for (int i = 0; i < (files.length); i++) {
				File f = new File("Logs/Images/" + files[i]);
				f.delete();
			}

	}

}