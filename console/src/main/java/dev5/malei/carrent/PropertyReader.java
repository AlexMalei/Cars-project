package dev5.malei.carrent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;
    private String filename;


    public PropertyReader() {
        this.filename = "console\\src\\main\\resources\\console.properties";
    }

    public String getProperty(String propName){
        String propertyValue = null;
        if (properties == null){
            properties = new Properties();
            try (FileInputStream fileInputStream = new FileInputStream(filename)){
                properties.load(fileInputStream);
                propertyValue = properties.getProperty(propName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return propertyValue;
    }



}
