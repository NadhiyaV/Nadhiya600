package genericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consistes of generic methods of property file
 */
public class PropertyFileUtility {

	public String toReadDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream(IconstantUtility.propertyfilepath);
		Properties prop= new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		
		return value;
		// TODO Auto-generated method stub

	}

}
