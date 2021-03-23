package net;
import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class notification {
    public notification(String title, String msg) throws AWTException {
      System.out.println("notification");
      //Obtain only one instance of the SystemTray object
      SystemTray tray = SystemTray.getSystemTray();

      //If the icon is a file //
      Image image = Toolkit.getDefaultToolkit().createImage("E:\\ProjectX_Client\\ProjectX_Client\\src\\projectX\\graphics\\icons\\app.png");
      //Alternative (if the icon is on the classpath):
      //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

      TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
      //Let the system resize the image if needed
      trayIcon.setImageAutoSize(true);
      //Set tooltip text for the tray icon

      trayIcon.setToolTip("System tray icon demo");
      tray.add(trayIcon);

      trayIcon.displayMessage(title, msg, MessageType.INFO);
    }
}