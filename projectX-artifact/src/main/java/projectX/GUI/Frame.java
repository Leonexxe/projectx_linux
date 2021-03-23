package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
      /**
       *
       */
      private static final long serialVersionUID = 1282276297036517076L;

      public Frame() {
            //this.setTransparency(Float.parseFloat("0.8"));
            this.loadTitleBar();
            /*this.setIconImage(Icons.pngLogo.getImage());*/
            this.setTitle("projectX alpha 1.0");
            this.revalidate();
      }

      public void loadDefault() {
            /*
             * ? this method just loads some default settings such as position and size
             */
            this.setLayout(null); // ? layout
            this.setBounds(0, 0, 1920, 1080); // ? Position and size
            this.setVisible(true); // ? Visibility
      }

      public void setTransparency(Float value) {
            /*
             * ? method for making the frame transparent ? it just passes the value given as
             * the first parameter ? to the "setOpacity" function of the Frame
             */

            // * the Frame has to be undecorated in order to be transparent
            //this.setUndecorated(true);
            this.setResizable(true);
            // * actually making the frame transparent
            this.setOpacity(value);
      }

      public void loadTitleBar() {
            JPanel TitleBar = new JPanel();
            TitleBar.setBounds(0, 0, 1920, 40);
            TitleBar.setLayout(null);

            JButton close = new JButton();
            close.setBounds(1880, 5, 30, 30);
            close.setBackground(Color.red);
            TitleBar.add(close);

            //this.add(TitleBar);

            /*
             * ? implementing the listeners for the buttons in the title bar
             */
            close.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        Frame.this.dispose();
                  }
            });
      }

      public void setMasterBackground(Color color) {
            this.rootPane.setBackground(color);
            this.getContentPane().setBackground(color);
      }
}
