package chat.server;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import GUI.GUI;

public class channel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 546448013716097109L;

    public String name = "placeholder";
    public String CID = "-1x-1";
    public String type = "";
    public GUI gui = null;

    /*
    * UI elements
    */
    public JTextArea nameBox = new JTextArea();

    public channel(String name, String CID, String type,GUI gui) 
    {
        /*
        * initiating values
        */
        this.name = name;
        this.CID  = CID;
        this.gui  = gui;
        this.type = type;

        /*
        *initiating UI elements
        */
        this.setBounds(0, 0, 200, 50);
        this.nameBox.setBounds(10, 10, 50, 30);
        this.nameBox.setEditable(false);
        this.nameBox.setText(this.name);
        switch(type)
        {
            case "voice"        : this.voice();         break;
            case "text"         : this.text();          break;
            case "rules"        : this.rules();         break;
            case "announcements": this.announcements(); break;
            default: System.out.println(type + " is not a valid channel type."); System.out.println("valid channel types: announcements, rules, voice, text");
        }
    }

    private void voice()
    {
        /*
        initiating the channel as a voice channel 
        */
    }

    private void text()
    {
        /*
        * initiating the channel as a text channel 
        */
        /*
        * UI
        */
        /*
        * obtain messages from the database
        */
    } 

    private void rules()
    {
        /*
        initiating the channel as a rules channel 
        */
        /*
        * UI
        */
        /*
        * obtain rules from the database
        */
    }

    private void announcements()
    {
        /*
        initiating the channel as a announcement channel 
        */
        /*
        * UI
        */
        /*
        * obtain messages from the database
        */
    }
}
