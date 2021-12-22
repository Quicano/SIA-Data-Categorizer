import util.GUI;
import java.io.IOException;

public class Main {

    public static void run(GUI gui) throws IOException {
        gui.chooseFile();
        gui.addKeywordList();
    }

    public static void main(String[] args) throws Exception {
        GUI gui = new GUI();
        run(gui);
    }
}
