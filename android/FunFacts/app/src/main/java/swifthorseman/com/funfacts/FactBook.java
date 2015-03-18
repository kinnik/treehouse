package swifthorseman.com.funfacts;

import java.util.Random;

/**
 * Created by harry on 17/03/15.
 */
public class FactBook {
    private static final String[] facts =
            {"Ants stretch when they wake up in the morning.",
             "Ostriches can run faster than horses.",
             "Olympic gold medals are actually made mostly of silver.",
             "You are born with 300 bones; by the time you are and adult you will have 206.",
             "It takes about 8 minutes for light from the Sun to reach Earth.",
             "Some bamboo plants can grow almost a meter in just one day.",
             "The state of Florida is bigger than England.",
             "Some penguins can leap 2-3 meters out of the water.",
             "On average, it takes 66 days to form a new habit.",
             "Mammoths still walked the earth when the Great Pyramid was being built."};

    private FactBook() {};

    public static String getFact() {
        Random rnd  = new Random();
        int index = rnd.nextInt(facts.length);

        return facts[index];
    }
}
