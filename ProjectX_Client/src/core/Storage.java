package core;
import java.awt.Color;
import java.awt.Font;
import types.user;

public class Storage {
    public Storage() {
    }

    //meta
    public String installPath = "/root/PROJECTX/repos/projectx_linux/";
    public String sourcePath  = "/root/PROJECTX/repos/projectx_linux/ProjectX_Client/src/";

    public String defaultCryptoKey = "";
    public String CurrentServer = "Server_Test";
    public String CurrentTheme = "Dark";
    public String CustomFont = "Default";
    public String Language = "English";

    public user CurrentUser = null;

    public Color CustomTextColor = null;
    public Color CustomSecondaryTextColor = null;
    public Color CustomBackgroundColor = Color.DARK_GRAY;

    public int MasterVolume = 100;
    public int FXVolume = 100;
    public int VoiceVolume = 100;
    public int MusicVolume = 100;

    public Font font = new Font("consolas", Font.BOLD + Font.ITALIC, 20);

    //* initiate
    public int initiate() { // Reads the user preferences from ../userpreferences.json
        int sucsess = 0;
        return sucsess;
    }

    //? retrieve information

    public String CurrentServer() {
        return this.CurrentServer;
    }

    public String CurrentTheme() {
        return this.CurrentTheme;
    }

    public user CurrentUser() {
        return this.CurrentUser;
    }

    public String CurrentFont() {
        return this.CustomFont;
    }

    public String Language() {
        return this.Language;
    }

    public Color CustomTextColor() {
        return this.CustomTextColor;
    }

    public Color CustomBackgroundColor() {
        return this.CustomBackgroundColor;
    }

    //! change information
}