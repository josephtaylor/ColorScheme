package jto.colorscheme;

/**
 * This is the <code>Color</code> class. It represents an RGB color. </br>It maintains three int
 * values for red, green, and blue. It also maintains an int representation of the RGB color
 * identical to the 'color' type in Processing.
 */
public class Color {

    public int red;
    public int green;
    public int blue;

    private int rgb;

    /**
     * Returns an int representation of the color identical to the Processing 'color' type.
     *
     * @return rgb the int color.
     */
    public int toInt() {
        return rgb;
    }

    /**
     * Sets the int rgb version of the color.
     *
     * @param rgb the color.
     */
    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
}
