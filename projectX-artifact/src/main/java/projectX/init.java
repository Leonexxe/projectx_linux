import java.io.FileWriter;
import java.io.IOException;

import PXfile.*;

public class init {
    public static void main(String[] args) {
        PXFileReader reader = new PXFileReader("ProjectX_Client/src/startup.txt");
        try {
            FileWriter writer = new FileWriter("ProjectX_Client/src/Startup.java");
            String data = "";
            data = data + ("\r\n public class startup");
            data = data + ("\r\n {");
            data = data + ("\r\n     public class main(String[] args)");
            data = data + ("\r\n     {");
            for(String line : reader.lines)
            {
                data = data + ("\r\n"+line);
            }
            data = data + ("\r\n     }");
            data = data + ("\r\n }");
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}