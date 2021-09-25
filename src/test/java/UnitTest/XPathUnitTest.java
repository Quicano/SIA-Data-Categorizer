package UnitTest;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.NodeList;
import util.XPathUnit;

import java.io.File;

public class XPathUnitTest {
    File xmlFile;
    XPathUnit xPathUnit;

    @Before
    public void setup(){
        xmlFile = new File("src/test/resources/XPathTestFile.xml");
        xPathUnit = new XPathUnit(xmlFile);
    }

    @Test
    public void testExamine() throws Exception {
        NodeList nodeList = xPathUnit.examine();
        System.out.println(nodeList.getLength());
    }
}
