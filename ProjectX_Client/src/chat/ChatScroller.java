package chat;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import core.*;
import GUI.Colors;

@SuppressWarnings("all")
public class ChatScroller {

    public int messagecounter = 0;
    public int verticalIndent = 0;
    public JPanel gui = new JPanel(null);
    private final JPanel panel = new JPanel(null);
    private final JScrollPane scroll = new JScrollPane(this.panel);
    public chat Chat = null;

    public ChatScroller(chat Chat) {
        this.Chat = Chat;
        this.panel.setOpaque(false);
        this.scroll.setOpaque(false);
        this.gui.setOpaque(false);
        this.scroll.getViewport().setOpaque(false);

        this.panel.setBounds(0, 0, 1600, 0);
        this.scroll.setBounds(0, 0, 1620, 910);

        this.gui.add(this.scroll);
        this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // scroll bar desing
        this.scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Colors.dark_Background;
            }
        });
        this.scroll.getVerticalScrollBar().setBackground(Color.black);
        this.scroll.setBorder(null);
    }

    public void addmessage(String message, String SenderUID, String recvCID, String SenderName, String senderProfilePicURL) {
        this.messagecounter++;
        message Message = new message(message, SenderUID + "",SenderName, this.messagecounter, this, this.Chat.client.storage.font);

        //this.panel.setBounds(this.panel.getX(), this.panel.getY(), this.panel.getWidth(), this.panel.getHeight() + 90);
        this.panel.setBounds(this.panel.getX(), this.panel.getY(), this.panel.getWidth(), this.verticalIndent);
        this.panel.add(Message);
        this.panel.revalidate();
        
        this.panel.setPreferredSize(new Dimension(this.panel.getWidth(), this.panel.getHeight()));
        if(this.verticalIndent > 900)
        {
            this.scroll.getVerticalScrollBar().setValue(this.verticalIndent);
        }
        this.scroll.revalidate();
    }

    public void SetBounds(int x, int y, int width, int height) {
        ChatScroller.this.scroll.setPreferredSize(new Dimension(width,height)); 
        this.gui.setBounds(x, y, width + 20, height);
    }
}
