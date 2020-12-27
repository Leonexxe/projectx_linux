import java.awt.Color;
import java.io.IOException;

@SuppressWarnings("all")
public class core {

    public String os = "windows";
    public Client client = null;

    public core(String os)
    {
        this.os = os;
    }

    public void __init__()
    {
        this.client = startClient(this.os);
    }

    public static Storage readSettings(String folderSeperator) {
        Storage storage = new Storage();

        Json json_usersettings = new Json("userSettings.json");
        Json json_Crypto = new Json("cryptography.json");

        storage.CustomBackgroundColor = Color.decode(json_usersettings.getValue("--Json/interface/colors/background-main"));
        storage.CustomTextColor = Color.decode(json_usersettings.getValue("--Json/interface/colors/main-text"));
        storage.CustomSecondaryTextColor = Color.decode(json_usersettings.getValue("--Json/interface/colors/secondary-text"));
        storage.CurrentUser = new user(-1, "Leonexxe // owner", "Leonexxe@projectX.com", "app.png");
        storage.defaultCryptoKey = json_Crypto.getValue("--Json/default");
        System.out.println("DefaulCryptoKey: " + storage.defaultCryptoKey);

        return storage;
  }

  public static Client startClient(String os) {
      Client client = null;
        /*
        starts the client with linux config
         */
        if(os.toUpperCase().equals("LINUX"))
        {
              try {
                    client = new Client(readSettings(""), "linux");
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
                    client = new Client(readSettings(""), "windows");
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
        readSettings("linux");
  }
}
