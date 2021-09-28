package UnitTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ConditionUnit;
import util.XPathUnit;

import java.io.File;

public class IdentifierTest {
    private XPathUnit xPathUnit;

    @Before
    public void setup(){
        xPathUnit = new XPathUnit();
    }

    @Test
    public void testSinglePageAttribute() throws Exception {
        File example1 = new File("src/test/resources/SinglePageExample1.tmp");
        File example2 = new File("src/test/resources/AufsatzsammlungExample.tmp");
        boolean bool1 = ConditionUnit.hasSinglePage(example1, xPathUnit);
        boolean bool2 = ConditionUnit.hasSinglePage(example2, xPathUnit);
        Assert.assertTrue(bool1);
        Assert.assertFalse(bool2);
    }
}
