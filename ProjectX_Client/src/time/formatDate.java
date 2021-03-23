package time;
public class formatDate {
      public static String Format_DD_MM_YYYY(int day, int month, int year) {
            String formatedDate  = day + "." + month + "." + year;
            return formatedDate;
      }

      public static String Format_MM_DD_YYYY(int day, int month, int year) {
            String formatedDate  = month + "/" + day + "/" + year;
            return formatedDate;
      }

      public static String Format_DD_MM_YYYY(date Date) {
            String formatedDate  = Date.day + "." + Date.month + "." + Date.year;
            return formatedDate;
      }

      public static String Format_MM_DD_YYYY(date Date) {
            String formatedDate  = Date.month + "/" + Date.day + "/" + Date.year;
            return formatedDate;
      }
}
