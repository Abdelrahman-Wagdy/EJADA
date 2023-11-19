package utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileHandler {
    private String filePath;

    public PropertyFileHandler(String filePath) {
        this.filePath = filePath;
        loadPropertiesFile();
    }

    public void loadPropertiesFile()
    {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
