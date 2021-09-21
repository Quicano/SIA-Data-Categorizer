package UnitTest;

import org.junit.Assert;
import org.junit.Test;
import util.Category;
import util.Classifier;

import java.io.File;

public class ClassifierTest {

    @Test
    public void testEinzelaufsaetze(){
        File example = new File("src/test/resources/EinzelaufsatzExample1.tmp");
        Category category = Classifier.asignToCategory(example);
        Assert.assertEquals(Category.Einzelaufsatz, category);
    }

    @Test
    public void testAufsatzsammlung(){
        File example = new File("src/test/resources/AufsatzsammlungExample.tmp");
        Category category = Classifier.asignToCategory(example);
        Assert.assertEquals(Category.Aufsatzsammlung, category);
    }

    @Test
    public void testUnbrauchbarSinglePage(){
        File example1 = new File("src/test/resources/SinglePageExample1.tmp");
        File example2 = new File("src/test/resources/SinglePageExample2.tmp");
        Category category1 = Classifier.asignToCategory(example1);
        Category category2 = Classifier.asignToCategory(example2);
        Assert.assertEquals(Category.Unbrauchbar , category1);
        Assert.assertEquals(Category.Unbrauchbar , category2);
    }

    @Test
    public void testUnbrauchbarImage(){
        File example1 = new File("src/test/resources/ImageExample1.tmp");
        File example2 = new File("src/test/resources/ImageExample2.tmp");
        Category category1 = Classifier.asignToCategory(example1);
        Category category2 = Classifier.asignToCategory(example2);
        Assert.assertEquals(Category.Unbrauchbar , category1);
        Assert.assertEquals(Category.Unbrauchbar , category2);
    }

    @Test
    public void testUnbrauchbarList(){
        File example = new File("src/test/resources/ListExample.tmp");
        Category category = Classifier.asignToCategory(example);
        Assert.assertEquals(Category.Unbrauchbar , category);
    }
}
