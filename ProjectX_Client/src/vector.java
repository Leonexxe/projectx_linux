
public class vector {
    double x = 0;
    double y = 0;
    public vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static vector getVector(point a, point b) {
        return new vector(a.x - b.x,a.y - b.y);
    }
}
