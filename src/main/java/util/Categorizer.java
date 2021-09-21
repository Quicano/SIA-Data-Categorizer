package util;

import java.io.File;

public class Categorizer {


    public static Category asignToCategory(File tempFile){
        if(AttributeIdentifier.lookForSinglePage(tempFile)){
            return Category.Unbrauchbar;
        }
        return Category.Einzelaufsatz;
    }

}
