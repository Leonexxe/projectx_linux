
public class microsecond {
      public double Value = 0;
      public microsecond(double value) {
            this.Value = value;
      }

      public nanosecond toNanoseconds() {
            return new nanosecond(this.Value * 1e+3);
      }

      public millisecond toMilliseconds() {
            return new millisecond(this.Value / 1e+3);
      }

      public second toSeconds() {
            return new second(this.Value / 1e+6);
      }

      public minute toMinutes() {
            return new minute(this.Value / 6e+7);
      }

      public hour toHours() {
            return new hour(this.Value / 3.6e+9);
      }

      public day toDays() {
            return new day(this.Value / 8.64e+10);
      }
}
