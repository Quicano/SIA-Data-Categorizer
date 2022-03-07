import util.GUI;

import org.apache.commons.lang3.SystemUtils;
import java.io.File;
import java.io.IOException;
import com.opencsv.bean.util.OpencsvUtils;

public class Main {

    public static void run(GUI gui) throws IOException {
        gui.chooseFile();
        gui.addKeywordList();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(OpencsvUtils.class);
        File properties = new File("../config.properties");
        if (properties.exists()){
            properties.delete();
        }
        GUI gui = new GUI();
        run(gui);
    }
}
