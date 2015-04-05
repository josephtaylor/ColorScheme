package jto.colorscheme;

import java.util.ArrayList;

/**
 * The <code>ColorSet</code> class represents a set or group of colors.</br> It maintains a list of
 * {@link jto.colorscheme.Color} objects.
 */
public class ColorSet {

    private ArrayList<Color> colors = new ArrayList<Color>();

    /**
     * The default constructor for ColorSet objects.
     */
    public ColorSet() {
    }

    /**
     * Adds a color to the list.
     *
     * @param c a color
     */
    public void addColor(Color c) {
        colors.add(c);
    }

    /**
     * Returns the list of colors.
     *
     * @return ArrayList<Color> colors - the list of colors.
     */
    public ArrayList<Color> getColors() {
        return colors;
    }
}
