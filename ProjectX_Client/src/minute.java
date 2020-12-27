
public class minute {
      public double Value = 0;
      
      public minute(double value) {
            this.Value = value;
      }

      public nanosecond toNanoseconds() {
            return new nanosecond(this.Value * 6e+10);
      }

      public microsecond toMicroseconds() {
            return new microsecond(this.Value * 6e+7);
      }

      public millisecond toMilliSeconds() {
            return new millisecond(this.Value * 60000);
      }

      public second toSeconds() {
            return new second(this.Value * 60);
      }

      public hour toHours() {
            return new hour(this.Value / 60);
      }

      public day toDays() {
            return new day(this.Value / 1440);
      }
}
