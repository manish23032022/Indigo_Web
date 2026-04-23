package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * FileUtility - Used to read data from properties file
 * @author Manish
 */
public class FileUtility {

    /**
     * Reads value from properties file based on key
     * @param key
     * @return value
     * @throws IOException
     */
    public String getDataFromPropertiesFile(String key) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/welcome/Documents/Indigo_Web/src/test/resources/properties/testdata.properties") ;
            Properties pObj = new Properties();
            pObj.load(fis);
            return pObj.getProperty(key);
        
    }
}
