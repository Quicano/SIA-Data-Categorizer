import util.GUI;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void run(GUI gui) throws IOException {
        gui.chooseFile();
        gui.addKeywordList();
    }

    public static void main(String[] args) throws Exception {
        File f = new File("C:/Users/Programmierarbeit/OneDrive/Desktop/Testdaten/Andere/");
        File[] files = f.listFiles();
        System.out.println(files[1].getName());/*
        File properties = new File("src/main/resources/config.properties");
        if (properties.exists()){
            properties.delete();
        }
        GUI gui = new GUI();
        run(gui);*/
    }
}
