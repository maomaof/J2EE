package selenium.utilities;
import com.sfnt.ems.service.generator.plugin.hasp.*;

/*
 * ÓÃÀ´decode c2vµÄ
 */
public class C2VDecoder {
	static String vendorCode="AzIceaqfA1hX5wS+M8cGnYh5ceevUnOZIzJBbXFD6dgf3tBkb9cvUF/Tkd/iKu2fsg9wAysYKw7RMAsV" + 
			"vIp4KcXle/v1RaXrLVnNBJ2H2DmrbUMOZbQUFXe698qmJsqNpLXRA367xpZ54i8kC5DTXwDhfxWTOZrB" + 
			"rh5sRKHcoVLumztIQjgWh37AzmSd1bLOfUGI0xjAL9zJWO3fRaeB0NS2KlmoKaVT5Y04zZEc06waU2r6" + 
			"AU2Dc4uipJqJmObqKM+tfNKAS0rZr5IudRiC7pUwnmtaHRe5fgSI8M7yvypvm+13Wm4Gwd4VnYiZvSxf" + 
			"8ImN3ZOG9wEzfyMIlH2+rKPUVHI+igsqla0Wd9m7ZUR9vFotj1uYV0OzG7hX0+huN2E/IdgLDjbiapj1" + 
			"e2fKHrMmGFaIvI6xzzJIQJF9GiRZ7+0jNFLKSyzX/K3JAyFrIPObfwM+y+zAgE1sWcZ1YnuBhICyRHBh" + 
			"aJDKIZL8MywrEfB2yF+R3k9wFG1oN48gSLyfrfEKuB/qgNp+BeTruWUk0AwRE9XVMUuRbjpxa4YA67SK" + 
			"unFEgFGgUfHBeHJTivvUl0u4Dki1UKAT973P+nXy2O0u239If/kRpNUVhMg8kpk7s8i6Arp7l/705/bL" + 
			"Cx4kN5hHHSXIqkiG9tHdeNV8VYo5+72hgaCx3/uVoVLmtvxbOIvo120uTJbuLVTvT8KtsOlb3DxwUrwL" + 
			"zaEMoAQAFk6Q9bNipHxfkRQER4kR7IYTMzSoW5mxh3H9O8Ge5BqVeYMEW36q9wnOYfxOLNw6yQMf8f9s" + 
			"JN4KhZty02xm707S7VEfJJ1KNq7b5pP/3RjE0IKtB2gE6vAPRvRLzEohu0m7q1aUp8wAvSiqjZy7FLaT" + 
			"tLEApXYvLvz6PEJdj4TegCZugj7c8bIOEqLXmloZ6EgVnjQ7/ttys7VFITB3mazzFiyQuKf4J6+b/a/Y";
	
	static LicGenAPIHelper licgen = new LicGenAPIHelper();
	public static int initialize()
	{
		
		
		java.util.Properties prop = new java.util.Properties();
		String licGenDLL = (System.getProperties().getProperty("os.arch").equals("x86"))?"sntl_licgen_windows.dll":"sntl_licgen_windows_x64.dll";
		prop.setProperty("hasp.licgen.win.library.name", "lib/"+licGenDLL);
		System.out.println(prop);
		licgen.init(prop);
		int status =licgen.hasp_lg_initialize(null);
		
		return status;
	}
	public static String decodeC2V(String currentState)
	{
		CharStringBuffer readableState =  new CharStringBuffer();
		int status = 0;
		int initStatus = initialize();
		if(initStatus==0)
		{
			try {
				status = licgen.hasp_lg_decode_current_state(vendorCode, currentState, readableState);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(status==0)
			return readableState.get();
		
		return null;
	}
	public static void main(String args[])
	{
		C2VDecoder c2v = new C2VDecoder();
		c2v.initialize();
		String curr = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><hasp_info><host_fingerprint type=\"SL-UserMode\" vendorid=\"37515\" crc=\"3225072873\">MnhJSYWAIBz8Th2oVgZBYuA8CUFPvGUSMANyak4BQOfFAsXNtX+VCh+5BVYtIo5ACyxxXhErWXgCYlZEsiLHxghUuwHyR5idCJKN6ZLINRABgFe0IuDAxI4QiSxvLME7kYo=</host_fingerprint></hasp_info>";
		String abc = c2v.decodeC2V(curr);
		System.out.println(abc);
	}
}
