package PXfile;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class PXFileEditor {
    
    public PXFileEditor()    
    {
    }

    public void open(String path) 
    {
    }

    public void close(String internalFileID)
    {
    }

    public JPanel gui(Font font, Color textcolor, Color BackgroundColor, int width, int height)
    {
        return new PXeditorUI(font, textcolor, BackgroundColor, width, height);
    }

    public static void main(String[] args)
    {
        PXFileEditor pxfe = new PXFileEditor();
    }
}

class PXeditorUI extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = 227501463121395557L;
    public Font font = null;
    public Color backgorundColor = null;
    public Color TextColor = null;
    public int width = 0;
    public int height = 0;

    public PXeditorUI(Font font, Color textcolor, Color BackgroundColor, int width, int height)
    {
    }
}

class PXeditorUITab
{
    public int height = 0;
    public int width = 0;
    public PXeditorUI editorUI = null;
    public PXopenfile openfile = null;

    public PXeditorUITab(PXeditorUI editorUI, String filepath, PXopenfile openfile)
    {
        this.editorUI = editorUI;
        this.height = this.editorUI.height - 10;
        this.openfile = openfile;
    }
}