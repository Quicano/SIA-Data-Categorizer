package UnitTest;

import org.junit.Test;
import util.PDFToXML;

import java.io.File;

public class DirectoryPathTest {

    @Test
    public void convertExternalFile() throws Exception {
        PDFToXML pdfToXML = new PDFToXML();
        File f = new File("C:/Users/Programmierarbeit/OneDrive/Desktop/Testdaten/Andere/-for-working-papers-in-scandinavian-syntax-pdf.pdf");
        pdfToXML.convertToXml(f, "C:/Users/Programmierarbeit/OneDrive/Desktop/Testdaten/Andere/");
    }
}
