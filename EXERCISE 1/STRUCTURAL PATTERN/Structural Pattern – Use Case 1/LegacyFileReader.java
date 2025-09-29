import java.nio.file.Files;
import java.nio.file.Paths;

public class LegacyFileReader {
    public String readLegacyFile(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}
