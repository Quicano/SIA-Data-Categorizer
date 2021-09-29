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
        boolean bool1 = ConditionUnit.hasAuthor(testFile1, xPathUnit);
        Assert.assertFalse(bool1);
    }

    @Test
    public void testHasReferences() throws Exception {
        File testFile1 = new File("src/test/resources/EinzelaufsatzExample2.tmp");
        boolean bool1 = ConditionUnit.hasReferences(testFile1, xPathUnit);
        Assert.assertTrue(bool1);
    }

}
