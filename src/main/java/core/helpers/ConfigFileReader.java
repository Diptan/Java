package core.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private static ConfigFileReader instance;
    private static String dpropertyFilePath = System.getProperty("user.dir") + "/src/main/resources/configuration.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(dpropertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + dpropertyFilePath);
        }
    }
    public static ConfigFileReader getInstance () {
        if (instance == null) {
            { instance = new ConfigFileReader();
            }
        }
        return instance;
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the configuration.properties file.");
    }

    public int getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Integer.parseInt(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the configuration.properties file.");
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("browser not specified in the configuration.properties file.");
    }

    public String driverPath() {
        String url = properties.getProperty("driverpath");
        if(url != null) return url;
        else throw new RuntimeException("driverpath not specified in the configuration.properties file.");
    }

}
