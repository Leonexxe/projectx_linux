
import java.io.File;
import javax.swing.ImageIcon;

public class icon {
    //? DataSystem related
    public String path = "";
    public File file = new File(this.path);

    //? actuall GUI
    public ImageIcon imageicon = new ImageIcon(this.path);

    public icon(String path) {
        this.path = path;
    }
}
