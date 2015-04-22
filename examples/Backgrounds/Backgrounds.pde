/*
 * This basic example shows loading from
 * an .xml file from paletton.com
 *
 * The sketch cycles through each color in the
 * ColorScheme, setting the background color
 * with the current color.
 */
import jto.colorscheme.*;

ColorScheme cs;

ArrayList<Color> colors;

int counter = 0;

void setup() {
  size(500, 500);
  background(0);
  
  // create the color scheme from an .xml file
  cs = new ColorScheme("complement.xml", this);
  
  // get the ArrayList of Color objects.
  colors = cs.getColors();
  
  frameRate(1);
}

void draw() {
    // set the background to the current color
    // notice the use of toInt() to convert it to
    // an int (the same as processing's color type)
    background(colors.get(counter).toInt());
    
    // update the counter
    counter = (counter + 1) % colors.size();
}