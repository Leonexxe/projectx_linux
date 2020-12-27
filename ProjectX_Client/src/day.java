
public class day {
      public double Value = 0;
      
      public day(double value) {
            this.Value = value;
      }

      public nanosecond toNanoseconds() {
            return new nanosecond(this.Value * 8.64e+13);
      }

      public microsecond toMicroseconds() {
            return new microsecond(this.Value * 8.64e+10);
      }

      public millisecond toMilliSeconds() {
            return new millisecond(this.Value * 8.64e+7);
      }

      public second toSeconds() {
            return new second(this.Value * 8.64e+4);
      }

      public minute toMinutes() {
            return new minute(this.Value * 1440);
      }

      public hour toHours() {
            return new hour(this.Value / 24);
      }
}
