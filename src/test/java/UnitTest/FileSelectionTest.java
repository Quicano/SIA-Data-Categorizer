package UnitTest;

import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.PDFToXML;

import java.io.File;
import java.io.IOException;

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
        pdfToXML.convertToXml(f, "src/test/resources/");
    }

    @Test
    public void pathConversion() throws IOException {
        String windowsFilePath = "C:\\src\\test\\resources\\furuya.pdf";
        String unixPath = FilenameUtils.separatorsToUnix(windowsFilePath);
        Assert.assertTrue(unixPath.equals("C:/src/test/resources/furuya.pdf"));
    }
}
