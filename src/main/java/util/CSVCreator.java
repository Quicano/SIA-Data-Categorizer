package util;

import classifier.Category;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVCreator {

    public static List<String[]> initializeCsvList(){
        String[] header = {"PDF-Name", "Kategorie", "Schlüsselworte"};
        List<String[]> csvlist = new ArrayList<>();
        csvlist.add(header);
        return csvlist;
    }

    public static List<String[]> appendDataSet(List<String[]> csvList, String pdfname, Category category, String keywords) {
        String[] record = {pdfname, category.name(), keywords};
        csvList.add(record);
        return csvList;
    }

    public static void writeFile(List<String[]> csvResult) throws IOException {
        File csv = new File("result.csv");
        csv.createNewFile();
        try (CSVWriter writer = new CSVWriter(new FileWriter("result.csv"))) {
            writer.writeAll(csvResult);
            System.out.println(csvResult);
        }
    }
}
