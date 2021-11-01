package UnitTest;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.XPathUnit;

import java.io.File;

public class XPathUnitTest {
    XPathUnit xPathUnit;

    @Before
    public void setup(){
        xPathUnit = new XPathUnit();
    }

    @Test
    public void testExamine() throws Exception {
        File xmlFile = new File("src/test/resources/XPathTestFile.xml");
        NodeList nodeList = xPathUnit.examine(xmlFile, "/Tests/Test");
        System.out.println(nodeList.getLength());
        System.out.println(nodeList.item(1));
    }

    @Test
    public void testStandardFile() throws Exception {
        File xmlFile = new File("src/test/resources/ListExample.tmp");
        NodeList nodeList = xPathUnit.examine(xmlFile, "//text");
        System.out.println(nodeList.getLength());
    }

    @Test
    public void testSinglePageFile() throws Exception {
        File xmlFile1 = new File("src/test/resources/SinglePageExample1.tmp");
        File xmlFile2 = new File("src/test/resources/EinzelaufsatzExample1.tmp");
        NodeList nodeList1 = xPathUnit.examine(xmlFile1, "//page");
        NodeList nodeList2 = xPathUnit.examine(xmlFile2, "//page");
        Assert.assertEquals(1 , nodeList1.getLength());
        Assert.assertEquals(15, nodeList2.getLength());
    }

    @Test
    public void testNoTextInFile() throws Exception {
        File xmlFile1 = new File("src/test/resources/ImageExample1.tmp");
        NodeList nodeList1 = xPathUnit.examine(xmlFile1, "//text");
        Assert.assertEquals(0, nodeList1.getLength());
    }

    @Test
    public void testContainsWord() throws Exception {
        File xmlFile1 = new File("src/test/resources/EinzelaufsatzExample1.tmp");
        int i = xPathUnit.containsWord(xmlFile1, "Haitao");
        int j  = xPathUnit.containsWord(xmlFile1, "haitao");
        Assert.assertTrue(i > 0);
        Assert.assertTrue(j > 0);
    }
}
