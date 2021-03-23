package types;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import GUI.components.settings.*;
import core.*;
import json.*;
import GUI.components.*;

public class setting extends JPanel {
      /**
      *
      */
      private static final long serialVersionUID = -3138950816375289591L;
      private JButton ButtonDisabled = new JButton();
      private JButton ButtonEnabled = new JButton();
      private JTextArea Text = new JTextArea();
      private JTextArea textArea = new JTextArea();
      private JTextArea textArea2 = new JTextArea();
      public String jsonPath = "";

      /**
      *
      */
      public setting(settingscroller SettingScroller, Font font, String text, String options, String value, String jsonPath) {
            this.setLayout(null);
            this.jsonPath = jsonPath;

            this.setOpaque(false);

            this.setBounds(0, SettingScroller.verticalIndent, 1610, 40);

            this.Text.setFont(font);
            this.Text.setText(text);
            this.Text.setBounds(0, 10, 1300, 30);
            this.Text.setOpaque(false);
            this.Text.setEditable(false);
            this.Text.setForeground(SettingScroller.client.storage.CustomTextColor);
            this.add(Text);

            // ? button disabled
            this.ButtonDisabled.setBounds(1250, 10, 150, 30);
            this.ButtonDisabled.setOpaque(true);
            this.ButtonDisabled.setBackground(Color.red);
            this.ButtonDisabled.addActionListener(new ActionListener() 
            {

                  @Override
                  public void actionPerformed(ActionEvent e) {
                        setting.this.ButtonEnabled.setVisible(true);
                        setting.this.ButtonDisabled.setVisible(false);
                        setting.this.textArea.setText("on");
                  }
                  
            });
            // ? button enabled
            this.ButtonEnabled.setBounds(1250, 10, 150, 30);
            this.ButtonEnabled.setOpaque(true);
            this.ButtonEnabled.setBackground(Color.green);
            this.ButtonEnabled.addActionListener(new Act
            public time(hour Hours,minute Minutes,second Seconds, millisecond Milliseconds) {
            }
      
            public time(int Hours,int Minutes,int Seconds,int Milliseconds) {
            }
      
            public time(String[] args)
            {
                  if(args[0] == "now")
                  {
                        this.Hours =  new millisecond(System.currentTimeMillis()).toHours();
                        if(this.Hours.toMinutes().Value >= 1 && this.Hours.toMinutes().Value <= 60)
                        {
                              this.Minutes = this.Hours.toMinutes();
                        }
                  }
            }
      
            public time(String formatedTime) {
                  // encoding Formated Time string
                  String[] deFormatedTime = formatedTime.split(":");
                  if(deFormatedTime[1] != null) {
                        this.Hours = new hour(Integer.parseInt(deFormatedTime[1]));
                  }
                  if(deFormatedTime[2] != null) {
                        this.Minutes = new minute(Integer.parseInt(deFormatedTime[2]));
                  }
                  if(deFormatedTime[3] != null) {
                        this.Seconds = new second(Integer.parseInt(deFormatedTime[3]));
                  }
                  if(deFormatedTime[4] != null) {
                        this.Milliseconds = new millisecond(Integer.parseInt(deFormatedTime[4]));
                  }
            }
      }
      ionListener() 
            {

                  @Override
                  public void actionPerformed(ActionEvent e) {
                        setting.this.ButtonEnabled.setVisible(false);
                        setting.this.ButtonDisabled.setVisible(true);
                        setting.this.textArea.setText("off");
                  }
                  
            });
            //? textarea
            this.textArea.setBounds(1250, 10, 150, 30);
            this.textArea.setOpaque(false);
            this.textArea.setEditable(true);
            this.textArea.setForeground(Color.white);
            this.textArea.setFont(font);
            this.textArea.setText(value);
            //? textarea 2
            this.textArea2.setBounds(1410, 10, 200, 30);
            this.textArea2.setOpaque(false);
            this.textArea2.setEditable(false);
            this.textArea2.setForeground(SettingScroller.client.storage.CustomSecondaryTextColor);
            this.textArea2.setFont(font);
            this.textArea2.setText("default: " + value);
            this.add(this.textArea2);

            if(options.contentEquals("true/false"))
            {
                  this.add(this.ButtonDisabled);
                  this.add(this.ButtonEnabled);
                  if(value.contentEquals("on"))
                  {
                        this.ButtonDisabled.setVisible(false);
                        this.ButtonEnabled.setVisible(true);
                  }
                  else
                  {
                        this.ButtonEnabled.setVisible(false);
                        this.ButtonDisabled.setVisible(true);
                  }
            }
            else if(options.contentEquals("custom"))
            {
                  this.add(this.textArea);
            }

            this.add(new ImagePanel("E:\\semitransparent.png", 1610, 40));
            SettingScroller.verticalIndent += 50;
      }

      public void apply(Json json)
      {
            json.getObject(this.jsonPath).value = this.textArea.getText();
      }
}
