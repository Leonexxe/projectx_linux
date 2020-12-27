
//importing external classes
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

@SuppressWarnings("all")
public class ServerConnection {

    public Socket Client = null;

    private Client client = null;

    private String newmessage = "";
    public String cryptoKey = "";
    
    public DataInputStream IN = null;
    public DataOutputStream OUT = null;
    public Boolean hascryptoKey = false;

    public ServerConnection(Client Client) {
        this.client = Client;
        System.out.println("opening refresher");
    }

    public void write(String message, Boolean encrypt) {
        String msg = message;
        if(encrypt)
        {
            msg = cryptography.encrypt(this.cryptoKey, message);
        }
        try {
            this.OUT.writeUTF(msg);
            this.OUT.flush();
            System.out.println("message was send");
        } catch (IOException e) {
            System.out.println("error sending the message");
            e.printStackTrace();
            try {
				this.client.kill(0);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
        }
    }

    public void Close() throws IOException {
        this.Client.close();
        System.out.println("connection closed sucsessfully");
    }

    public int Connect(String IP, int port) {
        int sucsess = 0;
        try {
            this.Client = new Socket(IP, port);

            //Create IN/OUT
            try {
                this.IN = new DataInputStream(this.Client.getInputStream());
                this.OUT = new DataOutputStream(this.Client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ProjektX_Refrescher refresher = new ProjektX_Refrescher(this, this.client);

            System.out.println("sucsessfully connected to " + IP + " on port " + port);
            sucsess = 1;
        } catch (IOException e) {
            System.out.println("failded to connect to " + IP + " on port " + port);
            e.printStackTrace();
        }
        return sucsess;
    }

    public String recv() throws IOException {
        String result = "";
        while(true)
        {
            if(this.IN.available() != 0) {
                String msg = this.IN.readUTF();
                if(this.hascryptoKey == true)
                {
                    result = cryptography.decrypt(this.cryptoKey, msg);
                }
                else
                {
                    result= msg;
                }
                break;
            }
        }
        return result;
    }
}