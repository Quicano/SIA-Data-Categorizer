import classifier.Classifier;
import classifier.Category;
import util.CSVCreator;
import util.GUI;
import util.PDFToXML;
import util.PropertiesHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void startCategorization() throws Exception {
        String filepath = PropertiesHandler.getValue("filepath");
        List<File> xmlFiles = PDFToXML.returnXMLFiles(filepath);
        List<String[]> csvData = CSVCreator.initializeCsvList();

        if(PropertiesHandler.getValue("keywords").isEmpty()){
            for (File f : xmlFiles){
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

    public static void run(GUI gui) throws IOException {
        gui.chooseFile();
        gui.addKeywordList();
    }

    public static void main(String[] args) throws Exception {
        GUI gui = new GUI();
        run(gui);
    }
}
