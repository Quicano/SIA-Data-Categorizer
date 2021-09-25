package classifier;

import util.ConditionUnit;

import java.io.File;

public class Classifier {


    public static Category asignToCategory(File tempFile) throws Exception {
        if(ConditionUnit.hasSinglePage(tempFile)){
            return Category.Unbrauchbar;
        }
        return Category.Einzelaufsatz;
    }

}
