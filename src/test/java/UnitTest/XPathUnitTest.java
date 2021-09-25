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
        NodeList nodeList = xPathUnit.examine("/Tutorials/Tutorial");
        System.out.println(nodeList.getLength());
        System.out.println(nodeList.item(1));
    }

    @Test
    public void testStandardFile() throws Exception {
        xPathUnit.setXmlFile(new File("src/test/resources/EinzelaufsatzExample1.tmp"));
        NodeList nodeList = xPathUnit.examine("//page");
        System.out.println(nodeList.getLength());
    }
}
