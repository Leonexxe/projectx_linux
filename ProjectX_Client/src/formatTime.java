
public class formatTime {

      public static String Format_HH_MM_SS_MSMS(hour Hours,minute Minutes,second Seconds, millisecond Milliseconds) {
            return Hours.Value + ":" + Minutes.Value + ":" + Seconds.Value + ":" + Milliseconds.Value;
      }

      public static String Format_HH_MM_SS_MSMS(int Hours,int Minutes,int Seconds,int Milliseconds) {
            return Hours + ":" + Minutes + ":" + Seconds + ":" + Milliseconds;
      }

      public static String Format_HH_MM_SS(hour Hours,minute Minutes,second Seconds) {
            return Hours.Value + ":" + Minutes.Value + ":" + Seconds.Value;
      }

      public static String Format_HH_MM_SS(int Hours,int Minutes,int Seconds) {
            return Hours + ":" + Minutes + ":" + Seconds;
      }

      public static String Format_HH_MM(hour Hours,minute Minutes) {
            return Hours.Value + ":" + Minutes.Value;
      }

      public static String Format_HH_MM(int Hours,int Minutes) {
            return Hours + ":" + Minutes;
      }

      public static String Format_HH_MM_SS_MSMS(time Time) {
            return Time.Hours.Value + ":" + Time.Minutes.Value + ":" + Time.Seconds.Value + ":" + Time.Milliseconds.Value;
      }
}
