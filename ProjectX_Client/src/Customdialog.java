
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class Customdialog {

    public JFrame dialog = new JFrame();
    private JPanel RootPane = new JPanel();
    public JPanel TitleBar = new JPanel();
    public JPanel ContentPane = new JPanel();

    private final JButton CloseButton = new JButton();
    private final JButton MaximizeButton = new JButton();
    private final JButton MinimizeButton = new JButton();
    private final JLabel Title = new JLabel();

    private final String CloseIconPath = "K:\\BlueIcons\\747818-ui-interface\\pngdownscaled\\034-cancel30x30";
    private final ImageIcon CloseIcon = new ImageIcon(CloseIconPath);

    public Customdialog() {
        this.dialog.setUndecorated(true);

        this.dialog.setVisible(true);
        this.dialog.getRootPane().setLayout(null);
        this.RootPane.setBounds(0, 0, 500, 250);
        this.RootPane.setLayout(null);
        this.dialog.getRootPane().add(this.RootPane);

        this.dialog.setBounds(300, 300, 500, 250);

        this.TitleBar.setBounds(0,0,500,30);
        this.TitleBar.setLayout(null);

        this.ContentPane.setBounds(1, 30, 498, (this.RootPane.getHeight() - 31));
        this.ContentPane.setLayout(null);

        this.TitleBar.add(this.CloseButton);
        this.CloseButton.setBounds(470, 5, 20, 20);
        this.CloseButton.setIcon(this.CloseIcon);
        this.CloseButton.setBorder(null);
        this.CloseButton.setOpaque(false);
        this.CloseButton.setBackground(this.TitleBar.getBackground());
        this.CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(777);
            }
        });

        this.Title.setBounds(10, 0, 250, 20);
        this.Title.setIconTextGap(10);
        this.Title.setOpaque(false);
        this.TitleBar.add(this.Title);

        this.RootPane.add(this.TitleBar);
        this.RootPane.add(this.ContentPane);
    }

    public void setPosition(int x, int y) {
        this.dialog.setBounds(x, y, this.dialog.getWidth(), this.dialog.getHeight());
    }

    public void setSize(int x, int y) {
        this.dialog.setBounds(this.dialog.getX(), this.dialog.getY(), x, y);
    }

    public void dialogColor(Color color) {
        this.TitleBar.setBackground(color);
        this.RootPane.setBackground(color);
        this.RootPane.updateUI();
    }

    public void IsError(String errorMessage) {
        try {
            ImageIcon icon = new ImageIcon("K:\\ColoredIcons\\3014079-cyber-security\\png\\025_security.png");
            this.Title.setIcon(icon);
            File pathToFile = new File("K:\\ColoredIcons\\3014079-cyber-security\\png\\025_security.png");
            Image image = ImageIO.read(pathToFile);
            this.dialog.setIconImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.dialogColor(Color.decode("#FF1744"));
        this.CloseButton.setBackground(this.TitleBar.getBackground());
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(this.ContentPane.getBackground());
        textArea.setForeground(Color.WHITE);
        textArea.setBounds(10, 10,400, 180);
        textArea.setText(errorMessage);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        this.ContentPane.add(textArea);

        JTextArea textArea2 = new JTextArea();
        textArea2.setBounds(10, 190, 400, 20);
        textArea2.setEditable(false);
        textArea2.setBackground(this.ContentPane.getBackground());
        textArea2.setForeground(Color.white);
        textArea2.setText("Feel free to close this window now");
        this.ContentPane.add(textArea2);

        this.ContentPane.updateUI();
    }

    public void SetCloseIcon(Icon icon) {
        this.CloseButton.setIcon(icon);
    }

    public void SetDialogIcon(Icon icon) {
        this.Title.setIcon(icon);
    }

    public void SetWindowIcon(String path) {
        try {
            File pathToFile = new File(path);
            Image image = ImageIO.read(pathToFile);
            this.dialog.setIconImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
            Customdialog dialog = new Customdialog();
            dialog.IsError(ex.toString());
        }
    }
}
