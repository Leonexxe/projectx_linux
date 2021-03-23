package PXfile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PXFileWriter {
    public FileWriter writer = null;

    public PXFileWriter(String filepath) {
        try {
            this.writer = new FileWriter(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(ArrayList<String> lines)
    {
    }

    public void write(String[] lines)
    {
    }

    public void write()
    {
    }

    public void append()
    {
    }
}
