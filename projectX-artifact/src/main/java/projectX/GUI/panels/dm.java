package GUI.panels;

import javax.swing.JPanel;
import java.awt.Color;

import core.Client;
import chat.chat;
import GUI.components.ImagePanel;

@SuppressWarnings("all")
public class dm extends JPanel {

    public chat Chat = null;
    private Client client = null;

    public dm(String recv, Client client) {

        this.client = client;
        this.Chat = new chat(recv, this.client);
        this.Chat.setOpaque(false);

        this.setLayout(null);

        this.setBounds(300, 0, 1620, 1080);

        this.add(this.Chat);

        this.add(new ImagePanel("E:\\semitransparent.png", 1620, 1080));
        this.setOpaque(false);
    }

    /*
    public void show() {
        this.setVisible(true);
    }

    public void hide() {
        this.setVisible(false);
    }
    */
}
