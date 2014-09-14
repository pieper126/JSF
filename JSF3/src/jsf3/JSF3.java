package jsf3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class JSF3 {

    public static void main(String[] args) {
        Properties properties = new Properties();
        
        // Get all environment variables from the system.
        Map<String, String> environment = System.getenv();
        
        // Loop through all of them
        for(String variableName : environment.keySet()){
            // Write it to the console.
            System.out.printf("%s=%s%n", variableName, environment.get(variableName));
            
            // Store it in the properties.
            properties.setProperty(variableName, environment.get(variableName));
        }
        
        // Save the properties file
        FileOutputStream fos;
        
        try{
            File file = new File("prop.properties");
            if(!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            
            properties.store(fos, "");
        }catch(FileNotFoundException ex){
            // This exception can only occur if the file was deleted between it
            // being created and the file output stream being created.
            System.err.println("ERROR: unable to find properties file.");
            return;
        }catch(IOException ex){
            System.err.println("ERROR: an IO exception occurd; " + ex.getMessage());
            return;
        }
    }
}
