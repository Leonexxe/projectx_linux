package PXfile;

public class PXopenfile {

    public PXFileWriter writer = null;
    public PXFileReader reader = null;
    
    public PXopenfile(String path)
    {
    }

    public String[] fileContents()
    {
        String[] lines = new String[this.reader.lines.size()];
        int line = 0;
        for(String I : this.reader.lines)
        {
            lines[line++] = I;
        }
        return lines;
    }

    public void save()
    {
        //this.writer.save();
    }

    public void close()
    {
    }
}
