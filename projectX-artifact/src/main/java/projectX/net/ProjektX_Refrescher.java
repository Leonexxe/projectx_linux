package net;
//importing external classes
import java.io.IOException;
import java.util.ArrayList;

import core.Client;

@SuppressWarnings("all")
public class ProjektX_Refrescher extends Thread {

    private ServerConnection con = null;
    private Client client = null;
    private Boolean isrunning = true;

    private ArrayList<ProjektX_Refrescher> connections = new ArrayList<ProjektX_Refrescher>();

    public ProjektX_Refrescher(ServerConnection connection, Client clienttorefresh) {
        this.con = connection;
        this.client = clienttorefresh;

        //Starting Thread
        this.start();
    }
    public void run() {
        super.setName("projectX");
        System.out.println("Refresher " + this + " ready to Refresh");

        while(this.client.isrunning && this.isrunning) {
            try 
            {
                String msg = this.con.recv();
                System.out.println("["+this.con.Client.getInetAddress()+"]:" + msg);
                if(msg.contentEquals("--disconnect"))
                {
                    this.con.Close();
                    this.isrunning = false;
                    break;
                }
                else if(msg.startsWith(":key"))
                {
                    this.con.cryptoKey = msg.split(":")[2];
                    this.con.hascryptoKey = true;
                    System.out.println("has crypto key: " + this.con.hascryptoKey);
                }
                else
                {
                    processMessage.processmessage(msg, this.client, this.con);
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        System.out.println("RIP @" + this);
        this.kill();
    }

    public void kill() {
        this.interrupt();
    }
}
