
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

@SuppressWarnings("all")
public class GUI {

    /*//////////////////////////////////////////////////////////////////////////////////////////////////*/
    //
    ///Inizializing Frame
    //
    /*//////////////////////////////////////////////////////////////////////////////////////////////////*/
    //StandartFrame frame = new StandartFrame();
    public Frame frame = new Frame();

    private Client client = null;

    // panels
    public dm dmPanel = null;
    public login LoginPanel = new login();
    public main_menu MainMenu = null;
    public server ServerPanel = new server();
    public serverlist serverListPanel = new serverlist();
    public sidebar SideBar = null;
    public settings Settings = null;

    /**
     * @wbp.parser.entryPoint
     */
    public GUI(Client clientForGUI) throws IOException, InterruptedException {
        this.frame.loadDefault();
        this.client = clientForGUI;
        System.out.println("GUI client: " + this.client);
        this.dmPanel = new dm("@admin", this.client);
        this.MainMenu = new main_menu(this.client.SYSTEM);
        this.Settings = new settings(this.client.jsonUserSettings ,this.client);
        this.SideBar = new sidebar(this);
        System.out.println("GUI Starting Up");
        this.frame.setMasterBackground(Color.decode("#404040"));
        this.initPanels();
        this.setBackground();
        this.start();
    }

    /*
    this is the end of the gui constructor
    */

    public void initPanels() {
        this.frame.add(this.dmPanel);
        this.frame.add(this.Settings);
        this.dmPanel.setOpaque(false);
        //this.frame.add(this.LoginPanel);
        //this.frame.add(this.MainMenu);
        //this.frame.add(this.ServerPanel);
        //this.frame.add(this.serverListPanel);
        this.frame.add(this.SideBar);

        frame.revalidate();
    }

    public void start() {
        //this.MainMenu.show();
    } 

    public void setBackground() {   
        this.frame.getContentPane().add(new ImagePanel("E:\\sunset.jpg", 1920, 1080));
    }




    public void kill() {
        this.frame.dispose();
        System.out.println("gui was closed sucsessfully");
    }

    public void recreate() throws IOException, InterruptedException {
        System.out.println("> recreating gui");
        System.out.println("-> disposing gui");
        System.out.println("--> disposing frame...");
        this.frame.dispose();
        System.out.println("--> frame disposed sucsessfully");
        System.out.println("-> loading gui...");
        System.out.println("--> creating new gui...");
        System.out.println("--> sucsessfully created new gui");
        System.out.println("-> the gui was sucsessfully recreated");
    }

    public void reload() {
    }

    public void resize() {
    }

    public void StartResizingEngine() {

        // Frame Layer
        PCR FramePCR = new PCR(this.frame);
        Resizer Resizer_FrameLayer = new Resizer(FramePCR, this.client);
    }

    public void enableTransparency() {
    }
}