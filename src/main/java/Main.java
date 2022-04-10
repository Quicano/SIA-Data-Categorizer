import util.GraphicalUserInterface;

import java.io.File;
import java.io.IOException;
import com.opencsv.bean.util.OpencsvUtils;

public class Main {

    public static void run(GraphicalUserInterface gui) throws IOException {
        gui.chooseFile();
        gui.addKeywordList();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(OpencsvUtils.class);
        File properties = new File("../config.properties");
        if (properties.exists()){
            properties.delete();
        }
        GraphicalUserInterface gui = new GraphicalUserInterface();
        run(gui);
    }
}
