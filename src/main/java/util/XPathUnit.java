package util;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.FileInputStream;

public class XPathUnit {

    public NodeList examine(File xmlFile, String expression) throws Exception {
        FileInputStream fileIS = new FileInputStream(xmlFile);
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = null;
        try{
            xmlDocument = builder.parse(fileIS);
        }catch (Exception e){
            System.out.println(e);
        }
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
        return nodeList;
    }

    public int containsWord(File xmlFile, String word) throws Exception {
        int numberOfFinds = 0;

        NodeList textNodes = this.examine(xmlFile, "//text");
        for(int i = 0; i < textNodes.getLength(); i ++){
            String content = textNodes.item(i).getTextContent();
            if(content.toLowerCase().contains(word) || content.contains(word)){
                numberOfFinds++;
            }
        }
        return numberOfFinds;
    }

}
