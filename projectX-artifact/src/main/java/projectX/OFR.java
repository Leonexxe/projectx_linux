
import java.awt.*;

public class OFR {

    public Component comp = null;

    public int FFRWidth = 0;
    public int FFRHeight = 0;
    public int FFRx = 0;
    public int FFRy = 0;
    
    public OFR(Component Comp, int ffrWidth , int ffrHeight, int ffrX, int ffrY) {
        this.FFRx = ffrX;
        this.FFRy = ffrY;
        this.FFRWidth = ffrWidth;
        this.FFRHeight = ffrHeight;

        this.comp = Comp;
    }

    public void Resize(int x, int y, int width, int height) {
        this.comp.setBounds(x*this.FFRx, y*this.FFRy, width*this.FFRWidth, height*this.FFRHeight);
    }
}