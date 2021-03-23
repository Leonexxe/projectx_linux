package time;
public class hour {
      public double Value = 0;

      public hour(double value) {
            this.Value = value;
      }

      public nanosecond toNanoseconds() {
            return new nanosecond(this.Value * 3.6e+12);
      }

      public microsecond toMicroseconds() {
            return new microsecond(this.Value * 3.6e+9);
      }

      public millisecond toMilliSeconds() {
            return new millisecond(this.Value * 3.6e+6);
      }

      public second toSeconds() {
            return new second(this.Value * 3600);
      }

      public minute toMinutes() {
            return new minute(this.Value * 60);
      }

      public day toDays() {
            return new day(this.Value / 24);
      }
}
