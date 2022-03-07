package util;

import classifier.Category;
import classifier.Classifier;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void startCategorization() throws Exception {
        String filepath = PropertiesHandler.getValue("filepath");
        System.out.println(filepath);
        List<File> xmlFiles = PDFToXML.returnXMLFiles(filepath);
        List<String[]> csvData = CSVCreator.initializeCsvList();

        if(PropertiesHandler.getValue("keywords") == null){
            System.out.println("get line");
            for (File f : xmlFiles){
                System.out.println(f);
                Category category = Classifier.asignToCategory(f);
                CSVCreator.appendDataSet(csvData, f.getName(), category, "keywords");
            }
        }else{
            ArrayList<String> keywords = new ArrayList<>();
            String s = PropertiesHandler.getValue("keywords");
            keywords.add(s);
            for (File f : xmlFiles){
                Category category = Classifier.asignToCategory(f, keywords);
                CSVCreator.appendDataSet(csvData, f.getName(), category, "keywords");
            }
        }
        CSVCreator.writeFile(csvData);
    }

}
