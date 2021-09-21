package util;

import java.io.File;

public class Categorizer {


    public static Category asignToCategory(File tempFile){
        if(XMLCrawler.lookForSinglePage(tempFile)){
            return Category.Unbrauchbar;
        }
        return Category.Einzelaufsatz;
    }

}
