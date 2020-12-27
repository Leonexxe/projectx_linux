import java.util.ArrayList;

public class voicechannelsubsys
{
    public String CID = "0x0";
    public String name = "NULL";
    public int userCount = 0;
    public ArrayList<user> users = new ArrayList<user>();

    public voicechannelsubsys()
    {
    }

    public void joinUser(String username, String UID)
    {
        System.out.println("\033[95m["+log.get_DateTime()+"]["+UID+"]["+username+"][joined]["+this.CID+"]["+this.name+"]");
    }

    public static void main(String[] args)
    {
        voicechannelsubsys sys = new voicechannelsubsys();
        sys.joinUser("Leonexxe - Owner", "2x58934275");
    }
}