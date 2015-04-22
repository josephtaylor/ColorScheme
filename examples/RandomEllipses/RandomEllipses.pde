/*
 * This example illustrates using
 * the ArrayList of Color objects provided
 * by the ColorScheme getColors() method.
 *
 * Each frame, a random color is selected
 * from the list and its value is used to
 * fill a random ellipse.
 */
import jto.colorscheme.*;

ColorScheme cs;

ArrayList<Color> colors;

void setup() {
  size(500, 500);
  background(0);

  //load an adobe .ase color file
  cs = new ColorScheme("test.ase", this);

  //access the ArrayList of Colors in the ColorScheme
  colors = cs.getColors();
}

void draw() {
    //pick a random index in the colors list.
    int index = (int) random(colors.size());

    //access the color from the list
    Color c = colors.get(index);

    //set the fill color to the value of the Color.
    fill(c.toInt());

    //pick a random radius
    float radius = random(20, 100);

    //draw an circle at a random location
    ellipse(random(width), random(height), radius, radius);
}
