package UnitTest;

import org.junit.Assert;
import org.junit.Test;
import util.Identifier;

import java.io.File;

public class IdentifierTest {

    @Test
    public void testSinglePageAttribute(){
        File example1 = new File("src/test/resources/SinglePageExample1.tmp");
        File example2 = new File("src/test/resources/SinglePageExample2.tmp");
        boolean bool1 = Identifier.lookForSinglePage(example1);
        boolean bool2 = Identifier.lookForSinglePage(example2);
        Assert.assertTrue(bool1);
        Assert.assertTrue(bool2);
    }
}
