package starter.utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils2 {

      public static JSONObject getUser2() {
        try {
            String filePath = "src/test/resources/sample/userRegister.json";

            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            return new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
