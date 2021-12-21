import classifier.Classifier;
import classifier.Category;
import util.CSVCreator;
import util.GUI;
import util.PDFToXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void run() throws Exception {
        Properties properties = new Properties();
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

    public static void setup(GUI gui){
       // gui.chooseFile();
        gui.addKeywordList();
    }


    public static void main(String[] args) throws Exception {
        setup(new GUI());
    }

}
