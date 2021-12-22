import util.GUI;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void run(GUI gui) throws IOException {
        gui.chooseFile();
        gui.addKeywordList();
    }

    public static void main(String[] args) throws Exception {
        File properties = new File("src/main/resources/config.properties");
        if (properties.exists()){
            properties.delete();
        }
        GUI gui = new GUI();
        run(gui);

    }
}
