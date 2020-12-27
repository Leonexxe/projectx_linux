
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class sidebar extends JPanel {

      /**
       *
       */
      private static final long serialVersionUID = 4974333911300917459L;

      public sidebar(GUI gui) {
            this.setBounds(0, 0, 300, 1080);
            this.setLayout(null);
            JButton settingsButton = new JButton();
            settingsButton.setIcon(Icons.GreenSettings);
            settingsButton.setBounds(25, 25, 256, 256);
            settingsButton.setOpaque(false);
            settingsButton.setBorder(null);
            settingsButton.setBackground(Color.black);
            settingsButton.revalidate();
            settingsButton.addActionListener(new ActionListener() 
            {
                  @Override
                  public void actionPerformed(ActionEvent e) 
                  {
                        gui.Settings.setVisible(true); 
                        gui.Settings.revalidate();
                        gui.dmPanel.setVisible(false);
                        gui.dmPanel.revalidate();
                  }
            }); 
            this.add(settingsButton);

            JButton dmButton = new JButton();
            dmButton.setBounds(25, 300, 256, 256);
            dmButton.setOpaque(false);
            dmButton.setBorder(null);
            dmButton.setBackground(Color.green);
            dmButton.revalidate();
            dmButton.addActionListener(new ActionListener() 
            {
                  @Override
                  public void actionPerformed(ActionEvent e) 
                  {
                        gui.dmPanel.setVisible(true); 
                        gui.dmPanel.revalidate();
                        gui.Settings.setVisible(false);
                        gui.Settings.revalidate();
                  }
            }); 
            this.add(dmButton);
            this.add(new ImagePanel("E:\\semitransparent.png", 300, 1080));
            this.add(new ImagePanel("E:\\semitransparent.png", 300, 1080));
            this.setOpaque(false);
      }
}
