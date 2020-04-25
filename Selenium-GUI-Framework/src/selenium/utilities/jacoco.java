package selenium.utilities;

public class jacoco {
	
	public  jacoco(){  
        try{  
                System.out.println("running jacoco..............");  
                Runtime.getRuntime().exec("C://codeCoverage//jacoco.bat").waitFor();  
                System.out.println("Reports created successfully!");  
        }catch(Exception e) {  
            System.out.println("Error creating the FileInfo panel: " +e);  
            e.printStackTrace();  
        }  
    }  

}
