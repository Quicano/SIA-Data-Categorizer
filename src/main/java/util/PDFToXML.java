package util;

import org.apache.commons.lang3.SystemUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PDFToXML {
    private String tempDir;

    private static Logger LOG = Logger.getLogger(PDFToXML.class.getName());

    public PDFToXML(){
        tempDir = "tempDir";
        File directory = new File(tempDir);
        if(!directory.exists()){
            directory.mkdir();
        }
    }

    public String convertToXml(File pdfFile, String directory) throws Exception {
        String nameOfPaper = pdfFile.getName().replace(".pdf", "");
        Runtime executionRuntime = Runtime.getRuntime();
        String xmlFilePath = tempDir + "/" + nameOfPaper + ".xml";
        Process pdfToXmlConversion;
        if (SystemUtils.IS_OS_LINUX) { //Linux Process
            pdfToXmlConversion = executionRuntime.exec("pdftohtml -xml -i -c -q -s " + pdfFile.getCanonicalPath() + " " + xmlFilePath);
        } else {//Windows Process. Ubuntu Virtual Machine needs to be installed
            System.out.println("wsl \n pdftohtml -xml -i -c -q -s " + pdfFile.getName());
            pdfToXmlConversion = executionRuntime.exec("cd "+ directory+ " \n wsl \n pdftohtml -xml -i -c -q -s " + pdfFile.getName() );
        }
        try {
            LOG.info("Waiting for conversion to finish..");
            boolean didFinish = pdfToXmlConversion.waitFor(20, TimeUnit.SECONDS);
            if (didFinish) {
                LOG.info("Conversion done.");
            } else {
                LOG.info("Conversion not done..?");
            }
        } catch (InterruptedException e) {
            System.exit(1); // TODO: Check how to handle this properly
        }
        File xmlFile = new File(xmlFilePath);
        String tempFilePath = this.formatXmlFile(xmlFile);
        return tempFilePath;
    }

    public String formatXmlFile(File xmlFile) throws IOException {
        String tempFilePath = xmlFile.getAbsolutePath()+".tmp";
        File tempFile = new File(tempFilePath);
        BufferedReader bufRead = new BufferedReader(new FileReader(xmlFile));
        BufferedWriter bufWrite = new BufferedWriter(new FileWriter(tempFile));
        LOG.info("Removing DTD in "+xmlFile.getAbsolutePath());
        for(String line = ""; line!=null; line=bufRead.readLine()) {
            if (line.length() > 1 && !line.startsWith("<!DOCTYPE")) {
                bufWrite.write(line+"\n");
            }
        }
        bufWrite.flush();
        bufWrite.close();
        return tempFilePath;
    }

    public static ArrayList<File> returnXMLFiles(String directory) throws Exception {
        File DataDir = new File(directory);
        ArrayList<File> fileList = new ArrayList<>(Arrays.asList(DataDir.listFiles()));
        ArrayList<File> outputList = new ArrayList<>();


        PDFToXML converter = new PDFToXML();
        for (File f : fileList){
            if(f.getName().endsWith(".tmp") || f.getName().endsWith(".xml")){
                outputList.add(f);
            }
            if(f.getName().endsWith(".pdf")){
                String xmlPath = converter.convertToXml(f, directory);
                outputList.add(new File(xmlPath));
            }
        }
        return outputList;
    }

}