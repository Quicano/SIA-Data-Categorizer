package util;

import org.w3c.dom.NodeList;

import java.io.File;

public class ConditionUnit {

    public static boolean lookForEinzelaufsatz(File tempFile){
        return false;
    }

    public static boolean lookForAufsatzsammlung(File tempFile){
        return false;
    }

    public static boolean hasSinglePage(File tempFile) throws Exception {
        XPathUnit xPathUnit = new XPathUnit();
        NodeList nodeList = xPathUnit.examine(tempFile, "//page");
        if(nodeList.getLength() <= 1){
            return true;
        }else{
            return false;
        }
    }

    public static boolean lookForImage(File tempFile){
        return false;
    }

    public static boolean lookForList(File tempFile){
        return false;
    }


}
