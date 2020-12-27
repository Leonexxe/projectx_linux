
////////////////////////////////////////////////////////////////////////////////////////////////////
//
//external classes
//
//////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.IOException;
import java.util.ArrayList;

public class Client {

    public ProjektX_Refrescher refresher = null;
    public Boolean isrunning = true;
    public ServerConnection chatconnection = null;
    public GUI gui = null;
    public Storage storage = null;
    public system SYSTEM = null;
    public ArrayList<chatServerConnection> chatServerConnections = new ArrayList<chatServerConnection>();
    public ServerConnection DBSERVER = null;
    public ServerConnection DMSERVER = null;
    public ServerConnection NOTIFYSERVER = null;
    public Json jsonCrypto = null;
    public Json jsonUserSettings = null;

    public Client(Storage storage, String os) throws IOException, InterruptedException {
        // opening system
        //this.SYSTEM = new system(this);
        //this.SYSTEM.out("new session created", "note");

        // opening storage unit
        this.storage = storage;

        // opening Json files
        this.jsonCrypto = new Json(this.storage.installPath + "ProjectX_Client\\src\\projectX\\boot\\cryptography.json");
        this.jsonUserSettings = new Json(this.storage.installPath + "ProjectX_Client\\src\\projectX\\boot\\userSettings.json");

        // opening server connections
        this.DBSERVER = new ServerConnection(this);
        this.DMSERVER = new ServerConnection(this);
        this.NOTIFYSERVER = new ServerConnection(this);
        /*
        this.DBSERVER.Connect("45.135.149.118", 5010);
        this.DMSERVER.Connect("45.135.149.118", 5011);
        this.NOTIFYSERVER.Connect("45.135.149.118", 5012);
        */

        // loading icons
        Icons.CheckIconpaths(SYSTEM);

        // opeing gui
        this.gui = new GUI(this);

        this.chatconnection = new ServerConnection(this);
        this.chatconnection.Connect("192.168.178.50", 5000);
        this.chatconnection.write("--key", false);
        while(this.chatconnection.hascryptoKey == false){System.out.println("waiting");}
        System.out.println("proceed");
        //this.chatconnection.write(":msg:Leonexxe<-1x-1><profilepicture>:das pferd frisst keinen kartoffelsalat", true);
        //this.chatconnection.write("--disconnect", true);
        //this.chatconnection.write("--server::password --shutdown", true);
    }

    public void kill(int wait) throws IOException, InterruptedException {
        this.wait(wait);
        chatconnection.Close();
        refresher.kill();
        this.isrunning = false;
    }

    public Boolean IsRunning() {
        return this.isrunning;
    }

    public void addMessage(String message, int SenderUID, int recvCID) {
    }

    public void createNewChatServerConnection(String sI)
    {
        this.chatServerConnections.add(new chatServerConnection(this, sI));
    }
}