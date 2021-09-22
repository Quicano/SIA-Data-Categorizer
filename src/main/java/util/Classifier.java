package util;

import java.io.File;

public class Classifier {


    public static Category asignToCategory(File tempFile){
        if(Identifier.lookForSinglePage(tempFile)){
            return Category.Unbrauchbar;
        }
        return Category.Einzelaufsatz;
    }

}
