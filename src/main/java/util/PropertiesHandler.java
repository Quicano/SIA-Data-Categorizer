package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

    public static void addValue(String keyword, String value) throws IOException {

        Properties properties = new Properties();
        properties.setProperty(keyword, value);
        File config = new File("src/main/resources/config.properties");
        FileOutputStream fileOut = new FileOutputStream(config, true);
        properties.store(fileOut, "Config");
    }
}
