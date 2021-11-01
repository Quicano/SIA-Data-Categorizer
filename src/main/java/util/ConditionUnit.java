package util;

import org.w3c.dom.NodeList;

import java.io.File;

public class ConditionUnit {


    public static boolean hasSinglePage(File tempFile, XPathUnit xPathUnit) throws Exception {
        NodeList pageNodes = xPathUnit.examine(tempFile, "//page");
        if(pageNodes.getLength() <= 1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean hasMorePages(File tempfile, XPathUnit xPathUnit) throws Exception{
        NodeList pageNodes = xPathUnit.examine(tempfile, "//page");
        if (pageNodes.getLength() >= 2 && pageNodes.getLength() <= 25){
            return true;
        }else{
            return false;
        }
    }

    public static boolean hasManyPages(File tempfile, XPathUnit xPathUnit) throws Exception{
        NodeList pageNodes = xPathUnit.examine(tempfile, "//page");
        if (pageNodes.getLength() >= 26){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isImage(File tempFile, XPathUnit xPathUnit) throws Exception {
        NodeList textNodes = xPathUnit.examine(tempFile, "//text");
        if(textNodes.getLength() == 0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean lookForList(File tempFile, XPathUnit xPathUnit){

        return false;
    }

    public static int hasKeyword(File tempfile, XPathUnit xPathUnit, String keyword) throws Exception {
        return xPathUnit.containsWord(tempfile, keyword);
    }

}
