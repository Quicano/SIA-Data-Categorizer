import org.junit.Test;
import util.PDFToXML;

import java.io.File;

public class InputTest {

    @Test
    public void inputDirTest() throws Exception {
        PDFToXML pdfToXML = new PDFToXML();
        File f = new File("C:/Users/Programmierarbeit/OneDrive/Desktop/Testdaten/Einzelpublikation/furuya.pdf");
        pdfToXML.convertToXml(f, "C:/Users/Programmierarbeit/OneDrive/Desktop/Testdaten/Einzelpublikation");
    }
}
