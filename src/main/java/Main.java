import classifier.Classifier;
import classifier.Category;
import util.CSVCreator;
import util.GUI;
import util.PDFToXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void run(Properties properties) throws Exception {
        String filepath = properties.getProperty("filepath");
        List<File> xmlFiles = PDFToXML.returnXMLFiles(filepath);
        List<String[]> csvData = CSVCreator.initializeCsvList();

        if(properties.getProperty("keywords").isEmpty()){
            for (File f : xmlFiles){
                Category category = Classifier.asignToCategory(f);
                CSVCreator.appendDataSet(csvData, f.getName(), category, "keywords");
            }
        }else{
            ArrayList<String> keywords = new ArrayList<>();
            String s = properties.getProperty("keywords");
            keywords.add(s);
            for (File f : xmlFiles){
                Category category = Classifier.asignToCategory(f, keywords);
                CSVCreator.appendDataSet(csvData, f.getName(), category, "keywords");
            }
        }
        CSVCreator.writeFile(csvData);
    }

    public static Properties setup(GUI gui) throws IOException {
        String filepath = gui.chooseFile();
        Properties properties = new Properties();
        properties.setProperty("filepath", filepath);
        File config = new File("src/main/resources/config.properties");
        FileOutputStream fileOut = new FileOutputStream(config, true);
        properties.store(fileOut, "Config");

        gui.addKeywordList();
        return properties;
    }

    public static void main(String[] args) throws Exception {
        Properties properties = setup(new GUI());
        run(properties);
    }
}
