import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class updateCSV {

    public static void updateParking(String oldRecord, String newRecord) throws IOException{
        Path filePath = Paths.get("Parking.txt");

        String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
        String updatedContent = content.replaceAll(oldRecord, newRecord);
        try {
            Files.write(filePath, updatedContent.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
