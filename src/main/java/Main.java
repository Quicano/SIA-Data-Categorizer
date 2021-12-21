import classifier.Classifier;
import classifier.Category;
import util.CSVCreator;
import util.PDFToXML;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<File> xmlFiles = PDFToXML.returnXMLFiles();

        List<String[]> csvData = CSVCreator.initializeCsvList();

        for (File f : xmlFiles){
            Category category = Classifier.asignToCategory(f);
            CSVCreator.appendDataSet(csvData, f.getName(), category, "keywords");
        }

        CSVCreator.writeFile(csvData);
    }
}
