
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class StandartFrame {

    public static Double MouseX;
    public static Double MouseY;

    private Boolean AutoResize = true;
    private Boolean isRunning = true;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Initializing the frame Components
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public final JFrame Frame = new JFrame();
    private final JPanel RootPane = new JPanel();
    private final JPanel TitleBar = new JPanel();
    private final JPanel MenuBar = new JPanel();
    public final JPanel ContentPanel = new JPanel();

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Initializing the standard buttons
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private final JButton CloseButton = new JButton();
    private final JButton MaximizeButton = new JButton();
    private final JButton MinimizeButton = new JButton();
    private final JLabel Title = new JLabel();

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Initializing Icons
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    private final String CloseIconPath = "K:\\BlueIcons\\747818-ui-interface\\pngdownscaled\\034-cancel30x30";
    private final ImageIcon CloseIcon = new ImageIcon(CloseIconPath);

    private final String MaximizeIconPath = "K:\\BlueIcons\\747818-ui-interface\\pngdownscaled\\046-expand20x20";
    private final ImageIcon MaximizeIcon = new ImageIcon(MaximizeIconPath);

    private final String MinimizeIconPath = "K:\\BlueIcons\\747818-ui-interface\\pngdownscaled\\042-minus20x20";
    private final ImageIcon MinimizeIcon = new ImageIcon(MinimizeIconPath);

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Initializing the Variables the Bounds are Stored in
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private int FrameX = this.Frame.getX();
    private int FrameY = this.Frame.getY();
    private int FrameWidth = this.Frame.getWidth();
    private int FrameHeight = this.Frame.getHeight();

    public StandartFrame() {
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Preparing the Frame for Use in the Template
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        this.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.Frame.setUndecorated(false);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Preparing the default Layout for the frame
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        this.RootPane.setBounds(0,0,1920,1080);
        this.Frame.add(this.RootPane);

        this.TitleBar.setBounds(0,0,1920,30);
        this.MenuBar.setBounds(0,30,1920,20);
        this.ContentPanel.setBounds(0,0,1920,1030);

        this.RootPane.setLayout(null);

        this.RootPane.add(this.TitleBar);
        this.TitleBar.setLayout(null);
        this.RootPane.add(this.MenuBar);
        this.MenuBar.setLayout(null);
        this.RootPane.add(this.ContentPanel);
        this.ContentPanel.setLayout(null);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Preparing the Mouse Listeners for moving and resizing to Imitate the Standard Frame
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        this.Frame.getRootPane().addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                MouseX = MouseInfo.getPointerInfo().getLocation().getX();
                MouseY = MouseInfo.getPointerInfo().getLocation().getY();
                StandartFrame.this.SetXYWH();
                //Template.this.TestForMouseOnBorder(Template.this.FrameX, Template.this.FrameY, Template.this.FrameWidth, Template.this.FrameHeight);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                MouseX = MouseInfo.getPointerInfo().getLocation().getX();
                MouseY = MouseInfo.getPointerInfo().getLocation().getY();
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Preparing Closebutton, minimizebutton, maximizebutton and title
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        this.TitleBar.add(this.CloseButton);
        this.CloseButton.setBounds(1890, 5, 20, 20);
        this.CloseButton.setIcon(this.CloseIcon);
        this.CloseButton.setBorder(null);
        this.CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(777);
            }
        });

        this.TitleBar.add(this.MaximizeButton);
        this.MaximizeButton.setBounds(1860, 5, 20, 20);
        this.MaximizeButton.setIcon(this.MaximizeIcon);
        this.MaximizeButton.setBorder(null);
        this.MaximizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StandartFrame.this.SetBounds(0, 0, 1920, 1080);
                
            }
        });

        this.TitleBar.add(this.MinimizeButton);
        this.MinimizeButton.setBounds(1830, 5, 20, 20);
        this.MinimizeButton.setIcon(this.MinimizeIcon);
        this.MinimizeButton.setBorder(null);
        this.MinimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StandartFrame.this.Frame.toBack();
            }
        });
        this.TitleBar.add(this.Title);

        this.Title.setBounds(10, 0, 500, 20);
        this.Title.setIconTextGap(10);
        this.Title.setOpaque(false);
        this.TitleBar.add(this.Title);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // Preparing The Menu Bar
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        JTextField resizex = new JTextField();
        JTextField resizey = new JTextField();
        JButton resizeApply = new JButton("Apply");
        resizex.setBounds(10, 5, 50, 15);
        resizey.setBounds(70, 5, 50, 15);
        resizeApply.setBounds(130, 5, 100, 15);
        resizex.setOpaque(false);
        resizey.setOpaque(false);
        resizeApply.setBorder(null);
        resizex.setBorder(null);
        resizey.setBorder(null);
        resizeApply.setForeground(Color.WHITE);
        resizex.setForeground(Color.WHITE);
        resizey.setForeground(Color.WHITE);
        resizeApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(resizex.getText());
                int y = Integer.parseInt(resizey.getText());
                StandartFrame.this.Resize(x, y);
            }
        });
        this.MenuBar.add(resizex);
        this.MenuBar.add(resizey);
        this.MenuBar.add(resizeApply);
    }

    public void Resize(int width, int height) {
        this.Frame.setBounds(this.Frame.getX(), this.Frame.getY(), width, height);
    }

    public void close() {
        this.Frame.dispose();
    }

    public void setVisibility(Boolean b) {
        this.Frame.setVisible(b);
    }

    public void SetBounds(int x, int y, int width, int height) {
        this.Frame.setBounds(x, y, width, height);
        this.RootPane.setBounds(x, y, width, height);
        this.ContentPanel.setBounds(x, y, width, height);
    }

    public void enableAutoResizing(Boolean b) {
        this.AutoResize = b;
    }

    public void Move(int x, int y) {
        this.Frame.move(x, y);
    }

    public void SetTitleBarSize(int width, int height) {
        this.TitleBar.setBounds(0,0,width,height);
    }

    private void SetXYWH() {
        this.FrameX = this.Frame.getX();
        this.FrameY = this.Frame.getY();
        this.FrameWidth = this.Frame.getWidth();
        this.FrameHeight = this.Frame.getHeight();
    }

    public void TestForMouseOnBorder(int x, int y,int width, int height) {
        int UpperMaxHeight = y + 2;
        int UpperMinHeight = y - 30;
        int UpperMaxWidth = width;
        int UpperMinWidth = x;

        if(MouseX <= UpperMaxWidth && MouseX >= UpperMinWidth && MouseY <= UpperMaxHeight && MouseY >= UpperMinHeight) {
            //Cursor is on Upper Border
            System.out.println("Mouse on Upper Border");
            int x1 = 0;
            int y1 = 0;
            x1 = MouseX.intValue();
            y1 = MouseY.intValue();
            this.SetBounds(x1, y1, this.FrameWidth, this.FrameHeight);
        }
    }

    public void SetTitleBarBackground(Color color) {
        this.TitleBar.setBackground(color);
        this.MinimizeButton.setBackground(color);
        this.MaximizeButton.setBackground(color);
        this.CloseButton.setBackground(color);
        this.Title.setBackground(color);
    }

    public void SetMenuBarBackground(Color color) {
        this.MenuBar.setBackground(color);
    }

    public void SetContentPanelBackground(Color color) {
        this.ContentPanel.setBackground(color);
    }

    public void SetMasterBackground(Color color) {
        this.ContentPanel.setBackground(color);
        this.MenuBar.setBackground(color);
        this.TitleBar.setBackground(color);
        this.MinimizeButton.setBackground(color);
        this.MaximizeButton.setBackground(color);
        this.CloseButton.setBackground(color);
        this.Title.setBackground(color);
    }

    public void add(Component comp) {
        this.ContentPanel.add(comp);
    }

    public String GetBounds() {
        return this.FrameX + "," + this.FrameY + "," + this.FrameWidth + "," + this.FrameHeight;
    }

    public Boolean isrunning() {
        return this.isRunning;
    }

    public void SetTitle(String Title) {
        this.Title.setText(Title);
    }

    public void SetTitleColor(Color color) {
        this.Title.setForeground(color);
    }

    public void SetMaximizeIcon(Icon icon) {
        this.MaximizeButton.setIcon(icon);
    }

    public void SetMinimizeIcon(Icon icon) {
        this.MinimizeButton.setIcon(icon);
    }

    public void SetTitleIcon(Icon icon) {
        this.Title.setIcon(icon);
    }

    public void SetCloseIcon(Icon icon) {
        this.CloseButton.setIcon(icon);
    }

    public void SetWindowIcon(String path) {
        try {
            File pathToFile = new File(path);
            Image image = ImageIO.read(pathToFile);
            this.Frame.setIconImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void RemoveCustomTitleBar() {
        this.RootPane.remove(this.TitleBar);
    }

    public void AddStandartTitleBar() {
        this.Frame.setUndecorated(false);
    }

    public void RemoveMenuBar() {
        this.RootPane.remove(this.MenuBar);
    }

    public int getheigth() {
        return this.FrameHeight;
    }

    public int getWidth() {
        return this.FrameWidth;
    }

    public Component GetRootPane() {
        return this.Frame.getRootPane();
    }

    public Component getContentPane() {
        return this.Frame.getContentPane();
    }

    public void enableTransparency() {
        /*
        The frame cant be transparent without being undecorated
        //* set the value of "Undecorated" to True
        */
        this.Frame.setUndecorated(true);
        /*
        The RootPane as well as the Contentpane have to be transparent too
        //* set the value of "opaque" to False
        */
        this.RootPane.setOpaque(false);
        this.ContentPanel.setOpaque(false);

        /*
        //?make the Frame transparent
        //* set "opacity" to 0
        */
        this.Frame.setOpacity(Float.parseFloat("0.4"));
    }
}