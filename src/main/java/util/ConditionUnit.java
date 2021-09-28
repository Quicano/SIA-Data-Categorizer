package util;

import org.w3c.dom.NodeList;

import java.io.File;

public class ConditionUnit {

    public static boolean hasSinglePage(File tempFile, XPathUnit xPathUnit) throws Exception {
        NodeList nodeList = xPathUnit.examine(tempFile, "//page");
        if(nodeList.getLength() <= 1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isImage(File tempFile, XPathUnit xPathUnit) throws Exception {
        NodeList nodeList = xPathUnit.examine(tempFile, "//text");
        if(nodeList.getLength() == 0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean lookForList(File tempFile, XPathUnit xPathUnit){
        return false;
    }

    public static boolean hasAuthor(File tempfile, XPathUnit xPathUnit) throws Exception {
        xPathUnit.examine(tempfile, "//text");
        return true;
    }

}
