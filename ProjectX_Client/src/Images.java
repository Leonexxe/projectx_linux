
import javax.swing.*;

public class Images {
    public static ImageIcon cityscapes[] = new ImageIcon[27];
    public static ImageIcon landscapes[] = new ImageIcon[14];

    public static void load() {
        landscapes[1]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape1.jpg");
        landscapes[2]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape2.jpg");
        landscapes[3]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape3.jpg");
        landscapes[4]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape4.jpg");
        landscapes[5]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape5.jpg");
        landscapes[6]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape6.jpg");
        landscapes[7]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape7.jpg");
        landscapes[8]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape8.jpg");
        landscapes[9]   = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape9.jpg");
        landscapes[10]  = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape10.jpg");
        landscapes[11]  = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape11.jpg");
        landscapes[12]  = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape12.jpg");
        landscapes[13]  = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape13.jpg");
        landscapes[14]  = new ImageIcon("src\\projectX\\graphics\\images\\landscapes\\landscape14.jpg");

        cityscapes[1]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape1.jpg");
        cityscapes[2]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape2.jpg");
        cityscapes[3]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape3.jpg");
        cityscapes[4]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape4.jpg");
        cityscapes[5]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape5.jpg");
        cityscapes[6]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape6.jpg");
        cityscapes[7]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape7.jpg");
        cityscapes[8]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape8.jpg");
        cityscapes[9]   = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape9.jpg");
        cityscapes[10]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape10.jpg");
        cityscapes[11]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape11.jpg");
        cityscapes[12]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape12.jpg");
        cityscapes[13]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape13.jpg");
        cityscapes[14]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape14.jpg");
        cityscapes[15]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape15.jpg");
        cityscapes[16]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape16.jpg");
        cityscapes[17]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape17.jpg");
        cityscapes[18]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape18.jpg");
        cityscapes[19]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape19.jpg");
        cityscapes[20]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape20.jpg");
        cityscapes[21]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape21.jpg");
        cityscapes[22]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape22.jpg");
        cityscapes[23]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape23.jpg");
        cityscapes[24]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape24.jpg");
        cityscapes[25]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape25.jpg");
        cityscapes[26]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape26.jpg");
        cityscapes[27]  = new ImageIcon("src\\projectX\\graphics\\images\\cityscapes\\cityscape27.jpg");
    }

    public static ImageIcon random() {
        ImageIcon image = null;
        Double random = Math.random();
        if(random < 0) {
            // landscapes
            image = landscapes[math.random(1, 14)];
        }
        else {
            // cityscapes
            image = cityscapes[math.random(1, 27)];
        }
        return image;
    }
}
