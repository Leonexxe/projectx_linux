package PXfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PXFileReader {
      private FileReader reader = null;
      private BufferedReader buffReader = null;
      private File file = null;

      public ArrayList<String> lines = new ArrayList<String>();

      private int currentLine = 0;

      private String write = "";

      public PXFileReader(String path) {
            this.file = new File(path);
            try {
                  this.reader = new FileReader(this.file);
                  //this.writer = new FileWriter(this.file);
                  this.buffReader = new BufferedReader(this.reader);
            } catch (IOException e) {
                  e.printStackTrace();
            }
            try {
                  this.readFile();
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }

      // public methods
      public boolean delete() {
            return this.file.delete();
      }

      public void close() throws IOException {
            this.reader.close();
      }

      public void append(String append, Boolean newLine) {
            if(newLine) {
                  this.write = this.write + "\r\n" + append;
            }
            else{
                  this.write = this.write + append;
            }
      }

      public String nextLine() {
            this.currentLine++;
            return this.lines.get(this.currentLine);
      }

      public String getLine(int index) {
            return this.lines.get(index);
      }

      // private methods
      private void readFile() throws IOException {
            String line = "";
            int currLine = 1;
            while((line = buffReader.readLine())!=null) {
                  this.lines.add(line);
                  System.out.println(line);
                  currLine++;
            }
            System.out.println("no more lines");
      }
      
      public static void main(String[] args) {
            PXFileReader file = new PXFileReader("userSettings.txt");
      }
}