package time;
public class time {

      public hour Hours = null;
      public minute Minutes = null;
      public second Seconds = null;
      public millisecond Milliseconds = null;

      public time(hour Hours,minute Minutes,second Seconds, millisecond Milliseconds) {
      }

      public time(int Hours,int Minutes,int Seconds,int Milliseconds) {
      }

      public time(String[] args)
      {
            if(args[0] == "now")
            {
                  this.Hours =  new millisecond(System.currentTimeMillis()).toHours();
                  if(this.Hours.toMinutes().Value >= 1 && this.Hours.toMinutes().Value <= 60)
                  {
                        this.Minutes = this.Hours.toMinutes();
                  }
            }
      }

      public time(String formatedTime) {
            // encoding Formated Time string
            String[] deFormatedTime = formatedTime.split(":");
            if(deFormatedTime[1] != null) {
                  this.Hours = new hour(Integer.parseInt(deFormatedTime[1]));
            }
            if(deFormatedTime[2] != null) {
                  this.Minutes = new minute(Integer.parseInt(deFormatedTime[2]));
            }
            if(deFormatedTime[3] != null) {
                  this.Seconds = new second(Integer.parseInt(deFormatedTime[3]));
            }
            if(deFormatedTime[4] != null) {
                  this.Milliseconds = new millisecond(Integer.parseInt(deFormatedTime[4]));
            }
      }
}
