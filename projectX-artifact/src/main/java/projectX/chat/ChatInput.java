package chat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.*;

public class ChatInput extends JPanel {

      /**
      *
      */
      private static final long serialVersionUID = -2698045337133446216L;

      private chat Chat = null;
      private Client client = null;
      private JTextField textInput = null;
      private JTextField nickname = null;
      // private JButton send = new JButton();
      private JButton add = new JButton();

      public ChatInput(chat Chat, Client client) {
            // init
            this.Chat = Chat;
            this.client = client;
            this.textInput = new JTextField();
            this.nickname = new JTextField();
            this.nickname.setOpaque(false);
            this.textInput.setFont(this.Chat.client.storage.font);

            // layout
            this.setLayout(null);

            // setting the boundries
            this.textInput.setBounds(90, 20, 1500, 50);
            this.nickname.setBounds(90, 75, 1500, 50);
            this.add.setBounds(20, 20, 50, 50);

            // icons
            this.add.setIcon(new ImageIcon("app50x50.png"));
            // adding the elements
            this.add(this.textInput);
            this.add(this.nickname);
            this.add(this.add);

            // visibility
            this.textInput.setVisible(true);

            // opaque
            this.textInput.setOpaque(false);
            this.add.setOpaque(false);

            // Colors
            this.textInput.setForeground(this.client.storage.CustomTextColor);

            // Font
            this.textInput.setFont(textInput.getFont().deriveFont(24));

            // EventListeners
            this.add.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        ChatInput.this.sendMessage();
                  }
            });

            this.add.addKeyListener(new KeyListener() {

                  @Override
                  public void keyTyped(KeyEvent e) {
                  }

                  @Override
                  public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER) {  
                              ChatInput.this.sendMessage();
                        }
                  }

                  @Override
                  public void keyReleased(KeyEvent e) {

                  }
                  
            });
      }

      public void sendMessage() {
            if(this.textInput.getText().contains("A") || this.textInput.getText().contains("B") || this.textInput.getText().contains("C") || this.textInput.getText().contains("D") || this.textInput.getText().contains("E") || this.textInput.getText().contains("F") || this.textInput.getText().contains("G") || this.textInput.getText().contains("H") || this.textInput.getText().contains("I") || this.textInput.getText().contains("J") || this.textInput.getText().contains("K") || this.textInput.getText().contains("L") || this.textInput.getText().contains("M") || this.textInput.getText().contains("N") || this.textInput.getText().contains("O") || this.textInput.getText().contains("P") || this.textInput.getText().contains("Q") || this.textInput.getText().contains("R") || this.textInput.getText().contains("S") || this.textInput.getText().contains("T") || this.textInput.getText().contains("U") || this.textInput.getText().contains("V") || this.textInput.getText().contains("W") || this.textInput.getText().contains("X") || this.textInput.getText().contains("Y") || this.textInput.getText().contains("Z") || this.textInput.getText().contains("a") || this.textInput.getText().contains("b") || this.textInput.getText().contains("c") || this.textInput.getText().contains("d") || this.textInput.getText().contains("e") || this.textInput.getText().contains("f") || this.textInput.getText().contains("g") || this.textInput.getText().contains("h") || this.textInput.getText().contains("i") || this.textInput.getText().contains("j") || this.textInput.getText().contains("k") || this.textInput.getText().contains("l") || this.textInput.getText().contains("m") || this.textInput.getText().contains("n") || this.textInput.getText().contains("o") || this.textInput.getText().contains("p") || this.textInput.getText().contains("q") || this.textInput.getText().contains("r") || this.textInput.getText().contains("s") || this.textInput.getText().contains("t") || this.textInput.getText().contains("u") || this.textInput.getText().contains("v") || this.textInput.getText().contains("w") || this.textInput.getText().contains("x") || this.textInput.getText().contains("y") || this.textInput.getText().contains("z") || this.textInput.getText().contains("1") || this.textInput.getText().contains("2") || this.textInput.getText().contains("3") || this.textInput.getText().contains("4") || this.textInput.getText().contains("5") || this.textInput.getText().contains("6") || this.textInput.getText().contains("7") || this.textInput.getText().contains("8") || this.textInput.getText().contains("9") || this.textInput.getText().contains("!") || this.textInput.getText().contains("\"") || this.textInput.getText().contains("§") || this.textInput.getText().contains("$") || this.textInput.getText().contains("%") || this.textInput.getText().contains("&") || this.textInput.getText().contains("/") || this.textInput.getText().contains("(") || this.textInput.getText().contains(")") || this.textInput.getText().contains("=") || this.textInput.getText().contains("?") || this.textInput.getText().contains("`") || this.textInput.getText().contains("*") || this.textInput.getText().contains("Ü") || this.textInput.getText().contains(">") || this.textInput.getText().contains("<") || this.textInput.getText().contains("|") || this.textInput.getText().contains(";") || this.textInput.getText().contains(":") || this.textInput.getText().contains("_") || this.textInput.getText().contains("-") || this.textInput.getText().contains(".") || this.textInput.getText().contains(",") || this.textInput.getText().contains("ä") || this.textInput.getText().contains("ö") || this.textInput.getText().contains("Ö") || this.textInput.getText().contains("Ä") || this.textInput.getText().contains("ü") || this.textInput.getText().contains("'") || this.textInput.getText().contains("~") || this.textInput.getText().contains("+") || this.textInput.getText().contains("°") || this.textInput.getText().contains("^") || this.nickname.getText().contains("A") || this.nickname.getText().contains("B") || this.nickname.getText().contains("C") || this.nickname.getText().contains("D") || this.nickname.getText().contains("E") || this.nickname.getText().contains("F") || this.nickname.getText().contains("G") || this.nickname.getText().contains("H") || this.nickname.getText().contains("I") || this.nickname.getText().contains("J") || this.nickname.getText().contains("K") || this.nickname.getText().contains("L") || this.nickname.getText().contains("M") || this.nickname.getText().contains("N") || this.nickname.getText().contains("O") || this.nickname.getText().contains("P") || this.nickname.getText().contains("Q") || this.nickname.getText().contains("R") || this.nickname.getText().contains("S") || this.nickname.getText().contains("T") || this.nickname.getText().contains("U") || this.nickname.getText().contains("V") || this.nickname.getText().contains("W") || this.nickname.getText().contains("X") || this.nickname.getText().contains("Y") || this.nickname.getText().contains("Z") || this.nickname.getText().contains("a") || this.nickname.getText().contains("b") || this.nickname.getText().contains("c") || this.nickname.getText().contains("d") || this.nickname.getText().contains("e") || this.nickname.getText().contains("f") || this.nickname.getText().contains("g") || this.nickname.getText().contains("h") || this.nickname.getText().contains("i") || this.nickname.getText().contains("j") || this.nickname.getText().contains("k") || this.nickname.getText().contains("l") || this.nickname.getText().contains("m") || this.nickname.getText().contains("n") || this.nickname.getText().contains("o") || this.nickname.getText().contains("p") || this.nickname.getText().contains("q") || this.nickname.getText().contains("r") || this.nickname.getText().contains("s") || this.nickname.getText().contains("t") || this.nickname.getText().contains("u") || this.nickname.getText().contains("v") || this.nickname.getText().contains("w") || this.nickname.getText().contains("x") || this.nickname.getText().contains("y") || this.nickname.getText().contains("z") || this.nickname.getText().contains("1") || this.nickname.getText().contains("2") || this.nickname.getText().contains("3") || this.nickname.getText().contains("4") || this.nickname.getText().contains("5") || this.nickname.getText().contains("6") || this.nickname.getText().contains("7") || this.nickname.getText().contains("8") || this.nickname.getText().contains("9") || this.nickname.getText().contains("!") || this.nickname.getText().contains("\"") || this.nickname.getText().contains("§") || this.nickname.getText().contains("$") || this.nickname.getText().contains("%") || this.nickname.getText().contains("&") || this.nickname.getText().contains("/") || this.nickname.getText().contains("(") || this.nickname.getText().contains(")") || this.nickname.getText().contains("=") || this.nickname.getText().contains("?") || this.nickname.getText().contains("`") || this.nickname.getText().contains("*") || this.nickname.getText().contains("Ü") || this.nickname.getText().contains(">") || this.nickname.getText().contains("<") || this.nickname.getText().contains("|") || this.nickname.getText().contains(";") || this.nickname.getText().contains(":") || this.nickname.getText().contains("_") || this.nickname.getText().contains("-") || this.nickname.getText().contains(".") || this.nickname.getText().contains(",") || this.nickname.getText().contains("ä") || this.nickname.getText().contains("ö") || this.nickname.getText().contains("Ö") || this.nickname.getText().contains("Ä") || this.nickname.getText().contains("ü") || this.nickname.getText().contains("'") || this.nickname.getText().contains("~") || this.nickname.getText().contains("+") || this.nickname.getText().contains("°") || this.nickname.getText().contains("^"))
            {
                  this.client.chatconnection.write(":msg:"+this.nickname.getText()+"<-1x-1><http://Leonexxe.de/projectX/profilepictures/p(-1x-1).png>:" + this.textInput.getText(), true);
                  this.textInput.setText("");
            }
      }
}
