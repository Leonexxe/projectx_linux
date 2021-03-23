package core;

import java.awt.Color;
import java.io.IOException;
import types.user;
import json.*;
import log.log;

@SuppressWarnings("all")
public class core {

    public String os = "windows";
    public Client client = null;
    public loadingscreen ls = null;
    public log log = new log(this);
    public String folderSeperator = "/";

    public core(String os)
    {
        this.os = os;
    }

     public void __init__()
     {
            this.ls = new loadingscreen();
            this.ls.run();
            this.client = startClient(this.os);
      }

    public Storage readSettings(String folderSeperator) {
        Storage storage = new Storage();

        Json json_usersettings = new Json("ProjectX_Client"+this.folderSeperator+"src"+this.folderSeperator+"settings"+this.folderSeperator+"cryptography.json");
        this.ls.inscreaseprogress(1);
        Json json_Crypto = new Json("ProjectX_Client"+this.folderSeperator+"src"+this.folderSeperator+"settings"+this.folderSeperator+"userSettings.json");
        this.ls.inscreaseprogress(1);

        storage.CustomBackgroundColor = Color.decode(json_usersettings.getValue("--Json/interface/colors/background-main"));
        this.ls.inscreaseprogress(1);
        storage.CustomTextColor = Color.decode(json_usersettings.getValue("--Json/interface/colors/main-text"));
        this.ls.inscreaseprogress(1);
        storage.CustomSecondaryTextColor = Color.decode(json_usersettings.getValue("--Json/interface/colors/secondary-text"));
        this.ls.inscreaseprogress(1);
        storage.CurrentUser = new user(-1, "projectX-Leonexxe[CEO/developer/founder]", "Leonexxe@projectX.com", "app.png");
        this.ls.inscreaseprogress(1);
        storage.defaultCryptoKey = json_Crypto.getValue("--Json/default");
        this.ls.inscreaseprogress(1);

        log.out("reading settings", "INFO", 1);
        return storage;
      }

  public Client startClient(String os) {
      Client client = null;
        /*
        starts the client with linux config
         */
        if(os.toUpperCase().equals("LINUX"))
        {
              try { 
                    client = new Client(readSettings("/"), "linux");
              } catch (IOException e) {
                    e.printStackTrace();
              } catch (InterruptedException e) {
                    e.printStackTrace();
              }
        }
        /*
        * starts the client with windows config
         */
        else if(os.toUpperCase().equals("WINDOWS"))
        {
              try {
                    client = new Client(readSettings("\\"), "windows");
              } catch (IOException e) {
                    e.printStackTrace();
              } catch (InterruptedException e) {
                    e.printStackTrace();
              }
        }
        /*
        * starts the client with macOS config
         */
        else if(os.toUpperCase().equals("MACOS"))
        {
              try {
                    client = new Client(readSettings(""), "macOS");
              } catch (IOException e) {
                    e.printStackTrace();
              } catch (InterruptedException e) {
                    e.printStackTrace();
              }
        }
        return client;
  }
  public static void main(String[] args) {
        core core = new core("linux");
        core.__init__();
  }
}
