
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

@SuppressWarnings("all")
public class settingscroller {

    public int messagecounter = 0;
    public int verticalIndent = 0;
    public JPanel gui = new JPanel(null);
    private final JPanel panel = new JPanel(null);
    private final JScrollPane scroll = new JScrollPane(this.panel);
    public Client client = null;
    public ArrayList<setting> settings = new ArrayList<setting>();

    public settingscroller(Client client) {
        System.out.println("settingsscroller initiated");
        this.client = client;
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

    public void addsetting(String Text, String type, String value, String jsonPath) {
        this.messagecounter++;
        setting Setting = new setting(this, this.client.storage.font, Text, type, value, jsonPath);

        this.panel.setBounds(this.panel.getX(), this.panel.getY(), this.panel.getWidth(), this.verticalIndent);
        this.panel.add(Setting);
        this.panel.revalidate();
        
        this.panel.setPreferredSize(new Dimension(this.panel.getWidth(), this.panel.getHeight()));
        this.scroll.revalidate();
        System.out.println("setting \""+Text+"\" was added");
        this.settings.add(Setting);
    }

    public void SetBounds(int x, int y, int width, int height) {
        settingscroller.this.scroll.setPreferredSize(new Dimension(width,height)); 
        this.gui.setBounds(x, y, width + 20, height);
    }
}
