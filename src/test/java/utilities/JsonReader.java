package utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class JsonReader {
    private static final String FILE_PATH = "src/test/resources/testdata/loginData.json";

    public static int getUserCount() {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            JsonArray arr = JsonParser.parseReader(reader).getAsJsonArray();
            return arr.size();
        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON file: " + FILE_PATH, e);
        }
    }

    public static String getEmailAt(int i) {
        return getValueAt(i, "Email");
    }

    public static String getPasswordAt(int i) {
        return getValueAt(i, "Password");
    }

    private static String getValueAt(int i, String key) {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            JsonArray arr = JsonParser.parseReader(reader).getAsJsonArray();
            JsonObject obj = arr.get(i).getAsJsonObject();
            return obj.get(key).getAsString();
        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON at index: " + i, e);
        }
    }
}
