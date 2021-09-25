package UnitTest;

import org.junit.Assert;
import org.junit.Test;
import util.ConditionUnit;

import java.io.File;

public class IdentifierTest {

    @Test
    public void testSinglePageAttribute() throws Exception {
        File example1 = new File("src/test/resources/SinglePageExample1.tmp");
        File example2 = new File("src/test/resources/AufsatzsammlungExample.tmp");
        boolean bool1 = ConditionUnit.hasSinglePage(example1);
        boolean bool2 = ConditionUnit.hasSinglePage(example2);
        Assert.assertTrue(bool1);
        Assert.assertFalse(bool2);
    }
}
