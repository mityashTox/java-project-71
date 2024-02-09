package hexlet.code;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Utils {
    public static Map<String, Object> parsFile(String file) throws IOException {
        Map<String, Object> mapFile;
        Path path = Paths.get(file).toAbsolutePath().normalize();
        String list =new String (Files.readAllBytes(path));
        mapFile = new ObjectMapper().readValue(list, HashMap.class);
        return mapFile;
    }

}