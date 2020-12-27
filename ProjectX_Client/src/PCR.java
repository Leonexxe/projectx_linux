
import java.awt.*;

import javax.swing.JPanel;

public class PCR {

    public int X = 0;
    public int Y = 0;
    public int width = 0;
    public int height = 0;

    public JPanel Dummy = new JPanel();
    public Component Comp = Dummy;

    public PCR(Component comp){
        // Defining The Parent Component
        this.Comp = comp;
        System.out.println("new Parent Component is now set as " + comp);

        // Initial Setting Size and Position
        this.X = this.Comp.getX();
        this.Y = this.Comp.getY();
        this.width = this.Comp.getWidth();
        this.height = this.Comp.getHeight();
    }    

    public void Refresh() {
        // Refreshing Size and Position
        this.X = this.Comp.getX();
        this.Y = this.Comp.getY();
        this.width = this.Comp.getWidth();
        this.height = this.Comp.getHeight();
    }
}