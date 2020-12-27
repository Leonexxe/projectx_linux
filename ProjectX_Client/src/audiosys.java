import java.util.ArrayList;

public class audiosys 
{
    public ArrayList<voicechannelsubsys> voicechannelsubsystems = new ArrayList<voicechannelsubsys>();
    public audiosys()
    {
    }

    public void terminate()
    {
        for(voicechannelsubsys subsys : this.voicechannelsubsystems)
        {
            subsys = null;
        }
    }
}