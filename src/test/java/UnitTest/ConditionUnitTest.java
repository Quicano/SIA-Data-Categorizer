package UnitTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ConditionUnit;
import util.XPathUnit;

import java.io.File;

public class ConditionUnitTest {
    XPathUnit xPathUnit;

    @Before
    public void setup(){
        xPathUnit = new XPathUnit();
    }

    @Test
    public void testHasMorePages() throws Exception {
        File testFile1 = new File("src/test/resources/EinzelaufsatzExample1.tmp");
        boolean bool1 = ConditionUnit.hasMorePages(testFile1, xPathUnit);
        Assert.assertTrue(bool1);
    }

    @Test
    public void testHasAuthor() throws Exception {
        File testFile1 = new File("src/test/resources/EinzelaufsatzExample1.tmp");
        int i = ConditionUnit.hasKeyword(testFile1, xPathUnit, "author");
        Assert.assertFalse(i > 1);
    }

    @Test
    public void testHasReferences() throws Exception {
        File testFile1 = new File("src/test/resources/EinzelaufsatzExample2.tmp");
        int i = ConditionUnit.hasKeyword(testFile1, xPathUnit, "reference");
        Assert.assertTrue(i > 1);
    }

}
