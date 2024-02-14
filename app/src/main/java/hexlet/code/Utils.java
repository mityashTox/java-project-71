package hexlet.code;



import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.formatters.Format;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, Object> parsFile(String file) throws IOException {
        Map<String, Object> mapFile;
        Path path = Paths.get(file).toAbsolutePath().normalize();
        String list = new String(Files.readAllBytes(path));
        mapFile = new ObjectMapper().readValue(list, HashMap.class);
        return mapFile;
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

    public static String useForm(String format, Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Map<String, Format> forms = Map.of(
                "stylish", new Stylish(),
                "plain", new Plain(),
                "json", new Json()
        );
        return forms.get(format).construct(mapFile1, mapFile2);
    }
}
