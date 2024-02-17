package hexlet.code;

import java.util.Map;

import static hexlet.code.Utils.parser;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) {
        Map<String, Object> mapFile1 = parser(filepath1);
        if (mapFile1.isEmpty()) {
            return "File '" + filepath1 + "' cannot be reading";
        }
        Map<String, Object> mapFile2 = parser(filepath2);
        if (mapFile2.isEmpty()) {
            return "File '" + filepath2 + "' cannot be reading";
        }
        return Utils.useForm(format, mapFile1, mapFile2);
    }

    public static String generate(String filepath1, String filepath2) {
        return generate(filepath1, filepath2, "stylish");
    }
}
