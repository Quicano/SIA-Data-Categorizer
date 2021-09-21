import util.Classifier;
import util.Category;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<File> readXMLFiles(){
        File DataDir = new File("Data");
        ArrayList<File> xmlList = new ArrayList<>(Arrays.asList(DataDir.listFiles()));
        for (File f : xmlList) {
            if (!f.getName().endsWith(".tmp") || !f.getName().endsWith(".xml")) {
                xmlList.remove(f);
            }
        }
        return xmlList;
    }

    public static void main(String[] args) {
        List<File> fileNames = readXMLFiles();
        for (File f : fileNames){
            Category category = Classifier.asignToCategory(f);
            System.out.println("Die Datei " + f.getName() + " ist von der Kategorie: " + category);
        }

    }
}
