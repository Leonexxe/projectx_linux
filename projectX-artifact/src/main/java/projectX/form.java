
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("all")
public class form extends JPanel{

    public ArrayList<input> input_list = new ArrayList<input>();
    public form() {
    }

    public void addTextField()
    {
    }

    public void addPasswordField()
    {
    }

    public void addFileField()
    {
    }

    public void addNumberField()
    {
        JPanel panel = new JPanel();
    }

    public void delete() {
        int size = this.input_list.size();
        int pos = 0;
        while(pos <= size) {
            this.input_list.get(pos).delete();
            pos++;
        }
        this.input_list = null;
    }
}
