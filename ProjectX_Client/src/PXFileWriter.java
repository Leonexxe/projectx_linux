import java.io.FileWriter;
import java.io.IOException;

public class PXFileWriter {
    public FileWriter writer = null;

    public PXFileWriter(String filepath) {
        try {
            this.writer = new FileWriter(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
