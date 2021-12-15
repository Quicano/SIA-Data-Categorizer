import classifier.Classifier;
import classifier.Category;
import util.CSVCreator;
import util.PDFToXML;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static ArrayList<File> convertPDFFiles() throws Exception {
        File DataDir = new File("InputData");
        ArrayList<File> fileList = new ArrayList<>(Arrays.asList(DataDir.listFiles()));
        ArrayList<File> outputList = new ArrayList<>();

        PDFToXML converter = new PDFToXML();
        for (File f : fileList){
            if(f.getName().endsWith(".tmp") || f.getName().endsWith(".xml")){
                outputList.add(f);
            }
            if(f.getName().endsWith(".pdf")){
                String xmlPath = converter.convertToXml("InputData/"+f.getName());
                outputList.add(new File(xmlPath));
            }
        }
        return outputList;
    }

    public static void main(String[] args) throws Exception {
        List<File> fileNames = convertPDFFiles();

        List<String[]> csvData = CSVCreator.initializeCsvList();

        for (File f : fileNames){
            Category category = Classifier.asignToCategory(f);
            CSVCreator.appendDataSet(csvData, f.getName(), category, "keywords");
        }

        CSVCreator.writeFile(csvData);
    }
}
