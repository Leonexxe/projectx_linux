
import java.awt.*;
import core.Client;
public class Resizer extends Thread{

    private int ComponentCount = 0;

    private int width = 0;
    private int height = 0;

    private boolean isRunning = true;

    private PCR ParentComponent = null;
    private Client client = null;

    public OFR[] Componentlist = new OFR[1000];

    public Resizer(PCR parentComponent, Client clientFR) {
        this.client = clientFR;
        this.setName("ProjectX_Resizer");

        this.ParentComponent = parentComponent;
        // Initialy setting Size and Position 

        this.width = ParentComponent.width;
        this.height = ParentComponent.height;

        //Starting Thread
        this.start();
    }

    public void run() {
        System.out.println("Resizer " + this + "is ready to resize");
        // Testing if Thread is supposed to run
        while(this.isRunning) {
            // Testing if Client is Runnning
            while(this.client.isrunning) {
                // Testing if Size has Changed
                this.ParentComponent.Refresh();
                if(this.width != this.ParentComponent.height|| this.height != this.ParentComponent.height) {
                    //System.out.println("Size of " + this.ParentComponent + " has Changed From " + this.width + "|" 
					//+ this.height + " to " + this.ParentComponent.width + "|" + this.ParentComponent.height);
					this.Resize(this.ParentComponent.width, this.ParentComponent.height);
                }
            }
            System.out.println("ending thread"); // this will get printed out to the console if the client it is atached to doesent run anymore
            break; // here you can define what the Thread should do if the client it is atached to wouldn't run anymore
            // in my case i just want it to end just by breaking out of the last loop(if a thread runs out of code it ends)
        }
    }

    public void Resize(int x, int y) {
        int component = 0;
        while(component >= 1000) {
            this.Componentlist[component].Resize(this.ParentComponent.X, this.ParentComponent.Y,
            this.ParentComponent.width, this.ParentComponent.height);
            component++;
        }
        //System.out.println("finished Resizing" + this);
    }

    public void add(Component comp) {

        int ffrX = 0;
        int ffrY = 0;
        int ffrWidth = 0;
        int ffrHeight = 0;

        // Calculating
        ffrWidth = (comp.getWidth() / this.ParentComponent.width);
        ffrHeight = (comp.getHeight() / this.ParentComponent.height);
        ffrX = (comp.getX() / this.ParentComponent.X);
        ffrY = (comp.getY() / this.ParentComponent.Y);

        // Creating the Object
        OFR ObjectToResize = new OFR(comp, ffrWidth, ffrHeight, ffrX, ffrY);

        this.Componentlist[ComponentCount++] = ObjectToResize;
    }
}