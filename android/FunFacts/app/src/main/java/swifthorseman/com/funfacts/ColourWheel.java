package swifthorseman.com.funfacts;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by harry on 17/03/15.
 */
public class ColourWheel {
    private static final String[] colours = {"#39add1", // light blue
                                            "#3079ab", // dark blue
                                            "#c25975", // mauve
                                            "#e15258", // red
                                            "#f9845b", // orange
                                            "#838cc7", // lavender
                                            "#7d669e", // purple
                                            "#53bbb4", // aqua
                                            "#51b46d", // green
                                            "#e0ab18", // mustard
                                            "#637a91", // dark gray
                                            "#f092b0", // pink
                                            "#b7c0c7"  // light gray
                                            };

    public static int getColour() {
        Random rnd  = new Random();
        int index = rnd.nextInt(colours.length);

        return Color.parseColor(colours[index]);
    }

}
