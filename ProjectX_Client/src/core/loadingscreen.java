package core;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class loadingscreen extends Thread {
    private JFrame frame = new JFrame();
    public LSHthread lsh = new LSHthread(this);
    public JTextField text2 = new JTextField();
    public boolean finished = false;
    public JProgressBar progress = new JProgressBar();

    public loadingscreen() {
    }

    public void run() {
        this.frame.setLayout(null);
        this.frame.setBounds(810, 290, 300, 500);
        this.frame.getContentPane().setLayout(null);
        this.frame.setResizable(false);
        this.frame.getContentPane().setBackground(Color.decode("#202029"));
        JTextField text = new JTextField();
        this.progress.setBounds(0, 450, 300, 10);
        this.progress.setMaximum(1000);
        this.progress.setValue(0);
        this.progress.setBackground(Color.decode("#202029"));
        this.progress.setForeground(Color.green);
        this.progress.setBorder(null);
        this.progress.setLayout(null);
        this.progress.setOpaque(true);
        this.progress.revalidate();
        text.setText("");
        text.setBounds(55, 200, 250, 50);
        text.setEditable(false);
        text.setOpaque(false);
        text.setBorder(null);
        text.setLayout(null);
        Font font = new Font("consolas", Font.BOLD + Font.ITALIC, 40);
        Font font2 = new Font("consolas", Font.BOLD + Font.ITALIC, 20);
        text.setFont(font);
        text.setForeground(Color.black);

        this.text2.setText("");
        this.text2.setBounds(65, 260, 250, 50);
        this.text2.setEditable(false);
        this.text2.setOpaque(false);
        this.text2.setBorder(null);
        this.text2.setLayout(null);
        this.text2.setFont(font2);
        this.text2.setForeground(Color.black);

        this.frame.getContentPane().add(this.progress);
        this.frame.getContentPane().add(text);
        this.frame.getContentPane().add(text2);
        this.frame.setVisible(false);
        this.frame.setVisible(true);
        this.frame.revalidate();
        String pool = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int waittime = 25;
        String title = "projectX";
        String finishedTitle = "";
        for (char I : title.toCharArray()) {
            String zeros = "";
            int zerocount = title.length() - finishedTitle.length();
            while (zeros.length() + 1 < zerocount) {
                zeros = zeros + "0";
            }
            for (char II : pool.toCharArray()) {
                text.setText(finishedTitle + II + zeros);
                text.revalidate();
                if (II == I) {
                    finishedTitle = finishedTitle + II;
                    break;
                }
                try {
                    Thread.sleep(waittime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void inscreaseprogress(int value) {
        int val = 0;
        while(val < value)
        {
            this.progress.setValue(this.progress.getValue() + 1);
            this.progress.setString(((this.progress.getValue() / 10) + "%"));
            this.progress.revalidate();
            this.frame.revalidate();
            val++;
            //System.out.println("loading " + ((this.progress.getValue() / 10) + "%"));
            this.text2.setText("loading " + ((this.progress.getValue() / 10) + "%"));
        }
    }

    public static void main(String[] args) {
        loadingscreen loadingscreen = new loadingscreen();
    }
}

class LSHthread extends Thread {
    private loadingscreen ls = null;

    public LSHthread(loadingscreen ls) {
        this.ls = ls;
    }

    public void run() {
        while (!this.ls.finished) {
            try {
                this.sleep(100);
                System.out.println("test");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public short inscreaseprogress(int value)
    {
        this.interrupt();
        short respond = 1;
        try
        {
            this.ls.inscreaseprogress(value);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            respond = 0;
        }
        return respond;
    }

    public short proceed()
    {
        this.interrupt();
        short respond = 1;
        try
        {
            /*this.ls.stepfinished();*/
        }
        catch(Exception e)
        {
            e.printStackTrace();
            respond = 0;
        }
        return respond;
    }
}