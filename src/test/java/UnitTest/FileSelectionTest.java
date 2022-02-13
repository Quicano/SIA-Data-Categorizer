package UnitTest;

import org.junit.Before;
import org.junit.Test;
import util.PDFToXML;

import java.io.File;

public class FileSelectionTest {
    private PDFToXML pdfToXML;

    @Before
    public void setup(){
        pdfToXML = new PDFToXML();
    }

    @Test
    public void inputDirTest() throws Exception {
        File f = new File("C:/Users/Programmierarbeit/OneDrive/Desktop/Testdaten/Einzelpublikation/furuya.pdf");
        pdfToXML.convertToXml(f, "C:/Users/Programmierarbeit/OneDrive/Desktop/Testdaten/Einzelpublikation");
    }

    @Test
    public void pdfToXmlTest() throws Exception {
        File f = new File("src/test/resources/furuya.pdf");
        System.out.println(f.getCanonicalPath());
        pdfToXML.convertToXml(f, "src/test/resources");
    }
}
