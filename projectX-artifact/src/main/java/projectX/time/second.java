package time;
public class second {
      public double Value = 0;

      public second(double value) {
            this.Value = value;
      }

      public nanosecond toNanoseconds() {
            return new nanosecond(this.Value * 1e+9);
      }

      public microsecond toMicroseconds() {
            return new microsecond(this.Value * 1e+6);
      }

      public millisecond toMilliSeconds() {
            return new millisecond(this.Value * 1e+3);
      }

      public minute toMinutes() {
            return new minute(this.Value / 60);
      }

      public hour toHours() {
            return new hour(this.Value / 3600);
      }

      public day toDays() {
            return new day(this.Value / 86400);
      }
}