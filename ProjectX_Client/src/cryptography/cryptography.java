package cryptography;
import java.util.ArrayList;

public class cryptography {

    private static String[] chars = new String[175];



    public static String decrypt(String rawcode, String Message) {

        chars[0] = ".";

        chars[1] = "a";

        chars[2] = "b";

        chars[3] = "c";

        chars[4] = "d";

        chars[5] = "e";

        chars[6] = "f";

        chars[7] = "g";

        chars[8] = "h";

        chars[9] = "i";

        chars[10] = "j";

        chars[11] = "k";

        chars[12] = "l";

        chars[13] = "m";

        chars[14] = "n";

        chars[15] = "o";

        chars[16] = "p";

        chars[17] = "q";

        chars[18] = "r";

        chars[19] = "s";

        chars[20] = "t";

        chars[21] = "t";

        chars[22] = "u";

        chars[23] = "v";

        chars[24] = "w";

        chars[25] = "x";

        chars[26] = "y";

        chars[27] = "z";

            //Uppercase

        chars[28] = "A";

        chars[29] = "B";

        chars[30] = "C";

        chars[31] = "D";

        chars[32] = "E";

        chars[33] = "F";

        chars[34] = "G";

        chars[35] = "H";

        chars[36] = "I";

        chars[37] = "J";

        chars[38] = "K";

        chars[39] = "L";

        chars[40] = "M";

        chars[41] = "N";

        chars[42] = "O";

        chars[43] = "P";

        chars[44] = "Q";

        chars[45] = "R";

        chars[46] = "S";

        chars[47] = "T";

        chars[48] = "U";

        chars[49] = "V";

        chars[50] = "W";

        chars[51] = "X";

        chars[52] = "Y";

        chars[53] = "Z";

        // Ä Ü Ö

        chars[54] = "ä";

        chars[55] = "ü";

        chars[56] = "ö";

        chars[57] = "Ä";

        chars[58] = "Ü";

        chars[59] = "Ö";

        //Basic Maths

        chars[60] = "+";

        chars[61] = "-";

        chars[62] = "*";

        chars[63] = "/";

        //Numbers

        chars[64] = "0";

        chars[65] = "1";

        chars[66] = "2";

        chars[67] = "3";

        chars[68] = "4";

        chars[69] = "5";

        chars[70] = "6";

        chars[71] = "7";

        chars[72] = "8";

        chars[73] = "9";

        //Curency

        chars[74] = "$";

        chars[75] = "£";

        chars[76] = "¥";

        chars[77] = "¢";

        chars[78] = "¤";

        //Othes

        chars[79] = "®";

        chars[80] = "©";

        chars[81] = "ª";

        chars[82] = "º";

        chars[83] = "½";

        chars[84] = "¼";

        chars[85] = "¾";

        chars[86] = "¹";

        chars[87] = "³";

        chars[88] = "²";

        chars[89] = "ƒ";

        chars[90] = "±";

        chars[92] = "×";

        chars[93] = "÷";

        chars[94] = "�?";

        chars[95] = "ï";

        chars[96] = "á";

        chars[97] = "é";

        chars[98] = "í";

        chars[99] = "ó";

        chars[100] = "ú";

        chars[101] = "�?";

        chars[102] = "É";

        chars[103] = "�?";

        chars[104] = "Ó";

        chars[105] = "Ú";

        chars[106] = "Ñ";

        chars[107] = "ñ";

        chars[109] = "@";

        chars[110] = "¿";

        chars[111] = "¡";

        chars[112] = "!";

        chars[113] = ":";

        chars[114] = "/";

        chars[115] = "\\";

        chars[116] = "!";

        chars[117] = "\"";

        chars[118] = "#";

        chars[119] = "$";

        chars[120] = "%";

        chars[121] = "&";

        chars[122] = "'";

        chars[123] = "(";

        chars[124] = ")";

        chars[125] = "*";

        chars[126] = "Ø";

        chars[127] = "ø";

        chars[128] = "ÿ";

        chars[129] = "û";

        chars[130] = "ô";

        chars[131] = "Æ";

        chars[132] = "æ";

        chars[133] = "Å";

        chars[134] = "î";

        chars[135] = ":";

        chars[136] = ";";

        chars[137] = " ";

        chars[138] = "<";

        chars[139] = "=";

        chars[140] = ">";

        chars[141] = "?";

        chars[142] = "^";

        chars[143] = "_";

        chars[144] = "]";

        chars[145] = "[";

        chars[146] = "|";

        chars[147] = "}";

        chars[148] = "{";

        chars[149] = "~";

        chars[150] = "¬";

        chars[151] = "«";

        chars[152] = "»";

        chars[153] = "░";

        chars[154] = " ";

        chars[155] = "▒";

        chars[156] = "▓";

        chars[157] = "│";

        chars[158] = "┤";

        chars[160] = "╣";

        chars[161] = "╗";

        chars[163] = "�?";

        chars[164] = "�?";

        chars[165] = "└";

        chars[166] = "┴";

        chars[167] = "┬";

        chars[168] = "├";

        chars[169] = "─";

        chars[170] = "┼";

        chars[171] = "╚";

        chars[172] = "╔";

        chars[173] = "�?";

        chars[174] = "Þ";

        String[] keys = rawcode.split("0");

        String[] cypherText = Message.split("0");



        String encoded = "";

        for(String i : cypherText)

        {

            String result = i;

            int charPOS = 0;

            for(String key : keys)

            {
                if(i.contentEquals(key))

                {
                    /*
                    try
                    {
                        System.out.println("try ["+i+"]-["+key+"]->["+chars[charPOS]+"]");
                    }
                    catch(Exception e)
                    {
                    }
                    */
                    result = chars[charPOS];
                    break;
                }

                else

                {
                    /*
                    try
                    {
                        System.out.println("try ["+i+"]-["+key+"]->["+chars[charPOS]+"]");
                    }
                    catch(Exception e)
                    {
                    }
                    */
                }

                charPOS++;

            }

            encoded = encoded + result;

        }

        if(encoded.startsWith("null"))

        {

            encoded = encoded.substring(4);

        }

        if(encoded.startsWith("."))

        {

            encoded = encoded.substring(1);

        }



        return encoded;

    }



    public static String encrypt(String rawcode, String Message) {

        chars[0] = ".";

        chars[1] = "a";

        chars[2] = "b";

        chars[3] = "c";

        chars[4] = "d";

        chars[5] = "e";

        chars[6] = "f";

        chars[7] = "g";

        chars[8] = "h";

        chars[9] = "i";

        chars[10] = "j";

        chars[11] = "k";

        chars[12] = "l";

        chars[13] = "m";

        chars[14] = "n";

        chars[15] = "o";

        chars[16] = "p";

        chars[17] = "q";

        chars[18] = "r";

        chars[19] = "s";

        chars[20] = "t";

        chars[21] = "t";

        chars[22] = "u";

        chars[23] = "v";

        chars[24] = "w";

        chars[25] = "x";

        chars[26] = "y";

        chars[27] = "z";

            //Uppercase

        chars[28] = "A";

        chars[29] = "B";

        chars[30] = "C";

        chars[31] = "D";

        chars[32] = "E";

        chars[33] = "F";

        chars[34] = "G";

        chars[35] = "H";

        chars[36] = "I";

        chars[37] = "J";

        chars[38] = "K";

        chars[39] = "L";

        chars[40] = "M";

        chars[41] = "N";

        chars[42] = "O";

        chars[43] = "P";

        chars[44] = "Q";

        chars[45] = "R";

        chars[46] = "S";

        chars[47] = "T";

        chars[48] = "U";

        chars[49] = "V";

        chars[50] = "W";

        chars[51] = "X";

        chars[52] = "Y";

        chars[53] = "Z";

        // Ä Ü Ö

        chars[54] = "ä";

        chars[55] = "ü";

        chars[56] = "ö";

        chars[57] = "Ä";

        chars[58] = "Ü";

        chars[59] = "Ö";

        //Basic Maths

        chars[60] = "+";

        chars[61] = "-";

        chars[62] = "*";

        chars[63] = "/";

        //Numbers

        chars[64] = "0";

        chars[65] = "1";

        chars[66] = "2";

        chars[67] = "3";

        chars[68] = "4";

        chars[69] = "5";

        chars[70] = "6";

        chars[71] = "7";

        chars[72] = "8";

        chars[73] = "9";

        //Curency

        chars[74] = "$";

        chars[75] = "£";

        chars[76] = "¥";

        chars[77] = "¢";

        chars[78] = "¤";

        //Othes

        chars[79] = "®";

        chars[80] = "©";

        chars[81] = "ª";

        chars[82] = "º";

        chars[83] = "½";

        chars[84] = "¼";

        chars[85] = "¾";

        chars[86] = "¹";

        chars[87] = "³";

        chars[88] = "²";

        chars[89] = "ƒ";

        chars[90] = "±";

        chars[91] = "±";

        chars[92] = "×";

        chars[93] = "÷";

        chars[94] = "�?";

        chars[95] = "ï";

        chars[96] = "á";

        chars[97] = "é";

        chars[98] = "í";

        chars[99] = "ó";

        chars[100] = "ú";

        chars[101] = "�?";

        chars[102] = "É";

        chars[103] = "�?";

        chars[104] = "Ó";

        chars[105] = "Ú";

        chars[106] = "Ñ";

        chars[107] = "ñ";

        chars[108] = "ñ";

        chars[109] = "@";

        chars[110] = "¿";

        chars[111] = "¡";

        chars[112] = "!";

        chars[113] = ":";

        chars[114] = "/";

        chars[115] = "\\";

        chars[116] = "!";

        chars[117] = "\"";

        chars[118] = "#";

        chars[119] = "$";

        chars[120] = "%";

        chars[121] = "&";

        chars[122] = "'";

        chars[123] = "(";

        chars[124] = ")";

        chars[125] = "*";

        chars[126] = "Ø";

        chars[127] = "ø";

        chars[128] = "ÿ";

        chars[129] = "û";

        chars[130] = "ô";

        chars[131] = "Æ";

        chars[132] = "æ";

        chars[133] = "Å";

        chars[134] = "î";

        chars[135] = ":";

        chars[136] = ";";

        chars[137] = " ";

        chars[138] = "<";

        chars[139] = "=";

        chars[140] = ">";

        chars[141] = "?";

        chars[142] = "^";

        chars[143] = "_";

        chars[144] = "]";

        chars[145] = "[";

        chars[146] = "|";

        chars[147] = "}";

        chars[148] = "{";

        chars[149] = "~";

        chars[150] = "¬";

        chars[151] = "«";

        chars[152] = "»";

        chars[153] = "░";

        chars[154] = " ";

        chars[155] = "▒";

        chars[156] = "▓";

        chars[157] = "│";

        chars[158] = "┤";

        chars[160] = "╣";

        chars[161] = "╗";

        chars[163] = "�?";

        chars[164] = "�?";

        chars[165] = "└";

        chars[166] = "┴";

        chars[167] = "┬";

        chars[168] = "├";

        chars[169] = "─";

        chars[170] = "┼";

        chars[171] = "╚";

        chars[172] = "╔";

        chars[173] = "�?";

        chars[174] = "Þ";

        // converting the code-string into a String array
        System.out.println("rawcode: " + rawcode);
        //ArrayList<String> code = split(rawcode, "Â§");
        String[] code = rawcode.split("0");
        String codeA = "[";
        for(String sI : code)
        {
            codeA = codeA + "'" + sI + "',";
        }
        codeA = codeA + "]";
        System.out.println("key [array]: " + codeA);
        System.out.println("key length: " + code.length);

        String Crypted = "";

        for(String cI : toStringArray(Message))

        {

            int POS = 0;

            for(String cII : chars)

            {
                //System.out.println("try ["+cI+"]-["+cII+"] <"+POS+">");
                if(cI.contentEquals(cII))

                {

                    Crypted = Crypted + "0" + code[POS];

                    break;

                }

                POS++;

            }

        }

        return Crypted;

    }

    private static ArrayList<String> toStringArray(String s)

    {
        

        ArrayList<String> ret = new ArrayList<String>();

        for(char c : s.toCharArray())

        {

            String str = c + "";

            ret.add(str);

        }

        return ret;

    }
}