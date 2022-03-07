package util;

import java.io.*;
import java.util.Properties;

public class PropertiesHandler {

    public static void addValue(String keyword, String value) throws IOException {
        Properties properties = new Properties();
        if(value != null){
            properties.setProperty(keyword, value);
        }
        String path = new File("../config.properties").getCanonicalPath();
        File config = new File(path);
        FileOutputStream fileOut = new FileOutputStream(config, true);
        properties.store(fileOut, "Config");
    }

    public static String getValue(String keyword) {
        String s = null;
        try (InputStream input = new FileInputStream("../config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            s = properties.getProperty(keyword);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return s;
    }
}
