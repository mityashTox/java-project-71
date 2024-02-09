package hexlet.code;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2) {
        Map<String, Object> mapFile1 = parser(filepath1);
        if (mapFile1.isEmpty()) {
            return "File '" + filepath1 + "' cannot be reading";
        }
        Map<String, Object> mapFile2 = parser(filepath2);
        if (mapFile2.isEmpty()) {
            return "File '" + filepath2 + "' cannot be reading";
        }
        return null;
    }

    public static Map<String, Object> parser(String filepath) {
        Map<String, Object> mapFile;
        try {
            mapFile = Utils.parsFile(filepath);
        } catch (NullPointerException | IOException e) {
            return new HashMap<>();
        }
        return mapFile;
    }
}
