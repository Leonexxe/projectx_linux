
import java.util.Random;

public class math {

    public static void main(String[] args) {
        vector vectorA = new vector(1, 2);
        vector vectorB = new vector(3, 4);
        System.out.println(A02V(vectorA,vectorB));
    }
 
    public static double A02V(vector v1, vector v2) {
        double Return = 0;

        // example:
        // vector1: (1x|2y)
        // vector2: (3x|4y)
        // |1ax   3bx|
        // |2ay   4by| = (1ax * 4by) + (2ay * 3bx) = 10

        vector a = v1;
        vector b = v2;

        Return = (a.x * b.y) + (a.y * b.x);

        return Return;
    }

    public static int random(int minimum, int maximum) {
        int Final = 0;

        Random rand = new Random();
        int random = rand.nextInt();
        while(random > maximum || random < minimum) {
            random = rand.nextInt();
        }
        Final = random;

        return Final;
    }
}
