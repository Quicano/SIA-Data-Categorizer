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

    public static boolean isEinzelaufsatz(File tempFile, XPathUnit xPathUnit) throws Exception {
        int indicators = 0;
        if (ConditionUnit.hasMorePages(tempFile, xPathUnit)){
            indicators++;
        }if(ConditionUnit.hasKeyword(tempFile, xPathUnit, "author") > 0) {
            indicators++;
        }if (ConditionUnit.hasKeyword(tempFile, xPathUnit, "reference")> 0){
            indicators++;
        }if (ConditionUnit.hasKeyword(tempFile, xPathUnit, "introduction")> 0){
            indicators++;
        }if (ConditionUnit.hasKeyword(tempFile, xPathUnit, "abstract") > 0){
            indicators++;
        }if (ConditionUnit.hasKeyword(tempFile, xPathUnit, "conclusion") > 0){
            indicators++;
        }
        if(indicators < 1){
            return false;
        }else{
            return true;
        }
    }

    public static boolean isAufsatzsammlung(File tempFile, XPathUnit xPathUnit) throws Exception {
        int indicators = 0;
        if (ConditionUnit.hasManyPages(tempFile, xPathUnit)){
            indicators++;
        }if(ConditionUnit.hasKeyword(tempFile, xPathUnit, "author") >= 2) {
            indicators++;
        }if (ConditionUnit.hasKeyword(tempFile, xPathUnit, "reference") >= 2){
            indicators++;
        }if (ConditionUnit.hasKeyword(tempFile, xPathUnit, "introduction")>= 2){
            indicators++;
        }if (ConditionUnit.hasKeyword(tempFile, xPathUnit, "abstract") >= 2){
            indicators++;
        }if (ConditionUnit.hasKeyword(tempFile, xPathUnit, "conclusion") >= 2){
            indicators++;
        }
        if(indicators < 4){
            return false;
        }else{
            return true;
        }
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
