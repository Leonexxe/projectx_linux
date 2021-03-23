
import java.util.Random;

public class randomizer {
    public randomizer() {
    }

    public boolean Random(int maximum,int hitOn) {
        boolean hit = false;

        Random rand = new Random();
        int random = rand.nextInt();
        while(random > maximum || random < 0) {
            random = rand.nextInt();
        }

        if(random == hitOn) {
            hit = true;
            System.out.println("random: " + random);
        }
        else
        {
            hit = false;
        }

        return hit;
    }
}