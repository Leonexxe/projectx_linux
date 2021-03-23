package time;
public class millisecond {
      public double Value = 0;

      public millisecond(double value) {
            this.Value = value;
      }

      public nanosecond toNanoseconds() {
            return new nanosecond(this.Value * 1e+6);
      }

      public microsecond toMicroseconds() {
            return new microsecond(this.Value * 1e+3);
      }

      public second toSeconds() {
            return new second(this.Value / 1_000);
      }

      public minute toMinutes() {
            return new minute(this.Value / 60_000);
      }

      public hour toHours() {
            return new hour(this.Value / 3.6e+6);
      }

      public day toDays() {
            return new day(this.Value / 8.64e+7);
      }
}
