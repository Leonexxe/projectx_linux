
/*////////////////////////////////////////////////////////////////////////////////////////////////////*/
//
//external classes
//
/*////////////////////////////////////////////////////////////////////////////////////////////////////*/
import javax.swing.*;
import java.io.File;

public class Icons {

    //    Icons made by Freepik from www.flaticon.com     //
    //    https://www.flaticon.com/de/autoren/freepik     //

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Paths
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //Folder Path
    public static String Blue_Folder_Path       = "src\\projectX\\graphics\\icons\\Blue\\";
    public static String Green_Folder_Path  	= "E:\\ProjectX_Client\\ProjectX_Client\\src\\projectX\\graphics\\icons\\Green\\";
    public static String Pink_Folder_Path       = "src\\projectX\\graphics\\icons\\Pink\\";
    public static String IconBasePath           = "src\\projectX\\graphics\\icons\\";

    //Logo
    public static File pngLogoPath          = new File("E:\\ProjectX_Client\\ProjectX_Client\\src\\projectX\\graphics\\icons\\app.png");
    public static File icoLogoPath          = new File("E:\\ProjectX_Client\\ProjectX_Client\\src\\projectX\\graphics\\icons\\app.ico");

    //Blue
    public static File BluePlayPath         = new File(Blue_Folder_Path     + "022-play30x30.png"           );
    public static File BlueLinePath         = new File(Blue_Folder_Path     + "042-minus20x20.png"          );
    public static File BlueCheckPath        = new File(Blue_Folder_Path     + "151-check30x30.png"          );
    public static File BlueCrossPath        = new File(Blue_Folder_Path     + "034-cancel30x30.png"         );
    public static File BlueExpandPath       = new File(Blue_Folder_Path     + "046-expand20x20.png"         );
    public static File BlueMinimizePath     = new File(Blue_Folder_Path     + "051-minimize20x20.png"       );
    public static File BlueThunderboltPath  = new File(Blue_Folder_Path     + "138-thunderbolt30x30.png"    );
    //Green
    public static File GreenPlayPath        = new File(Green_Folder_Path    + "022-play30x30.png"           );
    public static File GreenLinePath        = new File(Green_Folder_Path    + "042-minus20x20.png"          );
    public static File GreenCheckPath       = new File(Green_Folder_Path    + "151-check30x30.png"          );
    public static File GreenCrossPath       = new File(Green_Folder_Path    + "034-cancel30x30.png"         );
    public static File GreenExpandPath      = new File(Green_Folder_Path    + "046-expand20x20.png"         );
    public static File GreenMinimizePath    = new File(Green_Folder_Path    + "051-minimize20x20.png"       );
    public static File GreenThunderboltPath = new File(Green_Folder_Path    + "138-thunderbolt30x30.png"    );
    public static File GreenSettingsPath    = new File(Green_Folder_Path    + "142-settings256x256.png"     );
    //Pink
    public static File PinkPlayPath        = new File(Pink_Folder_Path    + "022-play30x30.png"             );
    public static File PinkLinePath        = new File(Pink_Folder_Path    + "042-minus20x20.png"            );
    public static File PinkCheckPath       = new File(Pink_Folder_Path    + "151-check30x30.png"            );
    public static File PinkCrossPath       = new File(Pink_Folder_Path    + "034-cancel30x30.png"           );
    public static File PinkExpandPath      = new File(Pink_Folder_Path    + "046-expand20x20.png"           );
    public static File PinkMinimizePath    = new File(Pink_Folder_Path    + "051-minimize20x20.png"         );
    public static File PinkThunderboltPath = new File(Pink_Folder_Path    + "138-thunderbolt30x30.png"      );
    public static File PinkSettingsPath    = new File(Pink_Folder_Path    + "142-settings256x256.png"       );

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Icons
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //Logo
    public static ImageIcon pngLogo             = new ImageIcon(pngLogoPath             .getPath());
    public static ImageIcon icoLogo             = new ImageIcon(icoLogoPath             .getPath());
    //Blue
    public static ImageIcon BlueLine            = new ImageIcon(BlueLinePath            .getPath());
    public static ImageIcon BluePlay            = new ImageIcon(BluePlayPath            .getPath());
    public static ImageIcon BlueCross           = new ImageIcon(BlueCrossPath           .getPath());
    public static ImageIcon BlueCheck           = new ImageIcon(BlueCheckPath           .getPath());
    public static ImageIcon BlueMaximize        = new ImageIcon(BlueExpandPath          .getPath());
    public static ImageIcon BlueMinimize        = new ImageIcon(BlueMinimizePath        .getPath());
    public static ImageIcon BlueThunderbolt     = new ImageIcon(BlueThunderboltPath     .getPath());
    //Green
    public static ImageIcon GreenLine           = new ImageIcon(GreenLinePath           .getPath());
    public static ImageIcon GreenPlay           = new ImageIcon(GreenPlayPath           .getPath());
    public static ImageIcon GreenCross          = new ImageIcon(GreenCrossPath          .getPath());
    public static ImageIcon GreenCheck          = new ImageIcon(GreenCheckPath          .getPath());
    public static ImageIcon GreenMaximize       = new ImageIcon(GreenExpandPath         .getPath());
    public static ImageIcon GreenMinimize       = new ImageIcon(GreenMinimizePath       .getPath());
    public static ImageIcon GreenThunderbolt    = new ImageIcon(GreenThunderboltPath    .getPath());
    public static ImageIcon GreenSettings       = new ImageIcon(GreenSettingsPath       .getPath());
    //Pink
    public static ImageIcon PinkLine           = new ImageIcon(PinkLinePath             .getPath());
    public static ImageIcon PinkPlay           = new ImageIcon(PinkPlayPath             .getPath());
    public static ImageIcon PinkCross          = new ImageIcon(PinkCrossPath            .getPath());
    public static ImageIcon PinkCheck          = new ImageIcon(PinkCheckPath            .getPath());
    public static ImageIcon PinkMaximize       = new ImageIcon(PinkExpandPath           .getPath());
    public static ImageIcon PinkMinimize       = new ImageIcon(PinkMinimizePath         .getPath());
    public static ImageIcon PinkThunderbolt    = new ImageIcon(PinkThunderboltPath      .getPath());
    public static ImageIcon PinkSettings       = new ImageIcon(PinkSettingsPath         .getPath());

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // Checking Icon Paths
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void CheckIconpaths(system System) {
        /*
        System.out("checking icon paths...", "note");

        //Logo
        System.out("...Logo...", "note");
        System.out("...pngLogo: "             + pngLogoPath             .exists(),       "note");
        System.out("...icoLogo: "             + icoLogoPath             .exists(),       "note");

        //Blue
        System.out("...Blue...", "note");
        System.out("...BlueLine: "             + BlueLinePath             .exists(),       "note");
        System.out("...BluePlay: "             + BluePlayPath             .exists(),       "note");
        System.out("...BlueCheck: "            + BlueCheckPath            .exists(),       "note");
        System.out("...BlueCross: "            + BlueCrossPath            .exists(),       "note");
        System.out("...BlueMaximize: "         + BlueExpandPath           .exists(),       "note");
        System.out("...BlueMinimize: "         + BlueMinimizePath         .exists(),       "note");
        System.out("...BlueThunderbolt: "      + BlueThunderboltPath      .exists(),       "note");
        //Green
        System.out("...Green...", "note");
        System.out("...GreenLine: "            + GreenLinePath            .exists(),       "note");
        System.out("...GreenPlay: "            + GreenPlayPath            .exists(),       "note");
        System.out("...GreenCheck: "           + GreenCheckPath           .exists(),       "note");
        System.out("...GreenCross: "           + GreenCrossPath           .exists(),       "note");
        System.out("...GreenMaximize: "        + GreenExpandPath          .exists(),       "note");
        System.out("...GreenMinimize: "        + GreenMinimizePath        .exists(),       "note");
        System.out("...GreenThunderbolt: "     + GreenThunderboltPath     .exists(),       "note");
        System.out("...GreenSettigns: "        + GreenSettingsPath        .exists(),       "note");
        //Pink
        System.out("...Pink...", "note");
        System.out("...PinkLine: "            + PinkLinePath              .exists(),       "note");
        System.out("...PinkPlay: "            + PinkPlayPath              .exists(),       "note");
        System.out("...PinkCheck: "           + PinkCheckPath             .exists(),       "note");
        System.out("...PinkCross: "           + PinkCrossPath             .exists(),       "note");
        System.out("...PinkMaximize: "        + PinkExpandPath            .exists(),       "note");
        System.out("...PinkMinimize: "        + PinkMinimizePath          .exists(),       "note");
        System.out("...PinkThunderbolt: "     + PinkThunderboltPath       .exists(),       "note");
        System.out("...PinkSettigns: "        + PinkSettingsPath          .exists(),       "note");
        */
    }
}