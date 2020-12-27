
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class log extends Thread {

    public String folder = "";
    public system sys = null;
    public core core = null;

    public log(core core) {
        this.core = core;
        this.run();
    }

    public void run() {
        //writing to the new log file
        this.out("init", "INFO");
    }

    public void out(String log_message, String type) {
        try {
            File myObj = new File(".log");
            /*
            Scanner myReader = new Scanner(myObj);
            String content = "";
            int line = 1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine() + "\n";
                content = content + data;
                line++;
            }
            myReader.close();

            content = content + get_DateTime() + " : ["+line+"] : ["+type.toUpperCase()+"] : " + log_message;
            */
            String content = get_DateTime() + " : [] : ["+type.toUpperCase()+"] : " + log_message;

            FileWriter writer = new FileWriter(myObj);
            writer.append(content);
            writer.close();
            modifications(content);
        } catch (IOException e) {
        }
    }

    private void modifications(String content)
    {
        /*
         * the String "content" contains all the information about the event wich just happend and was just written in the log file.
         * please keep in mind that your modifications could be overwritten by any future update so better save them in a extra file outside of this folder.
         */
    }

    public void delete() {
        try {
            FileWriter writer = new FileWriter(this.core.client.storage.installPath + "\\error.log");
            writer.append(get_DateTime() + " : [INFO] : error log file Created");
            writer.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        try {
            File file = new File(this.core.client.storage.installPath + "\\.log");
            FileWriter writer = new FileWriter(file);
            writer.append(get_DateTime() + " : [INFO] : log file Created");
            writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static String get_DateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");

        String formattedDate = myDateObj.format(myFormatObj);

        return formattedDate;
    }
}