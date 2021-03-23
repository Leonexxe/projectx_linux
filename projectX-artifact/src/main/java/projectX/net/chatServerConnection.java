package net;
import core.Client;
@SuppressWarnings("all")
public class chatServerConnection 
{
      public String cryptoKey = "";
      public Client client = null;
      public String serverID = null;
      private ServerConnection conn = null;
      
      public chatServerConnection(Client cI, String sII)
      {
            this.client = cI;
            this.serverID = sII;
            this.conn = new ServerConnection(cI);
      }

      private String orderCryptoKey()
      {
            return "";
      }
}
