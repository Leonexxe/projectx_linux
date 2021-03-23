package chat;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import GUI.components.ImagePanel;

@SuppressWarnings("all")
public class message extends JPanel {
      /**
      *
      */
      private static final long serialVersionUID = -4185132677363791583L;
      public message(String message, String senderUID, String senderName, int messagecount, ChatScroller chatscroller, Font font) {
            this.setLayout(null);

            this.setOpaque(false);

            this.setBounds(0, chatscroller.verticalIndent, 1500, 40 + this.calcMessageHeight(message.length(), font.getSize()));
            this.setBackground(Color.cyan);
    
            JTextArea sender = new JTextArea(senderUID);
            sender.setBounds(60 + this.calcUsernameLength(senderName.length(), font.getSize()), 0, 1500, this.calcMessageHeight(senderName.length(), font.getSize()));
            sender.setEditable(false);
            sender.setLineWrap(true);
            sender.setWrapStyleWord(true);
            sender.setForeground(chatscroller.Chat.client.storage.CustomTextColor);
            sender.setFont(font);
            sender.setForeground(chatscroller.Chat.client.storage.CustomSecondaryTextColor);
            sender.setText("UID: " + senderUID);
            this.add(sender);

            JTextArea senderII = new JTextArea();
            senderII.setBounds(60, 0, this.calcUsernameLength(senderName.length(), font.getSize()), this.calcMessageHeight(senderName.length(), font.getSize()));
            senderII.setEditable(false);
            senderII.setLineWrap(true);
            senderII.setWrapStyleWord(true);
            senderII.setForeground(chatscroller.Chat.client.storage.CustomTextColor);
            senderII.setFont(font);
            senderII.setText(senderName);
            senderII.setOpaque(false);
            this.add(senderII);

            JTextArea Message = new JTextArea();
            String msg = message;
            int count = -1;
            int totalcount = -1;
            int messagelength = msg.length() - 1;
            for(char c : msg.toCharArray())
            {
                  count++;
                  totalcount++;
                  if(count == 125)
                  {
                        msg = msg.substring(0, totalcount + 1) + " \r\n" + msg.substring(totalcount + 1, messagelength);
                        count = -1;
                  }
            }
            Message.setBounds(60, 30, 1500, this.calcMessageHeight(message.length(), font.getSize()));
            Message.setEditable(false);
            Message.setLineWrap(true);
            Message.setWrapStyleWord(true);
            Message.setForeground(chatscroller.Chat.client.storage.CustomTextColor);
            Message.setFont(font);
            Message.setWrapStyleWord(true);
            Message.setLineWrap(true);
            Message.setText(msg);
            this.add(Message);

            Message.setOpaque(false);
            sender.setOpaque(false);

            this.add(new ImagePanel("E:\\ProjectX_Client\\ProjectX_Client\\src\\projectX\\graphics\\icons\\app50x50.png", 50, 50));
            chatscroller.verticalIndent += this.getHeight() + 10;
      }

      private int calcMessageHeight(int messagelength, int fontsize)
      {
            int ret = ((messagelength / (125 * (fontsize / 20))) * 40) * (fontsize / 20);
            if(ret < 1)
            {
                  ret = 40;
            }
            return ret;
      }

      private int calcUsernameLength(int usernameLength, int fontsize)
      {
            return (usernameLength * 15) * (fontsize / 20);
      }
}
