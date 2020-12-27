
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;

@SuppressWarnings("all")
public class boot {
      public static void Boot(String os) {
            startClient(os);
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

      public static void startClient(String os) {
            /*
            starts the client with linux config
             */
            if(os.toUpperCase().equals("LINUX"))
            {
                  try {
                        Client client = new Client(readSettings(""), "linux");
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
                        Client client = new Client(readSettings(""), "windows");
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
                        Client client = new Client(readSettings(""), "macOS");
                  } catch (IOException e) {
                        e.printStackTrace();
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }
      }

      public static void main(String[] args) {
            readSettings("linux");
      }
}
