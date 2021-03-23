package net;
import cryptography.*;
import core.Client;
import chat.chat;
import GUI.GUI;

import java.awt.AWTException;

@SuppressWarnings("all")
public class processMessage {
      public static void processmessage(String message, Client client, ServerConnection con) {
            String msg = cryptography.decrypt(con.cryptoKey, message);
            System.out.println("MSG: " + msg);
            if (msg.startsWith(":msg")) {
                  System.out.println("message from server");
                  messageProtocoll(msg, client);
            } else if (msg.startsWith(":ntf")) {
                  System.out.println("incoming notification");
                  notify("[NOTIFICATION SERVER]", msg, client);
            } else {
                  System.out.println("cant identify respond");
            }
      }

      private static void messageProtocoll(String msg, Client client) {
            String senderName       = msg.split(":")[2].split("<")[0];
            String senderUID        = msg.split(":")[2].split("<")[1].replaceAll(">", "");
            String profilePicURL    = msg.split(":")[2].split("<")[2].replaceAll(">", "");
            String msgText          = msg.split(":")[4];
            System.out.println("profilePicURL: " + profilePicURL);
            System.out.println("senderUID: " + senderUID);
            System.out.println("senderName: " + senderName);
            client.gui.dmPanel.Chat.chatScroller.addmessage(msgText, senderUID, "-1", senderName, profilePicURL);
            notify(msgText, senderName + "(UID: "+senderUID+")", client);
      }

      private static void notify(String msg,String sender, Client client) {
            try {
                  notification notify = new notification(sender, msg);
            } catch (AWTException e) {
                  e.printStackTrace();
            }
      }
}
