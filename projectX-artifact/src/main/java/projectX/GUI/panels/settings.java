package GUI.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import json.*;
import core.Client;
import GUI.components.settings.settingscroller;
import GUI.components.ImagePanel;
import types.setting;

public class settings extends JPanel {
      /**
      *
      */
      public JButton apply = new JButton();
      private static final long serialVersionUID = -3978974315271206359L;
      public Json json = null;
      public settingscroller scroll = null;
      public Client client = null;


      public settings(Json json, Client client) {
            System.out.println("setting panel initiated");
            this.client = client;
            this.json = json;
            this.scroll = new settingscroller(this.client);
            this.setLayout(null);
            this.setBounds(300, 0, 1620, 1080);
            this.setOpaque(false);

            for (JsonData I : json.JsonToArray(json.mainJsonGroup)) {
                  System.out.println("adding setting: " + I.name);
                  if (I.path.contains("colors")) {
                        scroll.addsetting(I.name, "custom", I.value, I.path);
                  } 
                  else if(I.name.contentEquals("transparency-value"))
                  {
                        scroll.addsetting(I.name, "custom", I.value, I.path);
                  }
                  else 
                  {
                        this.scroll.addsetting(I.name, "true/false", I.value, I.path);
                  }
                  this.revalidate();
            }

            this.scroll.SetBounds(0, 0, 1620,  scroll.verticalIndent + 100);
            this.add(this.scroll.gui);

            this.apply.setBounds(700, scroll.verticalIndent + 120, 200, 50);
            this.apply.setBackground(Color.green);
            this.apply.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("apply button was pressed");
                        for(setting I : scroll.settings)
                        {
                              I.apply(json);
                              System.out.println("setting " + settings.this.json.getObject(I.jsonPath).name + " was applied");
                        }
                        settings.this.json.save();
                        System.out.println("settings saved");
                  }
            });
            this.apply.revalidate();
            this.add(this.apply);

            this.setBounds(300, 0, 1620, scroll.verticalIndent + 320);
            this.add(new ImagePanel("E:\\semitransparent.png", 1620, 1080));
            this.setVisible(false);
            this.revalidate();
      }
}
