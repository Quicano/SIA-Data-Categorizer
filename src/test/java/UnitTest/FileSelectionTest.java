package UnitTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.PDFToXML;
import util.WSLPath;
import java.io.File;

public class FileSelectionTest {
    private PDFToXML pdfToXML;

    @Before
    public void setup(){
        pdfToXML = new PDFToXML();
    }

    @Test
    public void pdfToXmlTest() throws Exception {
        File f = new File("src/test/resources/furuya.pdf");
        pdfToXML.convertToXml(f);
    }

    @Test
    public void pathConversion() {
        String windowsFilePath = "C:\\src\\test\\resources\\furuya.pdf";
        String unixPath = WSLPath.convertWindowsPath(windowsFilePath);
        Assert.assertTrue(unixPath.equals("/mnt/c/src/test/resources/furuya.pdf"));
    }
}
