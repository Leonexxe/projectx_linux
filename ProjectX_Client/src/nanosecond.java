
public class nanosecond {
      public double Value = 0;

      public nanosecond(double value) {
            this.Value = value;
      }
      
      public microsecond toMicroseconds() {
            return new microsecond(this.Value / 1e+3);
      }

      public millisecond toMilliseconds() {
            return new millisecond(this.Value / 1e+6);
      }

      public second toSeconds() {
            return new second(this.Value / 1e+9);
      }

      public minute toMinutes() {
            return new minute(this.Value / 6e+10);
      }

      public hour toHours() {
            return new hour(this.Value / 3.6e+12);
      }

      public day toDays() {
            return new day(this.Value / 8.64e+13);
      }
}
