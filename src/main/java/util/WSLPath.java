package util;

import org.apache.commons.io.FilenameUtils;

import java.util.Locale;

public class WSLPath {

    public static String convertWindowsPath(String winPath){
        String s = FilenameUtils.separatorsToUnix(winPath);
        int i = s.indexOf(":/");
        String harddrive = s.substring(0,i);
        String wslPath = s.replaceAll(harddrive + ":", "/mnt/" + harddrive.toLowerCase(Locale.ROOT));
        return wslPath;
    }
}
