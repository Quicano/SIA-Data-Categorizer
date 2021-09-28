package classifier;

import util.ConditionUnit;
import util.XPathUnit;

import java.io.File;

public class Classifier {

    public static Category asignToCategory(File tempFile) throws Exception {
        XPathUnit xPathUnit = new XPathUnit();
        if(isUnbrauchbar(tempFile, xPathUnit)){
            return Category.Unbrauchbar;
        }else if(isAufsatzsammlung(tempFile, xPathUnit)){
            return Category.Aufsatzsammlung;
        }else if(isEinzelaufsatz(tempFile, xPathUnit)){
            return Category.Einzelaufsatz;
        }
        return Category.Unbrauchbar;
    }

    public static boolean isEinzelaufsatz(File tempfile, XPathUnit xPathUnit){
        if(ConditionUnit.hasAuthor(tempfile, xPathUnit)){

        }
        return true;
    }

    public static boolean isAufsatzsammlung(File tempFile, XPathUnit xPathUnit){
        return true;
    }

    public static boolean isUnbrauchbar(File tempFile, XPathUnit xPathUnit) throws Exception {
        if(ConditionUnit.hasSinglePage(tempFile, xPathUnit)){
            return true;
        }else if(ConditionUnit.isImage(tempFile, xPathUnit)) {
            return true;
        }else if(ConditionUnit.lookForList(tempFile, xPathUnit)){
            return true;
        }else{
            return false;
        }
    }

}
