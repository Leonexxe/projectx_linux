package chat;
import javax.swing.JPanel;
import core.*;

public class chat extends JPanel {

      /**
      *
      */
      private static final long serialVersionUID = -1534756700678022210L;
      public String recv = "";
      public Client client = null;
      public ChatScroller chatScroller = null;
      private ChatInput chatInput = null;
      public chat(String recv, Client client) {
            // init
            this.recv = recv;
            this.client = client;
            System.out.println("chat Client: " + this.client);
            this.chatInput = new ChatInput(this, this.client);
            this.chatScroller = new ChatScroller(this);

            this.setOpaque(true);
            this.chatInput.setOpaque(false);
            this.chatScroller.gui.setOpaque(false);

            // layout
            this.setLayout(null);

            //bounds
            this.setBounds(0, 0, 1620, 1040);
            this.chatScroller.SetBounds(0, 0, 1620, 910);
            this.chatInput.setBounds(0, 930, 1620, 160);

            //adding elements
            this.add(this.chatInput);
            this.add(this.chatScroller.gui);

            //this.addTestMessages(20);
      }

      public void addTestMessages(int count) {
            /*
            int counter = count;
            while(counter > 0) {
                  this.chatScroller.addmessage("CONSOLE: Hello World " + counter);
                  System.out.println("new message");
                  counter--;
            }
            */
      }
}
