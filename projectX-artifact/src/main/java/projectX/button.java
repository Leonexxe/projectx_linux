
/*////////////////////////////////////////////////////////////////////////////////////////////////////*/
//
//projectX classes
//
/*////////////////////////////////////////////////////////////////////////////////////////////////////*/

/*////////////////////////////////////////////////////////////////////////////////////////////////////*/
//
//external classes
//
/*////////////////////////////////////////////////////////////////////////////////////////////////////*/
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

@SuppressWarnings("all")
public class button extends JPanel{

    public JButton Button = new JButton();
    public icon Icon = null;

    public button(String text,icon IconFB) {
        this.isOpaque();
        this.Button.setText(text);
        this.Icon = IconFB;
        this.Button.setIcon(this.Icon.imageicon);
    }

    public void setBounds(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.Button.setBounds(x, y, width, height);
    }

    public void setForeground(Color color) {
        this.Button.setForeground(color);
    }

    public void setBackground(Color color) {
        this.Button.setBackground(color);
    }
}
