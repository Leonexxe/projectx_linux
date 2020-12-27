
import java.util.Date;

public class dateTime {
      public date Date = null;
      public time Time = null;
      public dateTime(date Date, time Time) {
            this.Date = Date;
            this.Time = Time;
      }

      public String toString() {
            return formatDate.Format_MM_DD_YYYY(this.Date) + "-" + formatTime.Format_HH_MM_SS_MSMS(this.Time);
      }

      /*
      public static String now()
      {
            return new dateTime(new date(), new time(1,1,1,1)).toString();
      }
      */
}